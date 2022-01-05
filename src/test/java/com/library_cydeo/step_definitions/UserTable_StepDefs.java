package com.library_cydeo.step_definitions;

import com.library_cydeo.pages.LibrarianUserManagementPage;
import com.library_cydeo.utils.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;


public class UserTable_StepDefs {
    LibrarianUserManagementPage userManagementPage = new LibrarianUserManagementPage();


    @Then("table should have following column names:")
    public void tableShouldHaveFollowingColumnNames(List<String> expTableHeads) {
        BrowserUtils.waitForVisibility(userManagementPage.actTableHeads.get(0), 5);
        //System.out.println(expTableHeads + "\n" + BrowserUtils.getElementsText(userManagementPage.actTableHeads));
        Assert.assertEquals(expTableHeads, BrowserUtils.getElementsText(userManagementPage.actTableHeads));
    }
}
