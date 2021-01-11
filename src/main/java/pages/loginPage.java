package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends testBase{

	

	public loginPage () {
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Login")
	WebElement login;
	
	@FindBy(id="error")
	WebElement errorMsg;
	
	@FindBy(id="forgot_password_link")
	WebElement forgotPwd;
	
	@FindBy(id="idcard-identity")
	WebElement usernameFld;
	
	@FindBy(id="rememberUn")
	WebElement RememberMe;
	
	

	public String Login_Title() {
		
		return driver.getTitle();
		 	 
	}
	
	
	public void enterUserName(String userName) {
		username.clear();
		username.sendKeys(userName);
		 
		 	 
	}
	
	public void enterPassWord(String pwd) {
		password.clear();
		password.sendKeys(pwd);
				 	 
	}
	
	public HomePage clickLoginBtn() {
		
		login.click();
		return new HomePage(); 	 
	}
	
public void clickRemberMe() {
		
	RememberMe.click();
		 	 
	}
	
public String checkErrorMsg() {
	return errorMsg.getText(); 
	}
	
public String checkUsernameField() {
	return usernameFld.getText(); 
	}
	

public forgotPasswordPage clickForgotPwd() {
	forgotPwd.click();
	String ForgtTitle=driver.getTitle();
	System.out.println(ForgtTitle);
	 return new forgotPasswordPage();	 
}


	
}
