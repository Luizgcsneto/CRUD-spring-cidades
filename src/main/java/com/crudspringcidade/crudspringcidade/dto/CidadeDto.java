package com.crudspringcidade.crudspringcidade.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CidadeDto (
    @JsonProperty("_id") Long id, 
    @NotBlank @NotNull  @Column(length = 100) String nome, 
    @NotBlank @NotNull  @Column(length = 30) String estado
) {
    
}
