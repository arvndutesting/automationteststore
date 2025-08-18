package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {
	
WebDriver ldriver;
	
	static String randomStr = RandomStringUtils.randomAlphanumeric(8);
    public static String email1 = randomStr+"@gmail.com";
	
	public Register(WebDriver rDriver) {
		 

		
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

		// Registration fields
		@FindBy(id = "AccountFrm_firstname")
		WebElement firstName;

		@FindBy(id = "AccountFrm_lastname")
		WebElement lastName;

		@FindBy(id = "AccountFrm_email")
		WebElement email;

		@FindBy(id = "AccountFrm_telephone")
		WebElement telephone;

		@FindBy(id = "AccountFrm_country_id")
		WebElement setcountry;

		@FindBy(id = "AccountFrm_company")
		WebElement company;

		@FindBy(id = "AccountFrm_address_1")
		WebElement address1;

		@FindBy(id = "AccountFrm_city")
		WebElement city;

		@FindBy(id = "AccountFrm_postcode")
		WebElement postcode;

		@FindBy(id = "AccountFrm_country_id")
		WebElement country;

		@FindBy(id = "AccountFrm_zone_id")
		WebElement state;

		@FindBy(id = "AccountFrm_loginname")
		WebElement loginName;

		@FindBy(id = "AccountFrm_password")
		WebElement password;

		@FindBy(id = "AccountFrm_confirm")
		WebElement confirmPassword;

		@FindBy(id = "AccountFrm_zone_id")  // No newsletter radio button
		WebElement stateselect;

		@FindBy(id = "AccountFrm_agree")  // Privacy Policy checkbox
		WebElement privacyPolicy;

		@FindBy(xpath = "//button[@title='Continue']")
		WebElement continueButton;

	
		public void setFirstName() {
			firstName.clear();
			firstName.sendKeys("Aravind");
		}

		public void setLastName() {
			lastName.clear();
			lastName.sendKeys("Namani");
		}

		public void setEmail() {
			
			email.sendKeys(email1);
		}

		public void setTelephone() {
			telephone.clear();
			telephone.sendKeys("9963028201");
		}

		

		public void setAddress() {
			address1.clear();
			address1.sendKeys("D234 AZONE RKP");
		}

		public void setCity() {
			city.clear();
			city.sendKeys("MNCL");
		}
		
		public void setcountry() {
			Select sc= new Select(setcountry);
			sc.selectByVisibleText("India");
			
		}

		public void setstate() {
			Select sc= new Select(stateselect);
			sc.selectByVisibleText("Andhra Pradesh");
			
		}
		public void setPostcode() {
			postcode.clear();
			postcode.sendKeys("50423");
		}

		public void setLoginName() {
			loginName.clear();
			loginName.sendKeys(randomStr);
		}

		public void setPassword() {
			password.clear();
			password.sendKeys("koti2929");
		}

		public void setConfirmPassword() {
			confirmPassword.clear();
			confirmPassword.sendKeys("koti2929");
		}

		

		public void acceptPrivacyPolicy() {
			privacyPolicy.click();
		}

		public void clickContinueButton() {
			continueButton.click();
		}

		public String getPageTitle() {
			return ldriver.getTitle();
		}

}
