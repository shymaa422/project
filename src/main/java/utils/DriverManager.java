package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	public static WebDriver driver;

	public static void initDriver() {
		ChromeOptions opts = new ChromeOptions();
		opts.addArguments("--start-maximized");
		driver = new ChromeDriver(opts);
	}
	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		driver.quit();
	}
}
