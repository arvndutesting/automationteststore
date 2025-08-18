package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class login {
	WebDriver ldriver;
	
	static String randomStr = RandomStringUtils.randomAlphanumeric(8);
    public static String email1 = randomStr+"@gmail.com";
	
	public login(WebDriver rDriver) {
		 

		
		ldriver =  rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//*[@id=\"customer_menu_top\"]/li/a")
	WebElement rgn;
	
	
	public void rgnclk() {
		rgn.click();
	}
	
	
	
		@FindBy(xpath = "//*[@id=\"accountFrm\"]/fieldset/button")
		WebElement continueToRegister;

		public void clickContinueToRegister() {
			continueToRegister.click();
		}

		
		public String getPageTitle() {
			return ldriver.getTitle();
		}
	
		/////////////////// LOGIN PAGE POM ///////////////////////////////////////
		
		@FindBy(id = "loginFrm_loginname")
		WebElement loginNameInput;

		@FindBy(id = "loginFrm_password")
		WebElement passwordInput;

		@FindBy(xpath = "//button[@title='Login']")
		WebElement loginButton;

		// Action methods
		public void setLoginName1() {
			loginNameInput.clear();
			loginNameInput.sendKeys("arvndu");
		}

		public void setPassword1() {
			passwordInput.clear();
			passwordInput.sendKeys("koti2929");
		}

		public void clickLoginButton() {
			loginButton.click();
		}
}
