package pageObject;

import commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import pageUI.SwiftLocators;

public class SwiftPO extends AbstractPage {

    WebDriver driver;

    public SwiftPO(WebDriver driver) {
        super(driver);
    }

//  LOGIN PARTNER
    public void clickToLoginPartnerBtn() throws InterruptedException {
        waitToElementClickable(SwiftLocators.LOGIN_SHOPIFY_PARTNER_BUTTON);
        clickToElement(SwiftLocators.LOGIN_SHOPIFY_PARTNER_BUTTON);
        Thread.sleep(3000);
    }
    public void inputToEmailAccountPartner(String Email) throws InterruptedException {
        waitToElementVisible(SwiftLocators.ENTER_EMAIL_PARTNER_ACCOUNT);
        sendKeyToElement(SwiftLocators.ENTER_EMAIL_PARTNER_ACCOUNT, Email);
        Thread.sleep(3000);
    }
    public void clickToContinueWithEmailBtn() throws InterruptedException {
        waitToElementClickable(SwiftLocators.CONTINUE_WITH_EMAIL_BUTTON);
        clickToElement(SwiftLocators.CONTINUE_WITH_EMAIL_BUTTON);
        Thread.sleep(5000);
    }
    public void inputTPasswordAccountPartner(String passWord) throws InterruptedException {
        waitToElementVisible(SwiftLocators.ENTER_PASSWORD_PARTNER_ACCOUNT);
        sendKeyToElement(SwiftLocators.ENTER_PASSWORD_PARTNER_ACCOUNT, passWord);
        Thread.sleep(5000);
    }
    public void clickToLoginBtn() throws InterruptedException {
        waitToElementClickable(SwiftLocators.LOGIN_PARTNER_BUTTON);
        clickToElement(SwiftLocators.LOGIN_PARTNER_BUTTON);
        Thread.sleep(5000);
    }
    public void clickToUseARecoveryCodeBtn() throws InterruptedException {
        waitToElementClickable(SwiftLocators.SELECT_USE_RECOVERY_CODE);
        clickToElement(SwiftLocators.SELECT_USE_RECOVERY_CODE);
        Thread.sleep(5000);
    }
    public void inputRecoveryCode(String recoveryCode) throws InterruptedException {
        waitToElementVisible(SwiftLocators.ENTER_RECOVERY_CODE);
        sendKeyToElement(SwiftLocators.ENTER_RECOVERY_CODE, recoveryCode);
        Thread.sleep(5000);
    }
    public void clickToLoginPartnerAfterInputCodeBtn() throws InterruptedException {
        waitToElementClickable(SwiftLocators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
        clickToElement(SwiftLocators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
        Thread.sleep(3000);
    }
    //    SELECT PARTNER
    public void clickToSelectPartnerBtn() throws InterruptedException {
        waitToElementClickable(SwiftLocators.SELECT_PARTNER_ACCOUNTS);
        clickToElement(SwiftLocators.SELECT_PARTNER_ACCOUNTS);
        Thread.sleep(7000);
    }
    //    CREATE STORE TEST
    public void selectMenuStoresBtn() throws InterruptedException {
        waitToElementClickable((SwiftLocators.SELECT_MENU_STORES_BUTTON));
        clickToElement(SwiftLocators.SELECT_MENU_STORES_BUTTON);
        Thread.sleep(3000);
    }
    public void clickToAddStore() throws InterruptedException {
        waitToElementClickable((SwiftLocators.SECLECT_ADD_STORE_BUTTON));

        clickToElement(SwiftLocators.SECLECT_ADD_STORE_BUTTON);
        Thread.sleep(3000);
    }
    public void clickToCreateDevelopmentStore() throws InterruptedException {
        waitToElementClickable(SwiftLocators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
        clickToElement(SwiftLocators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
        Thread.sleep(5000);
    }
    public void selectOptionStoreTest() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(15));
////        switchToFrameOrIframe(SwiftLocators.FRAME_SHOPIFY_PAGE);
        waitToElementClickable(SwiftLocators.SELECT_OPTION_STORE_TEST);
        clickToElement(SwiftLocators.SELECT_OPTION_STORE_TEST);
        Thread.sleep(3000);
    }
    public void inputStoreName(String storeName) throws InterruptedException {
        waitToElementVisible(SwiftLocators.ENTER_STORE_NAME);
        sendKeyToElement(SwiftLocators.ENTER_STORE_NAME, storeName);
        scrollToEndOfPage();
        Thread.sleep(5000);
    }
    public void selectOprionStartWithTestData() throws InterruptedException {
        waitToElementClickable(SwiftLocators.SELECT_START_WITH_TEST_DATA);
        clickToElement(SwiftLocators.SELECT_START_WITH_TEST_DATA);
        Thread.sleep(5000);
    }
    public void clickToAddDevelopmentStoreBtn() throws InterruptedException {
        waitToElementClickable(SwiftLocators.CREATE_DEVELOPMENT_STORE_BUTTON);
        clickToElement(SwiftLocators.CREATE_DEVELOPMENT_STORE_BUTTON);
        Thread.sleep(25000);
    }
    public void clickToChooseAccountBtn() throws InterruptedException {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        waitToElementClickable(SwiftLocators.CLICK_TO_CHOOSE_ACCOUNT);
        clickToElement(SwiftLocators.CLICK_TO_CHOOSE_ACCOUNT);
        Thread.sleep(10000);
    }
}
