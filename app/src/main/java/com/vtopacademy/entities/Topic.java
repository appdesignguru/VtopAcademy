package com.vtopacademy.entities;

import java.util.Date;

public class Topic {

    private final int topicID;
    private final int number;
    private final String name;
    private final int categorySubjectID;
    private Date dateSavedToLocalDatabase;

    public Topic(int topicID, int number, String name, int categorySubjectID) {
        this.topicID = topicID;
        this.number = number;
        this.name = name;
        this.categorySubjectID = categorySubjectID;
    }

    public int getTopicID() {
        return topicID;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getCategorySubjectID() {
        return categorySubjectID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}
