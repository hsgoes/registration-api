package com.serasaexperian.registration.api.infrastructure.adapters.specifications;

import com.serasaexperian.registration.api.infrastructure.adapters.entity.PersonEntity;
import com.serasaexperian.registration.api.infrastructure.request.PersonFilter;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class PersonSpecifications {

    public static Specification<PersonEntity> build(PersonFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (filter.getName() != null && !filter.getName().isBlank()) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("name")),
                                "%" + filter.getName().toLowerCase() + "%"
                        )
                );
            }

            if (filter.getAge() != null && !filter.getAge().isBlank()) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("age")),
                                "%" + filter.getAge().toLowerCase() + "%"
                        )
                );
            }

            if (filter.getZipCode() != null && !filter.getZipCode().isBlank()) {
                predicate = criteriaBuilder.and(
                        predicate,
                        criteriaBuilder.like(
                                criteriaBuilder.lower(
                                        root.join("address").get("zipCode")
                                ),
                                "%" + filter.getZipCode().toLowerCase() + "%"
                        )
                );
            }

            return predicate;
        };
    }
}
