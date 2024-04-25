package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

//import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features = ".//Features/Login.feature",
		//features = ".//Features/addCustomer.feature",
		//features = ".//Features/",
		features = {".//Features/addCustomer.feature",".//Features/Login.feature"},
        glue = "stepDefinition", 
        dryRun = false, 
        monochrome = true,
        //tags = "@regression",
        //tags = "@sanity or @regression",
        //tags = "@sanity and @regression",
        //tags = "@sanity and not @regression",
        plugin = {"pretty", "html:target/Cucumber_Reports/reports.html"})
        //plugin = {"pretty", "html:target/Cucumber_Reports/Login_Reports.html"})
        //plugin = {"pretty", "html:target/Cucumber_Reports/addCustomer_Reports.html"})
        
        //plugin for extent reports
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

//plugin = {"pretty", "html:target/Cucumber_Reports/reports1.html" })	
//plugin = {"pretty", "json:target/Cucumber_Reports/reports_json.json" })


public class TestRunnerClass extends AbstractTestNGCucumberTests {
	/* This class will be empty */
}
