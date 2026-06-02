package com.salingean.sistema_bancario.exception;

public class BankingException extends RuntimeException {

    public BankingException(String message) {
        super(message);
    }
}
