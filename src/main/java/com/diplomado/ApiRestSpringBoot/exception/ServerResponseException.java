package com.diplomado.ApiRestSpringBoot.exception;

public class ServerResponseException extends RuntimeException{
    public ServerResponseException(String message) {
        super(message);
    }
}
