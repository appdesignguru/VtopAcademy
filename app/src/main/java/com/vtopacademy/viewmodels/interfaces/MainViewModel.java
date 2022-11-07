package com.vtopacademy.viewmodels.interfaces;

import androidx.lifecycle.MutableLiveData;
import com.vtopacademy.entities.Category;
import com.vtopacademy.entities.Subject;
import com.vtopacademy.entities.Topic;
import com.vtopacademy.entities.Video;
import com.vtopacademy.states.CategoryListUiState;
import com.vtopacademy.states.PaymentValidationUiState;
import com.vtopacademy.states.SubjectListUiState;
import com.vtopacademy.states.TopicListUiState;
import com.vtopacademy.states.VideoItemUiState;
import com.vtopacademy.states.VideoListUiState;

/** State holder interface for the UI screens. */
public interface MainViewModel {

    /** Returns CategoryUiState. */
    MutableLiveData<CategoryListUiState> getCategoryListUiState();

    /** Returns SubjectUiState. */
    MutableLiveData<SubjectListUiState> getSubjectListUiState();

    /** Returns TopicUiState. */
    MutableLiveData<TopicListUiState> getTopicListUiState();

    /** Returns VideoUiState. */
    MutableLiveData<VideoListUiState> getVideoListUiState();

    /** Returns VideoItemUiState. */
    MutableLiveData<VideoItemUiState> getVideoItemUiState();

    /** Returns PaymentValidationUiState. */
    MutableLiveData<PaymentValidationUiState> getPaymentValidationUiState();

    /** Sets selected category. */
    void setSelectedCategory(Category category);

    /** Sets selected subject. */
    void setSelectedSubject(Subject subject);

    /** Sets selected topic. */
    void setSelectedTopic(Topic topic);

    /** Sets selected video. */
    void setSelectedVideo(Video video);

}