package com.salingean.sistema_bancario.exception;

public class BlockedAccountException extends BankingException {

    public BlockedAccountException(String message) {
        super(message);
    }

}
