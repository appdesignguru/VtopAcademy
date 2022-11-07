package com.vtopacademy.states;

import com.vtopacademy.entities.Category;
import java.util.List;

/** UI state for category list screen. */
public class CategoryListUiState {

    private final boolean fetchingCategories;
    private final List<Category> categories;

    /** Constructs a new instance. */
    public CategoryListUiState(boolean fetchingCategories, List<Category> categories) {
        this.fetchingCategories = fetchingCategories;
        this.categories = categories;
    }

    /** Checks whether categories are currently being fetched. */
    public boolean isFetchingCategories() {
        return fetchingCategories;
    }

    /** Returns all categories. */
    public List<Category> getCategories() {
        return categories;
    }
}
