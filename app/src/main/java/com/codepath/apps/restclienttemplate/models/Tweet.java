package com.codepath.apps.restclienttemplate.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    private String body;
    private User user;
    private String date;
    private String url;

    //Empty constructor used by the parceler library
    public Tweet() {}

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.date = jsonObject.getString("created_at");

        try {
            tweet.url = jsonObject.getJSONObject("entities")
                    .getJSONArray("media")
                    .getJSONObject(0)
                    .getString("media_url_https");
        } catch (JSONException e) {
            tweet.url = "";
        }

        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

    public String getBody() {
        return body;
    }

    public User getUser() {
        return user;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
