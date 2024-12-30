package com.loandetails.bankloan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loandetails.bankloan.entity.LoanEntity;
import com.loandetails.bankloan.entity.UserEntity;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Integer> {

	LoanEntity findByUserName(String name);

	Optional<LoanEntity> findById(Integer loanid);

}
