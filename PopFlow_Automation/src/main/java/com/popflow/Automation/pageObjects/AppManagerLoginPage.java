package com.popflow.Automation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.popflow.Automation.helperClass.BrowserHelper;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;

public class AppManagerLoginPage {
	
	
	private WebDriver driver;
	private CommonActions commonActions;
	private BrowserHelper browserHelper;
	private ExtentTest logger;
;
	
	Logger log = LoggerHelper.getLogger(AppManagerLoginPage.class);
	
	@FindBy(id="Email")
	WebElement EmailField;
	
	@FindBy(id="Password")
	WebElement PasswordField;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot Password')]")
	WebElement ForgotPasswordLink;
	
	@FindBy(xpath="//div[@class='hero']//img")
	WebElement OpenMethodsLogo;
	
	@FindBy(xpath="//img[@class='expand-collapse-icon']")
	WebElement ExpandCollapseButton;
	
	
	public AppManagerLoginPage(WebDriver driver, ExtentTest logger) {
			this.driver = driver;
			this.logger = logger;
		commonActions = new CommonActions(driver,logger);
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		commonActions.enterData(EmailField, email);
		log.info("Entered Email :" + email);
		logger.info("Entered email :" + email);
	}
	
	public void enterPassword(String password) {
		commonActions.enterData(PasswordField, password);
		log.info("Entered Password :" + password);
		logger.info("Entered Password :" + password);
	}
	
	public AppManagerHomePage clickOnLoginButton(){
		commonActions.click(LoginBtn);
		commonActions.waitUntilElementIsVisible(driver, 60, ExpandCollapseButton);
		return new AppManagerHomePage(driver, logger);
	}
	
	public AppManagerHomePage enterLoginDataToAppManager(String email, String password) {
		commonActions.waitUntilElementIsVisible(driver,60, EmailField);
		enterEmail(email);
		enterPassword(password);
		return clickOnLoginButton();
	}
	
	public boolean getExpandButtonFlag() {
			commonActions.waitUntilElementIsVisible(driver, 60, ExpandCollapseButton);
		if (commonActions.isElementPresent(ExpandCollapseButton)) {
			return true;
		} else {
			log.info("Expand-collapse button on app manager is not present: " + ExpandCollapseButton.toString());
			logger.info("Expand-collapse on app manager is not present: " + ExpandCollapseButton.toString());
			return false;
		}
	}

}
