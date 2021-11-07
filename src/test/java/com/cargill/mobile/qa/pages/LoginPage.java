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

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView")
    private MobileElement errorMessageTextView;


    public LoginPage enterUserName(String userName) {
        clear(userNameEditText);
        sendKeys(userNameEditText, userName);
        return this;
    }

    public LoginPage enterPasswordName(String password) {
        clear(passwordEditText);
        sendKeys(passwordEditText, password);
        return this;
    }

    public ProductsPage pressLoginBtn() {
        click(btnLogin);
        return new ProductsPage();
    }

//    public ProductsPage login(String username, String password) throws InterruptedException{
//        enterUserName(username);
//        enterPasswordName(password);
//        return new ProductsPage();
//    }

    public String getErrText() {
        return getText(errorMessageTextView);
    }
}
