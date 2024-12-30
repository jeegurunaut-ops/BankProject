package com.loandetails.bankloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loandetails.bankloan.entity.LoanEntity;
import com.loandetails.bankloan.entity.UserEntity;
import com.loandetails.bankloan.repository.LoanRepository;
import com.loandetails.bankloan.repository.UserRepository;

@Service
public class BankService {

	@Autowired
	private LoanRepository loanrepository;

	@Autowired
	private UserRepository userrepository;

	public UserEntity saveuser(UserEntity user) {
		userrepository.save(user);
		return user;

	}

	public void saveuser(LoanEntity user) {
		// TODO Auto-generated method stub
		loanrepository.save(user);
	}

	public LoanEntity applyForLoan(LoanEntity name) {
		return loanrepository.save(name);
	}


	public LoanEntity getLoansByUser(String name) {
		return loanrepository.findByUserName(name);
	}

	public LoanEntity repayLoan(Integer loanid, Integer loanamount) {
		LoanEntity loan = loanrepository.findById(loanid).orElse(null);
		if (loan == null) {
			throw new RuntimeException("Loan not found");
		}

		loan.setOutstandingBalance(loan.getOutstandingBalance() - loanamount);
		return loanrepository.save(loan);
	}
}
