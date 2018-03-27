import org.json.JSONArray;
import org.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.ArrayList;

public class MyTest2 {
	public static void main(String []args) {
		TestUtils ese = new TestUtils();
		ArrayList<String> arr = new ArrayList<String>();
		ese.leer(arr);
		ese.initialize("https://www.oknapremium.by/manager/");
		ese.pageLoaded();
		for (String anArr : arr) {
			JSONArray images = null;
			Object im = null;
			try {
				images = new JSONArray(anArr.split("<\\*\\*\\*>")[1]);
				im = images.get(0);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			String name = anArr.split("<\\*\\*\\*>")[2];
			String price = anArr.split("<\\*\\*\\*>")[3];
			String width = anArr.split("<\\*\\*\\*>")[4];
			ese.isElement(By.cssSelector("h2"));
			if (!ese.driver.findElement(By.id("modx-leftbar-tabpanel__modx-resource-tree")).isDisplayed()){
				System.out.println("ahora");
			//ese.escripto(wait,driver,"document.querySelectorAll('#modx-leftbar')[0].setAttribute(\"style\",\"width: 386px; position: absolute; visibility: visible; left: 0px; top: 55px; z-index: auto;\"); return document.querySelectorAll('#modx-leftbar')[0].getAttribute('style')==\"width: 386px; position: absolute; visibility: visible; left: 0px; top: 55px; z-index: auto;\"");
			ese.clickJS("#modx-leftbar-tabs-xcollapsed .x-layout-mini-west");
			//	actions.moveToElement(driver.findElement(By.cssSelector(".x-layout-collapsed .x-layout-mini-west"))).click().build().perform();
			};
			ese.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modx-leftbar-tabpanel__modx-resource-tree")));
			//ese.escripto(wait,driver,"if(document.documentElement.scrollTop==0){return true} else {window.scrollTo(0,0)}");


			ese.ronda();
			if (ese.driver.findElements(By.xpath("//a[@class=\"x-tree-node-anchor\"]/span[text()=\"Рулонные шторы МИНИ сплошным полотном \"]")).size() == 0) {

ese.pausa(500);
			};
			ese.rClickJava(By.xpath("//a[@class=\"x-tree-node-anchor\"]/span[text()=\"Рулонные шторы МИНИ сплошным полотном \"]"));
			ese.isElement(By.className("x-menu-floating"));
			ese.mOverJava(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Создать\"]"));
			ese.isElement(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Документ\"]"));
			ese.clickJava(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Документ\"]"));
			ese.pageLoaded();
			ese.pausa(1200);
			ese.ronda();
		//	driver.findElement(By.id("modx-resource-pagetitle")).sendKeys(name);
			ese.typo("#modx-resource-pagetitle",name);
			//driver.findElement(By.id("modx-resource-longtitle")).sendKeys(name.replace("Рулонные", "Заказать"));
			ese.typo("#modx-resource-longtitle",name.replace("Рулонные", "Заказать"));
			//driver.findElement(By.id("modx-resource-description")).sendKeys(name+" ✔️. Только качественные материалы и фурнитура, доставка и установка. ✔️ Звоните!");
			ese.typo("#modx-resource-description",name+" ✔️. Только качественные материалы и фурнитура, доставка и установка. ✔️ Звоните!");
			ese.clickJava(By.id("modx-resource-published"));
			ese.clickJava(By.id("tiny-toggle-rte"));
			ese.typo("#ta", "<p>Стоимость: " +price+ " $</p> <p>Ширина: " +width+ " м</p> <p>Система «МИНИ» - рулонные шторы, в которых ткань открыто наматывается на вал, а отвес ткани свободно свисает вдоль створки окна, поэтому крепить систему можно одним из 4-х способов - на створку, к стене, к потолку или непосредственно в проем.</p> <p>Дополнительная комплектация системы «МИНИ» включает в себя:</p> <ul> <li>магниты - крепятся на саморезы под штапиком внизу створки, что позволяет зафиксировать полотно только при ее полном опускании (1,6 у.е.);</li> <li>леска - натягиваются вдоль штапика, что позволяет фиксировать полотно в любом его положении (1,2 у.е.).</li> <li>Фиксатор цепочки к раме (0,5 у.е.)</li> </ul> <p>Ширина и высота изделия округляется в большую сторону.</p> <p>Если высота изделия превышает 1,5 м к общей стоимости - прибавляется 10% за каждые последующие 10 см (0,1 м).</p> <p>Фурнитура системы «МИНИ» в коричневом цвете увеличивает общую стоимость изделия на 10%.</p>");
			//driver.findElement(By.id("ta")).sendKeys("<p>Стоимость: "+price+" $</p> <p>Ширина: "+width+" м</p><p>Рулонные шторы системы «MG-2» - рулонные шторы, в которых ткань открыто наматывается на вал, а отвес ткани свободно свисает вдоль створки окна, поэтому крепить систему можно одним из 3-х способов - к стене, к потолку или непосредственно в проем.</p> <p>ДОПОЛНИТЕЛЬНАЯ КОМПЛЕКТАЦИЯ: КОРОБ 10 у.е. за м/п</p> <p>Промежуточные размеры округляются в большую сторону</p> <p>Высота изделия больше 1,5 м - стоимость возрастает на 100%</p> <p>Высота изделия больше 2,1 м - стоимость возрастает на 35%</p> <p>Высота изделия больше 1.8 м - стоимость возрастает на 20%</p> <p>Высота изделия больше 2.4 м - стоимость возрастает на 50%</p>");

ese.clickJS("#x-form-el-modx-resource-template .x-form-arrow-trigger");
ese.pausa(500);
			ese.driver.findElement(By.id("modx-resource-template")).sendKeys("товар");
			ese.clickJava(By.id("modx-resource-tabs__modx-panel-resource-tv"));
			ese.typo("#tv2",name);
			ese.clickJava(By.id("modx-resource-vtabs__ext-comp-1035"));
			ese.driver.findElement(By.id("tvbrowser1")).sendKeys("");
			ese.typo("#tvbrowser1",im.toString());
			ese.driver.findElement(By.id("tvbrowser8")).sendKeys("");
			ese.typo("#tvbrowser8","images/gallery/rulonnye-shtory-na-kuhnyu-12.jpg");
			ese.clickJava(By.id("modx-resource-vtabs-header"));
			ese.clickJava(By.id("tvbrowser1"));
			ese.clickJava(By.id("modx-abtn-save"));
			ese.pausa(3000);
			ese.pageLoaded();
			ese.ronda();
			ese.clickJava(By.className("x-layout-mini-west"));
			ese.clickJava(By.id("modx-resource-tabs__modx-panel-resource-tv"));
			ese.clickJava(By.id("modx-resource-vtabs__ext-comp-1043"));
			//ese.escripto(wait,driver,"document.querySelectorAll(\"#modx-resource-tvs-div\")[0].classList.remove(\"x-hide-offsets\"); document.querySelectorAll(\"#modx-resource-settings\")[0].classList.add(\"x-hide-offsets\"); return document.querySelectorAll(\"#modx-resource-settings\")[0].classList.contains(\"x-hide-offsets\")");

			//ese.escripto(wait,driver,"document.querySelectorAll('#modx-tv-tabs .x-panel')[0].classList.add('x-hide-display'); document.querySelectorAll('#modx-tv-tabs .x-panel')[1].classList.remove('x-hide-display'); return !document.querySelectorAll('#modx-tv-tabs .x-panel')[1].classList.contains('x-hide-display');");
			//wait.until(ExpectedConditions.attributeContains(By.id("modx-resource-settings"),"class","x-hide-offsets"));

		//ese.escripto(wait,driver,"document.getElementById('modx-resource-vtabs__ext-comp-1043').style.zIndex = 999999; return document.getElementById('modx-resource-vtabs__ext-comp-1043').style.zIndex==999999");
		//actions.moveToElement(driver.findElement(By.id("modx-resource-vtabs__ext-comp-1043"))).click().build().perform();


			Object image = null;
			for (int i = 0; i < images.length(); i++) {
				try {
					 image = images.get(i);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				ese.clickJava(By.xpath("//button[text()='Добавить слайд']"));
				ese.isElement(By.className("x-window-mc"));
				ese.isElement(By.xpath("//input[contains(@id,'tvbrowserinp_') and contains(@id,'_9_1')]"));
				ese.driver.findElement(By.xpath("//input[contains(@id,'tvbrowserinp_') and contains(@id,'_9_1')]")).sendKeys("");
				ese.typo("input[id*=\"tvbrowserinp_\"][id*=\"_9_1\"]",image.toString());
				ese.clickJava(By.className("x-window-mc"));
				//driver.findElement(By.xpath("//input[contains(@id,'tvinp_') and contains(@id,'_9_2')]")).sendKeys("");
				ese.typo("input[id*=\"tvinp_\"][id*=\"_9_2\"]",name.split(" - ширина ")[0]);
				ese.clickJava(By.xpath("//button[text()='Выполнено']"));
			}

			ese.clickJava(By.id("modx-abtn-save"));
			ese.ronda();
		}

	}

}
