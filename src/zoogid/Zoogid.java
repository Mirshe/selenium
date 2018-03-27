package zoogid;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import util.TestUtils;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by Mirshe on 12.03.2018.
 */
public class Zoogid {
    public static void main(String[] args) {
        TestUtils ese = new TestUtils();
        ArrayList<String> arr = new ArrayList<String>();
        //change file URL
        ese.leer("C:\\Users\\Mirshe\\IdeaProjects\\selenium\\src\\txts\\Zoogid.txt", arr);
        //insert URL
        ese.initialize("http://zoogid.by/admin755rqj1ko/");
        ese.pageLoaded();
        ese.mOverJava(By.id("maintab-AdminCatalog"));
        ese.isElement(By.cssSelector("#maintab-AdminCatalog .submenu"));
        ese.click(By.id("subtab-AdminProducts"));
        ese.pageLoaded();
        for (String anArr : arr) {
            String art = anArr.split("\\*\\*\\*")[0];
            String name = anArr.split("\\*\\*\\*")[1];
            String price = anArr.split("\\*\\*\\*")[2];
            String catal = anArr.split("\\*\\*\\*")[3];
            String devel = anArr.split("\\*\\*\\*")[4];
            String img = anArr.split("\\*\\*\\*")[5];
           ese.click(By.cssSelector("i.process-icon-new"));
            ese.pageLoaded();
            ese.pausa(1000);
            ese.typo(By.id("name_3"),name);
            ese.typo(By.id("reference"),art);
            ese.pausa(1000);
            ese.click("#link-Prices");
            ese.isElement(By.id("priceTE"));
            ese.driver.findElement(By.id("priceTE")).sendKeys(Keys.CONTROL + "a");
            ese.pausa(500);
            ese.driver.findElement(By.id("priceTE")).sendKeys(Keys.DELETE);
            ese.driver.findElement(By.id("priceTE")).sendKeys(price);
            ese.pausa(1000);
            ese.click("#link-Seo");
            ese.pausa(1000);
            ese.isElement(By.id("generate-friendly-url"));
            ese.click(By.id("generate-friendly-url"));
            ese.pausa(1000);
            ese.typo(By.id("meta_title_3"),"Купить "+name+" с доставкой");
            ese.typo(By.id("meta_description_3"),name+". Купить товар с доставкой в Минске и Беларуси");
            ese.click(By.id("link-Associations"));
            ese.isElement(By.linkText("- Выберите (не обязательно) -"));
            ese.click(By.cssSelector("div > b"));
            ese.driver.findElement(By.cssSelector(".chosen-search input")).sendKeys(devel);
            ese.isElement(By.className("active-result"));
            ese.click(".active-result");
          //  ese.click(By.xpath("//div[@class=\"chosen-drop\"]/ul[@class=\"chosen-results\"]/li[@class=\"active-result\" and text()="+devel+"]"));
ese.click(By.id("uncheck-all-associated-categories-tree"));
ese.click(By.id("expand-all-associated-categories-tree"));
            ese.pausa(1000);
            ese.actions.moveToElement(ese.driver.findElement(By.cssSelector("#link-Informations"))).perform();
            ese.pausa(1000);
            ese.click(By.xpath("(//input[@name='categoryBox[]'])["+catal+"]"));

            ese.pausa(1000);
            ese.click("[name='submitAddproductAndStay']");
            if(ese.elementExist(By.xpath("//button[@name='submitAddproductAndStay' and text()=' Сохранить и остаться']"))){
                while (!ese.elementExist(By.id("legend_3"))) {
                    ese.click("[name='submitAddproductAndStay']");
                }
            };
            ese.pageLoaded();
            ese.isElement(By.cssSelector("div.alert.alert-success"));
            ese.rob(KeyEvent.VK_END);
            ese.click(By.id("link-Images"));
            ese.isElement(By.id("legend_3"));
            ese.typo(By.id("legend_3"),name);
            ese.driver.findElement(By.id("file")).sendKeys(img);
            ese.pausa(1000);
            if(ese.elementExist(By.cssSelector("#file-files-list .form-group"))){
ese.click(By.id("file-upload-button"));
                ese.isElement(By.id("file-success"));
            }
            while(!ese.elementExist(By.linkText("Править"))){
ese.click(By.name("submitAddproduct"));
            }
        }
    }
}
