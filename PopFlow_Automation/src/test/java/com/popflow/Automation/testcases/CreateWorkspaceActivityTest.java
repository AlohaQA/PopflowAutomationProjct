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
import com.popflow.Automation.pageObjects.PopflowHomePage;


public class CreateWorkspaceActivityTest extends TestBase{
	
	private CommonActions commonActions;
	private AppManagerLoginPage LoginPage;
	private AppManagerHomePage AMHomePage;
	private PopflowHomePage PFHomePage;
	private CreateWorkspaceActivityPage CreateWorkspace;
	private OSCLoginPage OSCLogin;
	
	
	Logger log = LoggerHelper.getLogger(PopFlowHomePageTest.class);
	
	public CreateWorkspaceActivityTest() {
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
		CreateWorkspace = PFHomePage.addNewWorkFlow(prop.getProperty("CreateWorkspaceString"));
	}
	
	@Test
	public void verifyAddingCreateWorkspaceActivity() {
		logger = extent.createTest("Verify user is able to add create workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.AddCreateWorkspaceActitiy(prop.getProperty("CreateWorkspaceString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to add Create Workspace activity", 
				"User is not able to add the Create Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyCreateContactActivity() {
		logger = extent.createTest("Verify Create Contact activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.verifyCreateContact(prop.getProperty("CreateWorkspaceString"));
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyCreateIncidentActivity() {
		logger = extent.createTest("Verify Create Incident activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.verifyCreateIncident(prop.getProperty("CreateWorkspaceString"));
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnRecordSaveEvent() {
		logger = extent.createTest("Verify Create contact activity with On Record Save event ");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.recordSaveEvent(prop.getProperty("CreateWorkspaceString"), 
										prop.getProperty("OnRecordSaveEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to execute the On Record Save Event ", 
				"Unable to execcute the On Record Save Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnRecordCloseEvent() {
		logger = extent.createTest("Verify Create contact activity with On Record Close event ");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.recordCloseEvent(prop.getProperty("CreateWorkspaceString"), 
										prop.getProperty("OnRecordCloseEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to execute the On Record Close Event ", 
				"Unable to execcute the On Record Close Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnDataLoadedEvent() {
		logger = extent.createTest("Verify Create contact activity with On Data Loaded event ");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.ondataLoadedEvent(prop.getProperty("CreateWorkspaceString"), 
										prop.getProperty("OnDataLoadedEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to execute the On Data Loaded Event ", 
				"Unable to execcute the On Data Loaded Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyOnEditorLoadedEvent() {
		logger = extent.createTest("Verify Create contact activity with On Data Loaded event ");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.onEditorLoadedEvent(prop.getProperty("CreateWorkspaceString"), 
										prop.getProperty("OnEditorLoadedEvent"), 
										prop.getProperty("DynamicUIString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to execute the On Editor Loaded Event ", 
				"Unable to execcute the On Data Editor Event ");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyEditActivity() {
		logger = extent.createTest("Verify user is able to rename the create workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.renameActivity(prop.getProperty("CreateWorkspaceString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to rename the Create Workspace activity", 
				"User is not able to rename the Create Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyDeleteActivity() {
		logger = extent.createTest("Verify user is able to delete the create workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.deleteActivity(prop.getProperty("CreateWorkspaceString"));
		commonActions.verifyAssertTrue(CreateWorkspace.DeleteWorkspaceFlag(), 
				"User is able to delete the Create Workspace activity", 
				"User is not able to delete the Create Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyPinActivity() {
		logger = extent.createTest("Verify user is able to pin the create workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.pinActivity(prop.getProperty("CreateWorkspaceString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to pin the Create Workspace activity", 
				"User is not able to pin the Create Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	@Test
	public void verifyCopyActivity() {
		logger = extent.createTest("Verify user is able to copy the create workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.copyPasteActivity(prop.getProperty("CreateWorkspaceString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to copy the Create Workspace activity", 
				"User is not able to copy the Create Workspace activity");
		PFHomePage.deleteCreatedWorkflow();
	}
	
	
	
}
