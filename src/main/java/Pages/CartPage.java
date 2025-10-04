package Pages;

import org.openqa.selenium.By;

import utils.WaitUtils;

public class CartPage {

	private static final By viewCartLink = By.xpath("//a[@title='View Cart']");
	private static final By checkoutButton = By
			.xpath("(//a[contains(.,'Checkout')])[3]");
	private static final By confirmRemove = By
			.xpath("//button[contains(.,'Agree')]");

	public static void openCart() {
		WaitUtils.waitForClickable(viewCartLink).click();
	}

	public static void removeProduct(String product) {

		WaitUtils.waitForClickable(By.xpath("//p[contains(., '" + product
				+ "')]/following::span[normalize-space(.)='Remove'][1]"))
				.click();

		WaitUtils.waitForClickable(confirmRemove).click();

	}

	public static void clickCheckout() {
		WaitUtils.waitForClickable(checkoutButton).click();
	}
}
