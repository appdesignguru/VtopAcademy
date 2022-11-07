package com.vtopacademy.entities;

import java.util.Date;

public class Pricing {

    private final int pricingID;
    private final int amount;
    private final int description;
    private final int numberOfDays;
    private final int categoryID;
    private final int subjectID;
    private Date dateSavedToLocalDatabase;

    public Pricing(int pricingID, int amount, int description,
                   int numberOfDays, int categoryID, int subjectID) {
        this.pricingID = pricingID;
        this.amount = amount;
        this.description = description;
        this.numberOfDays = numberOfDays;
        this.categoryID = categoryID;
        this.subjectID = subjectID;
    }

    public int getPricingID() {
        return pricingID;
    }

    public int getAmount() {
        return amount;
    }

    public int getDescription() {
        return description;
    }

    public int getNumberOfDays() {
        return numberOfDays;
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
