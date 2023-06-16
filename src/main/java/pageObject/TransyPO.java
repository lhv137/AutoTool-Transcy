package pageObject;

import commons.AbstractPage;
import org.openqa.selenium.*;
import pageUI.Locators;



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
        Thread.sleep(40000);
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
        Thread.sleep(15000);
    }
    public void clickToChooseAccountPartnerBtn(){
        waitToElementClickable((Locators.CLICK_CHOOSE_ACCOUNT_TO_INSTALL));
        clickToElement(Locators.CLICK_CHOOSE_ACCOUNT_TO_INSTALL);
    }
    public void clickToInstallTranscyV4AppBtn() throws InterruptedException {
        waitToElementClickable((Locators.CLICK_INSTALL_TRANSCY_UAT_V4_APP_BUTTON));
        clickToElement(Locators.CLICK_INSTALL_TRANSCY_UAT_V4_APP_BUTTON);
        Thread.sleep(25000);
    }
    public void clickToChooseFreePlanTranscyV4AppBtn() throws InterruptedException {
        switchToFrameOrIframe(Locators.IFRAME_TRANSCY_UAT_V4_APP);
        waitToElementClickable((Locators.CLICK_CHOOSE_FREE_PLAN_BUTTON));
        clickToElement(Locators.CLICK_CHOOSE_FREE_PLAN_BUTTON);
        driver.switchTo().defaultContent();
        Thread.sleep(15000);
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
        Thread.sleep(3000);
    }
    public void clickToLoginTranscyApp() throws InterruptedException {
        String winHandleBefore = driver.getWindowHandle();
        waitToElementClickable((Locators.SELECT_APPS_TRANSCY_BUTTON));
        clickToElement(Locators.SELECT_APPS_TRANSCY_BUTTON);
        Thread.sleep(5000);
    }
//  MODAL AFTER GO TO SWITCHER MENU
    public String getContentTitleFirstModal(){
        return getElementText(By.xpath(Locators.CONTENT_TITLE_MODAL_FIRST));
    }
    public String getContentHeadingModal1(){
        return getElementText(By.xpath(Locators.CONTENT_HEADING_MODAL_1));
    }
    public String getContentHeadingModal2(){
        return getElementText(By.xpath(Locators.CONTENT_HEADING_MODAL_2));
    }
    public String getContentHeadingModal3(){
        return getElementText(By.xpath(Locators.CONTENT_HEADING_MODAL_3));
    }
    public String getContentDescriptionModal1(){
        return getElementText(By.xpath(Locators.CONTENT_DESCRIPTION_MODAL_1));
    }
    public String getContentDescriptionModal2(){
        return getElementText(By.xpath(Locators.CONTENT_DESCRIPTION_MODAL_2));
    }
    public String getContentDescriptionModal3(){
        return getElementText(By.xpath(Locators.CONTENT_DESCRIPTION_MODAL_3));
    }
    public String getImageURLModal1(){
        return getAttribute(By.xpath(Locators.IMAGE_LINK_MODAL_1),"src");
    }
    public String getImageURLModal2(){
        return getAttribute(By.xpath(Locators.IMAGE_LINK_MODAL_2),"src");
    }
    public String getImageURLModal3(){
        return getAttribute(By.xpath(Locators.IMAGE_LINK_MODAL_3),"src");
    }
    public String getContentTitleSecondModal(){
        return getElementText(By.xpath(Locators.CONTENT_TITLE_MODAL_SECOND));
    }
    public String getContentDescriptionSecondModal(){
        return getElementText(By.xpath(Locators.CONTENT_DESCRIPTION_MODAL_SECOND));
    }
    public void clickToNextButton() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_NEXT_BUTTON_IN_MODAL));
        clickToElement(Locators.SELECT_NEXT_BUTTON_IN_MODAL);
        Thread.sleep(5000);
    }
    public void clickToExploreNowButton() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_EXPLORE_NOW_BUTTON_IN_MODAL));
        clickToElement(Locators.SELECT_EXPLORE_NOW_BUTTON_IN_MODAL);
        Thread.sleep(5000);
    }
    public void clickToDoItLaterButton() throws InterruptedException {
        waitToElementClickable((Locators.SELECT_OK_DO_IT_LATER_BUTTON));
        clickToElement(Locators.SELECT_OK_DO_IT_LATER_BUTTON);
        Thread.sleep(10000);
    }

//  GENERAL TAB
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

//  TEMPLATES TAB
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

//  CUSTOMIZATION TAB
    public void clickToCustomizationTab() throws InterruptedException {
        waitToElementClickable((Locators.CUSTOMIZE_TITLE_CONTENT));
        clickToElement(Locators.CUSTOMIZE_TITLE_CONTENT);
        Thread.sleep(5000);
    }
    public void clickToPositionTab() throws InterruptedException {
        waitToElementClickable((Locators.POSITIONS_TITLE_CONTENT));
        clickToElement(Locators.POSITIONS_TITLE_CONTENT);
        Thread.sleep(5000);
    }
    public void clickToSwitcherStyleTab() throws InterruptedException {
        waitToElementClickable((Locators.SWITCHER_STYLE_CONTENT_TITLE));
        clickToElement(Locators.SWITCHER_STYLE_CONTENT_TITLE);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
    public void clickToSwitcherDisclosureStyleTab() throws InterruptedException {
        waitToElementClickable((Locators.SWITCHER_DISCLOSURE_CONTENT_TITLE));
        clickToElement(Locators.SWITCHER_DISCLOSURE_CONTENT_TITLE);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");
    }
    public void clickToColorSchemaTab() throws InterruptedException {
        waitToElementClickable((Locators.COLOR_SCHEMA_CONTENT_TITLE));
        clickToElement(Locators.COLOR_SCHEMA_CONTENT_TITLE);
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2300)");
    }
    public String getPositionTitleContent(){
        return getElementText(By.xpath(Locators.POSITIONS_TITLE_CONTENT));
    }
    public String getPreferenceTitleContent(){
        return getElementText(By.xpath(Locators.POSITIONS_PREFERENCE_TITLE_CONTENT));
    }
    public String getPreferenceSettingType(){
        return getElementText(By.xpath(Locators.POSITIONS_PREFERENCE_SETTING_TYPE));
    }
    public String getPreferenceSettingPosition(){
        return getElementText(By.xpath(Locators.POSITIONS_PREFERENCE_SETTING_POSITION));
    }
    public String getOffsetTitleContent(){
        return getElementText(By.xpath(Locators.POSITIONS_OFFSET_TITLE_CONTENT));
    }
    public String getOffsetSettingTop(){
        return getAttribute(By.xpath(Locators.POSITIONS_OFFSET_SETTING_TOP),"value");
    }
    public String getOffsetSettingRight(){
        return getAttribute(By.xpath(Locators.POSITIONS_OFFSET_SETTING_RIGHT),"value");
    }
    public String getSwitcherStyleTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_CONTENT_TITLE));
    }
    public String getSwitcherStyleWidthTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_WIDTH_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingWidth(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_WIDTH_SETTING));
    }
    public String getSwitcherStyleSettingWidthValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_STYLE_WIDTH_VALUE),"value");
    }
    public String getSwitcherStyleBorderTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_BORDER_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingBorder(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_BORDER_SETTING));
    }
    public String getSwitcherStyleSettingBorderStyle(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_BORDER_STYLE));
    }
    public String getSwitcherStyleEffectTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_EFFECT_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingEffect(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_EFFECT_SETTING));
    }
    public String getSwitcherStyleHoverEffectTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_HOVER_EFFECT_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingHoverEffect(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_HOVER_EFFECT_SETTING));
    }
    public String getSwitcherStyleNoteEffect(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_EFFECT_NOTE));
    }
    public String getSwitcherStyleLayoutTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LAYOUT_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingLayout(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LAYOUT_SETTING));
    }
    public String getSwitcherStyleArrowSegmentTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_ARROW_SEGMENT_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingArrowSegment(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_ARROW_SEGMENT_SETTING));
    }
    public String getSwitcherStyleSettingStyleArrowSegment(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_ARROW_SEGMENT_LAYOUT));
    }
    public String getSwitcherStyleLabelSegmentTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LABEL_SEGMENT_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingLabelSegment(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LABEL_SEGMENT_SETTING));
    }
    public String getSwitcherStyleNoteLabelSegment(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LABEL_SEGMENT_NOTE));
    }
    public String getSwitcherStyleLanguageTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LANGUAGE_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingLanguage(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LANGUAGE_CONTENT_SETTING));
    }
    public boolean getSwitcherStyleLanguageStatusChecked(){
        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_STYLE_LANGUAGE_CHECKBOX),"checked");
        return true;
    }
    public boolean getSwitcherStyleLanguageStatusEnable(){
//        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_STYLE_LANGUAGE_CHECKBOX),"disable");
//        return false;
//        WebElement enable = driver.findElement(By.xpath(Locators.SWITCHER_STYLE_LANGUAGE_CHECKBOX));
//        if (enable.isEnabled()){
//            logConsole("Enabled:" + enable.isEnabled() );
//        }else
//            logConsole("Enabled: Disable" );
//        return true;
        boolean enable = driver.findElement(By.xpath(Locators.SWITCHER_STYLE_LANGUAGE_CHECKBOX)).isEnabled();
        return enable;
    }
    public String getSwitcherStyleContentCheckboxLanguage(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_LANGUAGE_CHECKBOX_CONTENT));
    }
    public String getSwitcherStyleCurrencyTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingCurrency(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CONTENT_SETTING));
    }
    public boolean getSwitcherStyleCurrencyStatusChecked(){
        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CHECKBOX),"checked");
        return true;
    }
    public boolean getSwitcherStyleCurrencyStatusEnable(){
//        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CHECKBOX),"disable");
//        return true;
        boolean enable = driver.findElement(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CHECKBOX)).isEnabled();
        return enable;
    }
    public String getSwitcherStyleContentCheckboxCurrency(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CHECKBOX_CONTENT));
    }
    public String getSwitcherStyleDividerFormatTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_DIVIDER_FORMAT_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingDividerFormat(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_DIVIDER_FORMAT_CONTENT_SETTING));
    }
    public String getSwitcherStyleFontTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_FONT_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingFont(){
        return getAttribute(By.xpath(Locators.SWITCHER_STYLE_FONT_SETTING),"value");
    }
    public String getSwitcherStyleLayoutFont(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_FONT_LAYOUT));
    }
    public String getSwitcherStyleNoteFont(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_FONT_NOTE));
    }
    public String getSwitcherStyleFlagStyleTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_FLAG_STYLE_CONTENT_TITLE));
    }
    public String getSwitcherStyleSettingFlagStyle(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_FLAG_STYLE_SETTING));
    }
    public String getSwitcherStyleLayoutFlagStyle(){
        return getElementText(By.xpath(Locators.SWITCHER_STYLE_FLAG_STYLE));
    }
    public String getSwitcherDisclosureStyleTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleWidthTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_WIDTH_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleWidthSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_WIDTH_SETTING));
    }
    public String getSwitcherDisclosureStyleWidthValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_WIDTH_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleBorderTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BORDER_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleBorderSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BORDER_SETTING));
    }
    public String getSwitcherDisclosureStyleBorderStyle(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BORDER_STYLE));
    }
    public String getSwitcherDisclosureStyleActiveEffectTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_ACTIVE_EFFECT_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleActiveEffectSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_ACTIVE_EFFECT_SETTING));
    }
    public String getSwitcherDisclosureStyleActiveEffectNote(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_ACTIVE_EFFECT_NOTE));
    }
    public String getSwitcherDisclosureStyleElementToShowTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_ELEMENT_TO_SHOW_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleElementToShowSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_ELEMENT_TO_SHOW_SETTING));
    }
    public String getSwitcherDisclosureStyleLanguageTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_LANGUAGE_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleLanguageSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_LANGUAGE_SETTING));
    }
    public boolean getSwitcherDisclosureStyleLanguageStatusChecked(){
        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_LANGUAGE_CHECKBOX),"checked");
        return true;
    }
    public boolean getSwitcherDisclosureStyleLanguageStatusEnable(){
//        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CHECKBOX),"disable");
//        return true;
        boolean enable = driver.findElement(By.xpath(Locators.SWITCHER_DISCLOSURE_LANGUAGE_CHECKBOX)).isEnabled();
        return enable;
    }
    public String getSwitcherDisclosureStyleLanguageCheckboxContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_LANGUAGE_CHECKBOX_CONTENT));
    }
    public String getSwitcherDisclosureStyleCurrencyTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_CURRENCY_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleCurrencySetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_CURRENCY_SETTING));
    }
    public boolean getSwitcherDisclosureStyleCurrencyStatusChecked(){
        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_CURRENCY_CHECKBOX),"checked");
        return true;
    }
    public boolean getSwitcherDisclosureStyleCurrencyStatusEnable(){
//        String languageStatus = getAttribute(By.xpath(Locators.SWITCHER_STYLE_CURRENCY_CHECKBOX),"disable");
//        return true;
        boolean enable = driver.findElement(By.xpath(Locators.SWITCHER_DISCLOSURE_CURRENCY_CHECKBOX)).isEnabled();
        return enable;
    }
    public String getSwitcherDisclosureStyleCurrencyCheckboxContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_CURRENCY_CHECKBOX_CONTENT));
    }
    public String getSwitcherDisclosureStyleTitleFontTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_TITLE_FONT_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleTitleFontValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_TITLE_FONT_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleTitleFontSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_TITLE_FONT_SETTING));
    }
    public String getSwitcherDisclosureStyleTitleFontNote(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_TITLE_FONT_NOTE));
    }
    public String getSwitcherDisclosureStyleSearchBoxTextFontTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_SEARCH_BOX_TEXT_FONT_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleSearchBoxTextFontValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_SEARCH_BOX_TEXT_FONT_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleSearchBoxTextFontSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_SEARCH_BOX_TEXT_FONT_SETTING));
    }
    public String getSwitcherDisclosureStyleSearchBoxTextFontNote(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_SEARCH_BOX_TEXT_FONT_NOTE));
    }
    public String getSwitcherDisclosureStyleOptionFontTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_OPTION_FONT_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleOptionFontValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_OPTION_FONT_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleOptionFontSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_OPTION_FONT_SETTING));
    }
    public String getSwitcherDisclosureStyleOptionFontNote(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_OPTION_FONT_NOTE));
    }
    public String getSwitcherDisclosureStyleSelectedOptionFontTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_SELECT_OPTION_FONT_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleSelectedOptionFontValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_SELECT_OPTION_FONT_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleSelectedOptionFontSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_SELECT_OPTION_FONT_SETTING));
    }
    public String getSwitcherDisclosureStyleSelectedOptionFontNote(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_SELECT_OPTION_FONT_NOTE));
    }
    public String getSwitcherDisclosureStyleFlagStyleTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_FLAG_STYLE_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleFlagStyleSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_FLAG_STYLE_SETTING));
    }
    public String getSwitcherDisclosureStyleFlagStyleStyle(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_FLAG_STYLE_VALUE));
    }
    public String getSwitcherDisclosureStyleButtonTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleButtonWidthTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_WIDTH_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleButtonWidthSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_WIDTH_SETTING));
    }
    public String getSwitcherDisclosureStyleButtonWidthValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_WIDTH_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleButtonHeightTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_HEIGHT_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleButtonHeightSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_HEIGHT_SETTING));
    }
    public String getSwitcherDisclosureStyleButtonHeightValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_HEIGHT_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleButtonShapeTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_SHAPE_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleButtonShapeSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_SHAPE_SETTING));
    }
    public String getSwitcherDisclosureStyleButtonFontTitleContent(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_FONT_CONTENT_TITLE));
    }
    public String getSwitcherDisclosureStyleButtonFontSetting(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_FONT_SETTING));
    }
    public String getSwitcherDisclosureStyleButtonFontValue(){
        return getAttribute(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_FONT_VALUE),"value");
    }
    public String getSwitcherDisclosureStyleButtonFontNote(){
        return getElementText(By.xpath(Locators.SWITCHER_DISCLOSURE_BUTTON_FONT_NOTE));
    }
    public String getColorSchemaTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherColorTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherColorBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherColorBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherColorBorderTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_BORDER_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherColorBorderValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_BORDER_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherColorTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherColorTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherColorArrowTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_ARROW_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherColorArrowValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_COLOR_ARROW_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherHoverStateTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherHoverStateBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherHoverStateBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherHoverStateBorderTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_BORDER_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherHoverStateBorderValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_BORDER_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherHoverStateTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherHoverStateTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherHoverStateArrowTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_ARROW_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherHoverStateArrowValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_HOVER_STATE_ARROW_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherActiveStateTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherActiveStateBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherActiveStateBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherActiveStateBorderTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_BORDER_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherActiveStateBorderValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_BORDER_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherActiveStateTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherActiveStateTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherActiveStateArrowTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_ARROW_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherActiveStateArrowValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_ACTIVE_STATE_ARROW_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorBorderTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BORDER_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorBorderValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BORDER_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorTitleColorTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_TITLE_COLOR_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorTitleColorValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_TITLE_COLOR_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxBorderTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_BORDER_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxBorderValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_BORDER_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxArrowTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_ARROW_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectBoxArrowValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_BOX_ARROW_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorOptionBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_OPTION_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorOptionBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_OPTION_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorOptionTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_OPTION_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorOptionTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_OPTION_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_OPTION_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_OPTION_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectedOptionTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_OPTION_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSelectedOptionTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SELECT_OPTION_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSearchBoxBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SEARCH_BOX_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSearchBoxBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SEARCH_BOX_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSearchBoxIconTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SEARCH_BOX_ICON_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSearchBoxIconValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SEARCH_BOX_ICON_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorSearchBoxTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SEARCH_BOX_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorSearchBoxTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_SEARCH_BOX_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorButtonBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BUTTON_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorButtonBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BUTTON_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureColorButtonTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BUTTON_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureColorButtonTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_COLOR_BUTTON_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_BORDER_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_BORDER_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_ARROW_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_SELECT_BOX_ARROW_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateOptionBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_OPTION_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateOptionBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_OPTION_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateOptionTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_OPTION_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateOptionTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_OPTION_TEXT_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateButtonBackgroundTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_BUTTON_BACKGROUND_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateButtonBackgroundValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_BUTTON_BACKGROUND_VALUE_COLOR));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateButtonTextTitleContent(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_BUTTON_TEXT_CONTENT_TITLE));
    }
    public String getColorSchemaSwitcherDisclosureHoverStateButtonTextValueColor(){
        return getElementText(By.xpath(Locators.COLOR_SCHEMA_SWITCHER_DISCLOSURE_HOVER_STATE_BUTTON_TEXT_VALUE_COLOR));
    }

}
