package net.phptravels.ui.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.phptravels.utils.browsers.Browser;
import net.phptravels.utils.helpers.UiHelper;

public class Register {

	@FindBy(how = How.CSS, using = "input[name='firstname']")
	private WebElement fNameInput;

	@FindBy(how = How.CSS, using = "input[name='lastname']")
	private WebElement lNameInput;

	@FindBy(how = How.CSS, using = "input[name='phone']")
	private WebElement mobileInput;

	@FindBy(how = How.CSS, using = "input[name='email']")
	private WebElement emailInput;

	@FindBy(how = How.CSS, using = "input[name='password']")
	private WebElement passInput;

	@FindBy(how = How.CSS, using = "input[name='confirmpassword']")
	private WebElement cofirmPassInput;

	@FindBy(how = How.CSS, using = "button.signupbtn")
	private WebElement signUpBtn;

	public WebElement getfNameInput() {
		return fNameInput;
	}

	public WebElement getlNameInput() {
		return lNameInput;
	}

	public WebElement getMobileInput() {
		return mobileInput;
	}

	public WebElement getEmailInput() {
		return emailInput;
	}

	public WebElement getPassInput() {
		return passInput;
	}

	public WebElement getCofirmPassInput() {
		return cofirmPassInput;
	}

	public WebElement getSignUpBtn() {
		return signUpBtn;
	}
	
	public MyAccount signUp(Map<String, String> values){
		UiHelper.sendKeys(fNameInput, values.get("FirstName"));
		UiHelper.sendKeys(lNameInput, values.get("LastName"));
		UiHelper.sendKeys(mobileInput, values.get("MobileNumber"));
		UiHelper.sendKeys(emailInput, values.get("Email"));
		UiHelper.sendKeys(passInput, values.get("Password"));
		UiHelper.sendKeys(cofirmPassInput, values.get("ConfirmPassword"));
		UiHelper.clickAndWait(getSignUpBtn());
		return PageFactory.initElements(Browser.getDriver(), MyAccount.class);
	}
}
