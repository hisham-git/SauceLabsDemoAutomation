package net.phptravels.utils.helpers;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.phptravels.utils.browsers.Browser;

/**
 * A helper class, contains methods like goToSpecificPage().
 */
public class Nav {
    private static final Logger logger = LoggerFactory.getLogger(Nav.class);

    /**
     * Navigates to the URL specified.
     *
     * @param url - URL to navigate to.
     */
    public static void toURL(String url, WebDriver driver){
        logger.debug("Navigating to " + url);
        driver.get(url);
    }
}