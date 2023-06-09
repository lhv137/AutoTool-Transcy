package pageObject;

import commons.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.remote.server.handler.interactions.SendKeyToActiveElement;
import pageUI.Locators;

import java.time.Duration;


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
    public void inputToEmailAccountPartner(String Email) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_EMAIL_PARTNER_ACCOUNT);
        sendKeyToElement(Locators.ENTER_EMAIL_PARTNER_ACCOUNT, Email);
    }
    public void clickToContinueWithEmailBtn() throws InterruptedException {
        waitToElementClickable(Locators.CONTINUE_WITH_EMAIL_BUTTON);
        clickToElement(Locators.CONTINUE_WITH_EMAIL_BUTTON);
    }
    public void inputTPasswordAccountPartner(String passWord) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT);
        sendKeyToElement(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT, passWord);
    }
    public void clickToLoginBtn() {
        waitToElementClickable(Locators.LOGIN_PARTNER_BUTTON);
        clickToElement(Locators.LOGIN_PARTNER_BUTTON);
    }
    public void clickToUseARecoveryCodeBtn() {
        waitToElementClickable(Locators.SELECT_USE_RECOVERY_CODE);
        clickToElement(Locators.SELECT_USE_RECOVERY_CODE);
    }
    public void inputRecoveryCode(String recoveryCode) {
        waitToElementVisible(Locators.ENTER_RECOVERY_CODE);
        sendKeyToElement(Locators.ENTER_RECOVERY_CODE, recoveryCode);
    }
    public void clickToLoginPartnerAfterInputCodeBtn() {
        waitToElementClickable(Locators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
        clickToElement(Locators.LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON);
    }
//    SELECT PARTNER
    public void clickToSelectPartnerBtn() throws InterruptedException {
        waitToElementClickable(Locators.SELECT_PARTNER_ACCOUNTS);
        clickToElement(Locators.SELECT_PARTNER_ACCOUNTS);
        Thread.sleep(4000);
    }
//    CREATE STORE TEST
    public void selectMenuStoresBtn(){
        waitToElementClickable((Locators.SELECT_MENU_STORES_BUTTON));
        clickToElement(Locators.SELECT_MENU_STORES_BUTTON);
    }
    public void clickToAddStore(){
        waitToElementClickable((Locators.SECLECT_ADD_STORE_BUTTON));
        clickToElement(Locators.SECLECT_ADD_STORE_BUTTON);
    }
    public void clickToCreateDevelopmentStore(){
        waitToElementClickable(Locators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
        clickToElement(Locators.DROPDOWN_CLICK_DEVELOPMENT_STORE);
    }
    public void selectOptionStoreTest() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(15));
////        switchToFrameOrIframe(Locators.FRAME_SHOPIFY_PAGE);
        Thread.sleep(5000);
        waitToElementClickable(Locators.SELECT_OPTION_STORE_TEST);
        clickToElement(Locators.SELECT_OPTION_STORE_TEST);
    }
    public void inputStoreName(String storeName) {
        waitToElementVisible(Locators.ENTER_STORE_NAME);
        sendKeyToElement(Locators.ENTER_STORE_NAME, storeName);
        scrollToEndOfPage();
    }
    public void selectOprionStartWithTestData(){
        waitToElementClickable(Locators.SELECT_START_WITH_TEST_DATA);
        clickToElement(Locators.SELECT_START_WITH_TEST_DATA);
    }
    public void clickToAddDevelopmentStoreBtn() throws InterruptedException {
        waitToElementClickable(Locators.CREATE_DEVELOPMENT_STORE_BUTTON);
        clickToElement(Locators.CREATE_DEVELOPMENT_STORE_BUTTON);
    }
    public void clickToChooseAccountBtn() throws InterruptedException {
        waitToElementClickable(Locators.CLICK_TO_CHOOSE_ACCOUNT);
        clickToElement(Locators.CLICK_TO_CHOOSE_ACCOUNT);
    }
//    ADD STORE TEST ADMIN TOOL
    public void inputUserNameAdminTool(String userNameAdmin) {
        waitToElementVisible(Locators.FILL_USERNAME_ADMIN_TOOL);
        sendKeyToElement(Locators.FILL_USERNAME_ADMIN_TOOL, userNameAdmin);
    }
    public void inputPassWordAdminTool(String passWordAdmin) {
        waitToElementVisible(Locators.FILL_PASSWORD_ADMIN_TOOL);
        sendKeyToElement(Locators.FILL_PASSWORD_ADMIN_TOOL, passWordAdmin);
    }
    public void clickToLoginAdminToolBtn() {
        waitToElementClickable(Locators.ENTER_LOGIN_ADMIN_TOOL_BUTTON);
        clickToElement(Locators.ENTER_LOGIN_ADMIN_TOOL_BUTTON);
    }
    public void clickToManageTestStoreBtn() {
        waitToElementClickable(Locators.CLICK_MANGE_TEST_STORE_BUTTON);
        clickToElement(Locators.CLICK_MANGE_TEST_STORE_BUTTON);
    }
    public void inputStoreTestDomain(String storeDomain) {
        waitToElementVisible(Locators.FILL_STORE_TEST_ADMIN_TOOL);
        sendKeyToElement(Locators.FILL_STORE_TEST_ADMIN_TOOL, storeDomain);
    }
    public void clickToAddTestStoreBtn() throws InterruptedException {
        waitToElementClickable(Locators.CLICK_ADD_STORE_TEST_BUTTON);
        clickToElement(Locators.CLICK_ADD_STORE_TEST_BUTTON);
        Thread.sleep(2000);
    }

//    INSTALL TRANSCY UAT V4 APP

    public void selectMenuAppsBtn(){
        waitToElementClickable((Locators.SELECT_MENU_APPS_BUTTON));
        clickToElement(Locators.SELECT_MENU_APPS_BUTTON);
    }
    public void searchAppTranscyUATV4(String appName) {
        waitToElementVisible(Locators.SEARCH_TRANSCY_UAT_V4_APP);
        sendKeyToElement(Locators.SEARCH_TRANSCY_UAT_V4_APP, appName);
        sendKeyBoardToElement(Locators.SEARCH_TRANSCY_UAT_V4_APP, Keys.ENTER);
    }
    public void clickToSelectTranscyUATV4App(){
        waitToElementClickable((Locators.SELECT_TRANSCY_UAT_V4_APP));
        clickToElement(Locators.SELECT_TRANSCY_UAT_V4_APP);
    }
    public void clickToSelectStoreBtn(){
        waitToElementClickable((Locators.SELECT_STORE_BUTTON_TO_INSTALL_TRANSCY_APP));
        clickToElement(Locators.SELECT_STORE_BUTTON_TO_INSTALL_TRANSCY_APP);
    }
    public void searchStoreDomainToInstallApp(String storeDomain) throws InterruptedException {
        waitToElementVisible(Locators.SEARCH_STORE_TO_INSTALL_TRANSCY_APP);
        sendKeyToElement(Locators.SEARCH_STORE_TO_INSTALL_TRANSCY_APP, storeDomain);
        Thread.sleep(3000);
        sendKeyBoardToElement(Locators.SEARCH_STORE_TO_INSTALL_TRANSCY_APP,Keys.BACK_SPACE);

    }
    public void selectStoreDomainToInstallApp(){
        waitToElementClickable((Locators.SELECT_STORE_TO_INSTALL_TRANSCY_APP));
        clickToElement(Locators.SELECT_STORE_TO_INSTALL_TRANSCY_APP);
    }
    public void clickToChooseAccountPartnerBtn(){
        waitToElementClickable((Locators.CLICK_CHOOSE_ACCOUNT_TO_INSTALL));
        clickToElement(Locators.CLICK_CHOOSE_ACCOUNT_TO_INSTALL);
    }
    public void clickToInstallTranscyV4AppBtn(){
        waitToElementClickable((Locators.CLICK_INSTALL_TRANSCY_UAT_V4_APP_BUTTON));
        clickToElement(Locators.CLICK_INSTALL_TRANSCY_UAT_V4_APP_BUTTON);
    }
    public void clickToChoosePlanTranscyV4AppBtn(){
        switchToFrameOrIframe(Locators.IFRAME_TRANSCY_UAT_V4_APP);
        waitToElementClickable((Locators.CLICK_CHOOSE_FREE_PLAN_BUTTON));
        clickToElement(Locators.CLICK_CHOOSE_FREE_PLAN_BUTTON);
        driver.switchTo().defaultContent();
    }
    public void clickSwitcherMenuBtn(){
        waitToElementClickable((Locators.SELECT_MENU_SWITCHER_BUTTON));
        clickToElement(Locators.SELECT_MENU_SWITCHER_BUTTON);
        switchToFrameOrIframe(Locators.IFRAME_TRANSCY_UAT_V4_APP);

    }
    public void selectFirstNextBtnInModal(){
        switchToFrameOrIframe(Locators.IFRAME_TRANSCY_UAT_V4_APP);
        waitToElementClickable((Locators.SELECT_NEXT_BUTTON_IN_MODAL));
        clickToElement(Locators.SELECT_NEXT_BUTTON_IN_MODAL);
    }

    public void selectSecondNextBtnInModal(){
        waitToElementClickable((Locators.SELECT_NEXT_BUTTON_IN_MODAL));
        clickToElement(Locators.SELECT_NEXT_BUTTON_IN_MODAL);
    }
    public void selectExploreNowBtnInModal(){
        waitToElementClickable((Locators.SELECT_EXPLORE_NOW_BUTTON_IN_MODAL));
        clickToElement(Locators.SELECT_EXPLORE_NOW_BUTTON_IN_MODAL);
    }

    public String getTextTitle(){
        waitToElementVisible(Locators.CONTENT_TITLE);

        return getTextTitle();
    }



}
