package com.popflow.Automation.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.util.SuppressForbidden;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openxml4j.samples.opc.CreateWordprocessingMLDocument;

import com.aventstack.extentreports.ExtentTest;
import com.popflow.Automation.base.TestBase;
import com.popflow.Automation.helperClass.BrowserHelper;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;
import com.popflow.Automation.util.RandomTextGeneretorUtility;

public class CreateWorkspaceActivityPage extends TestBase{

	private WebDriver driver;
	private CommonActions commonActions;
	private BrowserHelper browserHelper;
	private ExtentTest logger;
	private PopflowHomePage PFHomePage;
	private CommonCases CommonCases;
	private OSCLoginPage OSCLogin;
	private DynamicUIActivityPage DynamicUI;
	private RandomTextGeneretorUtility Random;
	
	
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
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/mapper/ul/li/div/div[2]/flow-chart/div[2]/mapper[2]/ul/li/div/div/div")
	WebElement OnEventButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/mapper/ul/li/div/div[2]/flow-chart/div[2]/mapper/ul/li/div/div/div")
	WebElement OnOpenEventButton;
	
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
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[1]/div/div/sc-ws-entity-autocomplete/div/div[2]/ul/li[2]")
	WebElement IncidentEntity;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[1]/div/div/sc-ws-entity-autocomplete/div/div[2]/ul/li[4]")
	WebElement TaskEntity;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[1]/div/div/sc-ws-entity-autocomplete/div/div[2]/ul/li[3]")
	WebElement OrgEntity;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[1]/button/i")
	WebElement AddEntityFieldButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[3]/div[1]/workspace-events-v1/form/div[1]/button/i")
	WebElement AddEventButton;
	
	@FindBy(xpath = "//select[@class='form-control selectpicker ng-untouched ng-pristine ng-invalid']")
	WebElement SelectEventButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/activitie-designer/div[2]/div/div/div/div/create-workspace-v1/div/div/div[2]/form/div[2]/div/div[2]/div/div[1]/sc-ws-field-autocomplete/div/div[1]/input")
	WebElement PropertyTextBox;
	
	@FindBy(xpath = "//*[@class='tab-text']")
	WebElement OSCFirstName;
	
	@FindBy(xpath = "//div[@class='oj-inputtext oj-form-control oj-component oj-required']")
	WebElement IncidentSubject;
	
	@FindBy(xpath = "//span[@class='tab-text']")
	WebElement TaskLabel;
	
	@FindBy(xpath = "//span[@class='tab-text']")
	WebElement OrgLabel;
	
	@FindBy(xpath = "//input[@automationid='bannerFlagAutomationId']")
	WebElement BannerText;
	
	@FindBy(xpath = "//i[@class='fa fa-times fa-fw oj-fwk-icon']")
	WebElement IncidentCloseButton;
		
	@FindBy(how = How.ID, using = "username")
	WebElement oscLoginPageUserNameField;

	@FindBy(how = How.ID, using = "password")
	WebElement oscLoginPagePasswordField;

	@FindBy(how = How.XPATH, using = "//*[@id='loginbutton']")
	WebElement oscLoginPageLoginBtn;
	
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
	
	@FindBy(xpath = "//*[@class='material-icons clickable']")
	WebElement RenameWorkflowButton;
	
	@FindBy(xpath = "//input[@class='form-control title-edit ng-untouched ng-pristine ng-valid' and @type='text']")
	WebElement RenameWorkflowTextbox;
	
	@FindBy(xpath = "//i[contains(text(),'settings')]")
	WebElement SettingsButton;
	
	@FindBy(xpath = "//a[contains(text(),'Pin')]")
	WebElement PinOption;
	
	@FindBy(xpath = "//a[contains(text(),'Delete')]")
	WebElement DeleteOption;
	
	@FindBy(xpath = "//a[contains(text(),'Copy')]")
	WebElement CopyOption;
	
	@FindBy(xpath = "//button[contains(text(),'Delete')]")
	WebElement DeleteButtonOnPopup;
	
	@FindBy(xpath = "//a[contains(text(),'Paste Create Contact')]")
	WebElement Pasteoption;
	
	@FindBy(xpath = "//div[contains(text(), ' On Open ')]")
	WebElement OnOpenEvent;
	
	@FindBy(xpath = "//i[contains(text(),'close')]")
	WebElement ClosePinnedActivityButton;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/mapper/ul/li/div/div[2]/flow-chart/div[2]/mapper[2]/ul/li/div/div[2]/flow-chart/div[1]/div/div/div/div/span/div")
	WebElement OnEventActivity;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/div[2]/div[2]/div[2]/mapper/ul/li/div/div[2]/flow-chart/div[2]/mapper/ul/li/div/div[2]/flow-chart/div[1]/div/div/div")
	WebElement OnOpenEventActivity;
	
	@FindBy(xpath = "//span[@id='ExtensibilityModalWindowViewModeldialog-title']")
	WebElement DynamicUITitle;
	
	@FindBy(xpath = "//button[@class='ws-toolbar-button Save']")
	WebElement SaveContactButtonFromOSC;
	
	@FindBy(xpath = "//i[@class='fa fa-times fa-fw oj-fwk-icon']")
	WebElement CloseContactWorksaceButtonFromOSC;
	
	@FindBy(xpath = "//button[@class='ws-toolbar-button Refresh']")
	WebElement RefershButtonFromOSC;
	
	@FindBy(xpath = "//button[@title='Close']")
	WebElement CloseButtonOnDynamicUIPopup;
	
	@FindBy(xpath = "//*[contains(text(), 'Publish')]")
	WebElement publishButton;
	
	@FindBy(xpath = "//*[contains(text(), 'Un-Publish')]")
	WebElement UnPublishButton;
	
	@FindBy(xpath = "//*[contains(text(), 'Re-Publish')]")
	WebElement RepublishButton;
	
	@FindBy(xpath = "//button[@class='btn btn-warning ng-star-inserted']")
	WebElement RepublishButtonOnPopup;
	
	@FindBy(xpath = "//button[@class='btn btn-danger ng-star-inserted']")
	WebElement UnPublishButtonOnPopup;
	
	@FindBy(xpath = "//input[@class='ng2-tag-input__text-input ng-untouched ng-pristine ng-valid']")
	WebElement EnterProfileTextBox;
	
	@FindBy(xpath = "/html/body/app-root/div[2]/workflow/publish-confirm/div/div/div/div[2]/div/tag-input/tag-input-dropdown/ng2-dropdown/div/ng2-dropdown-menu/div[1]/div/ng2-menu-item/div/span")
	WebElement QAProfileFromDropDown;
	
	@FindBy(xpath = "//button[@class='btn btn-success ng-star-inserted']")
	WebElement PublishButtonFromPopUp;
	
	@FindBy(xpath = "//*[contains(text(), 'Published')]")
	WebElement PublishStatus;
	
	public CreateWorkspaceActivityPage(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	commonActions = new CommonActions(driver,logger);
	OSCLogin = new OSCLoginPage(driver, logger);
	DynamicUI = new DynamicUIActivityPage(driver, logger); 
	Random = new RandomTextGeneretorUtility();
	CommonCases = new CommonCases(driver, logger);
	PageFactory.initElements(driver, this);
	}
	
	public void AddCreateWorkspaceActitiy(String CreateWorkspaceString) {
		commonActions.waitFor(2000);
		commonActions.click(CreateWorkspaceWorkflow);
		log.info("Clicked on the create workspace workflow button " + CreateWorkspaceWorkflow);
		logger.info("Clicked on the create workspace workflow button " + CreateWorkspaceWorkflow);
		commonActions.waitUntilElementIsVisible(driver, 60, WorkflowDesignButton);
		commonActions.click(WorkflowDesignButton);
		log.info("Clicked on the workflow design button " + WorkflowDesignButton);
		logger.info("Clicked on the workflow design button " + WorkflowDesignButton);
		commonActions.waitUntilElementIsVisible(driver, 60, InitialActivityButton);
		if(commonActions.isElementPresent(InitialActivityButton)) {
		commonActions.click(InitialActivityButton);
		commonActions.waitUntilElementIsVisible(driver, 60, CloseButtonFromActivityList);
		commonActions.enterData(SearchActivityTextBox, CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(CreateWorkspaceSearchResult), 
				" User able to search the create workspace activity in the activity list", 
				" User is not able  to serach the create worksace activity in the activity list");
		commonActions.click(CreateWorkspaceSearchResult);
		log.info("Clicked on the create workspace activity from search " + CreateWorkspaceSearchResult);
		logger.info("Clicked on the create workspace activity from search " + CreateWorkspaceSearchResult);
		commonActions.waitFor(1000);
		}
		else {
			log.info("Unable to see the initial activity panel on the workspace ");
			logger.info("Unable to see the initial activity panel on the worksace");
		}
	}
	
	public void renameActivity(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		CommonCases.TestrenameActivity(" Rename");
	}	
	
	public void pinActivity(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		CommonCases.pinActivity(CreateWorkspaceString);
		}
	
	public void deleteActivity(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		CommonCases.deleteActivity(CreateWorkspaceString);
	}
	
	public void copyPasteActivity(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		CommonCases.copyPasteActivityTest(CreateWorkspaceString, OnOpenEvent);
	}
	
	public void verifyCreateContact(String CreateWorkspaceString) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		commonActions.waitUntilElementIsVisible(driver, 60, OSCFirstName);
		String text = commonActions.getText(OSCFirstName);
		log.info("Text is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("First Last"), 
				" Contact is created using create workspace activity", 
				" Unable to create contact using create workspace activity");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
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
		commonActions.waitFor(1000);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
	}
	
	public void selectIncidentWorkspace(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		commonActions.click(AddedCreateWorkspaceActivity);
		log.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		logger.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		commonActions.waitUntilElementIsVisible(driver, 60, EntitiyTextBox);
		commonActions.click(EntitiyTextBox);
		log.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		logger.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		commonActions.waitUntilElementIsVisible(driver, 60, IncidentEntity);
		commonActions.click(IncidentEntity);
		log.info("Incident entity is selected form the drop down " + IncidentEntity);
		logger.info("Incident entity is selected form the drop down" + IncidentEntity);
		commonActions.waitFor(1000);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
	}
	
	public void selectTasktWorkspace(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		commonActions.click(AddedCreateWorkspaceActivity);
		log.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		logger.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		commonActions.waitUntilElementIsVisible(driver, 60, EntitiyTextBox);
		commonActions.click(EntitiyTextBox);
		log.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		logger.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		commonActions.waitUntilElementIsVisible(driver, 60, TaskEntity);
		commonActions.click(TaskEntity);
		log.info("Task entity is selected form the drop down " + TaskEntity);
		logger.info("Task entity is selected form the drop down" + TaskEntity);
		commonActions.waitFor(1000);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
	}
	
	public void selectOrganizationWorkspace(String CreateWorkspaceString) {
		AddCreateWorkspaceActitiy(CreateWorkspaceString);
		commonActions.click(AddedCreateWorkspaceActivity);
		log.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		logger.info("Clicked on the added create worksace activity " + AddedCreateWorkspaceActivity);
		commonActions.waitUntilElementIsVisible(driver, 60, EntitiyTextBox);
		commonActions.click(EntitiyTextBox);
		log.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		logger.info("Clicked on the entitiy textbox " + EntitiyTextBox);
		commonActions.waitUntilElementIsVisible(driver, 60, OrgEntity);
		commonActions.click(OrgEntity);
		log.info("Organization entity is selected form the drop down " + OrgEntity);
		logger.info("Organization entity is selected form the drop down" + OrgEntity);
		commonActions.waitFor(1000);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
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
		log.info("Entered First Name in the property field ");
		logger.info("Entered First Name in the property field ");
		commonActions.waitFor(1000);
		
		commonActions.click(AddEntityFieldButton);
		commonActions.waitUntilElementIsVisible(driver, 60, PropertyTextBox2);
		commonActions.click(PropertyTextBox2);
		commonActions.enterData(PropertyTextBox2, "Name.Last");
		commonActions.waitUntilElementIsVisible(driver, 60, EntityValueTextBox2);
		commonActions.enterData(EntityValueTextBox2, "Last");
		log.info("Entered Last Name in the property field ");
		logger.info("Entered Last Name in the property field ");
		
		commonActions.click(AddEntityFieldButton);
		commonActions.waitUntilElementIsVisible(driver, 60, PropertyTextBox3);
		commonActions.click(PropertyTextBox3);
		commonActions.enterData(PropertyTextBox3, "Email.Addr");
		commonActions.waitUntilElementIsVisible(driver, 60, EntityValueTextBox3);
		String email = "test"+Random.randomAlphaString(3)+"@om.com";
		commonActions.enterData(EntityValueTextBox3, email);
		log.info("Entered email address in the property field :" + email);
		logger.info("Entered email address in the property field :" + email);
		commonActions.verifyAssertTrue(EntityValueTextBox3 != null, 
				" User is able to add multiple entity fields for the contact workspace", 
				" Unable to add multiple entitiy fields for the contact workspace");
		commonActions.waitFor(2000);
	}
	
	public void verifyCreateIncident(String CreateWorkspaceString) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		
		selectIncidentWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addIncidentEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		
		runTest();
		OSCLogin.switchToOSCWindow();
	/*	commonActions.waitUntilElementIsVisible(driver, 60, BannerText);
		String text = commonActions.getText(BannerText);
		log.info("Text is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("BannerText"), 
				"Incident is created using create workspace activity", 
				"Unable to create Incident using create workspace activity");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
	*/
		commonActions.waitUntilElementIsVisible(driver, 60, IncidentCloseButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(IncidentCloseButton), 
				" Incident is created using create workspace activity", 
				" Unable to create Incident using create workspace activity");
		
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
	}
	
	public void addIncidentEntity() {
		commonActions.waitUntilElementIsVisible(driver, 60, AddEntityFieldButton);
		commonActions.click(AddEntityFieldButton);
		commonActions.waitUntilElementIsVisible(driver, 60, PropertyTextBox);
		commonActions.click(PropertyTextBox);
		
		commonActions.enterData(PropertyTextBox, "Subject");
		commonActions.waitUntilElementIsVisible(driver, 60, EntityValueTextBox);
		commonActions.enterData(EntityValueTextBox, "Test");
		commonActions.waitFor(1000);
		
		commonActions.click(AddEntityFieldButton);
		commonActions.waitUntilElementIsVisible(driver, 60, PropertyTextBox2);
		commonActions.click(PropertyTextBox2);
		commonActions.enterData(PropertyTextBox2, "Banner.Txt");
		commonActions.waitUntilElementIsVisible(driver, 60, EntityValueTextBox2);
		commonActions.enterData(EntityValueTextBox2, "BannerText");
		
		commonActions.verifyAssertTrue(EntityValueTextBox3 != null, 
				" User is able to add multiple entity fields for the contact workspace", 
				" Unable to add multiple entitiy fields for the contact workspace");
		commonActions.waitFor(2000);
	}
	
	public void runTest() {
		CommonCases.runTest();
	}
	
	public void onOpenEvent(String CreateWorkspaceString, String DynamicUIString, String DynamicUiTitle) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, OnOpenEvent);
		commonActions.click(OnOpenEvent);
		log.info("Clicked on the On Open button from designer " + OnOpenEvent);
		logger.info("Clicked on the On Open button from designer " + OnOpenEvent);
		
		DynamicUI.SelectDynamicUIActivity(DynamicUIString);
		commonActions.waitUntilElementIsVisible(driver, 60, OnOpenEventActivity);
		commonActions.click(OnOpenEventActivity);
		log.info("Clicked on the activity added on the On Open event " + OnOpenEventActivity);
		logger.info("Clicked on the activity added on the On Open event " + OnOpenEventActivity);
		DynamicUI.EnterDetailsInDynamicUIActivity(DynamicUIString, DynamicUiTitle);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		
	if(commonActions.isElementPresent(CloseButtonOnDynamicUIPopup)) {
		
		commonActions.waitUntilElementIsVisible(driver, 60, CloseButtonOnDynamicUIPopup);
		commonActions.waitUntilElementIsVisible(driver, 60, DynamicUITitle);
		String text1 = commonActions.getText(DynamicUITitle);
		log.info("Text on the dynamic UI activity title is :" + text1);
		logger.info("Text on the dynamic UI activity title is :" + text1);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(CloseButtonOnDynamicUIPopup)&&text1.equalsIgnoreCase("DynamicUI Test"), 
				"On Open  Event is working" , 
				"On Open Event is not working"); 
		commonActions.click(CloseButtonOnDynamicUIPopup);
		commonActions.waitUntilElementIsVisible(driver, 60, OSCFirstName);
		String text = commonActions.getText(OSCFirstName);
		log.info("Text on the created contact is :" + text);
		logger.info("Text on the created contact is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("First Last"), 
				" Contact is created using create workspace activity", 
				" Unable to create contact using create workspace activity");
		
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae(); 
	}else {
		commonActions.fail("Unable to execute On Open Event");
		log.info("Unable to execute On Open Event");
		logger.fail("Unable to execute On Open Event");
		}
	}
	
	public void recordSaveEvent(String CreateWorkspaceString, String EventName, String DynamicUIString, String DynamicUiTitle) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, AddEventButton);
		commonActions.click(AddEventButton);
		commonActions.waitUntilElementIsVisible(driver, 60, SelectEventButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(SelectEventButton), 
				" Add Event Button is functional", 
				" Add Event Button is not fuctional");
		log.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		selectEvent(EventName);
		
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventButton);
		commonActions.click(OnEventButton);
		log.info("Clicked on the On Record Save button from designer " + OnEventButton);
		logger.info("Clicked on the On Record Save button from designer " + OnEventButton);
		
		DynamicUI.SelectDynamicUIActivity(DynamicUIString);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventActivity);
		commonActions.click(OnEventActivity);
		log.info("Clicked on the activity added on the On Record Save event  " + OnEventActivity);
		logger.info("Clicked on the On Record Save button from designer " + OnEventActivity);
		DynamicUI.EnterDetailsInDynamicUIActivity(DynamicUIString, DynamicUiTitle);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		commonActions.waitUntilElementIsVisible(driver, 60, OSCFirstName);
		String text = commonActions.getText(OSCFirstName);
		log.info("Text on the created contact is :" + text);
		logger.info("Text on the created contact is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("First Last"), 
				" Contact is created using create workspace activity", 
				" Unable to create contact using create workspace activity");
		
		commonActions.waitUntilElementIsVisible(driver, 60, SaveContactButtonFromOSC);
		commonActions.click(SaveContactButtonFromOSC);
		log.info("Clicked on the save button on the workspace in the OSC " + SaveContactButtonFromOSC);
		logger.info("Clicked on the save button on the workspace in the OSC " + SaveContactButtonFromOSC);
		commonActions.waitUntilElementIsVisible(driver, 60, DynamicUITitle);
		String text1 = commonActions.getText(DynamicUITitle);
		log.info("Text on the dynamic UI activity title is :" + text1);
		logger.info("Text on the dynamic UI activity title is :" + text1);
		commonActions.verifyAssertTrue(text1.equalsIgnoreCase("DynamicUI Test"), 
				 " On Record Save event is working", 
				 " On Record Save event is not working");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae(); 
	}
	
	public void recordCloseEvent(String CreateWorkspaceString, String EventName, String DynamicUIString, String DynamicUiTitle) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, AddEventButton);
		commonActions.click(AddEventButton);
		commonActions.waitUntilElementIsVisible(driver, 60, SelectEventButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(SelectEventButton), 
				" Add Event Button is functional", 
				" Add Event Button is not fuctional");
		log.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		selectEvent(EventName);
		
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventButton);
		commonActions.click(OnEventButton);
		log.info("Clicked on the On Record close button from designer " + OnEventButton);
		logger.info("Clicked on the On Record close button from designer " + OnEventButton);
		
		DynamicUI.SelectDynamicUIActivity(DynamicUIString);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventActivity);
		commonActions.click(OnEventActivity);
		log.info("Clicked on the activity added on the On Record Save event  " + OnEventActivity);
		logger.info("Clicked on the activity added on the On Record Save event " + OnEventActivity);
		DynamicUI.EnterDetailsInDynamicUIActivity(DynamicUIString, DynamicUiTitle);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		commonActions.waitUntilElementIsVisible(driver, 60, OSCFirstName);
		String text = commonActions.getText(OSCFirstName);
		log.info("Text on the created contact is :" + text);
		logger.info("Text on the created contact is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("First Last"), 
				" Contact is created using create workspace activity", 
				" Unable to create contact using create workspace activity");
		
		commonActions.waitUntilElementIsVisible(driver, 60, SaveContactButtonFromOSC);
		commonActions.click(SaveContactButtonFromOSC);
		log.info("Clicked on the save contact button on the workspace in the OSC " + SaveContactButtonFromOSC);
		logger.info("Clicked on the save contact button on the workspace in the OSC " + SaveContactButtonFromOSC);
		
		commonActions.waitUntilElementIsVisible(driver, 60, RefershButtonFromOSC);
		commonActions.waitFor(2000);
		commonActions.click(CloseContactWorksaceButtonFromOSC);
		log.info("Clicked on the close button on the workspace in the OSC " + CloseContactWorksaceButtonFromOSC);
		logger.info("Clicked on the close button on the workspace in the OSC " + CloseContactWorksaceButtonFromOSC);
		commonActions.waitUntilElementIsVisible(driver, 60, DynamicUITitle);
		String text1 = commonActions.getText(DynamicUITitle);
		log.info("Text on the dynamic UI activity title is :" + text1);
		logger.info("Text on the dynamic UI activity title is :" + text1);
		commonActions.verifyAssertTrue(text1.equalsIgnoreCase("DynamicUI Test"), 
				 " On Record Close event is working", 
				 " On Record Close event is not working");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae(); 
	}
	
	public void ondataLoadedEvent(String CreateWorkspaceString, String EventName, String DynamicUIString, String DynamicUiTitle) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, AddEventButton);
		commonActions.click(AddEventButton);
		commonActions.waitUntilElementIsVisible(driver, 60, SelectEventButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(SelectEventButton), 
				" Add Event Button is functional", 
				" Add Event Button is not fuctional");
		log.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		selectEvent(EventName);
		
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventButton);
		commonActions.click(OnEventButton);
		log.info("Clicked on the On Record close button from designer " + OnEventButton);
		logger.info("Clicked on the On Record close button from designer " + OnEventButton);
		
		DynamicUI.SelectDynamicUIActivity(DynamicUIString);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventActivity);
		commonActions.click(OnEventActivity);
		log.info("Clicked on the activity added on the On Record Save event  " + OnEventActivity);
		logger.info("Clicked on the activity added on the On Record Save event " + OnEventActivity);
		DynamicUI.EnterDetailsInDynamicUIActivity(DynamicUIString, DynamicUiTitle);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		commonActions.waitUntilElementIsVisible(driver, 60, CloseButtonOnDynamicUIPopup);
		commonActions.click(CloseButtonOnDynamicUIPopup);
		commonActions.waitUntilElementIsVisible(driver, 60, OSCFirstName);
		String text = commonActions.getText(OSCFirstName);
		log.info("Text on the created contact is :" + text);
		logger.info("Text on the created contact is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("First Last"), 
				" Contact is created using create workspace activity", 
				" Unable to create contact using create workspace activity");
		
		commonActions.waitUntilElementIsVisible(driver, 60, CloseContactWorksaceButtonFromOSC);
		commonActions.click(SaveContactButtonFromOSC);
		log.info("Clicked on the save button on the workspace in the OSC " + SaveContactButtonFromOSC);
		logger.info("Clicked on the save button on the workspace in the OSC " + SaveContactButtonFromOSC);
		commonActions.waitUntilElementIsVisible(driver, 60, DynamicUITitle);
		String text1 = commonActions.getText(DynamicUITitle);
		log.info("Text on the dynamic UI activity title is :" + text1);
		logger.info("Text on the dynamic UI activity title is :" + text1);
		commonActions.verifyAssertTrue(text1.equalsIgnoreCase("DynamicUI Test"), 
				 " On Data Loaded event is working", 
				 " On Data Loaded event is not working");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae(); 
	}
	
	public void onEditorLoadedEvent(String CreateWorkspaceString, String EventName, String DynamicUIString, String DynamicUiTitle) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
		
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, AddEventButton);
		commonActions.click(AddEventButton);
		commonActions.waitUntilElementIsVisible(driver, 60, SelectEventButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(SelectEventButton), 
				" Add Event Button is functional", 
				" Add Event Button is not fuctional");
		log.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the Add event button from designer " + CreateWorkspaceDesignerCloseButton);
		selectEvent(EventName);
		
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventButton);
		commonActions.click(OnEventButton);
		log.info("Clicked on the On Record close button from designer " + OnEventButton);
		logger.info("Clicked on the On Record close button from designer " + OnEventButton);
		
		DynamicUI.SelectDynamicUIActivity(DynamicUIString);
		commonActions.waitUntilElementIsVisible(driver, 60, OnEventActivity);
		commonActions.click(OnEventActivity);
		log.info("Clicked on the activity added on the On Record Save event  " + OnEventActivity);
		logger.info("Clicked on the activity added on the On Record Save event " + OnEventActivity);
		DynamicUI.EnterDetailsInDynamicUIActivity(DynamicUIString, DynamicUiTitle);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		
	if(commonActions.isElementPresent(CloseButtonOnDynamicUIPopup)) {
		
		commonActions.waitUntilElementIsVisible(driver, 60, CloseButtonOnDynamicUIPopup);
		commonActions.waitUntilElementIsVisible(driver, 60, DynamicUITitle);
		String text1 = commonActions.getText(DynamicUITitle);
		log.info("Text on the dynamic UI activity title is :" + text1);
		logger.info("Text on the dynamic UI activity title is :" + text1);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(CloseButtonOnDynamicUIPopup)&&text1.equalsIgnoreCase("DynamicUI Test"), 
				"On Editor Loaded  Event is working" , 
				"On Editor Loaded Event is not working"); 
		commonActions.click(CloseButtonOnDynamicUIPopup);
		commonActions.waitUntilElementIsVisible(driver, 60, OSCFirstName);
		String text = commonActions.getText(OSCFirstName);
		log.info("Text on the created contact is :" + text);
		logger.info("Text on the created contact is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("First Last"), 
				" Contact is created using create workspace activity", 
				" Unable to create contact using create workspace activity");
		
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae(); 
	}else {
		commonActions.fail("Unable to execute On Editor Loaded Event");
		log.info("Unable to execute On Editor Loaded Event");
		logger.fail("Unable to execute On Editor Loaded Event");
		}
	}
	
	public void publishWorkflow(String CreateWorkspaceString) {
		selectContactWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.click(AddedCreateWorkspaceActivity);
		addContactEntity();
		commonActions.waitUntilElementIsVisible(driver, 60, CreateWorkspaceDesignerCloseButton);
		commonActions.click(CreateWorkspaceDesignerCloseButton);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		commonActions.waitUntilElementIsVisible(driver, 6, publishButton);
		commonActions.click(publishButton);
		commonActions.waitUntilElementIsVisible(driver, 60, EnterProfileTextBox);
		commonActions.click(EnterProfileTextBox);
		commonActions.enterData(EnterProfileTextBox, "amitprofile");
		commonActions.waitUntilElementIsVisible(driver, 60, QAProfileFromDropDown);
		commonActions.click(QAProfileFromDropDown);
		commonActions.waitUntilElementIsVisible(driver, 60, PublishButtonFromPopUp);
		commonActions.click(PublishButtonFromPopUp);
		commonActions.waitUntilElementIsVisible(driver, 60, UnPublishButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(UnPublishButton), 
				"User is able to Publish the worklow", 
				"User is not able to publish the workflow");
	}
	
	public void unpublishWorkflow(String CreateWorkspaceString) {
		publishWorkflow(CreateWorkspaceString);
		commonActions.click(UnPublishButton);
		commonActions.waitUntilElementIsVisible(driver, 60, UnPublishButtonOnPopup);
		commonActions.click(UnPublishButtonOnPopup);
		commonActions.waitUntilElementIsVisible(driver, 60, RepublishButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(RepublishButton), 
				"User is able to Un-publish the worklow", 
				"User is not able to Un-publish the workflow");
		
	}
	
	public void republishWorkflow(String CreateWorkspaceString) {
		unpublishWorkflow(CreateWorkspaceString);
		commonActions.click(RepublishButton);
		commonActions.waitUntilElementIsVisible(driver, 60, RepublishButtonOnPopup);
		commonActions.click(RepublishButtonOnPopup);
		commonActions.waitUntilElementIsVisible(driver, 60, publishButton);
		commonActions.verifyAssertTrue(commonActions.isElementPresent(publishButton), 
				"User is able to Re-publish the worklow", 
				"User is not able to Re-publish the workflow");
		
	}
	
	public void verifyCreateTask(String CreateWorkspaceString) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();

		selectTasktWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		commonActions.waitUntilElementIsVisible(driver, 60, TaskLabel);
		String text = commonActions.getText(TaskLabel);
		log.info("Text is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("New Task"), 
				" Task is created using create workspace activity", 
				" Task to create contact using create workspace activity");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
	} 
	
	public void verifyCreateOrganisation(String CreateWorkspaceString) {
		OSCLogin.openOSCWindow(prop.getProperty("OSCURL"));
		OSCLogin.loginToOSC(prop.getProperty("crmUN"), prop.getProperty("crmPwd"));
		log.info("User is logged in to the OSC ");
		logger.info("User is logged in to the OSC ");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();

		selectOrganizationWorkspace(CreateWorkspaceString);
		commonActions.waitFor(1000);
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		log.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		logger.info("Clicked on the close button from designer " + CreateWorkspaceDesignerCloseButton);
		
		runTest();
		OSCLogin.switchToOSCWindow();
		commonActions.waitUntilElementIsVisible(driver, 60, OrgLabel);
		String text = commonActions.getText(OrgLabel);
		log.info("Text is :" + text);
		commonActions.verifyAssertTrue(text.equalsIgnoreCase("New Organization"), 
				" Organization is created using create workspace activity", 
				" Unable to create Organization using create workspace activity");
		OSCLogin.switchBackToPopflowWindow();
		switchToPopflowIFrmae();
	}
	
	public void selectEvent(String EventName) {
		
		Select EventDropDown = new Select(SelectEventButton);
		EventDropDown.selectByVisibleText(EventName);
		log.info("Selected event from drop down is : " + EventName);
		logger.info("Selected event from drop down is :" + EventName);
		commonActions.waitFor(2000);
	}
	
	public boolean CreateWorkspaceFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, AddedCreateWorkspaceActivity);
		if(commonActions.isElementPresent(AddedCreateWorkspaceActivity)) {
			log.info("Create Workspace activity displayed on the workspace " + AddedCreateWorkspaceActivity);
			logger.info("Create Workspace activity displayed on the workspace " + AddedCreateWorkspaceActivity);
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean DeleteWorkspaceFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, InitialActivityButton);
		if(commonActions.isElementPresent(InitialActivityButton)) {
			log.info("Initial activity button displayed on the workspace " + InitialActivityButton);
			logger.info("Initial activity button displayed on the workspace " + InitialActivityButton);
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean PublishWorkflowFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, UnPublishButton);
		if(commonActions.isElementPresent(UnPublishButton)) {
			log.info("Unpublish button is displayed " + UnPublishButton);
			logger.info("Unpublish button is displayed " + UnPublishButton);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean UnPublishWorkflowFlag() {
		commonActions.waitUntilElementIsVisible(driver, 60, RepublishButton);
		if(commonActions.isElementPresent(RepublishButton)) {
			log.info("Republish button is displayed " + UnPublishButton);
			logger.info("Republish button is displayed " + UnPublishButton);
			return true;
		}else {
			return false;
		}
	}
	
	
}
