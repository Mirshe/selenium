package modx;

import org.openqa.selenium.By;
import util.TestUtils;

import java.util.ArrayList;

/**
 * Created by Mirshe on 12.03.2018.
 */
public class folksKamen {
    public static void main(String[] args) {
        TestUtils ese = new TestUtils();
        ArrayList<String> arr = new ArrayList<String>();
        //change file URL
        ese.leer("C:\\Users\\Mirshe\\IdeaProjects\\selenium\\src\\txts\\folksKamen.txt", arr);
        //insert URL
        ese.initialize("http://folk-kamen.lovegrizzly.ml/manager/");
        ese.pageLoaded();
        int id = 3;
        int[] ids = {86,88      };
        for (int i = 0; i < ids.length; i++) {
            ese.isElement(By.xpath("//a//span[text()='("+ids[i]+")']"));
            ese.click(By.xpath("//span[text()='("+ids[i]+")']"));
            ese.pageLoaded();
            ese.click(By.id("modx-resource-tabs__modx-panel-resource-tv"));
            ese.click(By.xpath("//li[contains(@id,'modx-resource-vtabs__')]/span[text()='Изображения']"));
            ese.typo(By.id("tvbrowser3"));
            ese.typo(By.id("tvbrowser3"),"images/vert_pam/new_2/"+id+"-1.jpg");
            for (int j = 1; j < 4; j++) {
                ese.click(By.xpath("//div[@id='tv20_items']//button[text()='Добавить элемент']"));
                ese.isElement(By.className("x-window-mc"));
                ese.isElement(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,\"_20_1\")]"));
                ese.typo(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,\"_20_1\")]"));
                ese.typo(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,\"_20_1\")]"),"images/vert_pam/new_2/"+id+"-"+j+".jpg");
                ese.click(By.className("x-window-mc"));
                ese.click(By.xpath("//button[text()=\"Выполнено\"]"));
            }
            ese.click(By.id("modx-abtn-save"));
            ese.pausa(200);
            ese.ronda();
            id++;
        }

    }
}
