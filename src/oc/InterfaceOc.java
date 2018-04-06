package oc;

import org.json.JSONArray;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import util.TestUtils;

import java.util.ArrayList;

/**
 * Created by Mirshe on 12.03.2018.
 */
public class InterfaceOc {
    public static void main(String[] args) {
        String escuela = "Интерфейс";
        String escuelaName = "Учебный центр \"Интерфейс\"";
       TestUtils ese = new TestUtils();
      ArrayList<String> arr = new ArrayList<String>();
        //change file URL
       ese.leer("D:\\move_to_griz\\selenium\\src\\txts\\Interface.txt", arr);
        //editToken
      ese.initialize("https://liga42.com/admin/");
      ese.pageLoaded();
        ese.click(By.cssSelector("#content > div > div > div > div > div.panel-body > form > div.text-right > button"));
        ese.mOverJava(By.id("menu-catalog"));
        ese.click(By.linkText("Товары"));
        ese.pageLoaded();
        for (String anArr : arr) {
            String name = anArr.split(";")[0];
            String model = anArr.split(";")[1];
            String descr = anArr.split(";")[2]+" ✓ Профессиональные курсы на Liga42.com";
            String title = anArr.split(";")[3];
            String price = anArr.split(";")[4].replaceAll(" ","")+".0000";
            String weight = anArr.split(";")[5];
            String place = anArr.split(";")[6];
            String date = anArr.split(";")[7];
            String main = anArr.split(";")[8];
            String OpDate = anArr.split(";")[9];
            String count = anArr.split(";")[10];
            String district = anArr.split(";")[12];
            String SEOUrl = ese.transliterate(name);
            JSONArray programm = null;
            JSONArray uno = null;
            JSONArray dos = null;
            try {
                programm = new JSONArray("["+anArr.split(";")[11]+"]");
                uno = (JSONArray) programm.get(0);
                dos = (JSONArray) programm.get(1);
            } catch (JSONException e) {
                e.printStackTrace();
            }
ese.checkTitle(title);
            ese.checkDescr(descr);
            ese.checkUrl(SEOUrl);
            ese.click(By.cssSelector("a.btn.btn-primary"));
            ese.pageLoaded();
            ese.typo("#input-name1",main);
            ese.typo("#input-meta-h11",name);
            ese.typo("#input-meta-title1",title);
            ese.typo("#input-meta-description1",descr);
            if(ese.elementExist(By.linkText("English"))){
ese.click(By.linkText("English"));
                ese.typo("#input-name2",main);
            }
            ese.click(By.linkText("Данные"));
            ese.typo("#input-model",model);
            ese.typo("#input-location",district);
            ese.typo("#input-price",price);
            ese.typo("#input-keyword",SEOUrl);
            ese.typo("#input-weight",weight.split(" ")[0]);
            ese.selectDropdown(By.id("input-weight-class"),4);
            ese.typo("#input-minimum","3");
            ese.click(By.linkText("Связи"));
            ese.selectDropdown(By.id("input-manufacturer"),escuela);
            ese.selectDropdown(By.id("main_category_id"),50);
            ese.typo(By.id("input-filter"));
            ese.isElement(By.linkText("Курсы > Профессия"));
            ese.click(By.linkText("Курсы > Профессия"));
            ese.typo(By.id("input-filter"));
          //  ese.isElement(By.cssSelector("#input-filter+ul.dropdown-menu li:nth-child(1)"));
            ese.pausa(200);
            ese.isElement(By.linkText("Курсы > Район"));
            ese.click(By.linkText("Курсы > Район"));
            ese.typo(By.id("input-filter"));
            ese.pausa(200);
            ese.isElement(By.linkText("Курсы > Сроки"));
            ese.click(By.linkText("Курсы > Сроки"));
            ese.typo(By.id("input-filter"));
            ese.pausa(200);
            ese.isElement(By.linkText("Курсы > Технология"));
            ese.click(By.linkText("Курсы > Технология"));
            ese.click(By.xpath("(//a[contains(text(),'Атрибуты')])[3]"));
            ese.click(By.cssSelector("td.text-left > button.btn.btn-primary"));
            ese.typo(By.name("product_attribute[0][name]"));
            ese.pausa(200);
            ese.isElement(By.linkText("   Высокая заработная плата"));
            ese.click(By.linkText("   Высокая заработная плата"));
            ese.click(By.cssSelector("td.text-left > button.btn.btn-primary"));
            ese.typo(By.name("product_attribute[1][name]"));
            ese.pausa(200);
            ese.isElement(By.xpath("(//a[contains(text(),'Перспективная профессия')])[2]"));
            ese.click(By.xpath("(//a[contains(text(),'Перспективная профессия')])[2]"));
            ese.click(By.cssSelector("td.text-left > button.btn.btn-primary"));
            ese.typo(By.name("product_attribute[2][name]"));
            ese.pausa(200);
            ese.isElement(By.xpath("(//a[contains(text(),'Работа в любой точке мира')])[3]"));
            ese.click(By.xpath("(//a[contains(text(),'Работа в любой точке мира')])[3]"));
            ese.click(By.xpath("(//a[contains(text(),'Опции')])[2]"));
ese.typo(By.id("input-option"));
ese.typo(By.id("input-option"),"расписание");
            ese.pausa(200);
            ese.isElement(By.linkText("РАСПИСАНИЕ"));
            ese.click(By.linkText("РАСПИСАНИЕ"));
            ese.typo(By.id("input-option"));
            ese.typo(By.id("input-option"),"адрес");
            ese.pausa(200);
            ese.isElement(By.linkText("АДРЕС"));
            ese.click(By.linkText("АДРЕС"));
            ese.typo(By.id("input-option"));
            ese.typo(By.id("input-option"),"препод");
            ese.pausa(200);
            ese.isElement(By.linkText("Преподаватель курса"));
            ese.click(By.linkText("Преподаватель курса"));
            ese.typo(By.id("input-option"));
            ese.typo(By.id("input-option"),"прод");
            ese.pausa(200);
            ese.isElement(By.linkText("Продолжительность"));
            ese.click(By.linkText("Продолжительность"));
            ese.typo(By.id("input-option"));
            ese.typo(By.id("input-option"),"дата");
            ese.pausa(200);
            ese.isElement(By.linkText("Дата"));
            ese.click(By.linkText("Дата"));
            ese.typo(By.id("input-option"));
            ese.typo(By.id("input-option"),"учебная");
            ese.pausa(200);
            ese.isElement(By.linkText("УЧЕБНАЯ ОРГАНИЗАЦИЯ"));
            ese.click(By.linkText("УЧЕБНАЯ ОРГАНИЗАЦИЯ"));
            ese.typo(By.id("input-option"));
            ese.typo(By.id("input-option"),"что в");
            ese.pausa(200);
            ese.isElement(By.linkText("что в итоге"));
            ese.click(By.linkText("что в итоге"));
            ese.click(By.linkText("Преподаватель курса"));
            ese.typo(By.id("input-value2"),model);
            ese.click(By.linkText("что в итоге"));
            /////-----------------------------SERTIFICATE-------------------
            ese.click(By.cssSelector("#option-value6 > tfoot > tr > td.text-left > button.btn.btn-primary"));
            ese.isElement(By.name("product_option[6][product_option_value][0][option_value_id]"));
ese.selectDropdown(By.name("product_option[6][product_option_value][0][option_value_id]"),1);
            ese.selectDropdown(By.name("product_option[6][product_option_value][0][subtract]"),1);
            ese.click(By.cssSelector("#option-value6 > tfoot > tr > td.text-left > button.btn.btn-primary"));
            ese.isElement(By.name("product_option[6][product_option_value][1][option_value_id]"));
            ese.selectDropdown(By.name("product_option[6][product_option_value][1][option_value_id]"),2);
            ese.selectDropdown(By.name("product_option[6][product_option_value][1][subtract]"),1);
            ese.click(By.linkText("УЧЕБНАЯ ОРГАНИЗАЦИЯ"));
            ese.typo(By.id("input-value5"),escuelaName);
            ese.click(By.linkText("АДРЕС"));
            ese.typo(By.id("input-value1"),place);
            ese.click(By.linkText("РАСПИСАНИЕ"));
            ese.typo(By.id("input-value0"),date);
            ese.click(By.linkText("Продолжительность"));
            ese.typo(By.id("input-value3"),weight);
            ese.click(By.linkText("Дата"));
            ese.typo(By.id("input-value4"),OpDate);
                        ese.click(By.linkText("Шаги обучения"));

            for (int i = 0; i <  uno.length(); i++) {



                ese.click(By.cssSelector("#steps > tfoot > tr > td.text-left > button.btn.btn-primary"));
                ese.sb.setLength(0);
ese.isElement(By.name((ese.sb.append("product_steps[").append(i).append("][sort_order]")).toString()));
                ese.sb.setLength(0);
ese.typo(By.name((ese.sb.append("product_steps[").append(i).append("][sort_order]")).toString()),String.valueOf(i));
                ese.sb.setLength(0);
                try {
                    ese.typo(By.name((ese.sb.append("product_steps[").append(String.valueOf(i)).append("][name]")).toString()),uno.get(i).toString());
                    ese.typo(By.name((ese.sb.append("product_steps[").append(String.valueOf(i)).append("][value]")).toString()),dos.get(i).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
