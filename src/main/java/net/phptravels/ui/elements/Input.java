package net.phptravels.ui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.phptravels.utils.logging.Log;

public class Input extends Control {
	
	public Input(WebElement element) {
		super(element);
		// TODO Auto-generated constructor stub
	}
	
	public void sendKeys(String value) {
		Log.logDebugMessage("Sending keys " + value);
		element.findElement(new By.ByXPath(INPUTXPATH)).sendKeys(value);
	}

	public void clear() {
		Log.logDebugMessage("Clearing ");
		element.findElement(new By.ByXPath(INPUTXPATH)).clear();
	}

}
