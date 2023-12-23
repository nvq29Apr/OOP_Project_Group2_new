package collectors;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import models.ConstantVar;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 *
 * @author quyetdaika
 */
public abstract class Collector<T> implements ConstantVar{
    protected String url, JSONPath;
    protected List<T> objects;
    protected WebDriver driver;
    protected FirefoxOptions options;
    protected Gson gson;
    
    public Collector(String URL, String JSONPath) {
        this.url = URL;
        this.JSONPath = JSONPath;
        gson = new Gson();
        objects = new ArrayList<>();
        options = new FirefoxOptions();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void active() throws InterruptedException, IOException {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); //Config môi trường để web chạy
        driver = new FirefoxDriver(options);        
        driver.get(url);  //Đưa url vào web để dẫn đến trang ở đây truyền trực tiếp nhưng thường hãy tách biến ra và config cứng lại       
        Thread.sleep(5000); // Đợi 5s để web ổn định có thể lấy dễ hơn
        
        collect();
        saveToJSON();
        driver.quit();
    }

    public abstract void collect();

    public void saveToJSON() throws IOException {
        String json = gson.toJson(objects);
        FileWriter writer = new FileWriter(JSONPath); 
        writer.write(json);
        writer.close();
    }
    
    public void clickByJS(WebElement we){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", we);
    }
    
    public void sleep(int sections){
        try {
            Thread.sleep(sections * 1000);
        } catch (InterruptedException ex) {
            
        }
    }
    
//    public void waitElement(String cssSelector){
//        try{
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
//        } catch(NoSuchElementException e){
//            
//        }
//    }
}
