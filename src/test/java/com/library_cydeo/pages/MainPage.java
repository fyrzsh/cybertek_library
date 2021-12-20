package com.library_cydeo.pages;

import com.library_cydeo.utils.BrowserUtils;
import com.library_cydeo.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MainPage extends BasePage {

//    //Webdriver variable just in case any of children need
//    protected WebDriver driver;
//
//    public MainPage() {
//        driver = Driver.getDriver();
//        PageFactory.initElements(driver, this);
//    }

    String userName;   // = ConfigurationReader.getProperty("cydeo.validStudentUserName");
    String password = ConfigurationReader.getProperty("cydeo.validUserPassword");

    @FindBy(id = "inputEmail")
    public WebElement emailAddressField;

    @FindBy(id = "inputPassword")
    public WebElement passwordField;

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInBtn;

    @FindBy(xpath = "//div[@class='alert alert-danger']")
    public WebElement errorMsg;

    @FindBy(xpath = "//ul[@class='navbar-nav mr-auto']//li")
    public List<WebElement> modelList;





    public void login () {
        Assert.assertTrue(emailAddressField.isDisplayed());
        Assert.assertTrue(passwordField.isDisplayed());
        Assert.assertTrue(signInBtn.isDisplayed());
        login (userName, password);
    }

    public void login (String email, String password) {
        emailAddressField.sendKeys(email);
        passwordField.sendKeys(password);
        signInBtn.click();
    }

    public void invalidLogin () {

        Map <String, String> invalidLoginMatrix = new HashMap<>();
        invalidLoginMatrix.put(userName, faker.internet().password());
        invalidLoginMatrix.put(faker.name().username(), password );
        invalidLoginMatrix.put(faker.name().username(), faker.internet().password());
        invalidLoginMatrix.put("", "");

        boolean result = false;

        for (String s : invalidLoginMatrix.keySet()) {
            login(s, invalidLoginMatrix.get(s));
            BrowserUtils.sleep(3);
            if(errorMsg.isDisplayed()) {
                emailAddressField.clear();
                passwordField.clear();
                result = true;
            }
        }

        Assert.assertTrue(result);

    }

    public void verifyTitle () {
        Assert.assertEquals(driver.getTitle(), "Login - Library", "Title not Matching!");
    }

    public void verifyUrl () {
        Assert.assertEquals(driver.getCurrentUrl(), "https://library2.cybertekschool.com/login.html", "Not Matching!");
    }




}
