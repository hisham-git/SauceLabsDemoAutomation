package net.phptravels.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

	@FindBy(how = How.CSS, using = "input[name='username']")
	private WebElement emailInput;

	@FindBy(how = How.CSS, using = "input[name='password']")
	private WebElement passInput;

	@FindBy(how = How.CSS, using = "button.loginbtn")
	private WebElement loginBtn;

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getPassInput() {
		return passInput;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
