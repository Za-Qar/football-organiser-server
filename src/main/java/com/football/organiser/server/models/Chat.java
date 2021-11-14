package com.football.organiser.server.models;

import java.util.Objects;
import com.google.cloud.Timestamp;

public class Chat {
    private String text;
    private Timestamp sentTimeStamp;
    private String uid;
    private String photoURL;

    public Chat(String text, Timestamp sentTimeStamp, String uid, String photoURL) {
        this.text = text;
        this.sentTimeStamp = sentTimeStamp;
        this.uid = uid;
        this.photoURL = photoURL;
    }

    public Chat() {
    }

    public String getText() {
        return text;
    }

    public Timestamp getSentTimeStamp() {
        return sentTimeStamp;
    }

    public String getUid() {
        return uid;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSentTimeStamp(Timestamp sentTimeStamp) {
        this.sentTimeStamp = sentTimeStamp;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "text='" + text + '\'' +
                ", sentTimeStamp='" + sentTimeStamp + '\'' +
                ", uid=" + uid +
                ", photoUrl='" + photoURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return uid == chat.uid && Objects.equals(text, chat.text) && Objects.equals(sentTimeStamp, chat.sentTimeStamp) && Objects.equals(photoURL, chat.photoURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sentTimeStamp, uid, photoURL);
    }
}
