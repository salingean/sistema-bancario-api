package com.salingean.sistema_bancario.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record AccountResponse(
        @Schema(example = "1")
        Long id,

        @Schema(example = "Salin Gean")
        String name,

        @Schema(example = "12345")
        String accountNumber,

        @Schema(example = "1500.00")
        BigDecimal balance,

        @Schema(example = "false")
        boolean blocked
) {
}