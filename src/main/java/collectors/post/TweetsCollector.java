package collectors.post;

/**
 *
 * @author quyetdaika
 */
import collectors.Collector;
import dataprocessors.GetDataFromJson;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Hashtag;
import models.Tweet;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TweetsCollector extends Collector<Tweet> implements GetDataFromJson {
    private HashMap<String, Integer> hashtagsMap;
    
    public TweetsCollector() {
        super(TWITTER_URL, TWEET_JSON_PATH);
        hashtagsMap = new HashMap<>();
    }
    
    @Override
    public void collect() {
        login();
        
        int totalTweets = 0;
        
        Set<String> uniqueNames = getUniqueNFTNameToSearch();
        for(String uniqueName : uniqueNames){
            String url = TWITTER_BASE_URL + uniqueName + TWITTER_SEARCH_FILTERS;
            driver.navigate().to(url);
            sleep(5);
            
            if(checkLimited()) break;
            
            List<WebElement> currentTweets = null;
            try {
                currentTweets = driver.findElements(By.cssSelector("article[role=article]"));
            }
            catch(org.openqa.selenium.NoSuchElementException e) {
                // Khong co tweet nao
                continue;
            }
            
            for (WebElement tweet : currentTweets) {
                // Lấy nội dung tweet

                // Lấy thời gian
                // Kiểm tra có phải quảng cáo không (quang cao se khong co nhan thoi gian)
                String createdAt = "";
                try {
                    WebElement timeElement = tweet.findElement(By.xpath("div/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[3]/a/time"));
                    createdAt = timeElement.getAttribute("datetime");
                }
                catch(org.openqa.selenium.NoSuchElementException e) {
                    // Quang cao
                    continue;
                }

                // Kiểm tra nếu bài viết quá dài, sẽ có nút Show more
                try {
                    WebElement showmoreElement = tweet.findElement(By.cssSelector("data-testid[tweet-text-show-more-link]"));
                    continue; // Bỏ qua những bài như vậy
                }
                catch(org.openqa.selenium.NoSuchElementException e) {
                    // System.out.println("Không có nút Show More");
                }

                // Lấy thông tin người đăng
                WebElement nameElement = tweet.findElement(By.xpath("div/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div[1]/div/a/div/div[1]/span/span"));
                String name = nameElement.getText();

                WebElement userElement = tweet.findElement(By.xpath("div/div/div[2]/div[2]/div[1]/div/div[1]/div/div/div[2]/div/div[1]/a/div/span"));
                String user = userElement.getText();

                // Lấy nội dung toàn bộ bài viết
                WebElement contentElement = tweet.findElement(By.xpath("div/div/div[2]/div[2]/div[2]"));
                String content = contentElement.getText();

                // Lấy hashtags
                List<WebElement> hashtagElement = contentElement.findElements(By.cssSelector("a[href^='/hashtag/']"));
                List<String> hashtags = new ArrayList<>();
                for(WebElement x : hashtagElement){
                    hashtags.add(x.getText());
                }
                putHashtagToMap(hashtags);

                // Lấy số lượt comment, retweet, like, view
                WebElement interactElement = tweet.findElement(By.cssSelector("div.css-175oi2r.r-1kbdv8c.r-18u37iz.r-1wtj0ep.r-1ye8kvj.r-1s2bzr4"));
                String[] interactValues = interactElement.getText().split("\n");
                String[] interacts = new String[4];
                // Có thể có bài viết không hiển thị số view
                for(int i = 0; i < interactValues.length; i++) interacts[i] = interactValues[i];

                // Thêm vào danh sách để xử lý, lưu trữ
                // Tweet(String name, String user, String content, String comment, String retweet, String like, String view, List<String> hashtags, String createdAt)
                objects.add(new Tweet(name, user, content, interacts[0], interacts[1], interacts[2], interacts[3], hashtags, createdAt, uniqueName));
            }
//            System.out.println("Số tweet đã lấy hiện tại: " + currentTweets.size()); 
            totalTweets += currentTweets.size();
        }
        System.out.println("Collected " + totalTweets + " Tweets!");
        
        try {
            storeHashtag();
        } catch (IOException ex) {
            Logger.getLogger(TweetsCollector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void login(){
        // Vào trình duyệt ẩn danh
        options.addArguments("-private");
            
        // Tìm element input login
        WebElement usernameInput = driver.findElement(By.cssSelector("input[autocomplete='username'][name='text']"));
        usernameInput.sendKeys(TWITTER_USERNAME);
        usernameInput.sendKeys(Keys.ENTER);
        sleep(5);

        // Nếu báo đăng nhập bất thường
        try {
            WebElement authen = driver.findElement(By.cssSelector("input[data-testid='ocfEnterTextTextInput'][value='']"));
            authen.sendKeys("daika_quyet");
            authen.sendKeys(Keys.ENTER);
        }
        catch(org.openqa.selenium.NoSuchElementException e) {
            
        }

        sleep(5);
        WebElement password = driver.findElement(By.cssSelector("input[autocomplete='current-password'][name='password']"));
        password.sendKeys(TWITTER_PASSWORD);
        password.sendKeys(Keys.ENTER);
        sleep(5);
    }
    
    private boolean checkLimited(){
        boolean limit = false;
        try {
            WebElement retryButton = driver.findElement(By.cssSelector(".css-175oi2r.r-sdzlij.r-1phboty.r-rs99b7.r-lrvibr.r-2yi16.r-1qi8awa.r-ymttw5.r-1loqt21.r-o7ynqc.r-6416eg.r-1ny4l3l"));
            // Limited
            limit = true;
        } catch(org.openqa.selenium.NoSuchElementException e) {
            limit = false;
        }
        return limit;
    }
    
    private void putHashtagToMap(List<String> hashtags){
        for(String hashtag : hashtags){
            if(hashtag.equals("")) continue;
            if(hashtagsMap.containsKey(hashtag)){
                int oldValue = hashtagsMap.get(hashtag);
                hashtagsMap.replace(hashtag, oldValue + 1);
            }
            else{
                hashtagsMap.put(hashtag, 1);
            }
        }
    }
    
    private void storeHashtag() throws IOException{
        List<Hashtag> hashtags = new ArrayList<>();
        Set<Map.Entry<String, Integer>> entrySet = hashtagsMap.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            Hashtag hashtag = new Hashtag(entry.getKey(), entry.getValue());
            hashtags.add(hashtag);
        }
        saveToJSON(hashtags, HASHTAG_JSON_PATH);
    }
}

