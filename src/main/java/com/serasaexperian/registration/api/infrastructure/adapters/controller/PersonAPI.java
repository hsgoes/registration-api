package com.serasaexperian.registration.api.infrastructure.adapters.controller;

import com.serasaexperian.registration.api.infrastructure.request.PersonFilter;
import com.serasaexperian.registration.api.infrastructure.request.CreatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.request.UpdatePersonRequestDTO;
import com.serasaexperian.registration.api.infrastructure.response.PersonResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/person")
@Tag(name = "API para gerenciamento de pessoas")
public interface PersonAPI {


    @PostMapping
    @ApiResponse(responseCode = "201", description = "Created")
    @Operation(
            summary = "Criar pessoa",
            description = "Registra uma pessoa no banco de dados juntamente com seu endereço e o score"
    )
    ResponseEntity<PersonResponseDTO> createPerson(@RequestBody CreatePersonRequestDTO createPersonRequestDTO);

    @ApiResponse(responseCode = "200", description = "OK")
    @Operation(
            summary = "Buscar pessoas",
            description = "Retorna uma lista de pessoas com base nos parâmetros de busca informados"
    )
    @GetMapping
    ResponseEntity<Page<PersonResponseDTO>> getPersons(@ModelAttribute PersonFilter filter, Pageable pageable);

    @ApiResponse(responseCode = "204", description = "No Content")
    @Operation(
            summary = "Deletar pessoa",
            description = "Deleta uma pessoa com base no id informado"
    )
    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePerson(@PathVariable String id);

    @ApiResponse(responseCode = "200", description = "OK")
    @Operation(
            summary = "Atualizar pessoa",
            description = "Atualiza uma pessoa com base no id informado"
    )
    @PutMapping("/{id}")
    ResponseEntity<PersonResponseDTO> updatePerson(@PathVariable String id, @RequestBody UpdatePersonRequestDTO updatePersonRequestDTO);
}
