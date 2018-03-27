import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by Mirshe on 07.03.2018.
 */
public class TestUtils {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        
    }
    public void ronda(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.driver.findElements(By.className("x-mask-loading")).size() != 0) {
            this.wait.until(ExpectedConditions.stalenessOf(this.driver.findElement(By.className("x-mask-loading"))));
            System.out.println("ronda_fin");
        }
    }
    public void escripto(String script){
        this.wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript(script).equals(true);
            }
        });
    }
    public void typo(String selector,String data){
        sb.setLength(0);
        this.wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript((sb.append("document.querySelectorAll('").append(selector).append("')[0].value = '").append(data).append("'; return true")).toString());
            }
        });
    }
    public void pausa(int sec){
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void leer(ArrayList<String> ar){
        try {
            try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Mirshe\\IdeaProjects\\selenium\\out\\production\\selenium\\1.txt").toAbsolutePath(), Charset.defaultCharset())) {
                lines.forEach(s -> ar.add(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void initialize(String url){
        System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=D:/grizzly","--start-maximized");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, 5000);
        this.actions = new Actions(driver);
        this.driver.get(url);

    }
    public void pageLoaded(){
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        System.out.println("CARGADO");
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        this.wait.until(pageLoadCondition);
    }
    public void isElement(By find){
        this.wait.until(ExpectedConditions.presenceOfElementLocated(find));
    }
    public void clickJS(String domSelector){
        sb.setLength(0);
        this.wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript((sb.append("document.querySelectorAll(\"").append(domSelector).append("\")[0].click(); return true")).toString()).equals(true);
            }
        });
    }
    public void clickJava(By element){
        this.actions.moveToElement(this.driver.findElement(element)).click().build().perform();
    }
    public void rClickJava(By element){
        this.actions.moveToElement(this.driver.findElement(element)).contextClick().build().perform();
    }
    public void mOverJava(By element){
        this.actions.moveToElement(this.driver.findElement(element)).perform();
    }
}
