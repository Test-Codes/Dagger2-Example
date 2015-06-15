package io.realm.dagger2.example.models;

/**
 * Created by TheFinestArtist on 6/15/15.
 */
public class Tweet {

    private String message;
    private String username;

    public Tweet(String message, String username) {
        this.message = message;
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
