package com.cargill.mobile.qa.stepDef;

import com.cargill.mobile.qa.pages.LoginPage;
import io.cucumber.java.en.When;

public class LoginStepDef {



    @When("I enter username as {string}")
    public void i_enter_username_as(String string) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(string);
    }


}
