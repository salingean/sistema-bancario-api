package com.salingean.sistema_bancario.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TransferRequest {

    @NotNull(message = "Source account is required")
    private Long sourceAccount;

    @NotNull(message = "Destination account is required")
    private Long destinationAccount;

    @NotNull(message = "Value is required")
    @Positive(message = "Transfer value must be greater than zero")
    private BigDecimal value;
}
