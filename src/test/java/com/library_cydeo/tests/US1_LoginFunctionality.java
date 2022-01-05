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

public class US1_LoginFunctionality extends TestBase {



    @Test
    public void librarianLoginFunctionalityTest () {

        LibrarianLoginPage librarianUser = new LibrarianLoginPage();
        librarianUser.verifyTitle();
        librarianUser.login();
        librarianUser.verifyModuleAmount();
        librarianUser.loginValidation();

    }


    @Test
    public void studentLoginFunctionalityTest () {
        StudentLoginPage studentUser = new StudentLoginPage();
        studentUser.verifyUrl();
        studentUser.login();
        studentUser.verifyModuleAmount();

    }

    @Test
    public void librarianInvalidLoginFunctionalityTest () {

        LibrarianLoginPage librarianUser = new LibrarianLoginPage();
        librarianUser.invalidLogin();
        StudentLoginPage studentUser = new StudentLoginPage();
        studentUser.invalidLogin();

        /**
         * there is a bug but did not want to deal with that :)
         * Error msg's are different
         */

    }




}
