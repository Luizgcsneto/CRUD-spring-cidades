package com.crudspringcidade.crudspringcidade.service;

import org.springframework.stereotype.Service;
import com.crudspringcidade.crudspringcidade.repository.CidadeRepository;
import com.crudspringcidade.crudspringcidade.dto.mapper.CidadeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.crudspringcidade.crudspringcidade.dto.CidadeDto;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import com.crudspringcidade.crudspringcidade.exception.CidadeNotFoundIdException;
import jakarta.validation.constraints.Positive;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;


@Service
public class CidadeService {

    @Autowired
    private final CidadeRepository cidadeRepository;
    @Autowired
    private final CidadeMapper cidadeMapper;

    public CidadeService(CidadeRepository cidadeRepository,
    CidadeMapper cidadeMapper){
        this.cidadeRepository = cidadeRepository;
        this.cidadeMapper = cidadeMapper;
    }

    public List<CidadeDto> listaCidades(){
        return cidadeRepository.findAll()
        .stream().map(cidadeMapper::toDto)
        .collect(Collectors.toList());
    }

    public CidadeDto findById(@PathVariable @Positive Long id)
    {
        return cidadeRepository.findById(id)
        .map(cidadeMapper::toDto)
        .orElseThrow(() -> new CidadeNotFoundIdException(id));
    }

    public CidadeDto create(@Valid @NotNull CidadeDto cidadeDto)
    {
        return cidadeMapper.toDto(cidadeRepository
        .save(cidadeMapper.toEntity(cidadeDto)));
    }

    public CidadeDto update (@NotNull @Positive Long id, @Valid @NotNull CidadeDto cidadeDto)
    {
        return cidadeRepository.findById(id).map(cidade -> {
            cidade.setNome(cidadeDto.nome());
            cidade.setEstado(cidadeDto.estado());
            return cidadeMapper.toDto(cidadeRepository.save(cidade));
        }).orElseThrow(() -> new CidadeNotFoundIdException(id));
    }

    public void delete(@PathVariable @NotNull @Positive Long id)
    {
        cidadeRepository.delete(cidadeRepository.findById(id)
        .orElseThrow(() -> new CidadeNotFoundIdException(id)));
    }


}
