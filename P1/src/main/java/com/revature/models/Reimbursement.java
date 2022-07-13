package com.revature.models;

import java.math.BigDecimal;

public class Reimbursement {
    
    // Variables matching the columns in the database
    
    private int reimbId;
    private BigDecimal money;
    private String reimbSubmitted;
    private String reimbResolved;
    private String reimbDescription;
    private int reimbAuthor;
    private int reimbStatusId;
    private int reimbTypeId;

    // Constructors

    // Default constructor
    public Reimbursement() {
        super();
    }

    // Constructor with all variables
    public Reimbursement(int reimbId, BigDecimal money, String reimbSubmitted, String reimbResolved, String reimbDescription, int reimbAuthor, int reimbStatusId, int reimbTypeId) {
        super();
        this.reimbId = reimbId;
        this.money = money;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbAuthor = reimbAuthor;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
    }

    // Constructor without ID
    public Reimbursement(BigDecimal money, String reimbSubmitted, String reimbResolved, String reimbDescription, int reimbAuthor, int reimbStatusId, int reimbTypeId) {
        super();
        this.money = money;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbAuthor = reimbAuthor;
        this.reimbStatusId = reimbStatusId;
        this.reimbTypeId = reimbTypeId;
    }

    // toString

    @Override
    public String toString() {
        return "Reimbursement [reimbId=" + reimbId + ", money=" + money + ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved=" + reimbResolved + ", reimbDescription=" + reimbDescription + ", reimbAuthor=" + reimbAuthor + ", reimbStatusId=" + reimbStatusId + ", reimbTypeId=" + reimbTypeId + "]";
    }

    // Getters and Setters

    public int getReimbId() {
        return reimbId;
    }
    
    public void setReimbId(int reimbId) {
        this.reimbId = reimbId;
    }
    
    public BigDecimal getMoney() {
        return money;
    }
    
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getReimbSubmitted() {
        return reimbSubmitted;
    }

    public void setReimbSubmitted(String reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public String getReimbResolved() {
        return reimbResolved;
    }

    public void setReimbResolved(String reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public int getReimbAuthor() {
        return reimbAuthor;
    }
    
    public void setReimbAuthor(int reimbAuthor) {
        this.reimbAuthor = reimbAuthor;
    }

    public int getReimbStatusId() {
        return reimbStatusId;
    }

    public void setReimbStatusId(int reimbStatusId) {
        this.reimbStatusId = reimbStatusId;
    }

    public int getReimbTypeId() {
        return reimbTypeId;
    }

    public void setReimbTypeId(int reimbTypeId) {
        this.reimbTypeId = reimbTypeId;
    }

}
