package pageObject;

import commons.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageUI.Locators;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TranscyPO extends AbstractPage {
    WebDriver driver;
    public String storeURL;
    AbstractTest abstractTest = new AbstractTest();

    public TranscyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToStartFreeTrialBtn() {
        waitToElementClickable(Locators.LOGIN_SHOPIFY_PARTNER_BUTTON);
        clickToElement(Locators.LOGIN_SHOPIFY_PARTNER_BUTTON);
    }
}
