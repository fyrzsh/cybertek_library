package com.library_cydeo.tests;

import com.library_cydeo.utils.ConfigurationReader;
import com.library_cydeo.utils.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {

    protected WebDriver driver;
    protected Faker faker = new Faker();
    protected Actions actions;
    //protected WebDriverWait wait = new WebDriverWait(driver, 10);

    @BeforeClass
    public void setUp (){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        driver.get(ConfigurationReader.getProperty("cydeo.library.url"));


    }

    @AfterClass
    public void tearDown () {
        //Driver.closeDriver();  // it will close the driver object and make it null
        driver.quit();
    }




}