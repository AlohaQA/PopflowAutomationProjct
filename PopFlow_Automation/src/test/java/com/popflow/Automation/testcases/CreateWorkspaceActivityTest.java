package com.popflow.Automation.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

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

	//@Test
	public void verifyAddingCreateWorkspaceActivity() {
		logger = extent.createTest("Verify user is able to add create workspace activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.AddCreateWorkspaceActitiy(prop.getProperty("CreateWorkspaceString"));
		commonActions.verifyAssertTrue(CreateWorkspace.CreateWorkspaceFlag(), 
				"User is able to add Create Workspace activity", 
				"User is not able to add the Create Workspace activity");
	}
	
	//@Test
	public void verifyCreateContactActivity() {
		logger = extent.createTest("Verify Create Contact activity");
		this.AppManagerLoginAndCreateaWorkflow();
		CreateWorkspace.verifyCreateContact(prop.getProperty("CreateWorkspaceString"));
	}
	
	public void verifyEditActivity() {
		
	}
	
}
