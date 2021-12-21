package com.library_cydeo.pages;

import com.library_cydeo.utils.BrowserUtils;
import com.library_cydeo.utils.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LibrarianLoginPage extends MainPage {

    public LibrarianLoginPage() {
        userName = ConfigurationReader.getProperty("cydeo.validLibrarianUserName");
    }

    @FindBy(xpath = "//span[.='Test Librarian 52']")
    public WebElement loginName;

    @FindBy (xpath = "//span[.=\'Users\']")
    public WebElement usersModule;

    @FindBy (xpath = "//span[.=\'Books\']")
    public WebElement booksModule;


    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")
    public WebElement addUserButton;

    @FindBy (xpath = "//a[@class=\'btn btn-lg btn-outline btn-primary btn-sm add_book_btn\']")
    public WebElement addBookButton;

    @FindBy(xpath = "//textarea[@id=\"description\"]")
    public WebElement descriptionField;

//    @FindBy(xpath = "//div[@class='form-group']/textarea")
//    public WebElement description;

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
        driver.findElement(By.xpath("//button[.='Save changes']")).click();

    }

    public void addNewBook () {
        BrowserUtils.sleep(2);
        booksModule.click();
        BrowserUtils.sleep(2);
        addBookButton.click();
        BrowserUtils.sleep(2);
        fillAddBookForm();
        BrowserUtils.sleep(2);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='toast-message']")).getText(), "The book has been created.", "User was not added!" );

    }

    public void fillAddBookForm () {
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(faker.book().publisher());
        driver.findElement(By.xpath("//input[@name='isbn']")).sendKeys("978-3-" + faker.number().numberBetween(1, 16) + "-142369-0");
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys(faker.number().numberBetween(1900, 2000)+"");
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys(faker.book().author());
        WebElement bookCategory = driver.findElement(By.xpath("//select[@id='book_group_id']"));
        Select select = new Select(bookCategory);
        select.selectByIndex(faker.number().numberBetween(1, 20));
        BrowserUtils.sleep(1);

//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOf(descriptionField));
        descriptionField.sendKeys(faker.lorem().paragraph(7));
        BrowserUtils.sleep(1);
        driver.findElement(By.xpath("//button[.='Save changes']")).click();
        BrowserUtils.sleep(2);




    }


}
