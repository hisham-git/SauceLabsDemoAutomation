package net.phptravels.utils.browsers;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.UnexpectedException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

/**
 * https://github.com/saucelabs-sample-test-frameworks/Java-TestNG-Selenium
 * 
 * username: his08
 * accesskey: 07079f3a-a7ac-4c67-8c86-79d0aa572328
 * 
 */


public class Browser {
	
	private static String buildTag = System.getenv("BUILD_TAG");

	private static String username = System.getenv("SAUCE_USERNAME");

	private static String accesskey = System.getenv("SAUCE_ACCESS_KEY");

	/**
	 * ThreadLocal variable which contains the {@link WebDriver} instance which
	 * is used to perform browser interactions with.
	 */
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	/**
	 * ThreadLocal variable which contains the Sauce Job Id.
	 */
	private static ThreadLocal<String> sessionId = new ThreadLocal<String>();
	
	 /**
     * @return the {@link WebDriver} for the current thread
     */
	public static WebDriver getDriver() {
		return webDriver.get();
	}

    /**
     *
     * @return the Sauce Job id for the current thread
     */
    public static String getSessionId() {
        return sessionId.get();
    }

    /**
     * Constructs a new {@link RemoteWebDriver} instance which is configured to use the capabilities defined by the browser,
     * version and os parameters, and which is configured to run against ondemand.saucelabs.com, using
     * the username and access key populated by the {@link #authentication} instance.
     *
     * @param browser Represents the browser to be used as part of the test run.
     * @param version Represents the version of the browser to be used as part of the test run.
     * @param os Represents the operating system to be used as part of the test run.
     * @param methodName Represents the name of the test case that will be used to identify the test on Sauce.
     * @return
     * @throws MalformedURLException if an error occurs parsing the url
     */
    public static void createDriver(String browser, String version, String os, String methodName)
            throws MalformedURLException, UnexpectedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // set desired capabilities to launch appropriate browser on Sauce
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM, os);
        capabilities.setCapability("name", methodName);

        if (buildTag != null) {
            capabilities.setCapability("build", buildTag);
        }

        // Launch remote browser and set it as the current thread
        webDriver.set(new RemoteWebDriver(
                new URL("https://" + username + ":" + accesskey + "@ondemand.saucelabs.com:443/wd/hub"),
                capabilities));

        // set current sessionId
        String id = ((RemoteWebDriver) getDriver()).getSessionId().toString();
        sessionId.set(id);
    }
    
	public static void logResult(ITestResult result) {
		((JavascriptExecutor) webDriver.get())
				.executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
	}
	
	public static void quitDriver(){
		getDriver().quit();
	}
	
	 /**
     * Gets URL of the current page.
     *
     * @return URL of the current page.
     */
    public static String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }
}