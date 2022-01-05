package com.library_cydeo.step_definitions;

import com.library_cydeo.pages.LibrarianLandingPage;
import com.library_cydeo.pages.LibrarianUserManagementPage;
import com.library_cydeo.pages.LoginPage;
import com.library_cydeo.utils.BrowserUtils;
import com.library_cydeo.utils.ConfigurationReader;
import com.library_cydeo.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.util.List;

public class Login_StepDefs {
    LoginPage loginPage = new LoginPage();
    LibrarianLandingPage librarianLandingPage = new LibrarianLandingPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//    LibrarianUserManagementPage userManagementPage = new LibrarianUserManagementPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.library.url"));

    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("cydeo.validLibrarianUserName"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("cydeo.validUserPassword"));
        loginPage.signInButton.click();

    }


    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expected = "dashboard";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expected));

        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver(); // important.
    }

    @When("I login as a student")
    public void iLoginAsAStudent() {
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("cydeo.validStudentUserName"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("cydeo.validUserPassword"));
        loginPage.signInButton.click();
    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {


        String expected = "books";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.urlContains(expected));

        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));

        Driver.closeDriver();

    }


    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.usernameInput.sendKeys(username);

    }

    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.passwordInput.sendKeys(password);
    }

    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInButton.click();
    }


    @And("there should be {int} users")
    public void thereShouldBeUsers(int userNum) {
        String expectedUserNumber = userNum + "";
        wait.until(ExpectedConditions.visibilityOf(librarianLandingPage.userCount));
        String  actualUserNumber = librarianLandingPage.userCount.getText();
        Assert.assertEquals("Actual user number is not as expected", expectedUserNumber, actualUserNumber);
    }


    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signInButton.click();
    }

    @Then("account holder name should be {string}")
    public void accountHolderNameShouldBe(String expAccUsername) {
        BrowserUtils.waitForVisibility(librarianLandingPage.accountUsername, 5);

        String actAccUsername = librarianLandingPage.accountUsername.getText();

        Assert.assertEquals("Account username is not ax expected!", expAccUsername, actAccUsername);

        Driver.closeDriver();   // this will close the driver to run the new one. Orr we need to log out

    }


}
