package com.example.clientes.shared.exception.base;
import org.springframework.http.HttpStatus;

public class ClientExistsException extends BaseException{

    public ClientExistsException(String message){
        super(false, HttpStatus.NOT_ACCEPTABLE, message, ExceptionCode.CLIENT_EXISTS);
    }
}
