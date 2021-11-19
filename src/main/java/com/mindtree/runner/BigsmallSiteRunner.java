package com.mindtree.runner;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mindtree.pageObject.HomePage;
import com.mindtree.pageObject.LoginPage;
import com.mindtree.pageObject.ProductDescriptionPage;
import com.mindtree.pageObject.ResetPasswordPage;
import com.mindtree.pageObject.AboutUsPage;
import com.mindtree.pageObject.BirthDayGiftsPage;
import com.mindtree.pageObject.CartPage;
import com.mindtree.pageObject.ContactUsPage;
import com.mindtree.pageObject.SearchResultsPage;
import com.mindtree.pageObject.WishListPage;
import com.mindtree.reusableComponents.WebDriverHelper;
import com.mindtree.utility.OpenCloseChrome;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BigsmallSiteRunner extends WebDriverHelper {

	public static Logger log;
	public static ExtentTest extentTest;
	public static ExtentReports extent;

	@BeforeTest
	public void set() {
		driver = DriverSetUp();
	}
	
	@Test(priority = 1)
	void addToWishlist() {
		log = Logger.getLogger(BigsmallSiteRunner.class.getName());
		extent = new ExtentReports(System.getProperty("user.dir") + "\\Testreports\\" + date + "_ExtentReport.html",
				false);
		extentTest = extent.startTest("addToWishlist");
		HomePage.giftSearch(log, driver, extentTest);
		SearchResultsPage.pickMat(driver, log, extentTest);
		ProductDescriptionPage.addToWishList(driver, log, extentTest);
	}
	
	@Test(priority = 2)
	void addToCart() {
		extentTest = extent.startTest("addToCart");
		HomePage.hoverLink(driver, log, extentTest);		
		BirthDayGiftsPage.clickBirthDayGiftUnder1000(driver, log, extentTest);
		SearchResultsPage.pickAdiyogi(driver, log, extentTest);
		ProductDescriptionPage.addToCart(driver, log, extentTest);
	}
	
	@Test(priority = 3)
	void checkPIN() {
		extentTest = extent.startTest("checkPIN");
		HomePage.clickDCLogo(driver, log, extentTest);
		SearchResultsPage.pickBottle(driver, log, extentTest);
		ProductDescriptionPage.checkCode(driver, log, extentTest);
	}
	
	@Test(priority = 4)
	void retrievePassword() throws InterruptedException {
		extentTest = extent.startTest("retirievePass");
		HomePage.clickSignIn(log, driver, extentTest);
		LoginPage.clickForgot(log, driver, extentTest);
		ResetPasswordPage.forgotPassword(log, driver, extentTest);
	}
	
	@Test(priority = 5)
	void shopCheckout() {
		extentTest = extent.startTest("shopCheckout");
		HomePage.clickCart(log, driver, extentTest);
		CartPage.clickCheckout(log, driver, extentTest);
	}
	
	@Test(priority = 6)
	void cartRemove() {
		extentTest = extent.startTest("cartRemove");
		HomePage.clickCart(log, driver, extentTest);
		CartPage.clickRemove(log, driver, extentTest);
	}
	
	@Test(priority = 7)
	void wishListRemove() {
		extentTest = extent.startTest("wishListRemove");
		HomePage.clickWishList(log, driver, extentTest);
		WishListPage.clickRemove(log, driver, extentTest);
	}
	
	@Test(priority = 10)
	void AboutUs() {
		extentTest = extent.startTest("AboutUs");
		HomePage.clickAboutUs(log, driver, extentTest);
		AboutUsPage.clickFacebook(log, driver, extentTest);
	}
	
	@Test(priority = 9)
	void validLogin() {
		extentTest = extent.startTest("validLogin");
		HomePage.clickSignIn(log, driver, extentTest);;
		LoginPage.loginValid(log, driver, extentTest);
	}
	
	@Test(priority = 8)
	void ContactUs() {
		extentTest = extent.startTest("ContactUs");
		HomePage.clickContactUs(log, driver, extentTest);
		ContactUsPage.enterDetails(log, driver, extentTest);
	}

	@AfterMethod
	void endTest() {
		extent.endTest(extentTest); 

	}

	@AfterTest
	public void end() throws InterruptedException {
		Thread.sleep(3000);
		extent.flush();
		extent.close();
		OpenCloseChrome.quitDriver(driver);
	}

}
