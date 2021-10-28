package com.cargill.mobile.qa.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement userNameEditText;

    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement passwordEditText;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private MobileElement btnLogin;

    @AndroidFindBy(accessibility = "test-Error message")
    private MobileElement errorMessageTextView;

    // "return this" returns "LoginPage" class
    // Calling "clear" method from BasePage
    // Calling "sendKeys" method from BasePage
    public LoginPage enterUserName(String username) throws InterruptedException{
        clear(userNameEditText);
        sendKeys(userNameEditText, username);
        return this;
    }

    public LoginPage enterPassword(String password) throws InterruptedException{
        clear(passwordEditText);
        sendKeys(passwordEditText, password);
        return this;
    }

    public void pressLogBtn() {
        click(btnLogin);

    }



}
