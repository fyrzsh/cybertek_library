package com.library_cydeo.pages;

import com.github.javafaker.Faker;
import com.library_cydeo.utils.ConfigurationReader;
import com.library_cydeo.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public abstract class BasePage {

    //Webdriver variable just in case any of children need
    protected WebDriver driver;
    protected Faker faker = new Faker();

    public BasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }



    public abstract void login ();

    public abstract void verifyUrl () ;

    public abstract void verifyTitle();

    public  abstract void loginValidation();

    public abstract void verifyModuleAmount ();








}
