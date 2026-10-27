package com.loan.loan_service.dto;

import com.loan.loan_service.entity.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {

    private Long id;
    private BigDecimal amount;
    private Integer tenure;
    private BigDecimal income;
    private String employmentType;
    private String purpose;
    private LoanStatus status;
    private LocalDateTime createdAt;
}