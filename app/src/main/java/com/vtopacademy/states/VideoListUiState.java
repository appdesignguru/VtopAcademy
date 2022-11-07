package com.vtopacademy.states;

import com.vtopacademy.entities.Category;
import com.vtopacademy.entities.Subject;
import com.vtopacademy.entities.Topic;
import com.vtopacademy.entities.Video;
import java.util.List;

/** UI state for video list screen. */
public class VideoListUiState {

    private final boolean fetchingVideos;
    private final List<Video> videos;
    private final Category selectedCategory;
    private final Subject selectedSubject;
    private final Topic selectedTopic;

    /** Constructs a new instance. */
    public VideoListUiState(boolean fetchingVideos, List<Video> videos, Category selectedCategory,
                        Subject selectedSubject, Topic selectedTopic) {
        this.fetchingVideos = fetchingVideos;
        this.videos = videos;
        this.selectedCategory = selectedCategory;
        this.selectedSubject = selectedSubject;
        this.selectedTopic = selectedTopic;
    }

    /** Checks whether videos are currently being fetched. */
    public boolean isFetchingVideos() {
        return fetchingVideos;
    }

    /** Returns all videos. */
    public List<Video> getVideos() {
        return videos;
    }

    /** Returns selected category. */
    public Category getSelectedCategory() {
        return selectedCategory;
    }

    /** Returns selected subject. */
    public Subject getSelectedSubject() {
        return selectedSubject;
    }

    /** Returns selected topic. */
    public Topic getSelectedTopic() {
        return selectedTopic;
    }

}