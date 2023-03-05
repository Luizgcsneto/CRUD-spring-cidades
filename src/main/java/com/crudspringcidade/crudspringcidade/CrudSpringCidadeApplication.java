package com.crudspringcidade.crudspringcidade;

import com.crudspringcidade.crudspringcidade.repository.CidadeRepository;
import com.crudspringcidade.crudspringcidade.model.Cidade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringCidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringCidadeApplication.class, args);
	}

	@Bean
	CommandLineRunner initDataBase(CidadeRepository cidadeRepository) 
	{
		return args -> {
			cidadeRepository.deleteAll();
			Cidade cidade = new Cidade();
			cidade.setNome("Paulo Afonso");
			cidade.setEstado("Bahia");
			cidadeRepository.save(cidade);
		};
	}

}
