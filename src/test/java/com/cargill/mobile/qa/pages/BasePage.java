package com.cargill.mobile.qa.pages;

import com.cargill.mobile.qa.utils.DriverManager;
import com.cargill.mobile.qa.utils.Utils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private AppiumDriver<?> driver;

    public BasePage() {
        driver = new DriverManager().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // "WAIT" is an enum variable and that's why we must capitalize it.
    // This same method can be done using "By" as you can see below.
    public void waitForVisibility(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Utils.WAIT);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForVisibility(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Utils.WAIT);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }

    // Note: We have called "waitForVisibility" method to make sure the element being clicked is first visible.
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
}
