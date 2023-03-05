package com.crudspringcidade.crudspringcidade.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.persistence.Column;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Data
@SQLDelete(sql = "UPDATE Cidade SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(length = 100)
    private String nome;

    
    @NotBlank
    @NotNull
    @Column(length = 30)
    private String estado;

    @NotBlank
    @NotNull
    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo";
}
