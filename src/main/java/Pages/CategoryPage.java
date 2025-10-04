package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.DriverManager;
import utils.WaitUtils;

public class CategoryPage {
	private static final WebDriver driver = DriverManager.getDriver();

	private static final By searchBox = By.name("query");
	private static final By addToCartBtn = By
			.xpath("//button[contains(.,'Add To Cart')]");
	private static final By toastItemAdded = By
			.xpath("//p[contains(.,'Item Added Successfully')]");
	private static final By quantityPlus = By
			.xpath("//span[@aria-label='Increase Quantity']");

	public static void searchForProduct(String productname) {
		WaitUtils.waitForVisible(searchBox).sendKeys(productname);
	}

	public static void clickOnProduct(String productname) {
		WaitUtils
				.waitForClickable(
						By.xpath("(//p[contains(.,'" + productname + "')])[1]"))
				.click();
	}

	public static void clickAddToCartOnProductPage() {
		WaitUtils.waitForClickable(addToCartBtn).click();
		WaitUtils.waitForVisible(toastItemAdded);
	}

	public static void chooseOption(String opt) {
		try {
			By option = By.xpath("//label[contains(.,'" + opt + "')]");

			WebElement element = driver.findElement(option);

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView({block: 'center'});", element);

			WaitUtils.waitForClickable(option).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void increaseQuantityTo(int Quantity) {
		for (int i = 0; i < Quantity; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,700)");
			WaitUtils.waitForClickable(quantityPlus).click();
		}
	}
}
