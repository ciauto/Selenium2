package seleniumAdv3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		Thread.sleep(2000);
		// row data and row count
		String xrow_start = "//*[@id='customers']/tbody/tr[";
		String xrow_end = "]/td[1]";
		int rowCount = 0;
		for (int i = 2; i <= 7; i++) {
			String str = driver.findElement(By.xpath(xrow_start + i + xrow_end)).getText();
			rowCount++;
			System.out.println(str);
		}
		System.out.println(rowCount);

		String xcol_start = "//*[@id='customers']/tbody/tr[2]/td[";
		String xcol_end = "]";
		int colCount = 0;
		for (int i = 1; i <= 3; i++) {
			String str = driver.findElement(By.xpath(xcol_start + i + xcol_end)).getText();
			colCount++;
			System.out.println(str);
		}
		System.out.println(colCount);

		System.out.println("--------------Printing all values from Web Table ----------------");

		String xpath_start = "//*[@id='customers']/tbody/tr[";
		String xpath_mid = "]/td[";
		String xpath_end = "]";

		for (int rows = 2; rows <= rowCount; rows++) {

			for (int cols = 1; cols <= colCount; cols++) {
				String x = driver.findElement(By.xpath(xpath_start + rows + xpath_mid + cols + xpath_end)).getText();
				System.out.println(x);
			}
			System.out.println();
		}
		driver.quit();

	}

}
