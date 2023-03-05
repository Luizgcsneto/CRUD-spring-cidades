package com.crudspringcidade.crudspringcidade.exception;

public class CidadeNotFoundIdException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public CidadeNotFoundIdException(Long id){
        super("Registro não encontrado com o id: " + id);
    }
    
}
