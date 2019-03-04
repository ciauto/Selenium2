package seleniumAdv3;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Firefox_Profile {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "C:\\driver\\geckodriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myProfile = profile.getProfile("selenium");
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(FirefoxDriver.PROFILE, myProfile);
		cap.setAcceptInsecureCerts(true);
		// cap.setCapability("marionette", true);
		// WebDriver driver=new FirefoxDriver(cap);
		// driver.get("http://newtours.demoaut.com/");
	}

}
