package com.vtopacademy.entities;

import java.util.Date;

public class CategorySubject {

    private final int categorySubjectID;
    private final int categoryID;
    private final int subjectID;
    private Date dateSavedToLocalDatabase;

    public CategorySubject(int categorySubjectID, int categoryID, int subjectID) {
        this.categorySubjectID = categorySubjectID;
        this.categoryID = categoryID;
        this.subjectID = subjectID;
    }

    public int getCategorySubjectID() {
        return categorySubjectID;
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