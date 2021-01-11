package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {

	 public static WebDriver driver;
	public static  Properties prop;
	
	public testBase()   {
		try {
		prop=new Properties();
		FileInputStream fp= new FileInputStream("C:\\Users\\anand\\Documents\\Saru\\GitSample\\GitDemo\\SFDC_Cucumber\\utility\\testdata.properties");
			 prop.load(fp);
		} catch (IOException e) {
			
			e.printStackTrace();
		
		 
		}  
	}
	
	public static void Initialize_The_Browser() throws IOException {
		  
	   //check for the browser
	   String browser=prop.getProperty("browser");
	   if (browser.equalsIgnoreCase("Chrome")) {
		   WebDriverManager.chromedriver().setup();
	   
		   driver=new ChromeDriver();
	   }
	   else
		   if (browser.equalsIgnoreCase("FireFox")) {
			   WebDriverManager.firefoxdriver().setup();
			   driver=new FirefoxDriver();
		   }
		   else
			   if (browser.equalsIgnoreCase("edge")) {
				   WebDriverManager.edgedriver().setup();
				   driver=new EdgeDriver();
			   }
		   
	   driver.get(prop.getProperty("url"));
	   driver.manage().window().maximize();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);

	}

	   public static void close_The_Browser() throws IOException {
		   
		 		   driver.quit();
	   }
	   
	   
	    public  void takeScreenShot(WebDriver driver,String fileWithPath) throws Exception{

	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(fileWithPath);

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

	    }


}
