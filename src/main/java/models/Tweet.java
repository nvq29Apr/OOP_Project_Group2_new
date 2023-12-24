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
    private String relatedNFT;

    public Tweet(String name, String user, String content, String comment, String retweet, String like, String view, List<String> hashtags, String createdAt, String relatedNFT) {
        this.name = name;
        this.user = user;
        this.content = content;
        this.comment = comment;
        this.retweet = retweet;
        this.like = like;
        this.view = view;
        this.hashtags = hashtags;
        this.createdAt = createdAt;
        this.relatedNFT = relatedNFT;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public String getComment() {
        return comment;
    }

    public String getRetweet() {
        return retweet;
    }

    public String getLike() {
        return like;
    }

    public String getView() {
        return view;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public String getRelatedNFT() {
        return relatedNFT;
    }
}
