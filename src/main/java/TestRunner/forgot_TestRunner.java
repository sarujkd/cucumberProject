package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions( features= {"C:\\Users\\anand\\Documents\\Saru\\GitSample\\GitDemo\\SFDC_Cucumber\\src\\main\\resources\\Features\\forgot.feature"},
                  glue= {"forGot_StepDef"},
                  format= {"pretty","html:target/SFDCReport1","json:target/SFDC_report1.json"},
                   monochrome=true,
                   strict=true,
                   dryRun=false)

public class forgot_TestRunner extends  AbstractTestNGCucumberTests{}


