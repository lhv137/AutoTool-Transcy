package pageObject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.Locators;

public class SwiftPO extends AbstractPage {

    WebDriver driver;

    public SwiftPO(WebDriver driver) {
        super(driver);
    }

//  LOGIN PARTNER
    public void clickToLoginPartnerBtn() throws InterruptedException {
        waitToElementClickable(Locators.LOGIN_SHOPIFY_PARTNER_BUTTON);
        clickToElement(Locators.LOGIN_SHOPIFY_PARTNER_BUTTON);
        Thread.sleep(3000);
    }
    public void inputToEmailAccountPartner(String Email) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_EMAIL_PARTNER_ACCOUNT);
        sendKeyToElement(Locators.ENTER_EMAIL_PARTNER_ACCOUNT, Email);
        Thread.sleep(3000);
    }
    public void clickToContinueWithEmailBtn() throws InterruptedException {
        waitToElementClickable(Locators.CONTINUE_WITH_EMAIL_BUTTON);
        clickToElement(Locators.CONTINUE_WITH_EMAIL_BUTTON);
        Thread.sleep(5000);
    }
    public void inputTPasswordAccountPartner(String passWord) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT);
        sendKeyToElement(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT, passWord);
        Thread.sleep(5000);
    }
    public void clickToLoginBtn() throws InterruptedException {
        waitToElementClickable(Locators.LOGIN_PARTNER_BUTTON);
        clickToElement(Locators.LOGIN_PARTNER_BUTTON);
        Thread.sleep(5000);
    }
    public void clickToUseARecoveryCodeBtn() throws InterruptedException {
        waitToElementClickable(Locators.SELECT_USE_RECOVERY_CODE);
        clickToElement(Locators.SELECT_USE_RECOVERY_CODE);
        Thread.sleep(5000);
    }
    public void inputRecoveryCode(String recoveryCode) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_RECOVERY_CODE);
        sendKeyToElement(Locators.ENTER_RECOVERY_CODE, recoveryCode);
        Thread.sleep(5000);
    }
    public void clickToLoginPartnerAfterInputCodeBtn() throws InterruptedException {
        waitToElementClickable(Locators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
        clickToElement(Locators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
        Thread.sleep(3000);
    }
    //    SELECT PARTNER
    public void clickToSelectPartnerBtn() throws InterruptedException {
        waitToElementClickable(Locators.SELECT_PARTNER_ACCOUNTS);
        clickToElement(Locators.SELECT_PARTNER_ACCOUNTS);
        Thread.sleep(7000);
    }
    //    CREATE STORE TEST
    public void selectMenuStoresBtn() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_MENU_STORES_BUTTON));
        clickToElement(Locators.SELECT_MENU_STORES_BUTTON);
        Thread.sleep(3000);
    }
    public void clickToAddStore() throws InterruptedException {
        waitToElementClickable((Locators.SECLECT_ADD_STORE_BUTTON));
        clickToElement(Locators.SECLECT_ADD_STORE_BUTTON);
        Thread.sleep(3000);
    }
    public void clickToCreateDevelopmentStore() throws InterruptedException {
        waitToElementClickable(Locators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
        clickToElement(Locators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
        Thread.sleep(5000);
    }
    public void selectOptionStoreTest() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(15));
////        switchToFrameOrIframe(Locators.FRAME_SHOPIFY_PAGE);
        waitToElementClickable(Locators.SELECT_OPTION_STORE_TEST);
        clickToElement(Locators.SELECT_OPTION_STORE_TEST);
        Thread.sleep(3000);
    }
    public void inputStoreName(String storeName) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_STORE_NAME);
        sendKeyToElement(Locators.ENTER_STORE_NAME, storeName);
        scrollToEndOfPage();
        Thread.sleep(5000);
    }
    public void selectOprionStartWithTestData() throws InterruptedException {
        waitToElementClickable(Locators.SELECT_START_WITH_TEST_DATA);
        clickToElement(Locators.SELECT_START_WITH_TEST_DATA);
        Thread.sleep(5000);
    }
    public void clickToAddDevelopmentStoreBtn() throws InterruptedException {
        waitToElementClickable(Locators.CREATE_DEVELOPMENT_STORE_BUTTON);
        clickToElement(Locators.CREATE_DEVELOPMENT_STORE_BUTTON);
        Thread.sleep(20000);
    }
    public void clickToChooseAccountBtn() throws InterruptedException {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        waitToElementClickable(Locators.CLICK_TO_CHOOSE_ACCOUNT);
        clickToElement(Locators.CLICK_TO_CHOOSE_ACCOUNT);
        Thread.sleep(10000);
    }
}
