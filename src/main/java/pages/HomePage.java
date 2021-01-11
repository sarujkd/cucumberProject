package pages;

import java.util.List;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends testBase {

	@FindBy(id = "userNavLabel")
	WebElement userDD;

	@FindBy(xpath = "//a[@title='Logout']")
	WebElement Logout;

	@FindBy(xpath = "//div[@id='userNav-menuItems']")
	List<WebElement> userDDval;

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String HomePageTitle() {
		return driver.getTitle();
	}

	public void clickUsernameDD() {
		userDD.click();
	}

	public void click_Logout() {
		Logout.click();
	}

	// get Drop down values
	public void get_UserDDValues() {
		System.out.println(userDDval.size());
		for (WebElement el : userDDval)
			System.out.println(el.getText());
	}

}