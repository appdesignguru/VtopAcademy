package com.vtopacademy.states;

import com.vtopacademy.entities.Category;
import com.vtopacademy.entities.Subject;
import com.vtopacademy.entities.Topic;
import com.vtopacademy.entities.Video;

/** UI state for video item screen. */
public class VideoItemUiState {

    private final Category selectedCategory;
    private final Subject selectedSubject;
    private final Topic selectedTopic;
    private final Video selectedVideo;


    /** Constructs a new instance. */
    public VideoItemUiState(Category selectedCategory, Subject selectedSubject,
                            Topic selectedTopic, Video selectedVideo) {
        this.selectedCategory = selectedCategory;
        this.selectedSubject = selectedSubject;
        this.selectedTopic = selectedTopic;
        this.selectedVideo = selectedVideo;
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

    /** Returns selected video. */
    public Video getSelectedVideo() {
        return selectedVideo;
    }
}
