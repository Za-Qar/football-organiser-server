package com.football.organiser.server.models;

import java.util.Objects;
import com.google.cloud.Timestamp;

public class Chat {
    private String text;
    private Timestamp sentTimeStamp;
    private String uuid;
    private String photoURL;

    public Chat(String text, Timestamp sentTimeStamp, String uuid, String photoURL) {
        this.text = text;
        this.sentTimeStamp = sentTimeStamp;
        this.uuid = uuid;
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
        return uuid;
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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "text='" + text + '\'' +
                ", sentTimeStamp='" + sentTimeStamp + '\'' +
                ", uuid=" + uuid +
                ", photoUrl='" + photoURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return uuid == chat.uuid && Objects.equals(text, chat.text) && Objects.equals(sentTimeStamp, chat.sentTimeStamp) && Objects.equals(photoURL, chat.photoURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, sentTimeStamp, uuid, photoURL);
    }
}
