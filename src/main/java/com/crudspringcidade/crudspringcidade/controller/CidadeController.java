package com.crudspringcidade.crudspringcidade.controller;

import org.springframework.web.bind.annotation.RestController;
import com.crudspringcidade.crudspringcidade.service.CidadeService;
import java.util.List;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.crudspringcidade.crudspringcidade.dto.CidadeDto;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/cidade")
public class CidadeController {

    private final CidadeService cidadeService;

    public CidadeController(CidadeService cidadeService){
        this.cidadeService = cidadeService;
    }

    @GetMapping
    @ResponseBody
    public List<CidadeDto> listaTimes() 
    {
        return cidadeService.listaCidades();
    }

    @GetMapping("/{id}")
    public CidadeDto findById(@PathVariable @NotNull @Positive Long id) 
    {
        return cidadeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CidadeDto create(@RequestBody @Valid CidadeDto cidadeDto) 
    {
        return  cidadeService.create(cidadeDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public CidadeDto update(@PathVariable @NotNull @Positive Long id,
            @RequestBody @Valid @NotNull CidadeDto cidadeDto) {
        return cidadeService.update(id, cidadeDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) 
    {
        cidadeService.delete(id);
    }

    
}
