package loginStepDef;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;

import pages.loginPage;
import pages.testBase;

public class LoginStepDef extends testBase {
	
	
	loginPage login_pg;
	HomePage homepage_pg;
	
	private static Logger logger = LogManager.getLogger();

	@Given("^Launch the browser and enter the Url$")
	public void launch_the_browser_and_enter_the_Url() throws IOException  {
		testBase.Initialize_The_Browser();
		
		logger.info("Browser is launched"); 
	
	}

	@When("^User enters Username in the text field$")
	public void user_enters_Username_in_the_text_field() throws Throwable {
		login_pg=new loginPage();
		login_pg.enterUserName(prop.getProperty("userName"));
		logger.info("Username is entered successfully"); 
	}

	@Then("^clears the password field$")
	public void clears_the_password_field() throws Throwable {
		login_pg=new loginPage();
		login_pg.enterPassWord("");
		logger.info("Password field is cleared successfully");
	}

	@And("^Clicks login button$")
	public void clicks_login_button() throws Throwable {
		homepage_pg=login_pg.clickLoginBtn();
		String hmTitle=homepage_pg.HomePageTitle();
		System.out.println("Homepage title : "+hmTitle);
		logger.info("Login button is clicked");
	}

	@Then("^checks Error messag Please enter your password should be displayed$")
	public void checks_Error_messag_Please_enter_your_password_should_be_displayed() throws Throwable {
		String Error_Msg=login_pg.checkErrorMsg();
		System.out.println("Error message: "+Error_Msg);
		Assert.assertEquals(Error_Msg,"Please enter your password.");
	}

	@When("^User enters valid Username in the username field$")
	public void user_enters_valid_Username_in_the_username_field() throws Throwable {
		login_pg=new loginPage();
		login_pg.enterUserName(prop.getProperty("userName"));
		logger.info("Username is entered successfully");
	}

	@Then("^Enters the valid password in the password field$")
	public void enters_the_valid_password_in_the_password_field() throws Throwable {
		login_pg=new loginPage();
		login_pg.enterPassWord(prop.getProperty("passWord"));
		logger.info("Password is entered successfully");

	}

	
	@When("^User enters invalid Username in the username field$")
	public void user_enters_invalid_Username_in_the_username_field() throws Throwable {
		login_pg=new loginPage();
		login_pg.enterUserName(prop.getProperty("InValiduserName"));
		logger.info("InValid Username is entered successfully");
		
	}

	@Then("^Enters the invalid password in the password field$")
	public void enters_the_invalid_password_in_the_password_field() throws Throwable {
		login_pg=new loginPage();
		login_pg.enterPassWord(prop.getProperty("InvalidPassWord"));
		logger.info("InValid Password is entered successfully");
	}

	@Then("^Error message should be displayed$")
	public void error_message_should_be_displayed() throws Throwable {
		String Error_Msg=login_pg.checkErrorMsg();
		System.out.println("Error message: "+Error_Msg);
		Assert.assertEquals(Error_Msg,"Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.");
		

	}
@After
public void closeBrowser() throws IOException {
	close_The_Browser();	
}

	
}
