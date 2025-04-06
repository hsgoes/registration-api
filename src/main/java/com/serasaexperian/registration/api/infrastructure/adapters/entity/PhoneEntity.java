package com.serasaexperian.registration.api.infrastructure.adapters.entity;

import com.serasaexperian.registration.api.application.domain.entity.Phone;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "phones")
@Getter
public class PhoneEntity {
    @Id
    private String id;
    private String DDD;
    private String number;

    public PhoneEntity() {
    }

    public PhoneEntity(Phone phone) {
        this.DDD = phone.getDdd().value();
        this.number = phone.getNumber().value();
    }

    public Phone toDomain() {
        return Phone.from(
                this.DDD,
                this.number
        );
    }
}
