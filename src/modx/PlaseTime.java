package modx;

import org.json.JSONArray;
import org.json.JSONException;
import org.openqa.selenium.By;
import util.TestUtils;

import java.util.ArrayList;

/**
 * Created by Mirshe on 12.03.2018.
 */
public class PlaseTime {
    public static void main(String[] args) {
        TestUtils ese = new TestUtils();
        ArrayList<String> arr = new ArrayList<String>();
        //change file URL
        ese.leer("C:\\Users\\Mirshe\\IdeaProjects\\selenium\\src\\txts\\PlaceTime.txt", arr);
        //insert URL
        ese.initialize("https://placeandtime.pl/manager/?a=index&namespace=migx&configs=news");
        ese.pageLoaded();
        for (String anArr : arr) {
            String name = anArr.split("<\\*\\*\\*>")[0];
            String text = anArr.split("<\\*\\*\\*>")[1];
            String url = ese.transliterate(name);
            ese.checkUrl(url);
            String title = anArr.split("<\\*\\*\\*>")[2];
            String mainimg = anArr.split("<\\*\\*\\*>")[3];
            String bigimg = anArr.split("<\\*\\*\\*>")[5];
            String cropimg = anArr.split("<\\*\\*\\*>")[6];


            ese.isElement(By.xpath("//button[text()='Добавить ']"));
            ese.click(By.xpath("//button[text()='Добавить ']"));
            ese.isElement(By.id("modx-window-mi-grid-update-migxdb"));
            ese.isElement(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_1')]"));
            ese.typo(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_1')]"),name);
                ese.click(By.xpath("//div[contains(@class,'x-window-mc')]//ul[contains(@class,'x-tab-strip')]/li[2]"));
            //ese.click(By.xpath("(//span[text()='Описание и доп. параметры']"));
            ese.isElement(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_6')]"));
            ese.typo(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_6')]"),name);
            ese.click(By.xpath("//a[@title=\"Редактировать HTML код\"]"));
            String winHandleBefore = ese.driver.getWindowHandle();
            for(String winHandle : ese.driver.getWindowHandles()){
                ese.driver.switchTo().window(winHandle);
            }
            ese.typo(By.id("htmlSource"),text);
            ese.click(By.id("insert"));
            ese.driver.switchTo().window(winHandleBefore);
            ese.click(By.xpath("//div[contains(@class,'x-window-mc')]//ul[contains(@class,'x-tab-strip')]/li[3]"));
            ese.isElement(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_9')]"));
            ese.typo(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_9')]"),url);
            ese.typo(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_10')]"),title);
            ese.typo(By.xpath("//input[contains(@id,\"tvinp_\") and contains(@id,'_1_11')]"),name+" ➢ Wiadomości portalu placeandtime.pl");
            ese.click(By.xpath("//div[contains(@class,'x-window-mc')]//ul[contains(@class,'x-tab-strip')]/li[4]"));
            ese.isElement(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,'_1_15')]"));
            ese.typo(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,'_1_15')]"),mainimg);
            ese.click(By.xpath("//div[contains(@class,'x-window-mc')]//ul[contains(@class,'x-tab-strip')]/li[4]"));
            JSONArray images = null;
            try {
                images = new JSONArray(anArr.split("<\\*\\*\\*>")[4]);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Object image = null;
            for (int i = 0; i < images.length(); i++) {
                try {
                    image = images.get(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ese.click(By.xpath("//button[text()='Добавить картинку']"));
                ese.isElement(By.xpath("//input[contains(@id,'tvbrowserinp_') and contains(@id,'_1_16_1')]"));
                ese.driver.findElement(By.xpath("//input[contains(@id,'tvbrowserinp_') and contains(@id,'_1_16_1')]")).sendKeys("");
                ese.typo("input[id*=\"tvbrowserinp_\"][id*=\"_1_16_1\"]",image.toString());
                ese.click(By.className("x-window-mc"));
                //driver.findElement(By.xpath("//input[contains(@id,'tvinp_') and contains(@id,'_9_2')]")).sendKeys("");
                ese.click(By.xpath("(//button[text()='Выполнено'])[2]"));
            }
            ese.typo(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,'_1_17')]"),bigimg);
            ese.click(By.xpath("//div[contains(@class,'x-window-mc')]//ul[contains(@class,'x-tab-strip')]/li[4]"));
            ese.typo(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,'_1_18')]"),cropimg);
            ese.click(By.xpath("//button[text()='Выполнено']]"));
        }
    }
}
