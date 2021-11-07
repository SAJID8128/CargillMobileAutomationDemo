package com.cargill.mobile.qa.pages;

import com.cargill.mobile.qa.utils.DriverManager;
import com.cargill.mobile.qa.utils.GlobalParams;
import com.cargill.mobile.qa.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public Utils utils = new Utils();
    private AppiumDriver<?> driver;

    public BasePage() {
        driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void waitForVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Utils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Utils.WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getAttribute(MobileElement element, String txt) {
        waitForVisibility(element);
        return element.getAttribute(txt);
    }

    public void click(MobileElement element) {
        waitForVisibility(element);
        element.click();
    }

    public void clear(MobileElement element) {
        waitForVisibility(element);
        element.clear();
    }

    public void sendKeys(MobileElement element, String txt) {
        waitForVisibility(element);
        element.sendKeys(txt);
    }

    public String getText(MobileElement element) {
        return getAttribute(element, "text");
    }

    public String getText(MobileElement element, String msg) {
        String txt;
        if("Android".equals(new GlobalParams().getPlatformName())) {
            txt = getAttribute(element, "text");
        } else {
            throw new IllegalStateException("Unexpected value: " + new GlobalParams().getPlatformName());
        }
        utils.log().info(msg + txt);
        return txt;
    }
}
