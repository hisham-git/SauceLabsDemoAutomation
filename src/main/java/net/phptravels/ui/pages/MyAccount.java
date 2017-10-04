package net.phptravels.ui.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import net.phptravels.utils.helpers.UiHelper;

public class MyAccount {
	
	@FindBy(how = How.CSS, using = "h3.RTL")
	private WebElement userInfoText;
	
	@FindBy(how = How.CSS, using = "div.alert-success")
	private WebElement profileUpdateSuccess;

	public WebElement getProfileUpdateSuccess() {
		return profileUpdateSuccess;
	}

	@FindBy(how = How.CSS, using = "a[href='#profile']")
	private WebElement myProfileTab;
	
	public WebElement getMyProfileTab() {
		return myProfileTab;
	}

	////////////////// Personal Information block////////////////////////
	@FindBy(how = How.CSS, using = "input[name='firstname']")
	private WebElement fNameInput;

	@FindBy(how = How.CSS, using = "input[name='lastname']")
	private WebElement lNameInput;

	@FindBy(how = How.CSS, using = "input[name='phone']")
	private WebElement mobileInput;

	////////////////// Confirmation  block////////////////////////
	@FindBy(how = How.CSS, using = "input[name='email']")
	private WebElement emailInput;

	@FindBy(how = How.CSS, using = "input[name='password']")
	private WebElement passInput;

	@FindBy(how = How.CSS, using = "input[name='confirmpassword']")
	private WebElement cofirmPassInput;	
	
	////////////////// Location  block////////////////////////
	@FindBy(how = How.CSS, using = "input[name='address1']")
	private WebElement address1Input;
	
	@FindBy(how = How.CSS, using = "input[name='address2']")
	private WebElement address2Input;
	
	@FindBy(how = How.CSS, using = "input[name='city']")
	private WebElement cityInput;
	
	@FindBy(how = How.CSS, using = "input[name='state']")
	private WebElement stateInput;
	
	@FindBy(how = How.CSS, using = "input[name='zip']")
	private WebElement postalZipInput;
	
	@FindBy(how = How.CSS, using = "select[name='country']")
	private WebElement countryDropDown;

	@FindBy(how = How.CSS, using = "button.updateprofile")
	private WebElement submitBtn;
	
	
	public WebElement getUserInfoText() {
		return userInfoText;
	}

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
	
	public WebElement getAddress1Input() {
		return address1Input;
	}

	public WebElement getAddress2Input() {
		return address2Input;
	}

	public WebElement getCityInput() {
		return cityInput;
	}

	public WebElement getStateInput() {
		return stateInput;
	}

	public WebElement getPostalZipInput() {
		return postalZipInput;
	}

	public WebElement getCountryDropDown() {
		return countryDropDown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public String getLoggedInUserName(){
		return userInfoText.getText().split("Hi, ")[1];
	}
	
	public void updateProfile(Map<String, String> values) {
		UiHelper.sendKeys(mobileInput, values.get("Phone"));
		UiHelper.sendKeys(emailInput, values.get("NewEmail"));
		UiHelper.sendKeys(passInput, values.get("NewPassword"));
		UiHelper.sendKeys(cofirmPassInput, values.get("ConfirmPassword"));
		UiHelper.sendKeys(address1Input, values.get("Address1"));
		UiHelper.sendKeys(address2Input, values.get("Address2"));
		UiHelper.sendKeys(cityInput, values.get("City"));
		UiHelper.sendKeys(stateInput, values.get("State"));
		UiHelper.sendKeys(postalZipInput, values.get("Zip"));
		UiHelper.selectInDropdownBtn(getCountryDropDown(), values.get("Country"));
		UiHelper.clickAndWait(getSubmitBtn());
	}

}
