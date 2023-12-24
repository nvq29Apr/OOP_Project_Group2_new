/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package models;

/**
 *
 * @author quyetdaika
 */
public interface ConstantVar {
    String TWITTER_URL = "https://twitter.com/i/flow/login";
    String TWITTER_USERNAME = "nvquyet2904@gmail.com";
    String TWITTER_PASSWORD = "quyetdaika2803";
    String TWITTER_BASE_URL = "https://twitter.com/search?q=%22";
    String TWITTER_SEARCH_FILTERS = "%22%20(%23NFT%20OR%20%23NFTCommunity)%20min_replies%3A1%20min_faves%3A1%20min_retweets%3A1%20-filter%3Areplies&src=typed_query";
    
    String BINANCE_URL = "https://www.binance.com/en/nft/ranking?tab=trend&chain=ALL";
    String BINANCE_TIMING_XPATH = "/html/body/div[3]/div/div[2]/main/div/div/div/div[1]/div[2]/div[2]/div";
    
    String NFT_JSON_PATH = "./json/NFTsFromBinance.json";
    String TWEET_JSON_PATH = "./json/Tweets.json";
    String HASHTAG_JSON_PATH = "./json/Hashtags.json";
}
