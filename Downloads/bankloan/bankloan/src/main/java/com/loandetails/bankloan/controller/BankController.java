package com.loandetails.bankloan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loandetails.bankloan.entity.LoanEntity;
import com.loandetails.bankloan.entity.UserEntity;
import com.loandetails.bankloan.service.BankService;

@RestController
public class BankController {
	
	@Autowired
	private BankService bankservice;
	
//	@PostMapping("/saveloanuser")
//	public void saveuser(@RequestBody LoanEntity user) {
//		bankservice.saveuser(user);
//	}
//	
//	@PostMapping("/saveuser")
//	public void saveuser(@RequestBody UserEntity user) {
//		bankservice.saveuser(user);
//	}
	
	@PostMapping("/apply")
	public ResponseEntity<String> applyForLoan(@RequestBody LoanEntity loan) {
		 ResponseEntity.ok(bankservice.applyForLoan(loan));
		 return ResponseEntity.ok("Loan apllied successfully");
		
	} 
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> getLoansByUser(@PathVariable LoanEntity name) {
		 Optional<LoanEntity> loan= Optional.of(bankservice.applyForLoan(name));
		if(loan.isPresent()) {
			return ResponseEntity.ok(loan.get());
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	
	}
	
	@GetMapping("/repay/{loanId}")
	public ResponseEntity<LoanEntity> repayLoan(@PathVariable Integer loanid, @RequestParam Integer loanamount) {
		return ResponseEntity.ok(bankservice.repayLoan(loanid, loanamount));
	
	}
	
}
