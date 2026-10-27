package com.loan.loan_service.repository;

import com.loan.loan_service.entity.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanApplication, Long> {

    List<LoanApplication> findByUserEmailOrderByCreatedAtDesc(String userEmail);
}