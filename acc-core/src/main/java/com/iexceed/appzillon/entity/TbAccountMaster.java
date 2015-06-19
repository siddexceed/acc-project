package com.iexceed.appzillon.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the TB_ACCOUNT_MASTER database table.
 * 
 */
@Entity
@Table(name="TB_ACCOUNT_MASTER")
@NamedQuery(name="TbAccountMaster.findAll", query="SELECT t FROM TbAccountMaster t")
public class TbAccountMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACCOUNT_NUM", unique=true, nullable=false, length=100)
	private String accountNum;

	@Column(name="ACCOUNT_ADDRESS", length=250)
	private String accountAddress;

	@Column(name="ACCOUNT_CURRENCY", nullable=false, length=50)
	private String accountCurrency;

	@Column(name="ACCOUNT_NAME", nullable=false, length=100)
	private String accountName;

	@Column(name="ACCOUNT_TYPE", nullable=false, length=100)
	private String accountType;

	@Column(name="CLEARING_AMT")
	private double clearingAmt;

	@Column(name="CREATION_DATE", nullable=false)
	private Date creationDate;

	@Column(name="CURRENT_BAL")
	private double currentBal;

	@Column(name="CUSTOMER_ID", length=50)
	private String customerId;

	@Column(name="LAST_TRANSACTION_DATE", nullable=false)
	private Date lastTransactionDate;

	@Column(name="LINE_AMT")
	private double lineAmt;

	@Column(name="WITHDRAWBLE_BAL")
	private double withdrawbleBal;

	public TbAccountMaster() {
	}

	public String getAccountNum() {
		return this.accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountAddress() {
		return this.accountAddress;
	}

	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}

	public String getAccountCurrency() {
		return this.accountCurrency;
	}

	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getClearingAmt() {
		return this.clearingAmt;
	}

	public void setClearingAmt(double clearingAmt) {
		this.clearingAmt = clearingAmt;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public double getCurrentBal() {
		return this.currentBal;
	}

	public void setCurrentBal(double currentBal) {
		this.currentBal = currentBal;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getLastTransactionDate() {
		return this.lastTransactionDate;
	}

	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}

	public double getLineAmt() {
		return this.lineAmt;
	}

	public void setLineAmt(double lineAmt) {
		this.lineAmt = lineAmt;
	}

	public double getWithdrawbleBal() {
		return this.withdrawbleBal;
	}

	public void setWithdrawbleBal(double withdrawbleBal) {
		this.withdrawbleBal = withdrawbleBal;
	}

}