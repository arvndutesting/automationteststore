package step_defination;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Booking_Tshirt;
import pageObjects.Register;
import pageObjects.baseclass;
import pageObjects.login;

public class Account extends baseclass {
	
	
	
	
	@Before
    public void setup() throws IOException {
        // Load config
        FileReader fis = new FileReader("C:\\guru99_project\\src\\test\\resources\\Config.properties");
        p = new Properties();
        p.load(fis);

        // Browser setup
        String loadBrowser = p.getProperty("browser");

        if (loadBrowser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (loadBrowser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (loadBrowser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new RuntimeException("Browser not supported: " + loadBrowser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // Page Objects Initialization
        rg = new Register(driver);
        lg = new login(driver);
        bt = new Booking_Tshirt(driver);
    }
	
	
	@Given("User launches chrome browser")
	public void user_launches_chrome_browser() {
	    System.out.println("USER LAUCH THE BROWSER AND LOADS THE URL");
	    
//	    String loadBrowser = p.getProperty("browser");
//
//	    if (loadBrowser.equalsIgnoreCase("chrome")) {
//	        WebDriverManager.chromedriver().setup();
//	        driver = new ChromeDriver();
//	    } 
//	    else if (loadBrowser.equalsIgnoreCase("edge")) {
//	        WebDriverManager.edgedriver().setup();
//	        driver = new EdgeDriver();
//	    } 
//	    else if (loadBrowser.equalsIgnoreCase("firefox")) {
//	        WebDriverManager.firefoxdriver().setup();
//	        driver = new FirefoxDriver();
//	    } 
//	    else {
//	        throw new RuntimeException("Browser not supported: " + loadBrowser);
//	    }
	   
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
	}

	@Given("User enters the url {string}")
	public void user_enters_the_url(String string) {
        
		driver.get(p.getProperty("url"));
		
		
	   
	}

	@Given("User click Register and select Register and click on continue")
	public void user_click_register_and_select_register_and_click_on_continue() {
	    rg.rgnclk();
	    
	}

	@Given("User enters all the required details")
	public void user_enters_all_the_required_details() {
		rg.clickContinueToRegister();
		
		rg.setFirstName();
		rg.setLastName();
		rg.setEmail();
		rg.setTelephone();
		rg.setAddress();
		rg.setcountry();
		rg.setstate();
		rg.setCity();
		rg.setPostcode();
		
		rg.setLoginName();
		rg.setPassword();
		rg.setConfirmPassword();
	    
	}

	@Then("User click on Privacy policy and click on continue button")
	public void user_click_on_privacy_policy_and_click_on_continue_button() {
		rg.acceptPrivacyPolicy();
		rg.clickContinueButton();
		System.out.println(rg.getPageTitle());
	    

}
	
	

	/////////////////  LOGIN DETAILS /////////////////////////////
	
	
	@When("User enter the login name and password")
	public void user_enter_the_login_name_and_password() {
		
	   lg.setLoginName1();
	   lg.setPassword1();
	}

	@Then("User click on continue button")
	public void user_click_on_continue_button() {
		lg.clickLoginButton();
		
	   
	}
	
	
	///////////////////////////////  BOOKING TSHIRT   /////////////////////////
	
	@When("User click on the T-Shirt")
	public void user_click_on_the_t_shirt() {
	    bt.scrollclk();
	}

	@When("User click on {string}")
	public void user_click_on(String string) {
		bt.shirtclk();
	    
	}

	@When("User select the White colour")
	public void user_select_the_white_colour() {
	   bt.selectclk();
	}
	
	@Then("User clicks on the Add to cart button")
	public void user_clicks_on_the_add_to_cart_button() {
	    bt.clickAddToCart();
	}

	@When("User select the Quality of {int} and click on Update")
	public void user_select_the_quality_of_and_click_on_update(Integer int1) throws InterruptedException {
	    
	    bt.quanityclk();
	    
	}

	@When("User click on the Confirm Order")
	public void user_click_on_the_confirm_order() {
	    bt.checkoutclk();
	}

	@Then("User getting the order details in console")
	public void user_getting_the_order_details_in_console() {
		
		String orderNumber = driver.findElement(By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/section/p[2]")).getText();
	    
		System.out.println(orderNumber);
		
	}

	
	
	@After
    public void teardown(Scenario sce) throws InterruptedException {
        if (sce.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            sce.attach(screenshot, "image/png", sce.getName());
        }

        Thread.sleep(2000); // optional delay
        if (driver != null) {
            driver.quit();
        }
    }


}
