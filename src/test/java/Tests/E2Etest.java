package Tests;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.CategoryPage;
import Pages.HomePage;
import Pages.LoginPage;
import utils.DriverManager;
import utils.GetProperty;

public class E2Etest {
	private static Properties props = new Properties();

	@BeforeClass
	public void setup() throws IOException {
		try (InputStream in = getClass().getClassLoader()
				.getResourceAsStream("config.properties")) {
			props.load(in);
		}
		DriverManager.initDriver();
	}

	@Test
	public void cartlowE2E() throws IOException {

		HomePage.open(GetProperty.getProps(props, "url"));

		HomePage.openLoginDropdown();
		HomePage.clickSignIn();

		LoginPage.enterIdentifierAndContinue(
				GetProperty.getProps(props, "email"));
		LoginPage.enterPasswordAndSignIn(
				GetProperty.getProps(props, "password"));

		Assert.assertTrue(HomePage.isProfileVisibleAfterLogin(),
				"Login failed or profile icon not visible");

		HomePage.goToLaptops();

		CategoryPage.searchForProduct(GetProperty.getProps(props, "product1"));
		CategoryPage.clickOnProduct(GetProperty.getProps(props, "product1"));

		CategoryPage.clickAddToCartOnProductPage();

		HomePage.goToSmartwatches();

		CategoryPage.searchForProduct(GetProperty.getProps(props, "product2"));
		CategoryPage.clickOnProduct(GetProperty.getProps(props, "product2"));

		CategoryPage.chooseOption(GetProperty.getProps(props, "connectivity"));
		CategoryPage.chooseOption(GetProperty.getProps(props, "color"));
		CategoryPage.chooseOption(GetProperty.getProps(props, "size"));

		CategoryPage.increaseQuantityTo(1);
		CategoryPage.clickAddToCartOnProductPage();

		CartPage.openCart();

		CartPage.removeProduct(GetProperty.getProps(props, "product1"));

		CartPage.clickCheckout();

	}

}
