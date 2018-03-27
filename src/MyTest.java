
import org.json.JSONArray;
import org.json.JSONException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;


public class MyTest {
	public static void main(String []args) {
		MyTest ese = new MyTest();
		ArrayList<String> arr = new ArrayList<String>();
		ese.leer(arr);
		System.setProperty("webdriver.chrome.driver", "C:\\gecko\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=D:/grizzly","--start-maximized");
		WebDriver driver = new ChromeDriver(options);


		//////
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		Actions actions = new Actions(driver);

		/////
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
					public Boolean apply(WebDriver driver) {
						System.out.println("CARGADO");
						return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
					}
				};
		JavascriptExecutor js = (JavascriptExecutor)driver;
		///////
		driver.get("https://www.oknapremium.by/manager/");
		wait.until(pageLoadCondition);
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
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
			if (!driver.findElement(By.id("modx-leftbar-tabpanel__modx-resource-tree")).isDisplayed()){
				System.out.println("ahora");
			//ese.escripto(wait,driver,"document.querySelectorAll('#modx-leftbar')[0].setAttribute(\"style\",\"width: 386px; position: absolute; visibility: visible; left: 0px; top: 55px; z-index: auto;\"); return document.querySelectorAll('#modx-leftbar')[0].getAttribute('style')==\"width: 386px; position: absolute; visibility: visible; left: 0px; top: 55px; z-index: auto;\"");
			ese.escripto(wait,driver,"document.querySelectorAll(\"#modx-leftbar-tabs-xcollapsed .x-layout-mini-west\")[0].click(); return true");
			//	actions.moveToElement(driver.findElement(By.cssSelector(".x-layout-collapsed .x-layout-mini-west"))).click().build().perform();
			};
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modx-leftbar-tabpanel__modx-resource-tree")));
			//ese.escripto(wait,driver,"if(document.documentElement.scrollTop==0){return true} else {window.scrollTo(0,0)}");


			ese.ronda(driver,wait);
			if (driver.findElements(By.xpath("//a[@class=\"x-tree-node-anchor\"]/span[text()=\"Рулонные шторы МИНИ сплошным полотном \"]")).size() == 0) {

ese.pausa(500);
			};
			actions.moveToElement(driver.findElement(By.xpath("//a[@class=\"x-tree-node-anchor\"]/span[text()=\"Рулонные шторы МИНИ сплошным полотном \"]"))).contextClick().build().perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className("x-menu-floating")));
			actions.moveToElement(driver.findElement(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Создать\"]"))).perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Документ\"]")));
			actions.moveToElement(driver.findElement(By.xpath("//span[@class=\"x-menu-item-text\" and text()=\"Документ\"]"))).click().build().perform();
			wait.until(pageLoadCondition);
			ese.pausa(1200);
			ese.ronda(driver,wait);
		//	driver.findElement(By.id("modx-resource-pagetitle")).sendKeys(name);
			ese.typo(wait,driver,"#modx-resource-pagetitle",name);
			//driver.findElement(By.id("modx-resource-longtitle")).sendKeys(name.replace("Рулонные", "Заказать"));
			ese.typo(wait,driver,"#modx-resource-longtitle",name.replace("Рулонные", "Заказать"));
			//driver.findElement(By.id("modx-resource-description")).sendKeys(name+" ✔️. Только качественные материалы и фурнитура, доставка и установка. ✔️ Звоните!");
			ese.typo(wait,driver,"#modx-resource-description",name+" ✔️. Только качественные материалы и фурнитура, доставка и установка. ✔️ Звоните!");
			actions.moveToElement(driver.findElement(By.id("modx-resource-published"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.id("tiny-toggle-rte"))).click().build().perform();
			ese.typo(wait,driver,"#ta", "<p>Стоимость: " +price+ " $</p> <p>Ширина: " +width+ " м</p> <p>Система «МИНИ» - рулонные шторы, в которых ткань открыто наматывается на вал, а отвес ткани свободно свисает вдоль створки окна, поэтому крепить систему можно одним из 4-х способов - на створку, к стене, к потолку или непосредственно в проем.</p> <p>Дополнительная комплектация системы «МИНИ» включает в себя:</p> <ul> <li>магниты - крепятся на саморезы под штапиком внизу створки, что позволяет зафиксировать полотно только при ее полном опускании (1,6 у.е.);</li> <li>леска - натягиваются вдоль штапика, что позволяет фиксировать полотно в любом его положении (1,2 у.е.).</li> <li>Фиксатор цепочки к раме (0,5 у.е.)</li> </ul> <p>Ширина и высота изделия округляется в большую сторону.</p> <p>Если высота изделия превышает 1,5 м к общей стоимости - прибавляется 10% за каждые последующие 10 см (0,1 м).</p> <p>Фурнитура системы «МИНИ» в коричневом цвете увеличивает общую стоимость изделия на 10%.</p>");
			//driver.findElement(By.id("ta")).sendKeys("<p>Стоимость: "+price+" $</p> <p>Ширина: "+width+" м</p><p>Рулонные шторы системы «MG-2» - рулонные шторы, в которых ткань открыто наматывается на вал, а отвес ткани свободно свисает вдоль створки окна, поэтому крепить систему можно одним из 3-х способов - к стене, к потолку или непосредственно в проем.</p> <p>ДОПОЛНИТЕЛЬНАЯ КОМПЛЕКТАЦИЯ: КОРОБ 10 у.е. за м/п</p> <p>Промежуточные размеры округляются в большую сторону</p> <p>Высота изделия больше 1,5 м - стоимость возрастает на 100%</p> <p>Высота изделия больше 2,1 м - стоимость возрастает на 35%</p> <p>Высота изделия больше 1.8 м - стоимость возрастает на 20%</p> <p>Высота изделия больше 2.4 м - стоимость возрастает на 50%</p>");

ese.escripto(wait,driver,"document.querySelectorAll(\"#x-form-el-modx-resource-template .x-form-arrow-trigger\")[0].click(); return true");
ese.pausa(500);
			driver.findElement(By.id("modx-resource-template")).sendKeys("товар");
			actions.moveToElement(driver.findElement(By.id("modx-resource-tabs__modx-panel-resource-tv"))).click().build().perform();
			ese.typo(wait,driver,"#tv2",name);
			actions.moveToElement(driver.findElement(By.id("modx-resource-vtabs__ext-comp-1035"))).click().build().perform();
			driver.findElement(By.id("tvbrowser1")).sendKeys("");
			ese.typo(wait,driver,"#tvbrowser1",im.toString());
			driver.findElement(By.id("tvbrowser8")).sendKeys("");
			ese.typo(wait,driver,"#tvbrowser8","images/gallery/rulonnye-shtory-na-kuhnyu-12.jpg");
			actions.moveToElement(driver.findElement(By.id("modx-resource-vtabs-header"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.id("tvbrowser1"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.id("modx-abtn-save"))).click().build().perform();
			ese.pausa(3000);
			wait.until(pageLoadCondition);
			ese.ronda(driver,wait);

			actions.moveToElement(driver.findElement(By.className("x-layout-mini-west"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.id("modx-resource-tabs__modx-panel-resource-tv"))).click().build().perform();
			actions.moveToElement(driver.findElement(By.id("modx-resource-vtabs__ext-comp-1043"))).click().build().perform();
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
				actions.moveToElement(driver.findElement(By.xpath("//button[text()='Добавить слайд']"))).click().build().perform();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.className("x-window-mc")));
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id,'tvbrowserinp_') and contains(@id,'_9_1')]"))).sendKeys("");
				ese.typo(wait,driver, "input[id*=\"tvbrowserinp_\"][id*=\"_9_1\"]",image.toString());
				actions.moveToElement(driver.findElement(By.className("x-window-mc"))).click().build().perform();
				//driver.findElement(By.xpath("//input[contains(@id,'tvinp_') and contains(@id,'_9_2')]")).sendKeys("");
				ese.typo(wait,driver, "input[id*=\"tvinp_\"][id*=\"_9_2\"]",name.split(" - ширина ")[0]);
				actions.moveToElement(driver.findElement(By.xpath("//button[text()='Выполнено']"))).click().build().perform();
			}

			actions.moveToElement(driver.findElement(By.id("modx-abtn-save"))).click().build().perform();
			if (driver.findElements(By.className("x-mask-loading")).size() != 0) {
				wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("x-mask-loading"))));
			}

		}

	}
	private void ronda(WebDriver driver,WebDriverWait wait){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (driver.findElements(By.className("x-mask-loading")).size() != 0) {
			wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("x-mask-loading"))));
			System.out.println("ronda_fin");
		}
	}
	private void escripto(WebDriverWait wait,WebDriver driver,String script){
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver)
						.executeScript(script).equals(true);
			}
		});
	}
	private void typo(WebDriverWait wait,WebDriver driver,String selector,String data){
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver)
						.executeScript("document.querySelectorAll('"+selector+"')[0].value = '"+data+"'; return true");
			}
		});
	}
	private void pausa(int sec){
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void leer(ArrayList<String> ar){
		try {
			try (Stream<String> lines = Files.lines(Paths.get("C:\\Users\\Mirshe\\IdeaProjects\\selenium\\out\\production\\selenium\\1.txt").toAbsolutePath(), Charset.defaultCharset())) {
				lines.forEach(s -> ar.add(s));
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}