package com.loan.loan_service.controller;

import com.loan.loan_service.dto.LoanRequest;
import com.loan.loan_service.dto.LoanResponse;
import com.loan.loan_service.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping("/apply")
    public ResponseEntity<LoanResponse> apply(Authentication authentication, @Valid @RequestBody LoanRequest request) {
        String email = authentication.getName();
        LoanResponse response = loanService.applyLoan(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/my")
    public ResponseEntity<List<LoanResponse>> myLoans(Authentication authentication) {
        String email = authentication.getName();
        List<LoanResponse> loans = loanService.getMyLoans(email);
        return ResponseEntity.ok(loans);
    }
}