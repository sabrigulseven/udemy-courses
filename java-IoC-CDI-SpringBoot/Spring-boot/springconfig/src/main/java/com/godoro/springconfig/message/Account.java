package com.godoro.springconfig.message;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Account {
	
    private long accountId;
    
    @NotEmpty(message = "{account.accountName.notEmpty}")
    private String accountName;
    
    @Min(value = 100, message = "{account.totalBalance.min}")
    @Max(value = 5000,message = "{account.totalBalance.max}")
    private double totalBalance;

    public Account() {
    }

    public Account(long accountId, String accountName, double totalBalance) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.totalBalance = totalBalance;
    }

    public long getAccountId() {
        return this.accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getTotalBalance() {
        return this.totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    @Override
    public String toString() {
        return "{" +
                " accountId='" + getAccountId() + "'" +
                ", accountName='" + getAccountName() + "'" +
                ", totalBalance='" + getTotalBalance() + "'" +
                "}";
    }

}
