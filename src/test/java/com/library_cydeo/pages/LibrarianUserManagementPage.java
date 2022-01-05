package com.library_cydeo.pages;

import com.library_cydeo.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LibrarianUserManagementPage {

    public LibrarianUserManagementPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (name = "tbl_users_length")
    public WebElement showRecordsDropdowns;

    @FindBy(xpath = "//tr[@role='row']/th")   //@FindBy(tagName = "//th")   //@FindBy(xpath = "//th")
    public List<WebElement> actTableHeads;
}
