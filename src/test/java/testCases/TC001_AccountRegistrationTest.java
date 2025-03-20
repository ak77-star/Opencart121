package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test
	public void verify_account_registartion()
	{
		
		logger.info("****** Starting TC001_AccountRegistration ******");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("****** Clicked on My Account Link ******");
		
		hp.clickRegister();
		
		logger.info("****** Clicked on Register Link ******");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		//regpage.setFirstName(randomString().toUpperCase());
		
		logger.info("****** Provide Customer Details ******");
		
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		
		String password=randomAlphaNumeric();
					
		regpage.setPassword(password);
		
		regpage.clickRadio();
		regpage.clickContinue();
		
		logger.info("****** Validating Expected Message ******");
		
	    String confmsg=regpage.getConfirmationMsg();	    
	    Assert.assertEquals(confmsg, "Your Account Has Been Created!");
	

	}
	
}

