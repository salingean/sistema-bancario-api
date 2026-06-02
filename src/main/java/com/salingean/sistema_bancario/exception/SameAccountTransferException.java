package com.salingean.sistema_bancario.exception;

public class SameAccountTransferException extends BankingException {

    public SameAccountTransferException(String message) {
        super(message);
    }

}
