package com.loan.loan_service.service;

import com.loan.loan_service.dto.LoanRequest;
import com.loan.loan_service.dto.LoanResponse;
import com.loan.loan_service.entity.LoanApplication;
import com.loan.loan_service.entity.LoanStatus;
import com.loan.loan_service.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanResponse applyLoan(String userEmail, LoanRequest request) {
        LoanApplication loan = new LoanApplication();
        loan.setUserEmail(userEmail);
        loan.setAmount(request.getAmount());
        loan.setTenure(request.getTenure());
        loan.setIncome(request.getIncome());
        loan.setEmploymentType(request.getEmploymentType());
        loan.setPurpose(request.getPurpose());
        loan.setStatus(LoanStatus.PENDING);
        loan.setCreatedAt(LocalDateTime.now());

        LoanApplication saved = loanRepository.save(loan);
        return toResponse(saved);
    }

    public List<LoanResponse> getMyLoans(String userEmail) {
        List<LoanApplication> loans = loanRepository.findByUserEmailOrderByCreatedAtDesc(userEmail);
        List<LoanResponse> responses = new ArrayList<>();
        for (LoanApplication loan : loans) {
            responses.add(toResponse(loan));
        }
        return responses;
    }

    private LoanResponse toResponse(LoanApplication loan) {
        return new LoanResponse(
                loan.getId(),
                loan.getAmount(),
                loan.getTenure(),
                loan.getIncome(),
                loan.getEmploymentType(),
                loan.getPurpose(),
                loan.getStatus(),
                loan.getCreatedAt()
        );
    }
}