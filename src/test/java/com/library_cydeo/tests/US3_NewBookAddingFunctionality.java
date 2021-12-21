package com.library_cydeo.tests;

import com.library_cydeo.pages.LibrarianLoginPage;
import org.testng.annotations.Test;

public class US3_NewBookAddingFunctionality extends TestBase {

    @Test
    public void librarianAddingNewBookTest () {
        LibrarianLoginPage librarianUser = new LibrarianLoginPage();
        librarianUser.login();
        librarianUser.addNewBook();
    }




}
