package com.salingean.sistema_bancario.exception;

public class InvalidTransferValueException extends BankingException {

    public InvalidTransferValueException(String message) {
        super(message);
    }

}
