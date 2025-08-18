package runner_file;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;
//import io.cucumber.junit.Cucumber;

//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
			features =//  ,{
		{"C:\\guru99_project\\src\\test\\resources\\features\\NewAccount.feature" ,
		"C:\\guru99_project\\src\\test\\resources\\features"},
			glue="step_defination" ,
			
			dryRun = false ,
			
			monochrome = true ,
			
					//tags = "@smoke",
			
					plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			                
		////*[@id="cart_quantity121cf270a9f0b2596b85990ba40feaeccad"]
			
		)


public class loginrunner extends AbstractTestNGCucumberTests{
	
	
	

}