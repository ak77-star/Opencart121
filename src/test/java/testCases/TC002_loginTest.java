package testCases;

import org.testng.Assert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_loginTest extends BaseClass{
	
	public void verify_login()
	{
		logger.info("****** Starting TC_002_LoginTest ******");
		
		try
		{
		
		HomePage hp=new HomePage(driver);
		
		//HomepAge
		
		hp.clickMyAccount();
		hp.clicklogin();
		
		//login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword((p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccount
		MyAccountPage macc=new MyAccountPage(driver);
		boolean tagetPage =macc.isMyAccountPageExists();
		
		Assert.assertTrue(tagetPage);
	}
	
	catch (Exception e)
	{
		Assert.fail();
	}
	
	logger.info("****** Finished TC_002_LoginTest******");
	
    }
    }


