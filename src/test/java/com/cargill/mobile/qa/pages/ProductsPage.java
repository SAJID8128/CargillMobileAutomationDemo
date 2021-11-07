package com.cargill.mobile.qa.pages;

import com.cargill.mobile.qa.utils.GlobalParams;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class ProductsPage extends LoginPage {

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-PRODUCTS\"]/preceding-sibling::android.view.ViewGroup/android.widget.TextView")
    private MobileElement titleTxt;

    public String getTitle() {
        return getText(titleTxt, "product page title is - ");
    }

//    public String getProductTitle(String title) throws Exception {
//        if ("Android".equals(new GlobalParams().getPlatformName())) {
//            return
//                    getText(andScrollToElementUsingUiScrollable("text", title)),"product title is: " + title);
//        }
//        throw new Exception("Invalid platform name");
//    }

//    public By defProuductPrice(String title) throws Exception {
//
//        if ("Android".equals(new GlobalParams().getPlatformName())) {
//            return By.xpath(("//*[@text=\"" + title + "\"]/following-sibling::*[@content-desc=\"test-Price\"]");
//        }
//        throw new Exception("Invalid platform name");
//
//        public String getProductPrice (String title, String price) throws Exception {
//            return getText(scrollToElement(defProductPrice(title), "up"), "product price is: " + price);
//        }

    }



