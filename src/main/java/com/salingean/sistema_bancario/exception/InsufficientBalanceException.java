package com.salingean.sistema_bancario.exception;

public class InsufficientBalanceException extends BankingException {

    public InsufficientBalanceException(String message) {
        super(message);
    }

}