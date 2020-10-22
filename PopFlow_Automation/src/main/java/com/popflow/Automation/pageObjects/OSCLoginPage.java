package com.popflow.Automation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.popflow.Automation.base.TestBase;
import com.popflow.Automation.helperClass.BrowserHelper;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;

public class OSCLoginPage extends TestBase{
	
	private WebDriver driver;
	private CommonActions commonActions;
	private BrowserHelper browserHelper;
	private ExtentTest logger;
	
	Logger log = LoggerHelper.getLogger(OSCLoginPage.class);
	
	@FindBy(how = How.ID, using = "username")
	private WebElement oscLoginPageUserNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement oscLoginPagePasswordField;

	@FindBy(how = How.XPATH, using = "//*[@id='loginbutton']")
	private WebElement oscLoginPageLoginBtn;
	
	@FindBy(xpath = "//*[@id=\"logo\"]")
	WebElement oscShieldButton;
	
	@FindBy(xpath = "/html/body/app-root/login/login-form/form/div/div/div[1]/label")
	WebElement EnvironmentNameLabel;
	
	@FindBy(xpath = "/html/body/app-root/div/button/i")
	WebElement SettingButton;
	
	private String mediaBarIFrameName = "sidePaneBrowserExtension";
	
	public OSCLoginPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	commonActions = new CommonActions(driver,logger);
	browserHelper = new BrowserHelper(driver);
	PageFactory.initElements(driver, this);
	}

	public void enterCRMUsername(String crmUN) {
		commonActions.enterData(oscLoginPageUserNameField, crmUN);
		log.info("Entered CRM Username :" + crmUN);
		logger.info("Entered CRM Username :" + crmUN);
	}

	public void enterCRMPassword(String crmPwd) { 
		commonActions.enterData(oscLoginPagePasswordField, crmPwd);
		log.info("Entered CRM Password :" + crmPwd);
		logger.info("Entered CRM Password :" + crmPwd);
	}

	public void openOSCWindow(String OSCURL) {
		browserHelper.openNewTabWindow();
		browserHelper.SwitchToWindow(1);
		driver.get(OSCURL);
	}
	
	public void switchBackToPopflowWindow() {
		browserHelper.SwitchToWindow(0);
	}
	
	public void switchToOSCWindow() {
		commonActions.waitFor(4000);
		browserHelper.SwitchToWindow(1);
	}
	
	public void loginToOSC(String crmUN, String crmPwd) {
		commonActions.waitUntilElementIsVisible(driver,60, oscLoginPageUserNameField);
		enterCRMUsername(prop.getProperty("crmUN"));
		enterCRMPassword(prop.getProperty("crmPwd"));
		commonActions.click(oscLoginPageLoginBtn);
		waitTillLoadPage();
		//this.switchToMediaBarIFrame();
		//commonActions.waitUntilElementIsVisible(driver, 60, EnvironmentNameLabel);
		commonActions.waitFor(10000);
	}
	
	public void switchToMediaBarIFrame() {
		browserHelper.switchToFrame(mediaBarIFrameName);
	//	commonActions.waitUntilElementIsVisible(driver, 60, mediaBarLoginBtn);
		commonActions.waitFor(5000);
	}

	public boolean waitTillLoadPage() {
		if(commonActions.waitUntilElementIsVisible(driver, 60, oscShieldButton) != null)
		return true;
		else
			return false;		
	}
}
