package forGot_StepDef;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.forgotPasswordPage;
import pages.loginPage;
import pages.testBase;

public class forgotStepDef extends testBase{
	
	loginPage login_pg;
	forgotPasswordPage frpage;
	 HomePage hmpage;
	private static Logger logger = LogManager.getLogger();

	
	@Given("^user is in login page$")
	public void user_is_in_login_page() throws Throwable {
		
			Initialize_The_Browser();
			
			logger.info("Browser is launched"); 
		

	}

	@When("^User enters Username in the field$")
	public void user_enters_Username_in_the_field() throws Throwable {
	   
		login_pg=new loginPage();
		login_pg.enterUserName(prop.getProperty("userName"));
		logger.info("Username is entered successfully");

	}

	@Then("^Clicks ForgotPassword$")
	public void clicks_ForgotPassword()  {
	   
		login_pg=new loginPage();
		
		login_pg.clickForgotPwd();
		logger.info("clicks forgot Password");
	}

	@Then("^Navigate to ForgotPassword page$")
	public void navigate_to_ForgotPassword_page() {
		 frpage = new forgotPasswordPage();
		 String title=frpage.ForgorpageTitle();
		 System.out.println(title);
		 Assert.assertEquals(title,"Forgot Your Password | Salesforce");
		
	}

	@Then("^Enters Username in the text field$")
	public void enters_Username_in_the_text_field() throws InterruptedException {
	  
		 frpage = new forgotPasswordPage();
		 frpage.enterUserName(prop.getProperty("userName"));
		 Thread.sleep(2000);
		 logger.info("Username is entered");
	}

	@Then("^clicks continue button$")
	public void clicks_continue_button()  {
		 frpage = new forgotPasswordPage();
		frpage.clickContinueBtn();
		logger.info("clicks continue button");
		 try {
			close_The_Browser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("^User enters valid username and password$")
	public void user_enters_valid_username_and_password()  {
		login_pg=new loginPage();
		login_pg.enterUserName(prop.getProperty("userName"));
		login_pg.enterPassWord(prop.getProperty("passWord"));
	}

	@Then("^clicks RememberMe Check box$")
	public void clicks_RememberMe_Check_box() {
		login_pg=new loginPage();
		login_pg.clickRemberMe();
		logger.info("clicks RemberMe button");
	}

	@Then("^clicks login button$")
	public void clicks_login_button()  {
		
		login_pg.clickLoginBtn();
		
	}
	@Then("^user navigates to homepage$")
	public void user_navigates_to_homepage()  {
		  hmpage=new HomePage(); 
		  String title=hmpage.HomePageTitle();
	System.out.println(title);
	Assert.assertEquals(title,"Home Page ~ Salesforce - Developer Edition");
	logger.info("User is in homepage");
	}
	
	@When("^User clicks username Drop down$")
	public void user_clicks_username_Drop_down() {
		 hmpage.clickUsernameDD();
		 logger.info("Username drop down is clicked");
	}

	@When("^clicks logout$")
	public void clicks_logout()  {
		 hmpage.click_Logout();
		 logger.info("Logout is clicked");
	}

	@Then("^validates Username is present in the username field$")
	public void validates_Username_is_present_in_the_username_field() {
		String uname=login_pg.checkUsernameField();
		System.out.println(uname);
		Assert.assertEquals(uname,prop.getProperty("userName"));
		logger.info("Found Username is in the text field");
	
		try {
			close_The_Browser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
