package seleniumAdv1;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TVO_ORG {
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://tvo.org/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//Store all Window tabs open by Selenium
		Set<String>winids=driver.getWindowHandles();
		Iterator<String> iterate=winids.iterator();
		String tvoOrgHomePage=iterate.next();
		System.out.println(tvoOrgHomePage);
		
		//size of Window
		long height = (long)js.executeScript("return window.innerHeight;");
		System.out.println(height);
		long width  = (long)js.executeScript("return window.innerWidth;");
		System.out.println(width);
		js.executeScript("window.scrollBy(0, 1200);");
		//Thread.sleep(6000);
		System.out.println(driver.findElement(By.xpath("//a[@href='/about/jobs']")).getText());
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/about/jobs']")));
		driver.findElement(By.xpath("//a[@href='/about/jobs']")).click();
		System.out.println("------After Click on Jobs at TVO hyper link");
		//Thread.sleep(4000);
		
		js.executeScript("window.scrollBy(0, 1200);");
		//Thread.sleep(6000);
		WebElement ele=driver.findElement(By.xpath("//a[@href='/job-postings']"));
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		//scroll little bit up
		js.executeScript("window.scrollBy(0, -200);");
		System.out.println(ele.getText());
		Thread.sleep(4000);
		ele.click();
		System.out.println("------After Click on Job Search button");
		winids=driver.getWindowHandles();
		iterate=winids.iterator();
		String tvoJobPage=iterate.next();
		System.out.println(tvoJobPage);
		String tvoJobSearchTab=iterate.next();
		System.out.println(tvoJobSearchTab);
		
		//switch focus to newly opened Job Search Tab
		driver.switchTo().window(tvoJobSearchTab);
		
		//switch focus to frame=icims_content_iframe,  Iframe name information is available in the HTML of the page
		
		driver.switchTo().frame("icims_content_iframe");
		
		driver.findElement(By.id("jsb_f_keywords_i")).sendKeys("Selenium");
		driver.findElement(By.id("jsb_form_submit_i")).click();
		String expectedText="Sorry, no jobs were found that match your search criteria. Please try other selections.";
		String actualText=driver.findElement(By.xpath("//div[@class='iCIMS_Message iCIMS_ErrorMessage iCIMS_GenericMessage']")).getText();
		if(expectedText.equals(actualText)) {
			System.out.println("Test passed");
		}else {
			System.out.println("Test failed");
		}
		driver.quit();
	}

}


