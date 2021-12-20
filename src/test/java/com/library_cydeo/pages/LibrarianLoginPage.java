package com.library_cydeo.pages;

import com.library_cydeo.utils.BrowserUtils;
import com.library_cydeo.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LibrarianLoginPage extends MainPage {

    public LibrarianLoginPage() {
        userName = ConfigurationReader.getProperty("cydeo.validLibrarianUserName");
    }

    @FindBy(xpath = "//span[.='Test Librarian 52']")
    public WebElement loginName;

    @FindBy (xpath = "//span[.=\'Users\']")
    public WebElement usersModule;


    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUserButton;

//    @FindBy(how = How.CLASS_NAME, using = "card card-body shadow")
//    public List<WebElement> modelList;


    @Override
    public void loginValidation() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(loginName));
        Assert.assertTrue(loginName.getText().toLowerCase().contains("librarian"), "Does not contain!");
    }

    public void verifyModuleAmount () {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(modelList.get(0)));
        BrowserUtils.sleep(2);
        Assert.assertTrue(modelList.size() == 3);
    }

    public void addNewUser () {
        BrowserUtils.sleep(3);
        usersModule.click();
        BrowserUtils.sleep(3);
        addUserButton.click();
        BrowserUtils.sleep(3);
        fillAddUserForm();
        BrowserUtils.sleep(3);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText(), "The user has been created.", "User was not added!" );

    }

    public void fillAddUserForm () {
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(faker.internet().password());
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(faker.internet().emailAddress());
//        new Select(driver.findElement(By.xpath("//input[@name='user_group_id']"))).selectByVisibleText("Librarian");
//        new Select(driver.findElement(By.xpath("//input[@name='status']"))).selectByVisibleText("ACTIVE");
//        driver.findElement(By.xpath("//input[@name='start_date']")).sendKeys(faker.date().toString());
//        driver.findElement(By.xpath("//input[@name='end_date']")).sendKeys(faker.date().);
        driver.findElement(By.xpath("//button[.='Save changes']")).click();






    }



}
