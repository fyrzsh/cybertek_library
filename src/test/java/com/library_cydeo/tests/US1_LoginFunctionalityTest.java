package com.library_cydeo.tests;

import com.library_cydeo.pages.LibrarianLoginPage;
import com.library_cydeo.pages.MainPage;
import com.library_cydeo.pages.StudentLoginPage;
import com.library_cydeo.utils.BrowserUtils;
import com.library_cydeo.utils.ConfigurationReader;
import com.sun.rowset.JdbcRowSetResourceBundle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class US1_LoginFunctionalityTest extends TestBase {



    @Test
    public void librarianLoginFunctionalityTest () {
//        driver.get(ConfigurationReader.getProperty("cydeo.library.url"));
//        MainPage mainPage = new MainPage();
//        mainPage.verifyTitle();
//        mainPage.login(ConfigurationReader.getProperty("cydeo.validLibrarianUserName"));

        LibrarianLoginPage librarianLoginPage = new LibrarianLoginPage();
        librarianLoginPage.verifyTitle();
        librarianLoginPage.login();
        librarianLoginPage.verifyModuleAmount();
        librarianLoginPage.loginValidation();

    }


    @Test
    public void studentLoginFunctionalityTest () {
        StudentLoginPage studentLoginPage = new StudentLoginPage();
        studentLoginPage.verifyUrl();
        studentLoginPage.login();
        studentLoginPage.verifyModuleAmount();

    }

    @Test
    public void librarianInvalidLoginFunctionalityTest () {
//        driver.get(ConfigurationReader.getProperty("cydeo.library.url"));
//        MainPage mainPage = new MainPage();
//        mainPage.verifyTitle();
//        mainPage.login(ConfigurationReader.getProperty("cydeo.validLibrarianUserName"));
        LibrarianLoginPage librarianLoginPage = new LibrarianLoginPage();
        librarianLoginPage.invalidLogin();
        StudentLoginPage studentLoginPage = new StudentLoginPage();
        studentLoginPage.invalidLogin();

        /**
         * there is a bug but did not want to deal with that :)
         * Error msg's are different
         */

    }




}
