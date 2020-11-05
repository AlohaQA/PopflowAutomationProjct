package com.popflow.Automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.popflow.Automation.base.TestBase;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;
import com.popflow.Automation.pageObjects.AppManagerHomePage;
import com.popflow.Automation.pageObjects.AppManagerLoginPage;
import com.popflow.Automation.pageObjects.CreateWorkspaceActivityPage;
import com.popflow.Automation.pageObjects.OSCLoginPage;
import com.popflow.Automation.pageObjects.OpenWorkspaceActivityPage;
import com.popflow.Automation.pageObjects.PopflowHomePage;


public class OpenWorkspaceActivityTest extends TestBase{
	
	private CommonActions commonActions;
	private AppManagerLoginPage LoginPage;
	private AppManagerHomePage AMHomePage;
	private PopflowHomePage PFHomePage;
	private OpenWorkspaceActivityPage OpenWorkspace;
	private OSCLoginPage OSCLogin;
	
	
	Logger log = LoggerHelper.getLogger(PopFlowHomePageTest.class);
	
	public OpenWorkspaceActivityTest() {
		super();
	}
	
	public void AppManagerLoginAndCreateaWorkflow(){
		commonActions = new CommonActions(driver,logger);
		LoginPage = new AppManagerLoginPage(driver,logger);
		AMHomePage = LoginPage.enterLoginDataToAppManager(prop.getProperty("email"), prop.getProperty("password"));
		commonActions.verifyAssertTrue(LoginPage.getExpandButtonFlag(),
				"User is login successfully to App Manager", "User is not login successfully to App Manager");
		AMHomePage.navigateToCloudopflow();
		AMHomePage.switchToPopflowIFrmae();
		System.out.println("Switched to frame");
		commonActions.verifyAssertTrue(AMHomePage.CRMInstanceFlag(),
				"Popflow CRM Instance page displayed", 
				"Popflow CRM Instance page not displayed");
		PFHomePage = AMHomePage.clickOnDesignButton();
		OpenWorkspace = PFHomePage.addNewWorkFlowForOpenWorkspace(prop.getProperty("OpenWorkspaceString"));
	}
	
	@Test
	public void verifyAddingOpenWorkspaceActivity() {
		logger = extent.createTest("Verify user is able to add open workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.AddOpenWorkspaceActitiy(prop.getProperty("OpenWorkspaceString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to add Open Workspace activity", 
				"User is not able to add the Open Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyEditActivity() {
		logger = extent.createTest("Verify user is able to rename the open workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.renameActivity(prop.getProperty("OpenWorkspaceString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to rename the Open Workspace activity", 
				"User is not able to rename the Open Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyDeleteActivity() {
		logger = extent.createTest("Verify user is able to delete the open workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.deleteActivity(prop.getProperty("OpenWorkspaceString"));
		commonActions.verifyAssertTrue(OpenWorkspace.DeleteWorkspaceFlag(), 
				"User is able to delete the Open Workspace activity", 
				"User is not able to delete the Open Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyPinActivity() {
		logger = extent.createTest("Verify user is able to pin the open workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.pinActivity(prop.getProperty("OpenWorkspaceString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to pin the Open Workspace activity", 
				"User is not able to pin the Open Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyCopyActivity() {
		logger = extent.createTest("Verify user is able to copy the create workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.copyPasteActivity(prop.getProperty("OpenWorkspaceString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to copy the Open Workspace activity", 
				"User is not able to copy the Open Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOpenContactActivity() {
		logger = extent.createTest("Verify Create Contact activity");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.verifyOpenContact(prop.getProperty("OpenWorkspaceString"));
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOpenIncidentActivity() {
		logger = extent.createTest("Verify Open Incident activity");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.verifyOpenIncident(prop.getProperty("OpenWorkspaceString"));
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOpenTaskActivity() {
		logger = extent.createTest("Verify that user is able to open Task using open workspace activity ");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.verifyOpenTask(prop.getProperty("OpenWorkspaceString"));
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOpenOrganizationActivity() {
		logger = extent.createTest("Verify that user is able to open Organization using open workspace activity ");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.verifyOpenOrganisation(prop.getProperty("OpenWorkspaceString"));
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnOpenEvent() {
		logger = extent.createTest("Verify user is able to execute activiy on the On Open event ");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.onOpenEvent(prop.getProperty("OpenWorkspaceString"), 
									prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to execute the activity on the On Open Event ", 
				"Unable to execute the activity on the On Open Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnRecordSaveEvent() {
		logger = extent.createTest("Verify open contact activity with On Record Save event ");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.recordSaveEvent(prop.getProperty("OpenWorkspaceString"), 
										prop.getProperty("OnRecordSaveEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to execute the On Record Save Event ", 
				"Unable to execute the On Record Save Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnRecordCloseEvent() {
		logger = extent.createTest("Verify Open contact activity with On Record Close event ");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.recordCloseEvent(prop.getProperty("OpenWorkspaceString"), 
										prop.getProperty("OnRecordCloseEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to execute the On Record Close Event ", 
				"Unable to execcute the On Record Close Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnDataLoadedEvent() {
		logger = extent.createTest("Verify Open contact activity with On Data Loaded event ");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.ondataLoadedEvent(prop.getProperty("OpenWorkspaceString"), 
										prop.getProperty("OnDataLoadedEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to execute the On Data Loaded Event ", 
				"Unable to execcute the On Data Loaded Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnEditorLoadedEvent() {
		logger = extent.createTest("Verify Open contact activity with On Data Loaded event ");
		this.AppManagerLoginAndCreateaWorkflow();
		OpenWorkspace.onEditorLoadedEvent(prop.getProperty("OpenWorkspaceString"), 
										prop.getProperty("OnEditorLoadedEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(OpenWorkspace.OpenWorkspaceFlag(), 
				"User is able to execute the On Editor Loaded Event ", 
				"Unable to execcute the On Data Editor Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
		
}
