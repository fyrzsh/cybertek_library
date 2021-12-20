package com.library_cydeo.tests;

import com.library_cydeo.pages.LibrarianLoginPage;
import org.testng.annotations.Test;

public class US2_NewUserAddingFunctionalityTest extends TestBase {

    @Test
    public void librarianAddingNewUserTest () {
        LibrarianLoginPage librarianLoginPage = new LibrarianLoginPage();
        librarianLoginPage.login();
        librarianLoginPage.addNewUser();
    }

}
