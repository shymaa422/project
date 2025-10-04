package Pages;

import org.openqa.selenium.By;

import utils.WaitUtils;

public class LoginPage {

	private static final By identifierInput = By
			.cssSelector("input#identifier[name='identifier']");
	private static final By continueButton = By
			.cssSelector("button[type='submit'].primary-button");
	private static final By passwordInput = By
			.cssSelector("input#password[name='password']");
	private static final By signInButton = By
			.cssSelector("button[type='submit'].primary-button");

	public static void enterIdentifierAndContinue(String email) {
		WaitUtils.waitForVisible(identifierInput).clear();
		WaitUtils.waitForVisible(identifierInput).sendKeys(email);
		WaitUtils.waitForClickable(continueButton).click();
	}

	public static void enterPasswordAndSignIn(String password) {
		WaitUtils.waitForVisible(passwordInput).sendKeys(password);
		WaitUtils.waitForClickable(signInButton).click();
	}
}
