package com.cargill.mobile.qa.stepDef;

import com.cargill.mobile.qa.pages.LoginPage;
import io.cucumber.java.en.When;

public class LoginStepDef {

    @When("I enter username")
    public void i_enter_username(String string) {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUserName(string);
    }

}
