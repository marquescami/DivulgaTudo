package com.project.GerenciamentoDeAnuncios.exceptions;

import com.project.GerenciamentoDeAnuncios.util.MessageUtils;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super(MessageUtils.NO_RECORDS_FOUND);
    }
}
