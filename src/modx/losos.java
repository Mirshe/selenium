package modx;

import org.openqa.selenium.By;
import util.TestUtils;

import java.util.ArrayList;

/**
 * Created by Mirshe on 12.03.2018.
 */
public class losos {
    public static void main(String[] args) {
        TestUtils ese = new TestUtils();
        ArrayList<String> arr = new ArrayList<String>();
        //change file URL
        ese.leer("D:\\move_to_griz\\selenium\\src\\txts\\losos.txt", arr);
        //insert URL
        ese.initialize("http://ilosos.lovegrizzly.ml/manager/");
        ese.pageLoaded();
        for (String anArr : arr) {
            String name = anArr.split("<\\*\\*\\*>")[0];
            String title = anArr.split("<\\*\\*\\*>")[1];
            String desc = anArr.split("<\\*\\*\\*>")[2];
            String cont = anArr.split("<\\*\\*\\*>")[3];
            ese.ronda();
            ese.isElement(By.xpath("//a/span[text()='Услуги ']"));
            ese.rClickJava(By.xpath("//a/span[text()='Услуги ']"));
            ese.isElement(By.className("x-menu-floating"));
            ese.mOverJava(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Создать\"]"));
            ese.isElement(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Документ\"]"));
            ese.click(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Документ\"]"));
            ese.pageLoaded();
            ese.typo("#modx-resource-pagetitle",name);
            ese.typo("#modx-resource-longtitle",title);
            ese.typo("#modx-resource-description",desc);
            ese.click(By.id("modx-resource-published"));
            ese.click(By.id("tiny-toggle-rte"));
            ese.typo("#ta",cont);
            ese.click("#x-form-el-modx-resource-template .x-form-arrow-trigger");
            ese.pausa(500);
            ese.driver.findElement(By.id("modx-resource-template")).sendKeys("Услуга");
            ese.click(By.id("modx-abtn-save"));
            ese.pageLoaded();
        }
    }
}
