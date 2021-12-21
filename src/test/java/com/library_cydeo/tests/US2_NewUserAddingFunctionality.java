package com.library_cydeo.tests;

import com.library_cydeo.pages.LibrarianLoginPage;
import org.testng.annotations.Test;

public class US2_NewUserAddingFunctionality extends TestBase {

    @Test
    public void librarianAddingNewUserTest () {
        LibrarianLoginPage librarianUser = new LibrarianLoginPage();
        librarianUser.login();
        librarianUser.addNewUser();
    }

}
