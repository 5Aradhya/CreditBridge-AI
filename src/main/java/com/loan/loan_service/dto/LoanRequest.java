package com.loan.loan_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class LoanRequest {

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotNull(message = "Tenure is required")
    @Positive(message = "Tenure must be greater than 0")
    private Integer tenure;

    @NotNull(message = "Income is required")
    @Positive(message = "Income must be greater than 0")
    private BigDecimal income;

    @NotBlank(message = "Employment type is required")
    private String employmentType;

    @NotBlank(message = "Purpose is required")
    private String purpose;
}