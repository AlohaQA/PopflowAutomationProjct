package com.popflow.Automation.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openxml4j.samples.opc.CreateWordprocessingMLDocument;

import com.aventstack.extentreports.ExtentTest;
import com.popflow.Automation.base.TestBase;
import com.popflow.Automation.helperClass.BrowserHelper;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;

public class CreateWorkspaceActivityPage extends TestBase{

	private WebDriver driver;
	private CommonActions commonActions;
	private BrowserHelper browserHelper;
	private ExtentTest logger;
	private PopflowHomePage PFHomePage;
	private OSCLoginPage OSCLogin;
	
	Logger log = LoggerHelper.getLogger(PopflowHomePage.class);
	
	@FindBy(xpath = "//i[@class='material-icons clickable'][contains(text(),'add')]")
	WebElement AddNewWorkflowButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/div[1]/div/div/div[2]/input")
	WebElement AddNewWorkFlowTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/div[1]/div/div/div[3]/button[2]")
	WebElement AddNewWorkFlowSaveButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflows/section/div[2]/ul/li[1]/div/h6")
	WebElement CreateWorkspaceWorkflow;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/instance/div/instance-workflow/section/div/div/div[1]/div/div[2]/div/a")
	WebElement WorkflowDesignButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/button")
	WebElement NextStepButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/mapper/ul/li/div/div/div")
	WebElement InitialActivityButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activities-sidebar/div[2]/div[1]/div/img")
	WebElement CloseButtonFromActivityList;
	
	@FindBy(xpath = "//*[@id='filter']")
	WebElement SearchActivityTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activities-sidebar/div[3]/div/div/ul/li")
	WebElement CreateWorkspaceSearchResult;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/mapper/ul/li/div/div[2]/flow-chart/div[1]/div")
	WebElement AddedCreateWorkspaceActivity;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/i")
	WebElement CreateWorkspaceDesignerCloseButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[1]/div/div/sc-ws-entity-autocomplete/div/div[1]/input")
	WebElement EntitiyTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[2]/div[2]/div[1]/sc-ws-field-autocomplete/div/div[1]/input")
	WebElement PropertyTextBox2;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[2]/div[3]/div[1]/sc-ws-field-autocomplete/div/div[1]/input")
	WebElement PropertyTextBox3;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[2]/div/div[3]/div/syntax-autocomplete/div/div/input")
	WebElement EntityValueTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[2]/div[2]/div[3]/div/syntax-autocomplete/div/div/input")
	WebElement EntityValueTextBox2;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[2]/div[3]/div[3]/div/syntax-autocomplete/div/div/input")
	WebElement EntityValueTextBox3;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[1]/div/div/sc-ws-entity-autocomplete/div/div[2]/ul/li[1]")
	WebElement ContactEntitiy;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[1]/button/i")
	WebElement AddEntityFieldButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[2]/div/div[1]/sc-ws-field-autocomplete/div/div[1]/input")
	WebElement PropertyTextBox;
	
	@FindBy(xpath = "//*[@class='tab-text']")
	WebElement OSCFirstName;
	
	@FindBy(how = How.ID, using = "username")
	private WebElement oscLoginPageUserNameField;

	@FindBy(how = How.ID, using = "password")
	private WebElement oscLoginPagePasswordField;

	@FindBy(how = How.XPATH, using = "//*[@id='loginbutton']")
	private WebElement oscLoginPageLoginBtn;
	
	@FindBy(xpath="//iframe[@class='stage-iframe']")
	WebElement PopFlowFrame;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/ol/ul/li[1]/a/i")
	WebElement runPopflowButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/ol/ul/li[1]/a/div/div[2]/testing/button")
	WebElement sendTestButton;
	
	@FindBy(xpath = "//*[@id=\"ws-toolbar-button-content-div\"]")
	WebElement SaveWorkSpaceButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/mapper/ul/li/div/div[2]/flow-chart/div[1]/div/div/div/div/span/i")
	WebElement CreateWorkspaceActivityEditButton;
	
	//@FindBy
	
	
	public CreateWorkspaceActivityPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	commonActions = new CommonActions(driver,logger);
	OSCLogin = new OSCLoginPage(driver, logger);
	PageFactory.initElements(driver, this);
	}
	
	public void AddCreateWorkspaceActitiy(String CreateWorkspaceString) {
		commonActions.waitFor(2000);
		commonActions.click(CreateWorkspaceWorkflow);
		commonActions.waitUntilElementIsVisible(driver, 60, WorkflowDesignButton);
		commonActions.click(WorkflowDesignButton);
		commonActions.waitUntilElementIsVisible(driver, 60, InitialActivityButton);
		commonActions.click(InitialActivityButton);
		commonActions.waitUntilElementIsVisible(driver, 60, CloseButtonFromActivityList);
		commonActions.enterData(SearchActivityTextBox, CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(CreateWorkspaceSearchResult), 
				"User able to search the create workspace activity in the activity list", 
				"User is not able  to serach the create worksace activity in the activity list");
		commonActions.click(CreateWorkspaceSearchResult);
		commonActions.waitFor(1000);
	}
	
	public void verifyCreateContact(String CreateWorkspaceString) {
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		runTest();
		OSCLogin.switchToOSCWindow();
		commonActions.waitUntilElementIsVisible(driver, 60, OSCFirstName);
		String text = commonActions.getText(OSCFirstName);
		log.info("Text is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("First Last"), 
				"Contact is created using create workspace activity", 
				"Unable to create contact using create workspace activity");
	}
	
	public void renameCreateWorkspaceActivity() {
		
	}
	
	public void selectContactWorkspace(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		commonActions.click(AddedCreateWorkspaceActivity);
		log.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		logger.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		commonActions.waitUntilElementIsVisible(driver, 60, EntitiyTextBox);
		commonActions.click(EntitiyTextBox);
		log.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		logger.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		commonActions.waitUntilElementIsVisible(driver, 60, ContactEntitiy);
		commonActions.click(ContactEntitiy);
		log.info("Contact entity is selected form the drop down " + EntitiyTextBox);
		logger.info("Contact entity is selected form the drop down" + EntitiyTextBox);
	}
	
	public void switchToPopflowIFrmae() {
		driver.switchTo().frame(PopFlowFrame);
		log.info("Switched to iframe"+PopFlowFrame.toString());
		logger.info("Switched to iframe"+PopFlowFrame.toString());
	}
	
	public void addContactEntity() {
		commonActions.waitUntilElementIsVisible(driver, 60, AddEntityFieldButton);
		commonActions.click(AddEntityFieldButton);
		commonActions.waitUntilElementIsVisible(driver, 60, PropertyTextBox);
		commonActions.click(PropertyTextBox);
		
		commonActions.enterData(PropertyTextBox, "Name.First");
		commonActions.waitUntilElementIsVisible(driver, 60, EntityValueTextBox);
		commonActions.enterData(EntityValueTextBox, "First");
		commonActions.waitFor(1000);
		
		commonActions.click(AddEntityFieldButton);
		commonActions.waitUntilElementIsVisible(driver, 60, PropertyTextBox2);
		commonActions.click(PropertyTextBox2);
		commonActions.enterData(PropertyTextBox2, "Name.Last");
		commonActions.waitUntilElementIsVisible(driver, 60, EntityValueTextBox2);
		commonActions.enterData(EntityValueTextBox2, "Last");
		
		commonActions.click(AddEntityFieldButton);
		commonActions.waitUntilElementIsVisible(driver, 60, PropertyTextBox3);
		commonActions.click(PropertyTextBox3);
		commonActions.enterData(PropertyTextBox3, "Email.Addr");
		commonActions.waitUntilElementIsVisible(driver, 60, EntityValueTextBox3);
		commonActions.enterData(EntityValueTextBox3, "testpopflow@om.com");
		
		commonActions.verifyAssertTrue(EntityValueTextBox3 != null, 
				"User is able to add multiple entity fields for the contact workspace", 
				"Unable to add multiple entitiy fields for the contact workspace");
		commonActions.waitFor(2000);
	}
	
	public void runTest() {
		commonActions.waitUntilElementIsVisible(driver, 60, runPopflowButton);
		commonActions.click(runPopflowButton);
		commonActions.waitFor(1000);
		commonActions.click(sendTestButton);
		commonActions.waitFor(2000);
	}
	
	public boolean CreateWorkspaceFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		if(commonActions.isElementPresent(AddedCreateWorkspaceActivity)) {
			log.info("Create Workspace activity displayed on the worksace " + AddedCreateWorkspaceActivity);
			logger.info("Create Workspace activity displayed on the worksace " + AddedCreateWorkspaceActivity);
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
}