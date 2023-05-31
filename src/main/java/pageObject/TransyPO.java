package pageObject;

import commons.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageUI.Locators;

public class TransyPO extends AbstractPage {
    WebDriver driver;
    public String storeURL;

    public TransyPO(WebDriver driver) {
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

    public void selectMenuStoresBtn(){
        waitToElementClickable((Locators.SELECT_MENU_STORES_BUTTON));
        clickToElement(Locators.SELECT_MENU_STORES_BUTTON);
    }

    public void clickToAddStore(){
//        WebDriver iFrame = driver.findElement(By.tagName(""));
//        driver.switchTo().frame(iFrame);
        waitToElementClickable((Locators.SECLECT_ADD_STORE_BUTTON));
        clickToElement(Locators.SECLECT_ADD_STORE_BUTTON);
    }

    public void clickToCreateDevelopmentStore(){
        waitToElementClickable(Locators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
        clickToElement(Locators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
    }

    public void selectOptionStoreTest(){
        waitToElementClickable(Locators.SELECT_OPTION_STORE_TEST);
        clickToElement(Locators.SELECT_OPTION_STORE_TEST);
    }

    public void inputStoreName(String storeName) {
        waitToElementVisible(Locators.ENTER_STORE_NAME);
        sendKeyToElement(Locators.ENTER_STORE_NAME, storeName);
    }

    public void selectOprionStartWithTestData(){
        waitToElementClickable(Locators.SELECT_START_WITH_TEST_DATA);
        clickToElement(Locators.SELECT_START_WITH_TEST_DATA);
    }

    public void clickToDevelopmentStoreBtn(){
        waitToElementClickable(Locators.CREATE_DEVELOPEMENT_STORE_BUTTON);
        clickToElement(Locators.CREATE_DEVELOPEMENT_STORE_BUTTON);
    }



}
