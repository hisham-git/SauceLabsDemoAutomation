
package tests.PhpTravels;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.Map;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import net.phptravels.utils.browsers.Browser;
import net.phptravels.utils.dataProvider.ExcelDataMapper;
import net.phptravels.utils.helpers.Nav;
import net.phptravels.utils.logging.Log;
import steps.Tests.SignUpSteps;

@Test(groups = { "SignUp" })
public class SignUpTest extends AbstractTest {

	private SignUpSteps steps;
	private static final String profileSuccessMsg = "Profile Updated Successfully.";
	
	@Factory(dataProvider = "getExcelData", dataProviderClass = ExcelDataMapper.class)
	public static Object[] SignUpTests(Map<String, String> configData) {
		return new Object[] { new SignUpTest(configData) };
	}
	
	public SignUpTest(Map<String, String> configData) {
		browser = configData.get("Browser");
		version = configData.get("Version");
		os = configData.get("OS");
	}

	@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		Log.logTestClassStart(this.getClass());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		Log.logTestClassEnd(this.getClass());
		Browser.quitWebDriver();
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		Log.logTestMethodStart(method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(Method method, ITestResult result) {
		steps.logOut();
		Browser.logResult(result);
		Log.logTestMethodEnd(method, result);
	}

	@Test(groups = {
			"SignUpUser" }, description = "Check user creation", dataProvider = "getExcelData", dataProviderClass = ExcelDataMapper.class)
	public void signUpUserTest(Map<String, String> testData, Method method) 
			throws MalformedURLException, InvalidElementStateException, UnexpectedException{
		Browser.createDriver(browser, version, os, method.getName());
		WebDriver driver = Browser.getWebDriver();
		Nav.toURL(baseUrl + "/register", driver);
		steps = new SignUpSteps(driver);
		steps.createNewSignIn(testData);
		steps.verifyUser(testData);
	}

	@Test(groups = {
			"UpdateProfile" }, dependsOnGroups = "SignUpUser", description = "Check user profile update", dataProvider = "getExcelData", dataProviderClass = ExcelDataMapper.class)
	public void updateProfileTest(Map<String, String> testData, Method method) 
			throws MalformedURLException, InvalidElementStateException, UnexpectedException{
		Browser.createDriver(browser, version, os, method.getName());
		WebDriver driver = Browser.getWebDriver();
		Nav.toURL(baseUrl + "/login", driver);
		steps = new SignUpSteps(driver);
		steps.logIn(testData);
		steps.selectMyProfileTab();
		steps.updateProfileAndVerifySuccessMsg(testData, profileSuccessMsg);
	}
}
