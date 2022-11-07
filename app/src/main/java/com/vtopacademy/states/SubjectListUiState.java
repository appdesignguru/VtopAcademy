package com.vtopacademy.states;

import com.vtopacademy.entities.Category;
import com.vtopacademy.entities.Subject;

import java.util.List;

/** UI state for subject list screen. */
public class SubjectListUiState {

    private final boolean fetchingSubjects;
    private final List<Subject> subjects;
    private final Category selectedCategory;

    /** Constructs a new instance. */
    public SubjectListUiState(boolean fetchingSubjects, List<Subject> subjects,
                          Category selectedCategory) {
        this.fetchingSubjects = fetchingSubjects;
        this.subjects = subjects;
        this.selectedCategory = selectedCategory;
    }

    /** Checks whether subjects are currently being fetched. */
    public boolean isFetchingSubjects() {
        return fetchingSubjects;
    }

    /** Returns all subjects. */
    public List<Subject> getSubjects() {
        return subjects;
    }

    /** Returns selected category. */
    public Category getSelectedCategory() {
        return selectedCategory;
    }
}

