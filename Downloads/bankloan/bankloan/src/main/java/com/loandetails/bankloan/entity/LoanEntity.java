package com.loandetails.bankloan.entity;

import org.apache.catalina.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "loantable")
public class LoanEntity {

	@Id
	@Column(name = "loanid")
	private Integer loanid;

	
	@Column(name = "uid")
	private Integer uid;

	@Column(name = "loanamount")
	private Integer loanamount;

	@Column(name = "term")
	private Integer term;

	@Column(name = "interest")
	private Integer interest;
	
	@Column(name="userName")
	private String userName;
	
	private Double outstandingBalance;
	
	public Integer getLoanid() {
		return loanid;
	}

	@OneToMany
	public void setLoanid(Integer loanid) {
		this.loanid = loanid;
	}

	

	public Integer getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(Integer loanamount) {
		this.loanamount = loanamount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = userName;
	}

	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public Integer getInterest() {
		return interest;
	}

	public void setInterest(Integer interest) {
		this.interest = interest;
	}

	@Override
	public String toString() {
		return "LoanEntity [loanid=" + loanid + ", loanamount=" + loanamount + ", term=" + term
				+ ", interest=" + interest + "]";
	}

	public Double getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(Double outstandingBalance) {
		
		 if (outstandingBalance < 0) {
	            throw new IllegalArgumentException("Outstanding balance cannot be negative");
	        }
		this.outstandingBalance = outstandingBalance;
	}

	
	
	

}
