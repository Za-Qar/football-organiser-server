package com.football.organiser.server.models;

import java.util.Objects;

public class Chat {
    private String text;
    private String timeStamp;
    private int uid;
    private String photoUrl;

    public Chat(String text, String timeStamp, int uid, String photoUrl) {
        this.text = text;
        this.timeStamp = timeStamp;
        this.uid = uid;
        this.photoUrl = photoUrl;
    }

    public String getText() {
        return text;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public int getUid() {
        return uid;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "text='" + text + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", uid=" + uid +
                ", photoUrl='" + photoUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return uid == chat.uid && Objects.equals(text, chat.text) && Objects.equals(timeStamp, chat.timeStamp) && Objects.equals(photoUrl, chat.photoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, timeStamp, uid, photoUrl);
    }
}
