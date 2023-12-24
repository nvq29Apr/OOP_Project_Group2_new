package collectors.post;

import collectors.Collector;
import dataprocessors.GetDataFromJson;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import models.Blog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BlogsCollector extends Collector<Blog> implements GetDataFromJson {

    public BlogsCollector() {
        super(BLOG_URL, BLOG_JSON_PATH);
    }

    public static void main(String[] args) throws InterruptedException, IOException{
        BlogsCollector blogsCollector = new BlogsCollector();
        blogsCollector.active();
    }

    @Override
    public void collect() {
        Set<String> nfts = getUniqueNFTNameToSearch();
        for (String nft : nfts){
            String url = BLOG_BASE_URL + nft ;
            driver.navigate().to(url);
            sleep(2);

            List<WebElement> webElements = driver.findElements(By.className("card-body"));
            for (int i = 0; i < webElements.size(); i++) {
                String[] webElementContents = webElements.get(i).getText().split("\n");
                String title = webElementContents[0];
                String info = webElementContents[1];
                WebElement linkElement = webElements.get(i).findElement(By.tagName("a"));
                String link = linkElement.getAttribute("href");

                WebElement imgElement = webElements.get(i).findElement(By.tagName("img"));
                String imgSrc = imgElement.getAttribute("src");

                objects.add(new Blog(title, info, imgSrc, link));
            }
        }
    }

}