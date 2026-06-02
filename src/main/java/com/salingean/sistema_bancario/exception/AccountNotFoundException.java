package com.salingean.sistema_bancario.exception;

public class AccountNotFoundException extends BankingException {

    public AccountNotFoundException(String message) {
        super(message);
    }
}
