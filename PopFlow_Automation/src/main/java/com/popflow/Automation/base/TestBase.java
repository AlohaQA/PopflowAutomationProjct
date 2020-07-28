package com.popflow.Automation.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.popflow.Automation.helperClass.LoggerHelper;
import com.popflow.Automation.util.ExtentReportUtility;

public class TestBase{
		
		public static WebDriver driver;
		public static Properties prop;
		public static ExtentReports extent;
		ExtentReportUtility extentReportUtility;;
		public ExtentTest logger;
		
		
		public TestBase() {
		}
		
		@BeforeSuite
		public void setuSuite() {
			extent = ExtentReportUtility.createReport();
		}
		
		@BeforeClass
		public void beforeclass() {
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/popflow/Automation/config/Config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@BeforeMethod
		public static void initialization() {
			String browsername = prop.getProperty("browser");
			if(browsername.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:/Automation/ChromeDriver/chromedriver.exe");	
				driver = new ChromeDriver();
				
				
			}
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();

		}
		
		@AfterMethod
		public void tearDown(ITestResult result) throws IOException {
			if(result.getStatus() == ITestResult.FAILURE) {
				logger.fail("FAIL",
						MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(result.getName())).build());
				logger.fail(MarkupHelper.createLabel(result.getName() + ":: FAILED", ExtentColor.RED));
			}
			else if(result.getStatus() == ITestResult.SUCCESS) {
				logger.pass(MarkupHelper.createLabel(result.getName() + ":: PASSED", ExtentColor.GREEN));
			}
			else if(result.getStatus() == ITestResult.SKIP) {
				logger.skip(MarkupHelper.createLabel(result.getName() + ":: SKIPPED", ExtentColor.ORANGE));
				logger.skip(result.getThrowable());
			}
			
			driver.close();
		}
		
		@AfterSuite
		public void afterSuite() {
			extent.flush();
		}
		
		public String takeScreenShot(String methodName) {
		
			
			SimpleDateFormat formater = new SimpleDateFormat("MM_dd_yyyy_hh_mm");
			String path = System.getProperty("user.dir") + "\\Failed_Screenshots\\"+methodName+"_"
					+ formater.format(new Date()) + ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(path));
			} catch (IOException e) {
				System.out.println("Exception occured when copying screenshot to folder.");
			}
			return path;
		}

}
