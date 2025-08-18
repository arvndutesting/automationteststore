package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Booking_Tshirt {
	
	WebDriver ldriver;
	
	public Booking_Tshirt(WebDriver rdriver) {
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver , this);
		
	}

	@FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[2]/a")
	WebElement scroll;
	
	// //*[@id="categorymenu"]/nav/ul/li[2]/div/ul[1]/li[2]/a
	
	@FindBy(xpath = "//*[@id=\"categorymenu\"]/nav/ul/li[2]/div/ul[1]/li[2]/a")
	WebElement scroll2;
	
	public void scrollclk() {
		
		Actions ac = new Actions(ldriver);
		
		ac.moveToElement(scroll).build().perform();
		
		ac.moveToElement(scroll2).click().perform();
		
		
		
		
		
		
	}
	
	@FindBy(xpath = "//*[@id=\"maincontainer\"]/div/div/div/div/div[3]/div[3]/div[2]/a/img")
	WebElement shirt;
	
	public void shirtclk() {
		
		shirt.click();
	}
	
	@FindBy(id = "option350")
	WebElement size;
	
	
	public void selectclk() {
		
		Select sc = new Select(size);
		sc.selectByValue("775");
		
	}
	
	 @FindBy(xpath = "//*[@id='product']/fieldset/div[6]/ul/li/a")
	    WebElement addToCartButton;

	    
	    @FindBy(css = ".success")
	    WebElement successMessage;

	 
	    public void clickAddToCart() {
	        JavascriptExecutor js = (JavascriptExecutor) ldriver;
	        js.executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
	        js.executeScript("arguments[0].click();", addToCartButton);
	    }
	
	@FindBy(xpath = "//*[@id=\"cart_quantity121cf270a9f0b2596b85990ba40feaeccad\"]")
	WebElement quanity;
	
	@FindBy(xpath = "//*[@id=\"cart_update\"]")
	WebElement update;
	
	public void quanityclk() throws InterruptedException {
		quanity.clear();
		quanity.sendKeys("2" , Keys.ENTER);
		Thread.sleep(3000);
		update.click();
		
	}
	
	@FindBy(id = "cart_checkout1")
	WebElement checkout;
	
	
	@FindBy(xpath = "//*[@id=\"checkout_btn\"]")
	WebElement confirm;
	
	public void checkoutclk() {
		checkout.click();
		confirm.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
