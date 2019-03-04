package seleniumAdv2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoComplete2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		WebDriver driver;
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Index.html");
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("sukhjinder");
		driver.findElement(By.xpath(".//*[@id='enterimg']")).click();
		driver.findElement(By.linkText("Widgets")).click();
		driver.findElement(By.linkText("AutoComplete")).click();
		String partialtext="he";
		String searchingtext="The Bahamas";
		driver.findElement(By.id("searchbox")).sendKeys(partialtext);
		Thread.sleep(4000);
		WebElement element = driver.findElement(By.id("ui-id-1"));
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
		driver.close();
	}
}
