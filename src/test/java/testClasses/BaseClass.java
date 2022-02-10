package testClasses;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilitypackage.ReadConfigData;

public class BaseClass {
	ReadConfigData readconfig=new ReadConfigData();
	public  String url= readconfig.getApplicationUrl();
	public  String username =readconfig.getUsername();
	public  String password =readconfig.getPassword();
	
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void initBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver=new ChromeDriver();
			
		}
		else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFox());
			driver=new FirefoxDriver();
			
		}
		driver.get(url);
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	


}
