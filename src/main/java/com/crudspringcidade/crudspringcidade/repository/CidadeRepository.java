package com.crudspringcidade.crudspringcidade.repository;

import com.crudspringcidade.crudspringcidade.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CidadeRepository extends JpaRepository<Cidade,Long> {}
