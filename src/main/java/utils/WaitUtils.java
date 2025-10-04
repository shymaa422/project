package utils;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private static int TIMEOUT = 15;

	public static WebElement waitForClickable(By locator) {
		return new WebDriverWait(DriverManager.getDriver(),
				Duration.ofSeconds(TIMEOUT))
				.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement waitForVisible(By locator) {
		return new WebDriverWait(DriverManager.getDriver(),
				Duration.ofSeconds(TIMEOUT))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
