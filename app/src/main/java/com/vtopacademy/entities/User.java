package com.vtopacademy.entities;

import java.util.Date;

public class User {

    private final int userID;
    private final String email;
    private Date dateSavedToLocalDatabase;

    public User(int userID, String email) {
        this.userID = userID;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
