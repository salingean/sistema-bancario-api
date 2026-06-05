package com.salingean.sistema_bancario.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountRequest {

    @Schema(description = "Customer name")
    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Schema(example = "12345")
    @NotBlank(message = "Account number cannot be empty")
    private String accountNumber;

    @Schema(example = "1000.00")
    @NotNull(message = "Balance is required")
    @PositiveOrZero(message = "Balance cannot be negative")
    private BigDecimal balance;
}
