package com.library_cydeo.pages;

import com.library_cydeo.utils.BrowserUtils;
import com.library_cydeo.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class StudentLoginPage extends MainPage {
    public StudentLoginPage() {
        userName = ConfigurationReader.getProperty("cydeo.validStudentUserName");
    }

    @FindBy(xpath = "//span[.='Test Student 106']")
    public WebElement loginName;


    @Override
    public void loginValidation() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(loginName));
        Assert.assertTrue(loginName.getText().toLowerCase().contains("student"), "Does not contain!");
    }

    public void verifyModuleAmount () {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(modelList.get(0)));
        BrowserUtils.sleep(2);
        Assert.assertTrue(modelList.size() == 2);
    }





}
