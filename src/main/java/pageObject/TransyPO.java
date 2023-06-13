package pageObject;

import commons.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUI.Locators;
import org.openqa.selenium.support.ui.Select;




public class TransyPO extends AbstractPage {
    WebDriver driver;

    public String storeURL;

    public TransyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
//    LOGIN PARTNER
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
        Thread.sleep(3000);
    }
    public void inputTPasswordAccountPartner(String passWord) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT);
        sendKeyToElement(Locators.ENTER_PASSWORD_PARTNER_ACCOUNT, passWord);
        Thread.sleep(3000);
    }
    public void clickToLoginBtn() throws InterruptedException {
        waitToElementClickable(Locators.LOGIN_PARTNER_BUTTON);
        clickToElement(Locators.LOGIN_PARTNER_BUTTON);
        Thread.sleep(3000);
    }
    public void clickToUseARecoveryCodeBtn() throws InterruptedException {
        waitToElementClickable(Locators.SELECT_USE_RECOVERY_CODE);
        clickToElement(Locators.SELECT_USE_RECOVERY_CODE);
        Thread.sleep(3000);
    }
    public void inputRecoveryCode(String recoveryCode) throws InterruptedException {
        waitToElementVisible(Locators.ENTER_RECOVERY_CODE);
        sendKeyToElement(Locators.ENTER_RECOVERY_CODE, recoveryCode);
        Thread.sleep(3000);
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

//    ADD STORE TEST ADMIN TOOL
    public void inputUserNameAdminTool(String userNameAdmin) throws InterruptedException {
        waitToElementVisible(Locators.FILL_USERNAME_ADMIN_TOOL);
        sendKeyToElement(Locators.FILL_USERNAME_ADMIN_TOOL, userNameAdmin);
        Thread.sleep(5000);
    }
    public void inputPassWordAdminTool(String passWordAdmin) throws InterruptedException {
        waitToElementVisible(Locators.FILL_PASSWORD_ADMIN_TOOL);
        sendKeyToElement(Locators.FILL_PASSWORD_ADMIN_TOOL, passWordAdmin);
        Thread.sleep(5000);
    }
    public void clickToLoginAdminToolBtn() throws InterruptedException {
        waitToElementClickable(Locators.ENTER_LOGIN_ADMIN_TOOL_BUTTON);
        clickToElement(Locators.ENTER_LOGIN_ADMIN_TOOL_BUTTON);
        Thread.sleep(5000);
    }
    public void clickToManageTestStoreBtn() throws InterruptedException {
        waitToElementClickable(Locators.CLICK_MANGE_TEST_STORE_BUTTON);
        clickToElement(Locators.CLICK_MANGE_TEST_STORE_BUTTON);
        Thread.sleep(5000);
    }
    public void inputStoreTestDomain(String storeDomain) throws InterruptedException {
        waitToElementVisible(Locators.FILL_STORE_TEST_ADMIN_TOOL);
        sendKeyToElement(Locators.FILL_STORE_TEST_ADMIN_TOOL, storeDomain);
        Thread.sleep(5000);
    }
    public void clickToAddTestStoreBtn() throws InterruptedException {
        waitToElementClickable(Locators.CLICK_ADD_STORE_TEST_BUTTON);
        clickToElement(Locators.CLICK_ADD_STORE_TEST_BUTTON);
        Thread.sleep(5000);
    }

//    INSTALL TRANSCY UAT V4 APP

    public void selectMenuAppsBtn() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_MENU_APPS_BUTTON));
        clickToElement(Locators.SELECT_MENU_APPS_BUTTON);
        Thread.sleep(5000);
    }
    public void searchAppTranscyUATV4(String appName) throws InterruptedException {
        waitToElementVisible(Locators.SEARCH_TRANSCY_UAT_V4_APP);
        sendKeyToElement(Locators.SEARCH_TRANSCY_UAT_V4_APP, appName);
        sendKeyBoardToElement(Locators.SEARCH_TRANSCY_UAT_V4_APP, Keys.ENTER);
        Thread.sleep(5000);
    }
    public void clickToSelectTranscyUATV4App() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_TRANSCY_UAT_V4_APP));
        clickToElement(Locators.SELECT_TRANSCY_UAT_V4_APP);
        Thread.sleep(5000);
    }
    public void clickToSelectStoreBtn() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_STORE_BUTTON_TO_INSTALL_TRANSCY_APP));
        clickToElement(Locators.SELECT_STORE_BUTTON_TO_INSTALL_TRANSCY_APP);
        Thread.sleep(5000);
    }
    public void searchStoreDomainToInstallApp(String storeDomain) throws InterruptedException {
        waitToElementVisible(Locators.SEARCH_STORE_TO_INSTALL_TRANSCY_APP);
        sendKeyToElement(Locators.SEARCH_STORE_TO_INSTALL_TRANSCY_APP, storeDomain);
        Thread.sleep(3000);
        sendKeyBoardToElement(Locators.SEARCH_STORE_TO_INSTALL_TRANSCY_APP,Keys.BACK_SPACE);
        Thread.sleep(5000);

    }
    public void selectStoreDomainToInstallApp() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_STORE_TO_INSTALL_TRANSCY_APP));
        clickToElement(Locators.SELECT_STORE_TO_INSTALL_TRANSCY_APP);
        Thread.sleep(10000);
    }
    public void clickToChooseAccountPartnerBtn(){
        waitToElementClickable((Locators.CLICK_CHOOSE_ACCOUNT_TO_INSTALL));
        clickToElement(Locators.CLICK_CHOOSE_ACCOUNT_TO_INSTALL);
    }
    public void clickToInstallTranscyV4AppBtn() throws InterruptedException {
        waitToElementClickable((Locators.CLICK_INSTALL_TRANSCY_UAT_V4_APP_BUTTON));
        clickToElement(Locators.CLICK_INSTALL_TRANSCY_UAT_V4_APP_BUTTON);
        Thread.sleep(15000);
    }
    public void clickToChooseFreePlanTranscyV4AppBtn() throws InterruptedException {
        switchToFrameOrIframe(Locators.IFRAME_TRANSCY_UAT_V4_APP);
        waitToElementClickable((Locators.CLICK_CHOOSE_FREE_PLAN_BUTTON));
        clickToElement(Locators.CLICK_CHOOSE_FREE_PLAN_BUTTON);
        driver.switchTo().defaultContent();
        Thread.sleep(10000);
    }
    public void clickSwitcherMenuBtn() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_MENU_SWITCHER_BUTTON));
        clickToElement(Locators.SELECT_MENU_SWITCHER_BUTTON);
        Thread.sleep(5000);
        switchToFrameOrIframe(Locators.IFRAME_TRANSCY_UAT_V4_APP);
        Thread.sleep(3000);

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

//    LOGIN STORE IN PARTNER
    public void fitlerStoreToLogin(String storeName) throws InterruptedException {
        waitToElementClickable((Locators.FILTER_STORE_BUTTON));
        sendKeyToElement(Locators.FILTER_STORE_BUTTON, storeName);
        Thread.sleep(5000);
    }
    public void clickToLoginStore() throws InterruptedException {
        waitToElementClickable((Locators.LOGIN_STORE_BUTTON));
        clickToElement(Locators.LOGIN_STORE_BUTTON);
        Thread.sleep(20000);
    }
    public void clickToAppsMenu() throws InterruptedException {
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        waitToElementClickable((Locators.APPS_STORE_BUTTON));
        clickToElement(Locators.APPS_STORE_BUTTON);
        Thread.sleep(5000);
    }
    public void clickToLoginTranscyApp() throws InterruptedException {
        String winHandleBefore = driver.getWindowHandle();
        waitToElementClickable((Locators.SELECT_APPS_TRANSCY_BUTTON));
        clickToElement(Locators.SELECT_APPS_TRANSCY_BUTTON);
        Thread.sleep(5000);
    }
    public String getTextHeaderTitle(){
        return getElementText(By.xpath(Locators.HEADER_TITLE_CONTENT));
    }
    public String getTextHeaderDescription(){
        return getElementText(By.xpath(Locators.SUB_TITLE_CONTENT));
    }
    public String getTextGeneralTitle(){
        return getElementText(By.xpath(Locators.GENERAL_TITLE_CONTENT));
    }
    public String getTextTabContent(){
        return getElementText(By.xpath(Locators.GENERAL_TAB_CONTENT));
    }
    public String getSwitcherDisplayTitle(){
        return getElementText(By.xpath(Locators.SWITCHER_DISPLAY_TITLE));
    }
    public boolean getSwitcherDisplayStatus(){
        String SwitcherStatus = getElementText(By.xpath(Locators.SWITCHER_DISPLAY_STATUS));
        return true;
    }
    public String getSwitcherDisplayLabel(){
        return getElementText(By.xpath(Locators.SWITCHER_DISPLAY_LABEL));
    }
    public String getSwitcherDisplaySetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISPLAY_SETTING));
    }
    public String getSwitcherDisplayNote(){
        return getElementText(By.xpath(Locators.SWITCHER_DISPLAY_NOTE));
    }
    public String getSwitcherDisclosureTitle(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE));
    }
    public String getSwitcherDisclosureSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_SETTING));
    }
    public String getGeolocationTitle(){
        return getElementText(By.xpath(Locators.GEOLOCATION_TITLE));
    }
    public String getGeolocationDescription(){
        return getElementText(By.xpath(Locators.GEOLOCATION_DESCRIPTION));
    }
    public String getBannerUpgradeContent(){
        return getElementText(By.xpath(Locators.BANNER_UPGRADE));
    }
    public String getButtonUpgradeContent(){
        return getElementText(By.xpath(Locators.BUTTON_UPGRADE_IN_BANNER));
    }
    public String getUnLockFeatureModalContent(){
        return getElementText(By.xpath(Locators.TEXT_UNLOCK_FEATURE));
    }
    public String getButtonUnLockFeatureModalContent(){
        return getElementText(By.xpath(Locators.BUTTON_UNLOCK_FEATURE));
    }
    public void clickToTempalatesTab() throws InterruptedException {
        waitToElementClickable((Locators.TEMPLATES_TITLE_CONTENT));
        clickToElement(Locators.TEMPLATES_TITLE_CONTENT);
        Thread.sleep(5000);
    }
    public String getActiveTemplateContent(){
        return getElementText(By.xpath(Locators.ACTIVE_TEMPLATE_TITLE));
    }
    public String getDefaultTemplateContent(){
        return getElementText(By.xpath(Locators.DEFAULT_TEMPLATE_CONTENT));
    }
    public String getStatusTemplateNote(){
        return getElementText(By.xpath(Locators.STATUS_TEMPLATE_NOTE));
    }
    public String getTemplateButton(){
        return getElementText(By.xpath(Locators.STATUS_TEMPLATE_BUTTON));
    }
    public String getTranscyTemplateContent(){
        return getElementText(By.xpath(Locators.TRANSCY_TEMPLATES_TITLE));
    }
    public String getMoreItemsSettingContent(){
        return getElementText(By.xpath(Locators.MORE_ITEMS_SETTING_TITLE));
    }
    public String getTranscyTemplateDefault(){
        return getElementText(By.xpath(Locators.TRANSCY_TEMPLATE_DEFAULT));
    }
    public String getButtonTranscyTemplateDefault(){
        return getElementText(By.xpath(Locators.TRANSCY_BUTTON_TEMPLATE_DEFAULT));
    }

}
