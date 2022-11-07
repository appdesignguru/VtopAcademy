package com.vtopacademy.entities;

import java.util.Date;

public class Subject {

    private final int subjectID;
    private final int number;
    private final String name;
    private final boolean requiresPayment;
    private Date dateSavedToLocalDatabase;

    public Subject(int subjectID, int number, String name, boolean requiresPayment) {
        this.subjectID = subjectID;
        this.number = number;
        this.name = name;
        this.requiresPayment = requiresPayment;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean requiresPayment() {
        return requiresPayment;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}