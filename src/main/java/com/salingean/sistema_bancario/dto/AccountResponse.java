package com.salingean.sistema_bancario.dto;

import java.math.BigDecimal;

public record AccountResponse(
        Long id,
        String name,
        String accountNumber,
        BigDecimal balance,
        boolean blocked
) {
}