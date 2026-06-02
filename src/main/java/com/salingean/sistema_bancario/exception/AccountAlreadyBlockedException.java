package com.salingean.sistema_bancario.exception;

public class AccountAlreadyBlockedException extends BankingException {

    public AccountAlreadyBlockedException(String message) {
        super(message);
    }

}
