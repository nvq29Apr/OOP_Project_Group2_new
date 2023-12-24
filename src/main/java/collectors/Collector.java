package collectors;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import models.ConstantVar;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 *
 * @author quyetdaika
 * @param <T>
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
    }
    
    public void active() throws InterruptedException, IOException {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        driver = new FirefoxDriver(options);        
        driver.get(url);    
        Thread.sleep(5000);
        
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
    
    public <O> void saveToJSON(List<O> objs, String JSONPath) throws IOException {
        String json = gson.toJson(objs);
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
}
