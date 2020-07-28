package com.popflow.Automation.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.popflow.Automation.helperClass.BrowserHelper;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;

public class AppManagerHomePage {
	
	private WebDriver driver;
	private CommonActions commonActions;
	private BrowserHelper browserHelper;
	private ExtentTest logger;

	Logger log = LoggerHelper.getLogger(AppManagerHomePage.class);
	
	@FindBy(xpath="//img[@class='expand-collapse-icon']")
	WebElement ExpandCollapseButton;
	
	@FindBy(xpath="//iframe[@class='stage-iframe']")
	WebElement PopFlowFrame;
	
	@FindBy(xpath="//*[contains(text(), 'CRM Instances')]")
	WebElement CRMInstanceLable;
	
//	@FindBy(xpath="/html/body/app-root/div[2]/instance-list/div[2]/div/div[3]/div/div[2]/div[3]/button")
//	WebElement DesignButtonInstance;
	
	@FindBy(xpath="/html/body/app-root/div[2]/instance-list/div[2]/div/div[1]/div/div[2]/div[3]/button")
	WebElement DesignButtonInstance;
	
	public AppManagerHomePage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	commonActions = new CommonActions(driver,logger);
	PageFactory.initElements(driver, this);
	}
	
	public void navigateToCloudopflow() {
		commonActions.isElementPresent(ExpandCollapseButton);
		commonActions.click(ExpandCollapseButton);
		log.info("Clicked on the expand-collapse button " + ExpandCollapseButton.toString());
		logger.info("Clicked on the expand-collapse button" + ExpandCollapseButton.toString());
		
	}
	
	public void switchToPopflowIFrmae() {
		driver.switchTo().frame(PopFlowFrame);
		log.info("Switched to iframe"+PopFlowFrame.toString());
		logger.info("Switched to iframe"+PopFlowFrame.toString());
	}
	
	public PopflowHomePage clickOnDesignButton() {
		commonActions.waitUntilElementIsVisible(driver, 60, DesignButtonInstance);
		commonActions.isElementPresent(DesignButtonInstance);
		commonActions.click(DesignButtonInstance);
		log.info("Clicked on the CRM Instance Design Button" + DesignButtonInstance.toString());
		logger.info("Clicked on the CRM Instance Design Button" + DesignButtonInstance.toString());
		return new PopflowHomePage(driver,logger);
	}

	public boolean CRMInstanceFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, CRMInstanceLable);
	if (commonActions.isElementPresent(CRMInstanceLable)) {
		return true;
	} else {
		log.info("CRM Instance Lable is not present: " + CRMInstanceLable.toString());
		logger.info("Expand-collapse on app manager is not present: " + CRMInstanceLable.toString());
		return false;
	}
	
	
	}
}
