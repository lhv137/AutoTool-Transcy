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
    public commons.PageGeneratorManager PageGeneratorManager;
    WebDriver driver;
    public String storeURL;
    AbstractTest abstractTest = new AbstractTest();

    public TranscyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//    LOGIN PARTNER
    public void clickToLoginPartnerBtn() {
        waitToElementClickable(Locators.LOGIN_SHOPIFY_PARTNER_BUTTON);
        clickToElement(Locators.LOGIN_SHOPIFY_PARTNER_BUTTON);
    }

    public void inputToEmailAccountPartner(String Email) {
        waitToElementVisible(Locators.ENTER_EMAIL_PARTNER_ACCOUNT);
        sendKeyToElement(Locators.ENTER_EMAIL_PARTNER_ACCOUNT, Email);
    }

    public void clickToContinueWithEmailBtn() {
        waitToElementClickable(Locators.CONTINUE_WITH_EMAIL_BUTTON);
        clickToElement(Locators.CONTINUE_WITH_EMAIL_BUTTON);
    }

    public void inputTPasswordAccountPartner(String Password) {
        waitToElementVisible(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT);
        sendKeyToElement(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT, Password);
    }

    public void clickToLoginBtn() {
        waitToElementClickable(Locators.LOGIN_PARTNER_BUTTON);
        clickToElement(Locators.LOGIN_PARTNER_BUTTON);
    }

    public void clickToUseARecoveryCodeBtn() {
        waitToElementClickable(Locators.SELECT_USE_RECOVERY_CODE);
        clickToElement(Locators.SELECT_USE_RECOVERY_CODE);
    }

    public void inputRecoveryCode(String RecoveryCode) {
        waitToElementVisible(Locators.ENTER_RECOVERY_CODE);
        sendKeyToElement(Locators.ENTER_RECOVERY_CODE, RecoveryCode);
    }

    public void clickToLoginPartnerAfterInputCodeBtn() {
        waitToElementClickable(Locators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
        clickToElement(Locators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
    }

//    SELECT PARTNER

    public void clickToSelectPartnerBtn() {
        waitToElementClickable(Locators.SELECT_PARTNER_ACCOUNTS);
        clickToElement(Locators.SELECT_PARTNER_ACCOUNTS);
    }



}
