package TestRunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions( features= {"src\\main\\resources\\Features\\Login.feature"},
                  glue= {"loginStepDef"},
                  format= {"pretty","html:target/SFDCReport","json:target/SFDC_report.json"},
                   monochrome=true,
                   strict=true,
                   dryRun=false)

public class Login_TestRunner extends AbstractTestNGCucumberTests {

	
}
