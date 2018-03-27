package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by Mirshe on 07.03.2018.
 */
public class TestUtils {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public Robot r;
    public StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

    }

    public void ronda() {
this.pausa(2000);
        if (this.elementExist(By.className("x-mask-loading"))) {
            this.wait.until(ExpectedConditions.stalenessOf(this.driver.findElement(By.className("x-mask-loading"))));
            System.out.println("ronda_fin");
        }
    }

    public void escripto(String script) {
        this.wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript(script).equals(true);
            }
        });
    }

    public void typo(String selector, String data) {
        sb.setLength(0);
        this.wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript((sb.append("document.querySelectorAll('").append(selector).append("')[0].value = '").append(data).append("'; return true")).toString());
            }
        });
    }

    public void typo(By selector, String data) {
        sb.setLength(0);
        this.wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript((sb.append("arguments[0].value = '").append(data).append("'; return true")).toString(), driver.findElement(selector));
            }
        });
    }

    public void pausa(int sec) {
        try {
            Thread.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void leer(String url, ArrayList<String> ar) {
        try {
            try (Stream<String> lines = Files.lines(Paths.get(url).toAbsolutePath(), Charset.defaultCharset())) {
                lines.forEach(s -> ar.add(s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize(String url) {
        try {
            this.r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=D:/grizzly", "--start-maximized");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, 5000);
        this.actions = new Actions(driver);
        this.driver.get(url);

    }

    public void pageLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        System.out.println("CARGADO");
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        this.wait.until(pageLoadCondition);
    }

    public void isElement(By find) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(find));
    }
    public Boolean elementExist(By find){
        return this.driver.findElements(find).size() != 0;
    }

    public void click(String domSelector) {
        sb.setLength(0);
        this.wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver)
                        .executeScript((sb.append("document.querySelectorAll(\"").append(domSelector).append("\")[0].click(); return true")).toString()).equals(true);
            }
        });
    }

    public void click(By element) {
        this.actions.moveToElement(this.driver.findElement(element)).click().build().perform();
    }

    public void rClickJava(By element) {
        this.actions.moveToElement(this.driver.findElement(element)).contextClick().build().perform();
    }

    public void mOverJava(By element) {
        this.actions.moveToElement(this.driver.findElement(element)).perform();
    }

    public void typo(By element) {
        this.driver.findElement(element).sendKeys("");
    }

    public String transliterate(String message) {
        char[] abcCyr = {' ', 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '.', ',', '!', '?', ';', ':', '/', '_', '(', ')', '-', '"', '\'', '№', '+', '#', '«', '»', '[', ']', '–', '&', '|', '=','1','2','3','4','5','6','7','8','9','0'};
        String[] abcLat = {"-", "a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "y", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ts", "ch", "sh", "sch", "", "i", "", "e", "ju", "ja", "A", "B", "V", "G", "D", "E", "E", "Zh", "Z", "I", "Y", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "Ts", "Ch", "Sh", "Sch", "", "I", "", "E", "Ju", "Ja", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "-", "-", "", "", "-", "-", "-", "-", "", "", "-", "", "", "N", "-", "", "", "", "", "", "-", "-", "-", "-","1","2","3","4","5","6","7","8","9","0"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            for (int x = 0; x < abcCyr.length; x++) {
                if (message.charAt(i) == abcCyr[x]) {
                    builder.append(abcLat[x]);
                }
            }
        }
        return (builder.toString().replaceAll("-+", "-").replaceAll("-$", "")).toLowerCase();
    }

    public void checkUrl(String s) {
        String pattern = "(?i)[^a-z0-9\\-]+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(s);
        if(m.find()){
            System.out.println("-----!URL no vale!-----");
        }
    }
    public void checkDescr(String s){
       if((s.length()>156)){
           System.out.println("-----!Describsion no vale!-----");
       }
    }
    public void checkTitle(String s){
        if((s.length()>65)){
            System.out.println("-----!Titulo no vale!-----");
        }
    }
    public void selectDropdown(By element,int index){
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByIndex(index);
    }
    public void selectDropdown(By element,String s){
        Select dropdown = new Select(driver.findElement(element));
        dropdown.selectByVisibleText(s);
    }
    public By getLink(String s){
        sb.setLength(0);
        return By.xpath((sb.append("//a[contains(text(),'").append(s).append("')]")).toString());
    }
    public void rob(int k){
        r.delay(1000);
           r.keyPress(k);
        r.delay(1000);
    }


}
