package com.vtopacademy.viewmodels.fakes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
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
import com.vtopacademy.viewmodels.interfaces.MainViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/** Fake MainViewModel implementation class. */
@HiltViewModel
public class FakeMainViewModel extends ViewModel implements MainViewModel {

    private Category selectedCategory;
    private Subject selectedSubject;
    private Topic selectedTopic;
    private Video selectedVideo;

    /** Constructs a new instance. */
    @Inject
    public FakeMainViewModel(){

    }

    @Override
    public MutableLiveData<CategoryListUiState> getCategoryListUiState() {
        MutableLiveData<CategoryListUiState> categoryListUiState = new MutableLiveData<>();

        List<Category> testCategories = new ArrayList<>();
        testCategories.add(new Category(1, 1, "JAMB"));
        testCategories.add(new Category(2, 2, "SS3"));

        categoryListUiState.setValue(new CategoryListUiState(false, testCategories));

        return categoryListUiState;
    }

    @Override
    public MutableLiveData<SubjectListUiState> getSubjectListUiState() {
        MutableLiveData<SubjectListUiState> subjectListUiState = new MutableLiveData<>();

        List<Subject> testSubjects = new ArrayList<>();
        testSubjects.add(new Subject(1, 1, "English", false));
        testSubjects.add(new Subject(2, 2, "Physics", false));

        subjectListUiState.setValue(new SubjectListUiState(false, testSubjects, selectedCategory));

        return subjectListUiState;
    }

    @Override
    public MutableLiveData<TopicListUiState> getTopicListUiState() {
        MutableLiveData<TopicListUiState> topicListUiState = new MutableLiveData<>();

        List<Topic> testTopics = new ArrayList<>();
        testTopics.add(new Topic(1, 1, "Topic 1", 2));
        testTopics.add(new Topic(2, 2, "Topic 2", 3));

        topicListUiState.setValue(
                new TopicListUiState(false, testTopics, selectedCategory, selectedSubject)
        );

        return topicListUiState;
    }

    @Override
    public MutableLiveData<VideoListUiState> getVideoListUiState() {
        MutableLiveData<VideoListUiState> videoListUiState = new MutableLiveData<>();

        List<Video> testVideos = new ArrayList<>();
        testVideos.add(
                new Video(1,  1, "Video Title 1", "youtubeID 1", "10", 2)
        );
        testVideos.add(
                new Video(2,  1, "Video Title 2", "youtubeID 2", "10", 2)
        );

        videoListUiState.setValue(new VideoListUiState(false, testVideos, selectedCategory,
                selectedSubject, selectedTopic));

        return videoListUiState;
    }

    @Override
    public MutableLiveData<VideoItemUiState> getVideoItemUiState() {
        MutableLiveData<VideoItemUiState> videoItemUiState = new MutableLiveData<>();
        videoItemUiState.setValue(
                new VideoItemUiState(selectedCategory, selectedSubject, selectedTopic, selectedVideo)
        );
        return videoItemUiState;
    }

    @Override
    public MutableLiveData<PaymentValidationUiState> getPaymentValidationUiState() {
        MutableLiveData<PaymentValidationUiState> paymentValidationUiState = new MutableLiveData<>();
        paymentValidationUiState.setValue(new PaymentValidationUiState(false, true));
        return null;
    }

    @Override
    public void setSelectedCategory(Category category) {
        selectedCategory = category;
    }

    @Override
    public void setSelectedSubject(Subject subject) {
        selectedSubject = subject;
    }

    @Override
    public void setSelectedTopic(Topic topic) {
        selectedTopic = topic;
    }

    @Override
    public void setSelectedVideo(Video video) {
        selectedVideo = video;
    }
}
