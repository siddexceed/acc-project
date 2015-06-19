package com.iexceed.appzillon.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the TB_TRANSACTION_MASTER database table.
 * 
 */
@Entity
@Table(name = "TB_TRANSACTION_MASTER")
@NamedQuery(name = "TbTransactionMaster.findAll", query = "SELECT t FROM TbTransactionMaster t")
public class TbTransactionMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "TRANSACTION_ID", unique = true, nullable = false, length = 100)
	private String transactionId;

	@Column(name = "ACCOUNT_NUM", nullable = false, length = 100)
	private String accountNum;

	@Column(name = "TRANSACTION_AMT")
	private double transactionAmt;

	@Column(name = "TRANSACTION_CODE", nullable = false, length = 100)
	private String transactionCode;

	@Column(name = "TRANSACTION_CURRENCY", nullable = false, length = 50)
	private String transactionCurrency;
	@Temporal(TemporalType.DATE)
	@Column(name = "TRANSACTION_DATE", nullable = false)
	private Date transactionDate;

	@Column(name = "TRANSACTION_DESC", length = 100)
	private String transactionDesc;

	@Column(name = "TRANSACTION_TYPE", nullable = false, length = 100)
	private String transactionType;

	public TbTransactionMaster() {
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNum() {
		return this.accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public double getTransactionAmt() {
		return this.transactionAmt;
	}

	public void setTransactionAmt(double transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public String getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getTransactionCurrency() {
		return this.transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionDesc() {
		return this.transactionDesc;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}