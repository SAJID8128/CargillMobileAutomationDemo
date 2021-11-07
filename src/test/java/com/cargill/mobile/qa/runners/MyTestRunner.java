package com.cargill.mobile.qa.runners;

import com.cargill.mobile.qa.utils.DriverManager;
import com.cargill.mobile.qa.utils.GlobalParams;
import com.cargill.mobile.qa.utils.ServerManager;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

//@CucumberOptions(
//        // This parameter is for reporting.
//        plugin = {"pretty"
//                , "html:target/cucumber/report.html"
//                , "summary"
//                , "de.monochromatic.cucumber.report.PrettyReports:target/cucumber-html-reports"}
//        // This is for your "resource" folder location.
//        ,features = {"src/test/resources"}
//        // "glue" is the package name of your "resource" folder.
//        ,glue = {"com.cargill.mobile.qa"}
//        /* Snippets. When Cucumber encounters a Gherkin step without a matching step definition,
//           it will print a step definition snippet with a matching Cucumber Expression.*/
//        ,snippets = CAMELCASE
//        // "dryRun" is for if you want to run specific test cases or all the test cases.
//        ,dryRun = false
//        /* Strict: if strict option is set to false then at execution time if cucumber encounters any
//           undefined/pending steps then cucumber does not fail the execution and undefined steps are
//           skipped and BUILD is SUCCESSFUL.*/
//        ,strict = true
//        // "monochrome" also used for reporting.
//        ,monochrome = true
//        // The tag you want to run.
//        ,tags = "@SmokeTest"
//
//----------WITH THE USE OF MAIN METHOD----------
//    public static void main(String[] args) {
//        GlobalParams params = new GlobalParams();
//        params.initializeGlobalParams();
//
//        ServerManager serverManager = new ServerManager();
//        serverManager.startServer();
//
//        try{
//            DriverManager driverManager = new DriverManager();
//            driverManager.initializeDriver();
//
//            LoginPage loginPage = new LoginPage();
//            loginPage.enterUserName("Nyla");
//            loginPage.enterPasswordName("Password");
//            loginPage.pressLoginBtn();
//           // driverManager.getDriver().quit();
//           // serverManager.getServer().stop();
//        } catch (Exception ex) {
//
//        }

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
                , "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"}
        // This is for your "resource" folder location.
        , features = {"src/test/resources"}
        // "glue" is the package name of your "resource" folder.
        , glue = {"com.cargill.mobile.qa"}
        /* Snippets. When Cucumber encounters a Gherkin step without a matching step definition,
           it will print a step definition snippet with a matching Cucumber Expression.*/
        , snippets = CAMELCASE
        // "dryRun" is for if you want to run specific test cases or all the test cases.
        , dryRun = false
        // "monochrome" also used for reporting.
        , monochrome = true
        /* Strict: if strict option is set to false then at execution time if cucumber encounters any
           undefined/pending steps then cucumber does not fail the execution and undefined steps are
           skipped and BUILD is SUCCESSFUL.*/
        , strict = true
        // The tag you want to run.
        , tags = "@Test"

)
public class MyTestRunner {

    @BeforeClass
    public static void initialize() throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        ServerManager serverManager = new ServerManager();
        serverManager.startServer();
        DriverManager driverManager = new DriverManager();
        driverManager.initializeDriver();
    }

    @AfterClass
    public static void quit() {

//        DriverManager driverManager = new DriverManager();
//        if (driverManager.getDriver() != null) {
//            driverManager.getDriver().quit();
//            driverManager.setDriver(null);
//        }
//        ServerManager serverManager = new ServerManager();
//        if (serverManager.getServer() != null) {
//            serverManager.getServer().stop();
//        }
    }

}
