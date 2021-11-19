package com.mindtree.pageObject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.reusableComponents.DriverFunctions;
import com.mindtree.uistore.AppUI;
import com.mindtree.utility.ExcelUtility;
import com.mindtree.utility.ExtentUtility;
import com.mindtree.utility.Log;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPage extends AppUI {

	public static void loginValid(Logger log, WebDriver driver, ExtentTest test) {
		try {
			    DriverFunctions.sendkeys(driver, eMail, ExcelUtility.Excelread(1, 1));
			    DriverFunctions.sendkeys(driver, passWord, ExcelUtility.Excelread(1, 2));
			    DriverFunctions.click(driver, SignInBtn);
				Log.testLoggerInfo(log, "Login Successful");
				test.log(LogStatus.PASS, "Login Successful");
			}
		
		catch (IOException e) {
			DriverFunctions.click(driver, siteLogo);
			Log.testLoggerError(log, "Login not Successful");
			Log.testLoggerWarn(log, "Robot PopUp appears at times");
			ExtentUtility.fail(test, driver, "Login not Successful");
		}
	}
	
	public static void invalidLogin(Logger log, WebDriver driver, ExtentTest test) {
		try {
			    DriverFunctions.sendkeys(driver, eMail, ExcelUtility.Excelread(2, 1));
			    DriverFunctions.sendkeys(driver, passWord, ExcelUtility.Excelread(2, 2));
			    DriverFunctions.click(driver, SignInBtn);
			    DriverFunctions.click(driver, siteLogo);
				Log.testLoggerInfo(log, "Error Message is shown");
				test.log(LogStatus.PASS, "Error Message is shown");
			}
		
		catch (IOException e) {
			DriverFunctions.click(driver, siteLogo);
			Log.testLoggerError(log, "The Error message is not displayed");
			Log.testLoggerWarn(log, "Robot PopUp appears at times");
			ExtentUtility.fail(test, driver, "The Error message is not displayed");
		}
	}
	
	public static void clickForgot(Logger log, WebDriver driver, ExtentTest test) {
		try {
		        DriverFunctions.click(driver, forgotButton);	
				Log.testLoggerInfo(log, "Navigated to Reset password page");
				test.log(LogStatus.PASS, "Navigated to Reset password page");
			}
		
		catch (Exception e) {
			Log.testLoggerError(log, "Not navigated to Reset password page");
			ExtentUtility.fail(test, driver, "Not navigated to Reset password page");
		}
	}

}
