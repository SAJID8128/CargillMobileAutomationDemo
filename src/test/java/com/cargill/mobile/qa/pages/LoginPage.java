package com.cargill.mobile.qa.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement userNameEditText;

    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement passwordEditText;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private MobileElement btnLogin;

    @AndroidFindBy(accessibility = "test-Error message")
    private MobileElement errorMessageTextEdit;

    public LoginPage enterUserName(String userName) {
        //clear(userNameEditText);
       // sendKeys(userNameEditText, userName);
        return this;
    }

    public LoginPage enterPasswordName(String password) {
        clear(passwordEditText);
        sendKeys(passwordEditText, password);
        return this;
    }

    public void pressLoginBtn() {
        click(btnLogin);
    }

}
