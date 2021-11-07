package com.cargill.mobile.qa.stepDef;

import com.cargill.mobile.qa.pages.LoginPage;
import com.cargill.mobile.qa.pages.ProductsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @When("I enter username as {string}")
    public void enterUsernameAs(String string) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(string);
    }

    @When("I enter password as {string}")
    public void enterPasswordAs(String string) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterPasswordName(string);
    }

    @When("I login")
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.pressLoginBtn();
    }

    @Then("Login should fail with an error message {string}")
    public void loginShouldFailWithAnErrorMessage(String string) {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.getErrText(), string);
    }

//    @Then("I should see Products page with title {String}")
//    public void iShouldSeeProductsPageWithTitle(String title) {
//        Assert.assertEquals(new ProductsPage().getTitle(), title);
//    }

}
