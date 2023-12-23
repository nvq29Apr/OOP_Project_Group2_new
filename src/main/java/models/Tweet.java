package models;

import java.util.List;

/**
 *
 * @author quyetdaika
 */
public class Tweet {
    private String name, user, content, comment, retweet, like, view;
    private List<String> hashtags;
    private String createdAt;

    public Tweet(String name, String user, String content, String comment, String retweet, String like, String view, List<String> hashtags, String createdAt) {
        this.name = name;
        this.user = user;
        this.content = content;
        this.comment = comment;
        this.retweet = retweet;
        this.like = like;
        this.view = view;
        this.hashtags = hashtags;
        this.createdAt = createdAt;
    } 
}
