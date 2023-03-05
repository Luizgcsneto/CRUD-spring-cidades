package com.crudspringcidade.crudspringcidade.dto.mapper;

import com.crudspringcidade.crudspringcidade.dto.CidadeDto;
import com.crudspringcidade.crudspringcidade.model.Cidade;

import org.springframework.stereotype.Component;

@Component
public class CidadeMapper {

    public CidadeDto toDto(Cidade cidade) {
        if (cidade == null) {
            return null;
        }
        return new CidadeDto(cidade.getId(), cidade.getNome(), cidade.getEstado());
    }

    public Cidade toEntity(CidadeDto cidadeDto) {
        if (cidadeDto == null) {
            return null;
        }

        Cidade cidade = new Cidade();

        if (cidadeDto.id() != null) {
            cidade.setId(cidadeDto.id());
        }

        cidade.setNome(cidadeDto.nome());
        cidade.setEstado(cidadeDto.estado());

        return cidade;

    }
}
