package seleniumAdv2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDemo {

	public static void main(String[] args) throws InterruptedException {

	String baseURL="https://www.wikipedia.org";
	System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get(baseURL);
	
	WebElement searchLang=driver.findElement(By.id("searchLanguage"));
	
	Select s1 = new Select(searchLang);
	
	s1.selectByIndex(20);
	Thread.sleep(4000);
	
	driver.close();
		
		
	}

}
