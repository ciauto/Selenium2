package seleniumAdv2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoComplete {
	private WebDriver driver;

	@BeforeTest
	public void setup(){
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.expedia.ca/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void testcase() throws InterruptedException{
		String partialtext="Toronto";
		String searchingtext = "Toronto (YYZ - Pearson Intl.) Ontario, Canada";
		driver.findElement(By.xpath("//div[@id='location-field-destination-menu']//button[@class='uitk-faux-input']")).click();
		
		driver.findElement(By.xpath("//input[@id='location-field-destination']")).sendKeys(partialtext);
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//ul[@class='uitk-typeahead-results no-bullet']"));
		List<WebElement> results = element.findElements(By.tagName("li"));
		int size = results.size();
		for(int i=0; i<size; i++)
		{
			String sr=results.get(i).getText();
			System.out.println(sr);
		}
		for(WebElement result:results)
		{
			if(result.getText().equals(searchingtext))
				result.click();
			Thread.sleep(4000);
			break;
		}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	} 
}
