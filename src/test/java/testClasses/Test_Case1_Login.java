package testClasses;





import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class Test_Case1_Login extends BaseClass {
	
	@Test
	public void login()  {
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		
		lp.setPassword(password);
		
		lp.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		Assert.assertTrue(true);
		
		}
		else {
			
			Assert.assertTrue(false);
		}
	}

}
