package com.vtopacademy.entities;

import java.util.Date;

public class Category {

    private final int categoryID;
    private final int number;
    private final String name;
    private Date dateSavedToLocalDatabase;

    public Category(int categoryID, int number, String name) {
        this.categoryID = categoryID;
        this.number = number;
        this.name = name;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}