package modx;

/**
 * Created by Mirshe on 12.03.2018.
 */

import org.openqa.selenium.By;
import util.TestUtils;

import java.util.ArrayList;

public class MigXImages {
    public static void main(String[] args) {
        String fin = "_16_1";
        TestUtils ese = new TestUtils();
        ArrayList<String> arr = new ArrayList<String>();
        ese.leer("C:\\Users\\Mirshe\\IdeaProjects\\selenium\\src\\txts\\MigXImages.txt", arr);
        ese.initialize("http://ilosos.lovegrizzly.ml/manager/?a=resource/update&id=3");
        ese.pageLoaded();
        ese.click(By.id("modx-resource-tabs__modx-panel-resource-tv"));
        ese.click(By.id("modx-resource-vtabs__ext-comp-1061"));
        for (String anArr : arr) {
            ese.click(By.xpath("(//button[text()='Добавить элемент'])[2]"));
            ese.isElement(By.className("x-window-mc"));
            ese.isElement(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,\""+fin+"\")]"));
            ese.typo(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,\""+fin+"\")]"));
            ese.typo(By.xpath("//input[contains(@id,\"tvbrowserinp_\") and contains(@id,\""+fin+"\")]"),anArr);
            ese.click(By.className("x-window-mc"));
            ese.click(By.xpath("(//button[text()=\"Выполнено\"])"));
        }
    }
}

