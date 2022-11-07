package com.vtopacademy.entities;

import java.util.Date;

public class Payment {

    private final int paymentID;
    private final String amount;
    private final PaymentStatus paymentStatus;
    private final Date RegistrationDate;
    private final Date ExpiryDate;
    private final int userID;
    private final int categoryID;
    private final int subjectID;
    private Date dateSavedToLocalDatabase;

    public Payment(int paymentID, String amount,
                   PaymentStatus paymentStatus, Date registrationDate, Date expiryDate, int userID, int categorySubjectID, int subjectID) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        RegistrationDate = registrationDate;
        ExpiryDate = expiryDate;
        this.userID = userID;
        this.categoryID = categorySubjectID;
        this.subjectID = subjectID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public String getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public Date getRegistrationDate() {
        return RegistrationDate;
    }

    public Date getExpiryDate() {
        return ExpiryDate;
    }

    public int getUserID() {
        return userID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}