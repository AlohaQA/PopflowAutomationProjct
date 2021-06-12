package com.popflow.Automation.testcases;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import com.popflow.Automation.base.TestBase;
import com.popflow.Automation.helperClass.CommonActions;
import com.popflow.Automation.helperClass.LoggerHelper;
import com.popflow.Automation.pageObjects.AppManagerHomePage;
import com.popflow.Automation.pageObjects.AppManagerLoginPage;
import com.popflow.Automation.pageObjects.PopflowHomePage;

public class PopFlowHomePageTest extends TestBase {
	
	private CommonActions commonActions;
	private AppManagerLoginPage LoginPage;
	private AppManagerHomePage AMHomePage;
	private PopflowHomePage PFHomePage;
	
	
	Logger log = LoggerHelper.getLogger(PopFlowHomePageTest.class);
	
	public PopFlowHomePageTest() {
		super();
	}

	
	public void AppManagerLogin(){
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
	}
	
	@Test
	public void verifyLoginWithValidCRMCredentials() {
		logger = extent.createTest("Verify popflow studio login functionality using valid CRM credentials");
		this.AppManagerLogin();
		PFHomePage.enterValidCRMCredentials(prop.getProperty("crmUN") ,prop.getProperty("crmPwd"));
		PFHomePage.clicOnSaveCredentialsButton();
		commonActions.verifyAssertTrue(PFHomePage.DeleteWorkFlowFlag(), 
				"User is able to login with the valid credentials", 
				"User is not able to login with the valid credentials");
		logger.info("User is able to login with the valid credentials");
		
	}
	
	@Test
	public void verifyloginWithInvalidCRMCredentials() {
		logger = extent.createTest("Verify popflow studio login functionality using Invalid CRM credentials");
		this.AppManagerLogin();
		PFHomePage.enterInvalidCRMCredentials(prop.getProperty("IncrmUN") ,prop.getProperty("IncrmPwd"));
		PFHomePage.clicOnSaveCredentialsButton();
		PFHomePage.getInvalidCredentialsErrorMsg();
		PFHomePage.clickOnCancelCredentialsButton();
		commonActions.verifyAssertTrue(PFHomePage.DeleteWorkFlowFlag(), 
				"User is not able to login with the Invalid credentials", 
				"User is able to login with the valid credentials");
	}
	
	@Test
	public void verifyAddNewWorkflowFunctionality() {
		logger = extent.createTest("Verify add new workflow functionality");
		this.AppManagerLogin();
		PFHomePage.addNewWorkFlow(prop.getProperty("NewWorkFlowName"));
		commonActions.verifyAssertTrue(PFHomePage.AddWorkflowFlag(), 
				"New workflow added successfully", 
				"Unable to add new workflow");
	}
	
	@Test
	public void verifyDeleteWorkflowFunctionality() {
		logger = extent.createTest("Verify delete workflow functionality");
		this.AppManagerLogin();
		PFHomePage.deleteWorkflow();
		commonActions.verifyAssertTrue(PFHomePage.DeleteWorkFlowFlag(),
				"Workflow has been deleted successfully", 
				"Unable to delete the workflow");
	}
	
	@Test
	public void verifyDuplicateWorkflowFuncttionality() {
		logger = extent.createTest("Verify duplicate workflow functionality");
		this.AppManagerLogin();
		PFHomePage.duplicateWorkFlow(prop.getProperty("DuplicateName"));
		commonActions.verifyAssertTrue(PFHomePage.DeleteWorkFlowFlag(),
				"User is able to Duplicate the workflow", 
				"User is not able to Duplicate the workflow");
		
	}
	
	@Test
	public void verifyAddNewCustomEventFunctionality() {
		logger = extent.createTest("Verify add new custom event functionality");
		this.AppManagerLogin();
		PFHomePage.AddCustomEventOnIncidentClose();
		commonActions.verifyAssertTrue(PFHomePage.onIncidentCloseFlag(), 
				"User is able to add On Incident Close event", 
				"Unable to add On Incident Close event");
	}
	
	@Test
	public void verifyPopflowEvents() {
		logger = extent.createTest("Verify that all the events are present under the telephony");
		this.AppManagerLogin();
		PFHomePage.verifyAllEvents();
		commonActions.verifyAssertTrue(PFHomePage.verifyTelephonyEventsFlag(), 
				"All the Telephony events are present", 
				"All the Telehony events are not present");
		commonActions.verifyAssertTrue(PFHomePage.verifyChatEventsFlag(), 
				"All the Chat events are present", 
				"All the Chat events are not present");
	}
	
	@Test
	public void verifyPopflowVersion() {
		logger = extent.createTest("Verify popflow version displays inside the app manager");
		this.AppManagerLogin();
		PFHomePage.verifyPopflowVersion();
		commonActions.verifyAssertTrue(PFHomePage.verifyVersionFlag(), 
				"Popflow version is verified", 
				"Unable to get the popflow version");
	}
	
	@Test
	public void verifyCRMInsatnceNavigation() {
		logger = extent.createTest("Verify that user is able to navigate to the CRM Instance");
		this.AppManagerLogin();
		PFHomePage.verifyInstanceNavigation();
		commonActions.verifyAssertTrue(PFHomePage.DeleteWorkFlowFlag(), 
				"User is able to navigate to the CRM Instance from the popflow studio home page", 
				"User is not able to navigate to the CRM Instance from the popflow home age");
	}
	
	@Test
	public void verifyEditWorkflowNameFunctionality() {
		logger = extent.createTest("Verify that user is able to edit the workflow name");
		this.AppManagerLogin();
		PFHomePage.editWorkflow();
	}
	
	@Test
	public void verifyEditWorkflowDescriptionFunctionality() {
		logger = extent.createTest("Verify that user is able to edit the workflow description");
		this.AppManagerLogin();
		PFHomePage.editWorkflowDescription();
	}
	
	@Test
	public void verifyErroMessageForLongWFName() {
		logger = extent.createTest("Verify that it is having validations for long workflow name");
		this.AppManagerLogin();
		PFHomePage.getErrormessageForLongWFName(prop.getProperty("longWorkFlowNameString"));
		commonActions.verifyAssertTrue(PFHomePage.DeleteWorkFlowFlag(), 
				"Validations are provided when user enter workflow name more than 50 characters", 
				"Validations are not provided when user enter workflow name more than 50 characters");
		logger.info("Validations are provided when user enter workflow name more than 50 characters");
	}
	
	@Test
	public void verifyErroMessageForLongWFDescription() {
		logger = extent.createTest("Verify that it is having validations for long workflow description");
		this.AppManagerLogin();
		PFHomePage.getErrormessageForLongWFDescription(prop.getProperty("longWorkFlowDesString"));
		commonActions.verifyAssertTrue(PFHomePage.DeleteWorkFlowFlag(), 
				"Validations are provided when user enter workflow description more than 200 characters", 
				"Validations are not provided when user enter workflow description more than 200 characters");
		logger.info("Validations are provided when user enter workflow description more than 200 characters");	
	}
	
	//@Test
	public void verifyCustomEventDeleteFunctioanlity() {
		logger = extent.createTest("Verify that user is able to delete the custom event");
		this.AppManagerLogin();
		PFHomePage.deleteCustomEventOnincidentClose();
	}
	
	@Test
	public void verifyImportWorkflowFunctionality() throws AWTException {
		logger = extent.createTest("Verify that user is able to import the workflow");
		this.AppManagerLogin();
		PFHomePage.importWorkflow();
		commonActions.verifyAssertTrue(PFHomePage.ImportWorkflowFlag(), 
				"User is able to import a workflow", 
				"User is not able to import the workflow");
	}
	
	@Test
	public void verifyImportOverrideWorkflowFunctionality() throws AWTException {
		logger = extent.createTest("Verify the override button functionality while imoporting workflow. ");
		this.AppManagerLogin();
		PFHomePage.importOverride();
		commonActions.verifyAssertTrue(PFHomePage.ImportWorkflowFlag(), 
				"User is able to override the existing workflow after import. ", 
				"User is not able to override the existing workflow after import. ");
	}
	
	@Test
	public void verifyImportWorkflowFunctionalityWithOptionNew() throws AWTException {
		logger = extent.createTest("Verify the import new button functionality while importing workflow. ");
		this.AppManagerLogin();
		PFHomePage.importNew();
		commonActions.verifyAssertTrue(PFHomePage.ImportNewWorkflowFlag(), 
				"User is able to import new workflow ", 
				"User is not able to import new workflow");
	}
}
