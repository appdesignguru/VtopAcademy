package com.vtopacademy.entities;

import java.util.Date;

public class Video {

    private final int videoID;
    private final int number;
    private final String title;
    private final String youtubeID;
    private final String size;
    private final int topicID;
    private Date dateSavedToLocalDatabase;

    public Video(int videoID, int number, String title,
                 String youtubeID, String size, int topicID) {
        this.videoID = videoID;
        this.number = number;
        this.title = title;
        this.youtubeID = youtubeID;
        this.size = size;
        this.topicID = topicID;
    }

    public int getVideoID() {
        return videoID;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getYoutubeID() {
        return youtubeID;
    }

    public String getSize() {
        return size;
    }

    public int getTopicID() {
        return topicID;
    }

    public Date getDateSavedToLocalDatabase() {
        return dateSavedToLocalDatabase;
    }

    public void setDateSavedToLocalDatabase(Date dateSavedToLocalDatabase) {
        this.dateSavedToLocalDatabase = dateSavedToLocalDatabase;
    }
}