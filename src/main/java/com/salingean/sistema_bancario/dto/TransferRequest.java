package com.salingean.sistema_bancario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(
            description = "Source account ID",
            example = "1"
    )
    @NotNull(message = "Source account is required")
    private Long sourceAccount;

    @Schema(
            description = "Destination account ID",
            example = "2"
    )
    @NotNull(message = "Destination account is required")
    private Long destinationAccount;

    @Schema(
            description = "Transfer amount",
            example = "500.00"
    )
    @NotNull(message = "Value is required")
    @Positive(message = "Transfer value must be greater than zero")
    private BigDecimal value;
}
