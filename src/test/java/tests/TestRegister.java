package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestRegister extends BaseTest {

    Locators locators;
    ExtentSparkReporter html;
    ExtentReports report;
    ExtentTest test;

    @Test
    public void testRegisterUser() {

        locators = new Locators();

        html = new ExtentSparkReporter("test-output/report.html");
        report = new ExtentReports();
        report.attachReporter(html);
        test = report.createTest("Test 1", "Odev4_AutomationExercises");

        test.info("Odev 4 un 14,16, ve 18. stepleri tekrar kontrol edilecek");
        test.log(Status.WARNING, "Warning");
        test.warning("My log as Warning, without Status");

//       2. Navigate to url 'http://automationexercise.com'

        Driver.getDriver().get("https://automationexercise.com/");

//       3. Verify that home page is visible successfully

        verifyHomePageIsVisible();

//       4. Click on 'Signup / Login' button

        clickToElement(locators.eSignUpLogin);

//        5. Verify 'New User Signup!' is visible

        verifyNewUserSignUpVisible();

//        6. Enter name and email address   7. 	Click 'Signup' button

        Faker faker = new Faker();

        locators.eSignUpName.sendKeys(faker.name().fullName());
        locators.eSignUpEmail.sendKeys(faker.internet().emailAddress());
        locators.eSignUpButton.click();

//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        verifyEnterAccountInformationVisible();

//         9. Fill details: Title, Name, Email, Password, Date of birth
//        10. Select checkbox 'Sign up for our newsletter!'
//        11. Select checkbox 'Receive special offers from our partners!'
//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//        13. Click 'Create Account button'

        locators.eGender.click();
        locators.eAccountPassword.sendKeys(faker.internet().password());

        new Select(locators.eSelectDays).selectByIndex(3);
        new Select(locators.eSelectMonths).selectByIndex(7);
        new Select(locators.eSelectYears).selectByIndex(12);

        clickByJS(locators.eCheckBoxes1);
        clickByJS(locators.eCheckBoxes2);

        locators.eFirstName.sendKeys(faker.name().firstName());
        locators.eLastName.sendKeys(faker.name().lastName());

        sendKeys(locators.lCompany, "alibaba");
        sendKeys(locators.lAddress1, "Cancan Sokak");
        sendKeys(locators.lAddress2, "Can Ada");

        new Select(locators.eSelectCountry).selectByIndex(2);

        sendKeys(locators.lState, "CAN Canada");
        sendKeys(locators.lCity, "Cagaloglu");
        sendKeys(locators.lZipcode, "19991");
        sendKeys(locators.lMobileNumber, "1999119991");

        clickByJS(locators.eCreateAccount);

//        14. Verify that 'ACCOUNT CREATED!' is visible

        verifyAccountCreatedVisible();

//        15. Click 'Continue' button
//        16. Verify that 'Logged in as username' is visible
//        17. Click 'Delete Account' button
//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        clickByJS(locators.lContinue);

//           verifyAccountDeleted();
//        clickByJS(locators.eAccountDeleted);
//        verifyLoggedInAsUsername();

        report.setSystemInfo("CID Team", "Test Automatisierer Team");
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Directory", System.getProperty("user.dir"));
        report.setSystemInfo("Date Time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss")));
        report.flush();

    }
}