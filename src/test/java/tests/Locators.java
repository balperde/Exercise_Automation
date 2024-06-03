package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Driver;

import java.util.List;

public class Locators {

    public Locators() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/login']")
    WebElement eSignUpLogin;

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement eSignUpName;

    @FindBy(xpath = "(//input[@placeholder='Email Address'])[2]")
    WebElement eSignUpEmail;

    @FindBy(xpath = "//button[text()='Signup']")
    WebElement eSignUpButton;

    @FindBy(css = "#id_gender1")
    WebElement eGender;

    @FindBy(xpath = "//input[@data-qa='password']")
    WebElement eAccountPassword;

    @FindBy(xpath = "//input[@data-qa='first_name']")
    WebElement eFirstName;

    @FindBy(xpath = "//input[@data-qa='last_name']")
    WebElement eLastName;

    @FindBy(xpath = "//select[@name='days']")
    WebElement eSelectDays;

    @FindBy(xpath = "//select[@name='months']")
    WebElement eSelectMonths;

    @FindBy(xpath = "//select[@name='years']")
    WebElement eSelectYears;

    @FindBy(xpath = "//label[text()='Sign up for our newsletter!']")
    WebElement eCheckBoxes1;
    @FindBy(xpath = "//label[text()='Receive special offers from our partners!']")
    WebElement eCheckBoxes2;
    @FindBy(xpath = "//select[@id='country']")
    WebElement eSelectCountry;
    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement eCreateAccount;
    @FindBy(xpath = "//a[@href='/delete_account']")
    public WebElement eAccountDeleted;

    By lCompany = By.xpath("//input[@id='company']");
    By lAddress1 = By.xpath("//input[@id='address1']");
    By lAddress2 = By.xpath("//input[@id='address2']");
    By lState = By.xpath ("//input[@data-qa='state']");
    By lCity = By.xpath("//input[@data-qa='city']");
    By lZipcode = By.xpath("//input[@data-qa='zipcode']");
    By lMobileNumber= By.xpath("//input[@data-qa='mobile_number']");
    By lContinue = By.xpath("//a[text()='Continue']");
}
