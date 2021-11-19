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

public class ContactUsPage extends AppUI{
	public static void enterDetails(Logger log, WebDriver driver, ExtentTest test) {
		try {
			    DriverFunctions.sendkeys(driver, contactName, ExcelUtility.Excelread(9, 1));
			    DriverFunctions.sendkeys(driver, contactEmail, ExcelUtility.Excelread(9, 2));
			    DriverFunctions.sendkeys(driver, contactMsg, ExcelUtility.Excelread(9, 3));
			    DriverFunctions.click(driver, contactSubmitBtn);
			    DriverFunctions.click(driver, siteLogo);
				Log.testLoggerInfo(log, "Entered contact details and notification shown");
				ExtentUtility.pass(test, "Entered contact details and notification shown");
			}
		
		catch (IOException e) {
			Log.testLoggerError(log, "Unable to enter Contact details");
			ExtentUtility.fail(test, driver, "Unable to enter Contact details");
		}
	}
}
