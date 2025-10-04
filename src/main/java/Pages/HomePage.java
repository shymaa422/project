package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.DriverManager;
import utils.WaitUtils;

public class HomePage {
	private static final WebDriver driver = DriverManager.getDriver();

	private static final By profileIconDropdown = By
			.cssSelector("span.icon-users[aria-label='Profile Info']");
	private static final By signInLink = By
			.cssSelector("a[href='https://cartlow.com/customer/login']");
	private static final By laptopsTab = By.cssSelector("a[title='Laptops']");
	private static final By smartwatchesTab = By
			.cssSelector("a[title='Smartwatches']");
	private static final By profileIconAfterLogin = By
			.cssSelector("a[href='https://cartlow.com/customer/logout']");

	public static void open(String url) {
		driver.get(url);
	}

	public static void openLoginDropdown() {
		WaitUtils.waitForClickable(profileIconDropdown).click();
	}

	public static void clickSignIn() {
		WaitUtils.waitForClickable(signInLink).click();
	}

	public static void goToLaptops() {
		WaitUtils.waitForClickable(laptopsTab).click();
	}

	public static void goToSmartwatches() {
		WaitUtils.waitForClickable(smartwatchesTab).click();
	}

	public static boolean isProfileVisibleAfterLogin() {

		WaitUtils.waitForClickable(profileIconDropdown).click();

		return WaitUtils.waitForVisible(profileIconAfterLogin).isDisplayed();

	}
}
