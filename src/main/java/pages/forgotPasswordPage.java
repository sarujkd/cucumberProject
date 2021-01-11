package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class forgotPasswordPage extends testBase {

	
	public forgotPasswordPage(){
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="un")
	WebElement username;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public String ForgorpageTitle() {
			return driver.getTitle();
	}
	
	
	public void enterUserName(String uname) {
		username.clear();
		username.sendKeys(uname);
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
	
}
