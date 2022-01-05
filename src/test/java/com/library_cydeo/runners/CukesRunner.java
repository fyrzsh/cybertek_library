package com.library_cydeo.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Giving the location of our feature
@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "html:target/cucumber-report.html"
        },


        features = "src/test/resources/features",            //different package -- copy path - from ROOT
        glue = "com/library_cydeo/step_definitions",              //same package -- copy path - same package
        dryRun = false,                                      // when it is false, the test will run, when it is not, they won't
        tags =   "@all_accounts and not @librarians"   //"@librarianParam or @studentParam"   //"@lyft or @etsy"
        //tags  = "@etsy"
)

public class CukesRunner {
}
