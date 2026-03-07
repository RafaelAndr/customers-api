package br.com.coderbank.customerportal.exception;

public class ClientAlreadyExistsException extends RuntimeException{
    public ClientAlreadyExistsException(String message) {
        super(message);
    }
}
