package com.popflow.Automation.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.popflow.Automation.base.TestBase;
import com.popflow.Automation.helperClass.BrowserHelper;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class PopflowHomePage extends TestBase{
	
	private WebDriver driver;
	private CommonActions commonActions;
	private BrowserHelper browserHelper;
	private ExtentTest logger;
	
	Logger log = LoggerHelper.getLogger(PopflowHomePage.class);
	
	@FindBy(xpath="/html/body/app-root/div[2]/instance-list/div[2]/div/div[1]/div/div[2]/div[3]/button")
	WebElement DesignButtonInstance;
	
	@FindBy(xpath="//a[@class='linked-account clickable']")
	WebElement LinkeAccountButton;
	
	@FindBy(xpath="/html/body/app-root/crm-manager/div/div/div/div[2]/form/div[1]/div/div/input")
	WebElement OSCUserNameField;
	
	@FindBy(xpath="/html/body/app-root/crm-manager/div/div/div/div[2]/form/div[2]/div/div/input")
	WebElement OSCPasswordField;
	
	@FindBy(xpath="/html/body/app-root/crm-manager/div/div/div/div[3]/button[2]")
	WebElement SaveCredentialsButton;
	
	@FindBy(xpath="/html/body/app-root/crm-manager/div/div/div/div[2]/div[2]")
	WebElement InvalidOSCCredErrorMessage;
	
	@FindBy(xpath = "/html/body/app-root/crm-manager/div/div/div/div[3]/button[1]")
	WebElement CancelButtonFromCredentialPopup;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/section/div[1]/div/ul/li/a[2]/i")
	WebElement SortWorkFlowButton;
	
//	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/section/div[2]/ul/li[1]/div/h6")
//	WebElement FirstWorkFlow;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/section/div[2]/ul/li[1]")
	WebElement FirstWorkFlow;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflow/section/div/div/div[1]/div/div[2]/div/button/i")
	WebElement SettingButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflow/section/div/div/div[1]/div/div[2]/div/ul/li[1]/a")
	WebElement DuplicateButtonFrmDropDown;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflow/duplicate-workflow/div/div/div/div[2]/div/div[1]/div/input")
	WebElement DulicateWorkFlowNameTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflow/duplicate-workflow/div/div/div/div[3]/button[2]")
	WebElement DuplicateWorkFlowButton;
	
	@FindBy(xpath = "//i[@class='material-icons clickable'][contains(text(),'add')]")
	WebElement AddNewWorkflowButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/div[1]/div/div/div[2]/input")
	WebElement AddNewWorkFlowTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/div[1]/div/div/div[3]/button[2]")
	WebElement AddNewWorkFlowSaveButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/section/div[2]/ul/li[1]/div/i")
	WebElement DeleteWorkFlowButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/div[2]/div/div/div[3]/button[2]")
	WebElement DeleteWorkFlowButtonOnPopup;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflow/section/div/div/div[1]/div/div[1]/h5/edit-input/div/span/i")
	WebElement EditWorkflowNameButton;
	
	@FindBy(xpath = "//input[@class='form-control' and @type='text']")
	WebElement EditWorkFlowTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflow/section/div/div/div[2]/div[1]/div/dl/dd[1]/edit-input/div/span/i")
	WebElement EditWorkFlowDescriptionButton;
	
	@FindBy(xpath = "//input[@class='form-control' and @type='text']")
	WebElement EditWorkflowDescriptionTextBox;
	
	@FindBy(xpath = "//p[@class='text-danger error-message']")
	WebElement WorkflowNameErrorMessage;
	
	@FindBy(xpath = "//p[@class='text-danger error-message']")
	WebElement WorkflowDescriptionErrorMessage;
	
	@FindBy(xpath = "//i[@class='material-icons custom-event-icon']")
	WebElement AddNewCustomEventButton;
	
//	@FindBy(xpath = "//input[@placeholder='Enter Name']")
//	WebElement CustomEventNameTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-events/div[1]/div/div/div[2]/input[1]")
	WebElement CustomEventNameTextBox;
	
	@FindBy(xpath = "//a[contains(text(),'On Incident Save')]")
	WebElement OnIncidentSaveEvent;
	
	@FindBy(xpath = "//input[@placeholder='Enter Description']")
	WebElement CustomEventDescriptionTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-events/section/div[2]/ul/li[4]/div/ul/li/div")
	WebElement AddedCustomEventOnIncidentClose;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-events/section/div[2]/ul/li[4]/div/ul/li/div/span/i[2]")
	WebElement CustomEventDeleteButton;
	
	@FindBy(xpath = "//div[@class='modal-content ng-untouched ng-pristine ng-valid']//button[@class='btn btn-danger'][contains(text(),'Delete')]")
	WebElement CustomEventDeleteButtonOnPopup;
	
	@FindBy(xpath = "//i[@class='material-icons clickable' and @title='Edit Custom Event']")
	WebElement CustomEventEditButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-events/div[1]/div/div/div[3]/button[2]")
	WebElement CustomEventSaveButton;
	
	@FindBy(xpath = "//i[@class='material-icons clickable'][contains(text(),'system_update_alt')]")
	WebElement ImportActivityButton;
	
	@FindBy(xpath = "//div[contains(text(),'On Hold')]")
	WebElement OnHoldEventButton;
	
	@FindBy(xpath = "//div[contains(text(),'On End')]")
	WebElement OnEndEventButton;
	
	@FindBy(xpath = "//div[contains(text(),'On Ring')]")
	WebElement OnRingEventButton;
	
	@FindBy(xpath = "//div[contains(text(),'On Answer')]")
	WebElement OnAnswerButton;
	
	@FindBy(xpath = "//div[contains(text(),'Chat Ring')]")
	WebElement ChatRingEventButton;
	
	@FindBy(xpath = "//div[contains(text(),'Chat Accept')]")
	WebElement ChatAcceptEventButton;
	
	@FindBy(xpath = "//div[contains(text(),'Chat Reject')]")
	WebElement ChatRejectEventButton;
	
	@FindBy(xpath = "//div[contains(text(),'On Chat End')]")
	WebElement ChatEndEventButton;
	
	@FindBy(xpath = "//i[contains(text(),'info')]")
	WebElement InfoButton;
	
	@FindBy(xpath = "/html/body/app-root/div[1]/div/div/div[2]")
	WebElement PopflowVersion;
	
	@FindBy(xpath = "//a[contains(text(),'Instances')]")
	WebElement InstanceButton;
	
	@FindBy(xpath = "//a[contains(text(),'isv-19a-openmethods')]")
	WebElement PopflowHomePageButton;
	
	@FindBy(xpath = "//h6[contains(text(),'Import Workflow Test')]")
	WebElement ImportWorkflowTag;
	
	@FindBy(xpath = "//h6[contains(text(),'Import Workflow Test(1)')]")
	WebElement ImportNewWorkflowTag;
	
	@FindBy(xpath = "//button[contains(text(),'Override')]")
	WebElement ImortOverrideButton;
	
	@FindBy(xpath = "//button[contains(text(),'Import new')]")
	WebElement ImortNewButtonOnPopup;
	
	
	public PopflowHomePage(WebDriver driver, ExtentTest logger) {
			this.driver = driver;
			this.logger = logger;
		commonActions = new CommonActions(driver,logger);
		PageFactory.initElements(driver, this);
	}
	
	public void enterCRMUsername(String crmUN) {
		commonActions.enterData(OSCUserNameField, crmUN);
		log.info("Entered CRM Username :" + crmUN);
		logger.info("Entered CRM Username :" + crmUN);
	}
	
	public void enterCRMPassword(String crmPwd) { 
		commonActions.enterData(OSCPasswordField, crmPwd);
		log.info("Entered CRM Password :" + crmPwd);
		logger.info("Entered CRM Password :" + crmPwd);
	}
	
	public void clicOnSaveCredentialsButton() {
		commonActions.waitUntilElementIsVisible(driver, 60, SaveCredentialsButton);
		commonActions.click(SaveCredentialsButton);
		log.info("Clicked on save credentials button :" + SaveCredentialsButton.toString());
		logger.info("Clicked on save credentials button :" + SaveCredentialsButton.toString());
	}
	
	public void clickOnCancelCredentialsButton() {
		commonActions.waitUntilElementTobeClickable(driver, 60, CancelButtonFromCredentialPopup);
		commonActions.click(CancelButtonFromCredentialPopup);
		log.info("Clicked on cancel button :" + CancelButtonFromCredentialPopup.toString());
		logger.info("Clicked on cancel button :" + CancelButtonFromCredentialPopup.toString());
	}
	
	public void enterValidCRMCredentials(String crmUN , String crmPwd) {
		commonActions.waitUntilElementIsVisible(driver, 60, LinkeAccountButton);
		commonActions.click(LinkeAccountButton);
		log.info("Clicked on the CRM Linked account button" + LinkeAccountButton.toString() );
		logger.info("Clicked on the CRM Linked account Button" + LinkeAccountButton.toString() );
		commonActions.waitUntilElementIsVisible(driver, 60, OSCUserNameField);
		enterCRMUsername(crmUN);
		enterCRMPassword(crmPwd);
	}
	
	public void enterInvalidCRMCredentials(String IncrmUN , String IncrmPwd) {
		commonActions.waitUntilElementIsVisible(driver, 60, LinkeAccountButton);
		commonActions.click(LinkeAccountButton);
		commonActions.waitUntilElementIsVisible(driver, 60, OSCUserNameField);
		enterCRMUsername(IncrmUN);
		enterCRMPassword(IncrmPwd);
	}
	
	public void getInvalidCredentialsErrorMsg() {
		commonActions.waitUntilElementIsVisible(driver, 60, InvalidOSCCredErrorMessage);
		String ErrorMssg = commonActions.getText(InvalidOSCCredErrorMessage);
		log.info("Error message when entered invalid CRM credentials is:"+ ErrorMssg);
		logger.info("Error message when entered invalid CRM credentials is:"+ ErrorMssg);
		commonActions.verifyAssertTrue(ErrorMssg.equalsIgnoreCase("	×\n" + 
				"Error!\n" + 
				"Unable to authenticate this user. Please check username and Password."), 
				
				"Showing correct error message for Invalid OSC credentials", 
				"Showing incorrect error message for Invalid OSC credentials");
	}
	
	public void duplicateWorkFlow(String DuplicateName) {
		commonActions.waitUntilElementIsVisible(driver, 60, FirstWorkFlow);
		commonActions.click(FirstWorkFlow);
		log.info("Clicked on first workflow" + FirstWorkFlow.toString());
		log.info("Clicked on first workflow" + FirstWorkFlow.toString());
		commonActions.waitUntilElementIsVisible(driver, 60, SortWorkFlowButton);
		commonActions.click(SortWorkFlowButton);
		log.info("Clicked on sort button" + SortWorkFlowButton.toString());
		logger.info("Clicked on sort button" + SortWorkFlowButton.toString()); 
		commonActions.waitUntilElementTobeClickable(driver, 60, SettingButton);
		commonActions.click(SettingButton);
		log.info("Clicked on setting button" + SettingButton.toString());
		logger.info("Clicked on sort button" + SettingButton.toString());
		commonActions.waitUntilElementTobeClickable(driver, 60, DuplicateButtonFrmDropDown);
		commonActions.click(DuplicateButtonFrmDropDown);
		log.info("Clicked on duplicate button from drop down" + DuplicateButtonFrmDropDown.toString());
		logger.info("Clicked on duplicate button from drop down" + DuplicateButtonFrmDropDown.toString());
		commonActions.waitUntilElementIsVisible(driver, 60, DulicateWorkFlowNameTextBox);
		commonActions.click(DulicateWorkFlowNameTextBox);
		commonActions.clear(DulicateWorkFlowNameTextBox);
		commonActions.enterData(DulicateWorkFlowNameTextBox, DuplicateName);
		log.info("Entered duplicate workflow name as :" + DuplicateName);
		logger.info("Entered duplicate workflow name as :" + DuplicateName);
		commonActions.waitUntilElementTobeClickable(driver, 60, DuplicateWorkFlowButton);
		commonActions.click(DuplicateWorkFlowButton);
		log.info("Clicked on duplicate workflow button on popup" + DuplicateWorkFlowButton.toString());
		logger.info("Clicked on duplicate workflow button on popup" + DuplicateWorkFlowButton.toString());
		commonActions.waitFor(3000);
	}
	
	public CreateWorkspaceActivityPage addNewWorkFlow(String NewWorkFlowName) {
		 commonActions.waitUntilElementIsVisible(driver, 60, AddNewWorkflowButton);
		 commonActions.click(AddNewWorkflowButton);
		 log.info("Clicked on the add new workflow button" + AddNewWorkflowButton.toString());
		 logger.info("Clicked on the add new workflow button" + AddNewWorkflowButton.toString());
		 commonActions.waitUntilElementIsVisible(driver, 60, AddNewWorkFlowTextBox);
		 commonActions.enterData(AddNewWorkFlowTextBox, NewWorkFlowName);
		 log.info("Entered New Workflow Name :" + NewWorkFlowName);
		 logger.info("Entered New Workflow Name :" + NewWorkFlowName);
		 commonActions.waitUntilElementTobeClickable(driver, 60, AddNewWorkFlowSaveButton);
		 commonActions.click(AddNewWorkFlowSaveButton);
		 log.info("Clicked on the add new workflow save button" + AddNewWorkFlowSaveButton.toString());
		 logger.info("Clicked on the add new workflow save button" + AddNewWorkFlowSaveButton.toString());
		 commonActions.waitFor(3000);
		 return new CreateWorkspaceActivityPage(driver, logger);
	}
	
	public void editWorkflow() {
		commonActions.waitUntilElementIsVisible(driver, 60, FirstWorkFlow);
		commonActions.click(FirstWorkFlow);
		commonActions.waitUntilElementTobeClickable(driver, 60, EditWorkflowNameButton);
		if(commonActions.isElementPresent(EditWorkflowNameButton)) {;
			log.info("Edit workflow button is present " + EditWorkflowNameButton);
			logger.info("Edit workflow button is present " + EditWorkflowNameButton);
			commonActions.click(EditWorkflowNameButton);
			log.info("Cllicked on the edit workflow button" + EditWorkflowNameButton.toString());
			logger.info("Cllicked on the edit workflow button" + EditWorkflowNameButton.toString());
			commonActions.waitUntilElementIsVisible(driver, 60, EditWorkFlowTextBox);
			commonActions.enterData(EditWorkFlowTextBox, " - verify edit workflow");
			commonActions.waitFor(3000);
			commonActions.click(SettingButton);
			log.info("Clicked ont the settings button " + SettingButton.toString());
			logger.info("Clicked ont the settings button " + SettingButton.toString());
			commonActions.waitFor(3000);
		}else {
			log.info("Edit workflow button is not present " + EditWorkflowNameButton);
			logger.info("Edit workflow button is not present " + EditWorkflowNameButton);
		}
	}
	
	public void editWorkflowDescription() {
		commonActions.waitUntilElementIsVisible(driver, 60, FirstWorkFlow);
		commonActions.click(FirstWorkFlow);
		commonActions.waitUntilElementTobeClickable(driver, 60, EditWorkFlowDescriptionButton);
		if(commonActions.isElementPresent(EditWorkFlowDescriptionButton)) {;
			log.info("Edit workflow button is present " + EditWorkFlowDescriptionButton);
			logger.info("Edit workflow button is present " + EditWorkFlowDescriptionButton);
			commonActions.click(EditWorkFlowDescriptionButton);
			log.info("Cllicked on the edit workflow button" + EditWorkFlowDescriptionButton.toString());
			logger.info("Cllicked on the edit workflow button" + EditWorkFlowDescriptionButton.toString());
			commonActions.waitUntilElementIsVisible(driver, 60, EditWorkflowDescriptionTextBox);
			commonActions.enterData(EditWorkFlowTextBox, " - verify edit workflow description");
			commonActions.waitFor(3000);
			commonActions.click(SettingButton);
			log.info("Clicked ont the settings button " + SettingButton.toString());
			logger.info("Clicked ont the settings button " + SettingButton.toString());
			commonActions.waitFor(3000);
		}else {
			log.info("Edit workflow button is not present " + EditWorkflowNameButton);
			logger.info("Edit workflow button is not present " + EditWorkflowNameButton);
		}
		
	}
	
	public void getErrormessageForLongWFName(String longWorkFlowNameString) {
		commonActions.waitUntilElementIsVisible(driver, 60, FirstWorkFlow);
		commonActions.click(FirstWorkFlow);
		commonActions.waitUntilElementTobeClickable(driver, 60, EditWorkflowNameButton);
		if(commonActions.isElementPresent(EditWorkflowNameButton)) {;
			log.info("Edit workflow button is present " + EditWorkflowNameButton);
			logger.info("Edit workflow button is present " + EditWorkflowNameButton);
			commonActions.click(EditWorkflowNameButton);
			log.info("Cllicked on the edit workflow button" + EditWorkflowNameButton.toString());
			logger.info("Cllicked on the edit workflow button" + EditWorkflowNameButton.toString());
			commonActions.waitUntilElementIsVisible(driver, 60, EditWorkFlowTextBox);
			commonActions.enterData(EditWorkFlowTextBox, longWorkFlowNameString);
			
			commonActions.waitUntilElementIsVisible(driver, 60, WorkflowNameErrorMessage);
			String ErrorMsg = commonActions.getText(WorkflowNameErrorMessage);
			log.info("Error message when entered workflow name more than 50 characters : "+ ErrorMsg);
			logger.info("Error message when entered workflow name more than 50 characters : "+ ErrorMsg);

			commonActions.verifyAssertTrue(ErrorMsg.equalsIgnoreCase(
					"Workflow name cannot be larger than 45 characters."),
					
					"Showing correct error message after entering workflow name more than 50 characters", 
					"Showing incorrect error message after entering workflow name more than 50 characters");
			commonActions.click(SettingButton);
			log.info("Clicked ont the settings button " + SettingButton.toString());
			logger.info("Clicked ont the settings button " + SettingButton.toString());
			commonActions.waitFor(1000);
		}else {
			log.info("Edit workflow button is not present " + EditWorkflowNameButton);
			logger.info("Edit workflow button is not present " + EditWorkflowNameButton);
		}
	}
	
	public void getErrormessageForLongWFDescription(String longWorkFlowDesString) {
		commonActions.waitUntilElementIsVisible(driver, 60, FirstWorkFlow);
		commonActions.click(FirstWorkFlow);
		commonActions.waitUntilElementTobeClickable(driver, 60, EditWorkFlowDescriptionButton);
		if(commonActions.isElementPresent(EditWorkFlowDescriptionButton)) {;
			log.info("Edit workflow button is present " + EditWorkFlowDescriptionButton);
			logger.info("Edit workflow button is present " + EditWorkFlowDescriptionButton);
			commonActions.click(EditWorkFlowDescriptionButton);
			log.info("Cllicked on the edit workflow button" + EditWorkFlowDescriptionButton.toString());
			logger.info("Cllicked on the edit workflow button" + EditWorkFlowDescriptionButton.toString());
			commonActions.waitUntilElementIsVisible(driver, 60, EditWorkflowDescriptionTextBox);
			commonActions.enterData(EditWorkflowDescriptionTextBox, longWorkFlowDesString);
			
			commonActions.waitUntilElementIsVisible(driver, 60, WorkflowDescriptionErrorMessage);
			String ErrorMsg = commonActions.getText(WorkflowDescriptionErrorMessage);
			log.info("Error message when entered workflow description more than 50 characters : * "+ ErrorMsg + "*");
			logger.info("Error message when entered workflow description more than 50 characters : * "+ ErrorMsg + "*");
			
			commonActions.verifyAssertTrue(ErrorMsg.equalsIgnoreCase(""
					+ "Description cannot be larger than 200 characters."),
					
					"Showing correct error message after entering workflow description more than 200 characters", 
					"Showing incorrect error message after entering workflow description more than 200 characters");
			commonActions.click(SettingButton);
			log.info("Clicked ont the settings button " + SettingButton.toString());
			logger.info("Clicked ont the settings button " + SettingButton.toString());
			commonActions.waitFor(1000);
		}else {
			log.info("Edit workflow button is not present " + EditWorkflowNameButton);
			logger.info("Edit workflow button is not present " + EditWorkflowNameButton);
		}
	}
	
	public void mouseHoverOnWorkFlow() {
		commonActions.waitUntilElementIsVisible(driver, 60, FirstWorkFlow);
		Actions action = new Actions(driver);
		action.moveToElement(FirstWorkFlow).build().perform();
	}
	
	public void deleteWorkflow() {
		this.mouseHoverOnWorkFlow();
		commonActions.waitUntilElementIsVisible(driver, 60, DeleteWorkFlowButton);
		commonActions.clickbymouseHover(DeleteWorkFlowButton);
//		commonActions.click(DeleteWorkFlowButton);
		log.info("Clicked on delete workflow button " + DeleteWorkFlowButton.toString());
		logger.info("Clicked on delete workflow button " + DeleteWorkFlowButton.toString());
		commonActions.waitUntilElementIsVisible(driver, 60, DeleteWorkFlowButtonOnPopup);
		commonActions.click(DeleteWorkFlowButtonOnPopup);
		log.info("Clicked on delete workflow button on popup " + DeleteWorkFlowButtonOnPopup.toString());
		logger.info("Clicked on delete workflow button on popup " + DeleteWorkFlowButtonOnPopup.toString());
		commonActions.waitUntilElementIsVisible(driver, 60, AddNewWorkflowButton);
	}	
	
	public void importWorkflow() throws AWTException {
			commonActions.waitFor(2000);
		if(commonActions.isElementPresent(ImportActivityButton))
		{
			Robot robot = new Robot();
			log.info("Import button is present" + ImportActivityButton.toString());
			logger.info("Import button is present" + ImportActivityButton.toString());
			commonActions.click(ImportActivityButton);
			log.info("Clicked on the import button " + ImportActivityButton.toString());
			logger.info("Clicked on the impoer button " + ImportActivityButton.toString());
			robot.setAutoDelay(2000);
			StringSelection string = new StringSelection("C:\\Users\\Aloha8\\My workspace\\Git\\PopFlow_Automation\\Import\\Import Workflow Test.pfwf");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string,null);
			commonActions.waitFor(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			robot.setAutoDelay(1000);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			if(commonActions.isElementPresent(ImportWorkflowTag)) {
				
				log.info("Selected a workflow to import ");
				logger.info("Selected a workflow to import");
			}
		}
		else {
			log.info("Import button is not present" + ImportActivityButton.toString());
			logger.info("Import button is not present" + ImportActivityButton.toString());
		}
	}
	
	public void importOverride() throws AWTException {
		
			//importWorkflow();
			commonActions.waitFor(1000);
			importWorkflow();
			if(commonActions.isElementPresent(ImortOverrideButton)) {
				log.info("Override button is present on the popup " + ImortOverrideButton.toString());
				logger.info("Oveerride button is present on he popup " + ImortOverrideButton.toString());
				commonActions.click(ImortOverrideButton);
				log.info("Clicked on the override button " + ImortOverrideButton.toString());
				logger.info("Clicked on the override button " + ImortOverrideButton.toString());
			}else {
				log.info("Override Button is not present on the popup " + ImortOverrideButton.toString());
				logger.info("Override button is not present on the popup " + ImortOverrideButton.toString());
			}
			commonActions.waitFor(1000);
	}
	
	public void importNew() throws AWTException {
		
		//importWorkflow();
		commonActions.waitFor(1000);
		importWorkflow();
		if(commonActions.isElementPresent(ImortNewButtonOnPopup)) {
			log.info("Import new button is present on the popup " + ImortNewButtonOnPopup.toString());
			logger.info("Import new button is present on he popup " + ImortNewButtonOnPopup.toString());
			commonActions.click(ImortNewButtonOnPopup);
			log.info("Clicked on the import new button " + ImortNewButtonOnPopup.toString());
			logger.info("Clicked on the import new button " + ImortNewButtonOnPopup.toString());
		}else {
			log.info("Import New Button is not present on the popup " + ImortNewButtonOnPopup.toString());
			logger.info("Import New button is not present on the popup " + ImortNewButtonOnPopup.toString());
		}
		commonActions.waitFor(1000);
	}
	
	public void verifyOnRingEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, OnRingEventButton);
		if(commonActions.isElementPresent(OnRingEventButton)){
			log.info("On Ring Event is present " + OnRingEventButton.toString());
			logger.info("On Ring Event is present " + OnRingEventButton.toString());
			commonActions.click(OnRingEventButton);
			log.info("Clicked on the On Ring Event " + OnRingEventButton.toString());
			logger.info("Clicked on the On Ring Event " + OnRingEventButton.toString());
		}
		else {
			log.info("On Ring event is not present" + OnRingEventButton.toString());
			logger.info("On Ring event is not present" + OnRingEventButton.toString());
	}
}
	
	public void verifyOnAnswerEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, OnAnswerButton);
		if(commonActions.isElementPresent(OnAnswerButton)){
			log.info("On Answer Event is present " + OnAnswerButton.toString());
			logger.info("On Answer Event is present " + OnAnswerButton.toString());
			commonActions.click(OnAnswerButton);
			log.info("Clicked on the On Answer Event " + OnAnswerButton.toString());
			logger.info("Clicked on the On Answer Event " + OnAnswerButton.toString());
		}
		else {
			log.info("On Answer event is not present" + OnAnswerButton.toString());
			logger.info("On Answer event is not present" + OnAnswerButton.toString());
		}	
	}
	
	public void verifyOnHoldEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, OnHoldEventButton);
		if(commonActions.isElementPresent(OnHoldEventButton)){
			log.info("On Hold Event is present " + OnHoldEventButton.toString());
			logger.info("On Hold Event is present " + OnHoldEventButton.toString());
			commonActions.click(OnHoldEventButton);
			log.info("Clicked on the On Hold Event " + OnHoldEventButton.toString());
			logger.info("Clicked on the On Hold Event " + OnHoldEventButton.toString());
		}
		else {
			log.info("On Hold event is not present" + OnHoldEventButton.toString());
			logger.info("On Hold event is not present" + OnHoldEventButton.toString());
		}	
	}
	
	public void verifyOnEndEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, OnEndEventButton);
		if(commonActions.isElementPresent(OnEndEventButton)){
			log.info("On End Event is present " + OnEndEventButton.toString());
			logger.info("On End Event is present " + OnEndEventButton.toString());
			commonActions.click(OnEndEventButton);
			log.info("Clicked on the On End Event " + OnEndEventButton.toString());
			logger.info("Clicked on the On End Event " + OnEndEventButton.toString());
		}
		else {
			log.info("On End event is not present" + OnEndEventButton.toString());
			logger.info("On End event is not present" + OnEndEventButton.toString());
		}	
	}
	
	public void verifyChatRingEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, ChatRingEventButton);
		if(commonActions.isElementPresent(ChatRingEventButton)){
			log.info("Chat Ring Event is present " + ChatRingEventButton.toString());
			logger.info("Chat Ring Event is present " + ChatRingEventButton.toString());
			commonActions.click(ChatRingEventButton);
			log.info("Clicked on the Chat Ring event " + ChatRingEventButton.toString());
			logger.info("Clicked on the Chat Ring event " + ChatRingEventButton.toString());
		}
		else {
			log.info("Chat Ring event is not present" + ChatRingEventButton.toString());
			logger.info("Chat Ring event is not present" + ChatRingEventButton.toString());
		}	
	}
	
	public void verifyChatAcceptEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, ChatAcceptEventButton);
		if(commonActions.isElementPresent(ChatAcceptEventButton)){
			log.info("Chat Accept Event is present " + ChatAcceptEventButton.toString());
			logger.info("Chat Accept Event is present " + ChatAcceptEventButton.toString());
			commonActions.click(ChatAcceptEventButton);
			log.info("Clicked on the Chat Accept Event " + ChatAcceptEventButton.toString());
			logger.info("Clicked on the Chat Accept Event " + ChatAcceptEventButton.toString());
		}
		else {
			log.info("Chat Accept event is not present" + ChatAcceptEventButton.toString());
			logger.info("Chat Accept event is not present" + ChatAcceptEventButton.toString());
		}	
	}
	
	public void verifyChatRejectEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, ChatRejectEventButton);
		if(commonActions.isElementPresent(ChatRejectEventButton)){
			log.info("Chat Reject Event is present " + ChatRejectEventButton.toString());
			logger.info("Chat Reject Event is present " + ChatRejectEventButton.toString());
			commonActions.click(ChatRejectEventButton);
			log.info("Clicked on the Chat Reject Event " + ChatRejectEventButton.toString());
			logger.info("Clicked on the Chat Reject Event " + ChatRejectEventButton.toString());
		}
		else {
			log.info("Chat Reject event is not present" + ChatRejectEventButton.toString());
			logger.info("Chat Reject event is not present" + ChatRejectEventButton.toString());
		}	
	}
	
	public void verifyOnChatEndEvent() {
		commonActions.waitUntilElementIsVisible(driver, 60, ChatEndEventButton);
		if(commonActions.isElementPresent(ChatEndEventButton)){
			log.info("On Chat End Event is present " + ChatEndEventButton.toString());
			logger.info("On Chat End Event is present " + ChatEndEventButton.toString());
			commonActions.click(ChatEndEventButton);
			log.info("Clicked on the On Chat End Event " + ChatEndEventButton.toString());
			logger.info("Clicked on the On Chat End Event " + ChatEndEventButton.toString());
		}
		else {
			log.info("On Chat End event is not present" + ChatEndEventButton.toString());
			logger.info("On Chat End event is not present" + ChatEndEventButton.toString());
		}	
	}
	
	public  void verifyAllEvents() {
		this.verifyOnRingEvent();
		this.verifyOnAnswerEvent();
		this.verifyOnHoldEvent();
		this.verifyOnEndEvent();
		this.verifyChatRingEvent();
		this.verifyChatAcceptEvent();
		this.verifyChatRejectEvent();
		this.verifyOnChatEndEvent();
	}
	
	public void  AddCustomEventOnIncidentClose() {
		Robot select;
		commonActions.waitFor(2000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddNewCustomEventButton);
		if(commonActions.isElementPresent(AddNewCustomEventButton)) {
			commonActions.click(AddNewCustomEventButton);
			log.info("Clicked on add new custom event butttn" + AddNewCustomEventButton.toString());
			logger.info("Clicked on add new custom event butttn" + AddNewCustomEventButton.toString());
			commonActions.waitUntilElementIsVisible(driver, 60, CustomEventNameTextBox);
			commonActions.click(CustomEventNameTextBox);
			log.info("Clicked on add custom event text box " + CustomEventNameTextBox.toString());
			logger.info("Clicked on add custom event text box " + CustomEventNameTextBox.toString());
			
			try {
				select = new Robot();
				select.keyPress(KeyEvent.VK_DOWN);
				select.keyPress(KeyEvent.VK_ENTER);
			commonActions.waitFor(1000);	
			log.info("Selected On Incident Close event from dropdown");
			logger.info("Selected On Incident Close event from dropdown");
			commonActions.waitUntilElementIsVisible(driver, 60, CustomEventDescriptionTextBox);
			String text = commonActions.getText(CustomEventDescriptionTextBox);
				commonActions.verifyAssertTrue(text!= null, 
						"Default description is provided for the On Incident Close event", 
						"Default description is not provided for the On Incident Close event");
			commonActions.waitUntilElementIsVisible(driver, 60, CustomEventSaveButton);
			commonActions.click(CustomEventSaveButton);
			} catch (AWTException e) {
				System.out.println("Exception occurred when selecting the custom event" + e);
			}
			
		}else {
			log.info("Add Custom Event Button is not present on the popflow home page" + AddNewCustomEventButton.toString());
			logger.info("Add Custom Event Button is not present on the popflow home page" + AddNewCustomEventButton.toString());
		}
	}
	
	public void deleteCustomEventOnincidentClose() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCustomEventOnIncidentClose);
		if(commonActions.isElementPresent(AddedCustomEventOnIncidentClose));{
			log.info("On Incident event close event is present " + AddedCustomEventOnIncidentClose);
			commonActions.scrollDownToElementDisplayed(js, CustomEventDeleteButton, driver);
			commonActions.waitUntilElementIsVisible(driver, 60, CustomEventDeleteButton);
			commonActions.clickbymouseHover(CustomEventDeleteButton);
			commonActions.waitUntilElementIsVisible(driver, 60, CustomEventDeleteButtonOnPopup);
			commonActions.click(CustomEventDeleteButtonOnPopup);
		}
		
	}
	
	public void verifyPopflowVersion() {
		commonActions.waitUntilElementTobeClickable(driver, 60, InfoButton);
		if(commonActions.isElementPresent(InfoButton)) {
			log.info("Info Button is present on the popflow studio " + InfoButton);
			logger.info("Info Button is present on the popflow studio " + InfoButton);
			commonActions.click(InfoButton);
			log.info("Clicked on the info button on the popflow studio" + InfoButton.toString());
			logger.info("Clicked on the info button on the popflow studio" + InfoButton.toString());
			log.info("Popflow Version Is * * * " + commonActions.getText(PopflowVersion) + " * * *");
			logger.info("Popflow Version Is * * * " + commonActions.getText(PopflowVersion) + " * * *");
		}else {
			log.info("Info Button is not present on the popflow studio " + InfoButton.toString());
			logger.info("Info Button is not present on the popflow studio " + InfoButton.toString());
		}
	}
	
	public void verifyInstanceNavigation() {
		commonActions.waitUntilElementIsVisible(driver, 60, InstanceButton);
		if(commonActions.isElementPresent(InstanceButton)) {
			log.info("Instance button is present on the popflow studio " + InstanceButton);
			logger.info("Instance button is present on the popflow studio " + InstanceButton);
			commonActions.click(InstanceButton);
			log.info("Clicked on the instance button " + InstanceButton);
			logger.info("Clicked on the instance button " + InstanceButton);
			commonActions.waitUntilElementIsVisible(driver, 60, DesignButtonInstance);
			commonActions.click(DesignButtonInstance);
			log.info("Clicked on the CRM instance design button " + DesignButtonInstance.toString());
			logger.info("Clicked on the CRM instance design button " + DesignButtonInstance.toString());
			commonActions.waitUntilElementIsVisible(driver, 60, InstanceButton);
			log.info("Instance button displayed on the popflow studio " + InstanceButton);
			logger.info("Instance button displayed on the popflow studio " + InstanceButton);	
		}else {
			log.info("Instance button is not present on the popflow studio " + InstanceButton);
			logger.info("Instance button is not present on the popflow studio " + InstanceButton);
		}
		
	}
	
	
	//This method is created for temporary delete of the created workflows
	public void deleteCreatedWorkflow() {
		commonActions.waitUntilElementIsVisible(driver, 60, PopflowHomePageButton);
		if(commonActions.isElementPresent(PopflowHomePageButton)) {
			log.info("Instance button is present on the popflow studio " + InstanceButton);
			logger.info("Instance button is present on the popflow studio " + InstanceButton);
			commonActions.click(PopflowHomePageButton);
			log.info("Clicked on the instance button " + InstanceButton);
			logger.info("Clicked on the instance button " + InstanceButton);
			commonActions.waitUntilElementIsVisible(driver, 60, InstanceButton);
			this.deleteWorkflow();
			commonActions.waitFor(2000);
		}else {
			log.info("Instance button is not present on the popflow studio " + InstanceButton);
			logger.info("Instance button is not present on the popflow studio " + InstanceButton);
		}
		
	}
		
	public boolean DeleteWorkFlowFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, LinkeAccountButton);
	if (commonActions.isElementPresent(LinkeAccountButton)) {
		return true;
	} else {
		log.info("CRM Instance Lable is not present: " + LinkeAccountButton.toString());
		logger.info("Expand-collapse on app manager is not present: " + LinkeAccountButton.toString());
		return false;
		}
	}
	
	public boolean CRMLoginFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, LinkeAccountButton);
		if(commonActions.getText(LinkeAccountButton).equalsIgnoreCase("CRM linked account as - anupavaya"))
		{
			return true;
		}else {
			log.info("User is not able to link the account" + LinkeAccountButton.toString());
			logger.info("User is not able to link the account" + LinkeAccountButton.toString());
			return false;
		}
	
	}
	
	public boolean AddWorkflowFlag() {
	if (commonActions.isElementPresent(AddNewWorkFlowSaveButton)) {
		return false;
	} else {
		log.info("User is able to add the new workflow: " + AddNewWorkflowButton.toString());
		logger.info("User is unable to add the new workflow: " + AddNewWorkflowButton.toString());
		return true;
		}
	}
	
	public boolean verifyTelephonyEventsFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, OnRingEventButton);
		if (commonActions.isElementPresent(OnRingEventButton)
				&& commonActions.isElementPresent(OnAnswerButton)
				&& commonActions.isElementPresent(OnHoldEventButton)
				&& commonActions.isElementPresent(OnEndEventButton)) {
			
		return true;
	}else {
		return false;
		}
	}
	
	public boolean verifyChatEventsFlag() {
			commonActions.waitUntilElementIsVisible(driver, 60, ChatRingEventButton);
			if (commonActions.isElementPresent(ChatRingEventButton)
					&& commonActions.isElementPresent(ChatAcceptEventButton)
					&& commonActions.isElementPresent(ChatRejectEventButton)
					&& commonActions.isElementPresent(ChatEndEventButton)) {
				
			return true;
		}else {
			return false;
		}
	}		
			
	public boolean verifyVersionFlag() {
		if(commonActions.isElementPresent(PopflowVersion)) {
			return true;
		}
		else {
			return false;
		}
	}
		
	public boolean onIncidentCloseFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCustomEventOnIncidentClose);
		if(commonActions.isElementPresent(AddedCustomEventOnIncidentClose)) {
			return true;
		}else {
			return false;
		}
			
	}
	
	public boolean ImportWorkflowFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, ImportWorkflowTag);
		if(commonActions.isElementPresent(ImportWorkflowTag))
		{
			return true;
		}else {
			return false;
		}
	}
	
	public boolean ImportNewWorkflowFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, ImportNewWorkflowTag);
		if(commonActions.isElementPresent(ImportNewWorkflowTag))
		{
			return true;
		}else {
			return false;
		}
	}
	
	public boolean waitTillLoadPage() {
		if(commonActions.waitUntilElementIsVisible(driver, 60, AddNewWorkflowButton) != null)
		return true;
		else
			return false;		
	}
	
	
	
		
}
