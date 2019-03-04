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
		String searchingtext = "Toronto, ON, Canada (YYZ - Pearson Intl.)";
		driver.findElement(By.xpath("//a[@id='tab-flight-tab']")).click();
		driver.findElement(By.xpath("//input[@id='flight-origin']")).clear();
		driver.findElement(By.xpath("//input[@id='flight-origin']")).sendKeys(partialtext);
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id='typeahead-list']/div/div/ul"));
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
			break;
		}
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();
	} 
}
