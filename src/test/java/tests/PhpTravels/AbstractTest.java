package tests.PhpTravels;


import java.lang.reflect.Method;
import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import net.phptravels.tools.propertyholder.spring.DataHolder;
import net.phptravels.tools.propertyholder.spring.URLsHolder;
import net.phptravels.utils.browsers.Browser;
import net.phptravels.utils.helpers.Nav;
import net.phptravels.utils.logging.Log;
import net.phptravels.utils.testlisteners.TestListener;
/**
 * Base test class containing common pre-/post-conditions steps and auxiliary methods.<br/>
 *
 * TODO: use listeners to track test failures like IOException. <br/>
 * TODO: log additional info like IP etc before test start.     <br/>
 */
@Listeners (TestListener.class)
public abstract class AbstractTest {
	
	protected String browser, version, os;
	protected Browser newBrowser;

	protected static final String baseUrl = URLsHolder.getHolder().getBaseUrl();
	
	protected static final String backendUrl = URLsHolder.getHolder().getPageAdmin();
	protected static String adminName = DataHolder.getHolder().getAdminName();
	protected static String adminLogin = DataHolder.getHolder().getAdminAccountName();
	protected static String adminPasword = DataHolder.getHolder().getAdminAccountPassword();
	
	protected static final String frontendUrl = URLsHolder.getHolder().getPageAccount();
	protected static String userName = DataHolder.getHolder().getUserName();
	protected static String userLogin = DataHolder.getHolder().getUserAccountName();
	protected static String userPassword = DataHolder.getHolder().getUserAccountPassword();
	
	 /**
     * DataProvider that explicitly sets the browser combinations to be used.
     *
     * @param testMethod
     * @return Two dimensional array of objects with browser, version, and platform information
     */
    @DataProvider(name = "hardCodedBrowsers", parallel = true)
    public static Object[][] sauceBrowserDataProvider(Method testMethod) {
        return new Object[][]{
                /*new Object[]{"MicrosoftEdge", "14.14393", "Windows 10"},
                new Object[]{"firefox", "49.0", "Windows 10"},
                new Object[]{"internet explorer", "11.0", "Windows 7"},
                new Object[]{"safari", "10.0", "OS X 10.11"},
                new Object[]{"chrome", "54.0", "OS X 10.10"},
                new Object[]{"firefox", "latest-1", "Windows 7"},*/
        };
    }
    
    protected void annotate(String text) {
        ((JavascriptExecutor) Browser.getDriver()).executeScript("sauce:context=" + text);
    }

	/**
	 * Performs precondition action(s) before each test start.
	 * <p>
	 * @throws MalformedURLException 
	 */
	
	/**
	 * Before all the TestNG test run: 
	 * 1. log the name of the TestNG test suite
	 * 2. log the environment name for test execution
	 */
	@BeforeSuite(alwaysRun = true)
	@Parameters({ "envTarget" })
	public void beforeSuite(String envTarget, ITestContext testContext) {
		Log.logTestSuiteStart(testContext);
		Log.logSuiteInfo("Starting test run on: [" + envTarget.toUpperCase() + "] environment");
	}
	
	/**
	 * After all the TestNG test run: 
	 * 1. log the name of the TestNG test suite
	 */
	@AfterSuite(alwaysRun = true)
	@Parameters({ "envTarget" })
	public void afterSuite(String envTarget, ITestContext testContext) {
		Log.logSuiteInfo("Completed test run  on: [" + envTarget.toUpperCase() + "] environment");
		Log.logTestSuiteEnd(testContext);
	}
	
	/**
	 * Before all the test classes run: 
	 * 1. log the name of the TestNG test
	 * 2. Open new browser window
	 * 3. Navigate to AUT URL
	 * 
	 * @param browser - optional
	 * @param testContext
	 */
	@BeforeTest(alwaysRun = true)
	@Parameters({ "browser" })
	public synchronized void beforeTest(@Optional("chrome") String browser, ITestContext testContext) throws MalformedURLException {
		Log.logTestStart(testContext);
		/*newBrowser = new Browser(browser);
		Log.logTestInfo("Opening " + browser);*/
	}

	/**
	 * After all the Tests Classes have finished executing, log it and close browser
	 * 
	 * @param testContext ITestContext which contains the name of the Test from the testng.xml file
	 */
	@AfterTest(alwaysRun = true)
	public void afterTest(ITestContext testContext) {
		// Close the browser
		/*f (newBrowser != null)
			newBrowser.quit();*/
		Log.logTestEnd(testContext);
	}
	
	/**
	 * Before every test, log the method that is being run
	 * 
	 * @param method
	 */
	@BeforeMethod(alwaysRun = true)
	public synchronized void beforeMethod(Method method) {
		Log.logTestMethodStart(method);
	}
	
	/**
	 * After every test, Log the name of the method that was run
	 * 
	 * @param method
	 */
	@AfterMethod(alwaysRun = true)
	public synchronized void afterMethod(Method method, ITestResult result) {
		Log.logTestMethodEnd(method, result);
	}
}