package collectors.nft;

/**
 *
 * @author quyetdaika
 */
import collectors.Collector;
import dataprocessors.GetDataFromJson;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import models.NFT;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class NFTsCollector extends Collector<NFT> implements GetDataFromJson{
    public NFTsCollector() {
        super(BINANCE_URL, NFT_JSON_PATH);
    }

    @Override
    public void collect() {
        try {
            WebElement acceptButton = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
            acceptButton.click();
        }
        catch (NoSuchElementException e) {
            //
        }
        try {
            WebElement acceptButton2 = driver.findElement(By.cssSelector("button.css-1s94759"));
            clickByJS(acceptButton2);
        }
        catch (NoSuchElementException e) {
            //
        }
        
        Set<String> nameUniques = new HashSet<>();
        // List of timing 1H 6H 24H 7D
        List<WebElement> timeSlots = driver.findElements(By.xpath(BINANCE_TIMING_XPATH));
        for(WebElement h : timeSlots){
            clickByJS(h);
            sleep(3);
            List<WebElement> dataEachRow = driver.findElements(By.cssSelector("div.css-kyd4a2"));
            for(WebElement x : dataEachRow) {
                String name = x.findElement(By.className("css-1iqk42z")).getText();
                nameUniques.add(name);
                
                String volume = x.findElement(By.className("css-q3dmv4")).getText();

                String change = x.findElement(By.className("css-1g8p7ho")).getText() + "%";

                String floorPrice = x.findElement(By.className("css-t03i0x")).getText();

                String owners = x.findElements(By.className("css-15n6x8q")).get(0).getText();
                
                String items = x.findElements(By.className("css-15n6x8q")).get(1).getText();
                
                objects.add(new NFT(name, volume, change, floorPrice, owners, items, h.getText()));
            }
        }
        
        System.out.println("Collected " + nameUniques.size() + " NFTs!");
    }
}
