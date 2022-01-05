package com.library_cydeo.step_definitions;


import com.library_cydeo.pages.LibrarianLandingPage;
import com.library_cydeo.pages.LibrarianUserManagementPage;
import com.library_cydeo.pages.PageBase;
import com.library_cydeo.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Page_Navigation_StepDefs {

    LibrarianUserManagementPage librarianUserManagementPage = new LibrarianUserManagementPage();
    //PageBase pageBase = new PageBase();
    LibrarianLandingPage librarianLandingPage = new LibrarianLandingPage();
    Select select;

    @When("I click on {string} link")
    public void i_click_on_link(String link) {
        BrowserUtils.waitForVisibility(librarianLandingPage.dashboardPageLink, 5);

        switch (link.toLowerCase()) {

            case "dashboard":
                librarianLandingPage.dashboardPageLink.click();
                break;
            case "users":
                librarianLandingPage.userPageLink.click();
                break;
            case "books":
                librarianLandingPage.booksPageLink.click();
                break;
        }
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {
        BrowserUtils.waitForVisibility(librarianUserManagementPage.showRecordsDropdowns, 5);
        select = new Select(librarianUserManagementPage.showRecordsDropdowns);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "10");

    }

    @Then("ow records should have following options:")
    public void ow_records_should_have_following_options(List <String> options) {

        select = new Select(librarianUserManagementPage.showRecordsDropdowns);
        List<WebElement> selectOptions = select.getOptions();

        List<String> list = BrowserUtils.getElementsText(selectOptions);

        Assert.assertEquals(options, list);

    }

}
