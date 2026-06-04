package com.salingean.sistema_bancario.mapper;

import com.salingean.sistema_bancario.dto.AccountResponse;
import com.salingean.sistema_bancario.entity.Account;

public class AccountMapper {

    public static AccountResponse toResponse(Account account) {

        return new AccountResponse(
                account.getId(),
                account.getName(),
                account.getAccountNumber(),
                account.getBalance(),
                account.isBlocked()
        );
    }
}
