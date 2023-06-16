package transcy;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.ExpectedData;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.TransyPO;

import java.util.Random;

public class createStoreAndInstallApp extends AbstractTest {
    private WebDriver driver;
    private TransyPO transcyPage;
    private AbstractPage abstractPage;

//    PARNTER INFO
    String partnerURL = "https://www.shopify.com/partners";
    String emailPartner = "vilh@fireapps.vn";
    String passwordPartner = "123321";
    String recoveryCode = "97E5-2AF4-FA18";
    int number = new Random().nextInt(99999999);
    String storeName = "storetesttranscy" + number;

//    ADMIN TOOL INFO
    String adminToolUATURL = "https://transcy-stag-admin.onecommerce.app";
    String userNameAdminTool = "admin";
    String passWordAdminTool = "ShopifyAppsGreat2022";

//    INSTALL TRANSCY UAT V4 APP
    String appName = "Transcy UAT V4";

    @BeforeTest
    public void beforeTest() {
//        driver = getBrowserDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        transcyPage = PageGeneratorManager.getShopifyPage(driver);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void LoginPartnerFireAppsDev() throws InterruptedException {

        log.info("Pre-condition: Login Partner Shopify");
        driver.get(partnerURL);

        log.info("Step 01: Press Login Partner button");
        transcyPage.clickToLoginPartnerBtn();

        log.info("Step 02: Fill Email account Partner");
        transcyPage.inputToEmailAccountPartner(emailPartner);

        log.info("Step 03: Press Continue with Email button");
        transcyPage.clickToContinueWithEmailBtn();

        log.info("Step 04: Fill Password account Partner");
        transcyPage.inputTPasswordAccountPartner(passwordPartner);

        log.info("Step 05: Press Login button");
        transcyPage.clickToLoginBtn();

        log.info("Step 06: Press Use a Recovery code button");
        transcyPage.clickToUseARecoveryCodeBtn();

        log.info("Step 07: Fill Recovery code");
        transcyPage.inputRecoveryCode(recoveryCode);

        log.info("Step 08: Press Login button");
        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

        log.info("Step 09: Press Partner button");
        transcyPage.clickToSelectPartnerBtn();

    }

    @Test(priority = 2)
    public void CreateStoreTestInPartner() throws InterruptedException {

        log.info("Step 01: Press Stores menu");
        transcyPage.selectMenuStoresBtn();

        log.info("Step 02: Press Add Store button");
        transcyPage.clickToAddStore();

        log.info("Step 03: Press Create Development Store button");
        transcyPage.clickToCreateDevelopmentStore();

        log.info("Step 04: Select Store test and Build option");
        transcyPage.selectOptionStoreTest();

        log.info("Step 05: Fill Store name");
        transcyPage.inputStoreName(storeName);
        System.out.println("Store name: " + storeName);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");

        log.info("Step 06: Select Start with test data option");
        transcyPage.selectOprionStartWithTestData();

        log.info("Step 07: Press Create Development store button");
        transcyPage.clickToAddDevelopmentStoreBtn();

//        log.info("Step 08: Choose account to login");
//        transcyPage.clickToChooseAccountBtn();
//        Thread.sleep(10000);
    }

        @Test(priority = 3)
        public void AddStoreTestTranscyInAdminTool () throws InterruptedException {
            String storeNameAdmin = storeName + ".myshopify.com";

            log.info("Step 01: Go to Admin tool");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(adminToolUATURL);

            log.info("Step 02: Fill Username Admin tool");
            transcyPage.inputUserNameAdminTool(userNameAdminTool);

            log.info("Step 03: Fill Password Admin tool");
            transcyPage.inputPassWordAdminTool(passWordAdminTool);

            log.info("Step 04: Login Admin tool");
            transcyPage.clickToLoginAdminToolBtn();

            log.info("Step 05: Go to Manage Test store menu");
            transcyPage.clickToManageTestStoreBtn();

            log.info("Step 06: Fill Store Domain to Add Store test");
            transcyPage.inputStoreTestDomain(storeNameAdmin);
            System.out.println("Store domain: " + storeNameAdmin);

            log.info("Step 07: Click Add Store test");
            transcyPage.clickToAddTestStoreBtn();

            log.info("Step 08: Handle Alert");
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(10000);
        }

        @Test(priority = 4)
        public void InstallTranscyAppUAT () throws InterruptedException {
            String storeTest = storeName + ".myshopify.com";

            // Login Partner Shopify
            log.info("Step 01: Re-Login Partner Shopify");
            Thread.sleep(3000);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(partnerURL);

            log.info("Step 02: Press Login Partner button");
            transcyPage.clickToLoginPartnerBtn();

            log.info("Step 03: Select Partner button");
            transcyPage.clickToSelectPartnerBtn();

            log.info("Step 04: Go To Apps Menu");
            transcyPage.selectMenuAppsBtn();

            log.info("Step 05: Search Transcy UAT V4 App");
            transcyPage.searchAppTranscyUATV4(appName);

            log.info("Step 06: Click to select Transcy UAT V4 App");
            transcyPage.clickToSelectTranscyUATV4App();

            log.info("Step 07: Click to Select Store button");
            transcyPage.clickToSelectStoreBtn();

            log.info("Step 08: Search Store Domain");
            transcyPage.searchStoreDomainToInstallApp(storeTest);

            log.info("Step 09: Select Store Domain to Install App");
            transcyPage.selectStoreDomainToInstallApp();

//            log.info("Step 10: Click Choose Partner Account button");
//            transcyPage.clickToChooseAccountPartnerBtn();
//            Thread.sleep(5000);

            log.info("Step 10: Click Install Transcy V4 App button");
            transcyPage.clickToInstallTranscyV4AppBtn();

            log.info("Step 11: Click Choose Free Plan Transcy V4 App button");
            transcyPage.clickToChooseFreePlanTranscyV4AppBtn();

            log.info("Step 12: Click to Switcher menu button");
            transcyPage.clickSwitcherMenuBtn();
        }

        @Test(priority = 5)
        public void VerifyModalFirstTimeGoToMenuSwitcher () throws InterruptedException {
            log.info("=== Verify Setting Default In Modal ===");

            log.info("Step 01: Verify Title Content on Modal");
            Assert.assertEquals(transcyPage.getContentTitleFirstModal(), ExpectedData.expectContentTitleModalFirstDefault);
            System.out.println("Actual result: " + transcyPage.getContentTitleFirstModal());
            System.out.println("Expected result: " + ExpectedData.expectContentTitleModalFirstDefault);
            Thread.sleep(5000);

            log.info("Step 02: Verify Heading Content on Modal 1");
            Assert.assertEquals(transcyPage.getContentHeadingModal1(), ExpectedData.expectContentHeadingModal1Default);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal1());
            System.out.println("Expected result: " + ExpectedData.expectContentHeadingModal1Default);
            Thread.sleep(5000);

            log.info("Step 03: Verify Content on Modal 1");
            Assert.assertEquals(transcyPage.getContentDescriptionModal1(), ExpectedData.expectContentDescriptionModal1Default);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal1());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModal1Default);
            Thread.sleep(5000);

            log.info("Step 04: Verify Image URL on Modal 1");
            Assert.assertEquals(transcyPage.getImageURLModal1(), ExpectedData.getExpectURLImageModal1Default);
            System.out.println("Actual result: " + transcyPage.getImageURLModal1());
            System.out.println("Expected result: " + ExpectedData.getExpectURLImageModal1Default);
            Thread.sleep(5000);

            log.info("=== Go To Modal 2 ===");
            transcyPage.clickToNextButton();

            log.info("Step 05: Verify Heading Content on Modal 2");
            Assert.assertEquals(transcyPage.getContentHeadingModal2(), ExpectedData.expectContentHeadingModal2Default);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal2());
            System.out.println("Expected result: " + ExpectedData.expectContentHeadingModal2Default);
            Thread.sleep(5000);

           log.info("Step 06: Verify Content on Modal 2");
            Assert.assertEquals(transcyPage.getContentDescriptionModal2(), ExpectedData.expectContentDescriptionModal2Default);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal2());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModal2Default);
            Thread.sleep(5000);

            log.info("Step 07: Verify Image URL on Modal 2");
            Assert.assertEquals(transcyPage.getImageURLModal2(), ExpectedData.getExpectURLImageModal2Default);
            System.out.println("Actual result: " + transcyPage.getImageURLModal2());
            System.out.println("Expected result: " + ExpectedData.getExpectURLImageModal2Default);
            Thread.sleep(5000);

            log.info("=== Go To Modal 3 ===");
            transcyPage.clickToNextButton();

            log.info("Step 08: Verify Heading Content on Modal 3");
            Assert.assertEquals(transcyPage.getContentHeadingModal3(), ExpectedData.expectContentHeadingModal3Default);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal3());
            System.out.println("Expected result: " + ExpectedData.expectContentHeadingModal3Default);
            Thread.sleep(5000);

            log.info("Step 09: Verify Content on Modal 3");
            Assert.assertEquals(transcyPage.getContentDescriptionModal3(), ExpectedData.expectContentDescriptionModal3Default);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal3());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModal3Default);
            Thread.sleep(5000);

            log.info("Step 10: Verify Image URL on Modal 3");
            Assert.assertEquals(transcyPage.getImageURLModal3(), ExpectedData.getExpectURLImageModal3Default);
            System.out.println("Actual result: " + transcyPage.getImageURLModal3());
            System.out.println("Expected result: " + ExpectedData.getExpectURLImageModal3Default);
            Thread.sleep(5000);

            log.info("=== Go To Next Modal ===");
            transcyPage.clickToExploreNowButton();

            log.info("Step 11: Verify Title Content on Second Modal");
            Assert.assertEquals(transcyPage.getContentTitleSecondModal(), ExpectedData.expectContentTitleModalSecondDefault);
            System.out.println("Actual result: " + transcyPage.getContentTitleSecondModal());
            System.out.println("Expected result: " + ExpectedData.expectContentTitleModalSecondDefault);
            Thread.sleep(5000);

            log.info("Step 12: Verify Description Content on Second Modal");
            Assert.assertEquals(transcyPage.getContentDescriptionSecondModal(), ExpectedData.expectContentDescriptionModalSecondDefault);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionSecondModal());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModalSecondDefault);
            Thread.sleep(5000);

            log.info("=== Click OK Do It Later Button ===");
            transcyPage.clickToDoItLaterButton();
        }

        @Test(priority = 6)
        public void VerifySwitcherSettingsDefaultGeneralTab () throws InterruptedException {

            log.info("=== Verify Setting Default General Setting Tab ===");

            log.info("Step 01: Verify Header Title Content");
            Assert.assertEquals(transcyPage.getTextHeaderTitle(), ExpectedData.expectContentHeaderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getTextHeaderTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentHeaderTitleDefault);
            Thread.sleep(5000);

            log.info("Step 02: Verify Header Description  Content");
            Assert.assertEquals(transcyPage.getTextHeaderDescription(), ExpectedData.expectContentSubTitleDefault);
            System.out.println("Actual result: " + transcyPage.getTextHeaderDescription());
            System.out.println("Expected result: " + ExpectedData.expectContentSubTitleDefault);
            Thread.sleep(5000);

    //        log.info("Step 16: Verify General Header Title");
    //////        transcyPage.clickToTempalatesTab();
    //        WebElement selectText = driver.findElement(By.cssSelector(".Polaris-Tabs__Wrapper"));
    //        selectText.getText();
    //        System.out.println("Text is: " +selectText);
    //////        Assert.assertEquals(transcyPage.getTextGeneralTitle(),expectContentGeneralTitle);
    ////        System.out.println("Actual result: " + transcyPage.getTextGeneralTitle());
    //        System.out.println("Expected result: " + expectContentGeneralTitle);

            log.info("Step 03: Verify General Tab Content");
            Assert.assertEquals(transcyPage.getTextTabContent(), ExpectedData.expectContentGeneralTabDefault);
            System.out.println("Actual result: " + transcyPage.getTextTabContent());
            System.out.println("Expected result: " + ExpectedData.expectContentGeneralTabDefault);
            Thread.sleep(5000);

            log.info("Step 04: Verify Switcher Display Title");
            Assert.assertEquals(transcyPage.getSwitcherDisplayTitle(), ExpectedData.expectContentSwitcherDisplayTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplayTitleDefault);
            Thread.sleep(5000);

            log.info("Step 05: Verify Switcher Visibility Status");
            Assert.assertTrue(transcyPage.getSwitcherDisplayStatus());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayStatus());
            Thread.sleep(5000);

            log.info("Step 06: Verify Switcher Display Label");
            Assert.assertEquals(transcyPage.getSwitcherDisplayLabel(), ExpectedData.expectContentSwitcherDisplayLabelDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayLabel());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplayLabelDefault);
            Thread.sleep(5000);

            log.info("Step 07: Verify Switcher Display Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisplaySetting(), ExpectedData.expectContentSwitcherDisplaySettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplaySetting());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplaySettingDefault);
            Thread.sleep(5000);

            log.info("Step 08: Verify Switcher Display Note");
            Assert.assertEquals(transcyPage.getSwitcherDisplayNote(), ExpectedData.expectContentSwitcherDisplayNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayNote());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplayNoteDefault);
            Thread.sleep(5000);

            log.info("Step 09: Verify Switcher Diclosure Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureTitle(), ExpectedData.expectContentSwitcherDisclosureTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisclosureTitleDefault);
            Thread.sleep(5000);

            log.info("Step 10: Verify Switcher Diclosure Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureSetting(), ExpectedData.expectContentSwitcherDisclosureSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureSetting());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisclosureSettingDefault);
            Thread.sleep(5000);

            log.info("Step 11: Verify Geolocation Title");
            Assert.assertEquals(transcyPage.getGeolocationTitle(), ExpectedData.expectContentGeolocationTitleDefault);
            System.out.println("Actual result: " + transcyPage.getGeolocationTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentGeolocationTitleDefault);
            Thread.sleep(5000);

            log.info("Step 12: Verify Geolocation Description");
            Assert.assertEquals(transcyPage.getGeolocationDescription(), ExpectedData.expectContentGeolocationDescriptionDefault);
            System.out.println("Actual result: " + transcyPage.getGeolocationDescription());
            System.out.println("Expected result: " + ExpectedData.expectContentGeolocationDescriptionDefault);
            Thread.sleep(5000);

            log.info("Step 13: Verify Banner Upgrade");
            Assert.assertEquals(transcyPage.getBannerUpgradeContent(), ExpectedData.expectContentBlockPlanDefault);
            System.out.println("Actual result: " + transcyPage.getBannerUpgradeContent());
            System.out.println("Expected result: " + ExpectedData.expectContentBlockPlanDefault);
            Thread.sleep(5000);

            log.info("Step 14: Verify Button Banner Upgrade");
            Assert.assertEquals(transcyPage.getButtonUpgradeContent(), ExpectedData.expectContentButtonBlockPlanDefault);
            System.out.println("Actual result: " + transcyPage.getButtonUpgradeContent());
            System.out.println("Expected result: " + ExpectedData.expectContentButtonBlockPlanDefault);
            Thread.sleep(5000);

            log.info("Step 15: Verify Unlock Feature Content");
            Assert.assertEquals(transcyPage.getUnLockFeatureModalContent(), ExpectedData.expectContentUnLockFeatureDefault);
            System.out.println("Actual result: " + transcyPage.getUnLockFeatureModalContent());
            System.out.println("Expected result: " + ExpectedData.expectContentUnLockFeatureDefault);
            Thread.sleep(5000);

            log.info("Step 16: Verify Button Unlock Feature Content");
            Assert.assertEquals(transcyPage.getButtonUnLockFeatureModalContent(), ExpectedData.expectContentButtonUnLockFeatureDefault);
            System.out.println("Actual result: " + transcyPage.getButtonUnLockFeatureModalContent());
            System.out.println("Expected result: " + ExpectedData.expectContentButtonUnLockFeatureDefault);
            Thread.sleep(5000);
        }
        @Test(priority = 7)
        public void VerifySwitcherSettingsDefaultTemplatesTab () throws InterruptedException {

            log.info("=== Go to Templates Setting Tab ===");
            transcyPage.clickToTempalatesTab();

            log.info("=== Verify Setting Default Templates Setting Tab ===");

            log.info("Step 01: Verify Active Template Title");
            Assert.assertEquals(transcyPage.getActiveTemplateContent(), ExpectedData.expectContentActiveTemplateTitleDefault);
            System.out.println("Actual result: " + transcyPage.getActiveTemplateContent());
            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitleDefault);
            Thread.sleep(5000);

            log.info("Step 02: Verify Active Template Default");
            Assert.assertEquals(transcyPage.getDefaultTemplateContent(), ExpectedData.expectContentDefaultTemplateDefault);
            System.out.println("Actual result: " + transcyPage.getDefaultTemplateContent());
            System.out.println("Expected result: " + ExpectedData.expectContentDefaultTemplateDefault);
            Thread.sleep(5000);

            log.info("Step 03: Verify Active Template Note");
            Assert.assertEquals(transcyPage.getStatusTemplateNote(), ExpectedData.expectContentTemplateNoteDefault);
            System.out.println("Actual result: " + transcyPage.getStatusTemplateNote());
            System.out.println("Expected result: " + ExpectedData.expectContentTemplateNoteDefault);
            Thread.sleep(5000);

            log.info("Step 04: Verify Active Template Button");
            Assert.assertEquals(transcyPage.getTemplateButton(), ExpectedData.expectContentTemplateButtonDefault);
            System.out.println("Actual result: " + transcyPage.getTemplateButton());
            System.out.println("Expected result: " + ExpectedData.expectContentTemplateButtonDefault);
            Thread.sleep(5000);

            log.info("Step 05: Verify Transcy Templates Title");
            Assert.assertEquals(transcyPage.getTranscyTemplateContent(), ExpectedData.expectContentTranscyTemplateDefault);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateContent());
            System.out.println("Expected result: " + ExpectedData.expectContentTranscyTemplateDefault);
            Thread.sleep(5000);

            log.info("Step 06: Verify More Items Setting");
            Assert.assertEquals(transcyPage.getMoreItemsSettingContent(), ExpectedData.expectContentMoreItemsSettingDefault);
            System.out.println("Actual result: " + transcyPage.getMoreItemsSettingContent());
            System.out.println("Expected result: " + ExpectedData.expectContentMoreItemsSettingDefault);
            Thread.sleep(5000);

            log.info("Step 07: Verify Transcy Templates Default");
            Assert.assertEquals(transcyPage.getTranscyTemplateDefault(), ExpectedData.expectContentTranscyTemplateDefault);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateDefault());
            System.out.println("Expected result: " + ExpectedData.expectContentTranscyTemplateDefault);
            Thread.sleep(5000);

            log.info("Step 08: Verify Transcy Templates Button");
            Assert.assertEquals(transcyPage.getButtonTranscyTemplateDefault(), ExpectedData.expectContentTranscyTemplateButtonDefault);
            System.out.println("Actual result: " + transcyPage.getButtonTranscyTemplateDefault());
            System.out.println("Expected result: " + ExpectedData.expectContentTranscyTemplateButtonDefault);
            Thread.sleep(5000);
        }
        @Test(priority = 8)
        public void VerifySwitcherSettingsDefaultCustomizationTab () throws InterruptedException {

            log.info("=== Go to Customization Setting Tab ===");
            transcyPage.clickToCustomizationTab();

            log.info("=== Verify Position Tab ===");

            log.info("Step 01: Verify Position Title");
            Assert.assertEquals(transcyPage.getPositionTitleContent(), ExpectedData.expectPositionTitleDefault);
            System.out.println("Actual result: " + transcyPage.getPositionTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectPositionTitleDefault);
            Thread.sleep(5000);

            log.info("Step 02: Verify Preference Title");
            Assert.assertEquals(transcyPage.getPreferenceTitleContent(), ExpectedData.expectPreferenceTitleDefault);
            System.out.println("Actual result: " + transcyPage.getPreferenceTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectPreferenceTitleDefault);
            Thread.sleep(5000);

            log.info("Step 03: Verify Preference Setting type");
            Assert.assertEquals(transcyPage.getPreferenceSettingType(), ExpectedData.expectPreferenceSettingTypeDefault);
            System.out.println("Actual result: " + transcyPage.getPreferenceSettingType());
            System.out.println("Expected result: " + ExpectedData.expectPreferenceSettingTypeDefault);
            Thread.sleep(5000);

            log.info("Step 04: Verify Preference Setting position");
            Assert.assertEquals(transcyPage.getPreferenceSettingPosition(), ExpectedData.expectPreferenceSettingPositionDefault);
            System.out.println("Actual result: " + transcyPage.getPreferenceSettingPosition());
            System.out.println("Expected result: " + ExpectedData.expectPreferenceSettingPositionDefault);
            Thread.sleep(5000);

            log.info("Step 05: Verify Offset Title");
            Assert.assertEquals(transcyPage.getOffsetTitleContent(), ExpectedData.expectOffsetTitleDefault);
            System.out.println("Actual result: " + transcyPage.getOffsetTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectOffsetTitleDefault);
            Thread.sleep(5000);

            log.info("Step 06: Verify Offset Top");
            Assert.assertEquals(transcyPage.getOffsetSettingTop(), ExpectedData.expectOffsetSettingTopValueDefault);
            System.out.println("Actual result: " + transcyPage.getOffsetSettingTop());
            System.out.println("Expected result: " + ExpectedData.expectOffsetSettingTopValueDefault);
            Thread.sleep(5000);

            log.info("Step 07: Verify Offset Right");
            Assert.assertEquals(transcyPage.getOffsetSettingRight(), ExpectedData.expectOffsetSettingRightValueDefault);
            System.out.println("Actual result: " + transcyPage.getOffsetSettingRight());
            System.out.println("Expected result: " + ExpectedData.expectOffsetSettingRightValueDefault);
            Thread.sleep(5000);

            log.info("Step 08: Verify Switcher Style Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleTitleContent(), ExpectedData.expectSwitcherStyleTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleTitleDefault);
            Thread.sleep(5000);

            log.info("=== Collapse Position Tab ===");
            transcyPage.clickToPositionTab();

            log.info("=== Expand Switcher Style Tab ===");
            transcyPage.clickToSwitcherStyleTab();

            log.info("=== Verify Switcher Style Tab ===");

            log.info("Step 01: Verify Switcher Style - Width Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleWidthTitleContent(), ExpectedData.expectSwitcherStyleWidthTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleWidthTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthTitleDefault);
            Thread.sleep(5000);

            log.info("Step 02: Verify Switcher Style - Width Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidth(), ExpectedData.expectSwitcherStyleWidthSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidth());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthSettingDefault);
            Thread.sleep(5000);

            log.info("Step 03: Verify Switcher Style - Width Value");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidthValue(), ExpectedData.expectSwitcherStyleWidthValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidthValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthValueDefault);
            Thread.sleep(5000);

            log.info("Step 04: Verify Switcher Style - Border Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleBorderTitleContent(), ExpectedData.expectSwitcherStyleBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleBorderTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderTitleDefault);
            Thread.sleep(5000);

            log.info("Step 05: Verify Switcher Style - Border Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorder(), ExpectedData.expectSwitcherStyleBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorder());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderSettingDefault);
            Thread.sleep(5000);

            log.info("Step 06: Verify Switcher Style - Border Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorderStyle(), ExpectedData.expectSwitcherStyleBorderStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorderStyle());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderStyleDefault);
            Thread.sleep(5000);

            log.info("Step 07: Verify Switcher Style - Effect Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleEffectTitleContent(), ExpectedData.expectSwitcherStyleEffectTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleEffectTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectTitleDefault);
            Thread.sleep(5000);

            log.info("Step 08: Verify Switcher Style - Effect Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingEffect(), ExpectedData.expectSwitcherStyleEffectSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingEffect());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectSettingDefault);
            Thread.sleep(5000);

            log.info("Step 09: Verify Switcher Style - Hover & active Effect Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleHoverEffectTitleContent(), ExpectedData.expectSwitcherStyleHoverEffectTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleHoverEffectTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleHoverEffectTitleDefault);
            Thread.sleep(5000);

            log.info("Step 10: Verify Switcher Style - Hover & active Effect Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingHoverEffect(), ExpectedData.expectSwitcherStyleHoverEffectSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingHoverEffect());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleHoverEffectSettingDefault);
            Thread.sleep(5000);

            log.info("Step 11: Verify Switcher Style - Effect Note");
            Assert.assertEquals(transcyPage.getSwitcherStyleNoteEffect(), ExpectedData.expectSwitcherStyleEffectNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteEffect());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectNoteDefault);
            Thread.sleep(5000);

            log.info("Step 12: Verify Switcher Style - Layout Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutTitleContent(), ExpectedData.expectSwitcherStyleLayoutTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLayoutTitleDefault);
            Thread.sleep(5000);

            log.info("Step 13: Verify Switcher Style - Layout Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLayout(), ExpectedData.expectSwitcherStyleLayoutSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLayout());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLayoutSettingDefault);
            Thread.sleep(5000);

            log.info("Step 14: Verify Switcher Style - Arrow Segment Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleArrowSegmentTitleContent(), ExpectedData.expectSwitcherStyleArrowSegmentTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleArrowSegmentTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentTitleDefault);
            Thread.sleep(5000);

            log.info("Step 15: Verify Switcher Style - Arrow Segment Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingArrowSegment(), ExpectedData.expectSwitcherStyleArrowSegmentSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingArrowSegment());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentSettingDefault);
            Thread.sleep(5000);

            log.info("Step 16: Verify Switcher Style - Arrow Segment Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingStyleArrowSegment(), ExpectedData.expectSwitcherStyleArrowSegmentStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingStyleArrowSegment());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentStyleDefault);
            Thread.sleep(5000);

            log.info("Step 17: Verify Switcher Style - Label Segment Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleLabelSegmentTitleContent(), ExpectedData.expectSwitcherStyleLabelSegmentTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLabelSegmentTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentTitleDefault);
            Thread.sleep(5000);

            log.info("Step 18: Verify Switcher Style - Label Segment Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLabelSegment(), ExpectedData.expectSwitcherStyleLabelSegmentSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLabelSegment());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentSettingDefault);
            Thread.sleep(5000);

            log.info("Step 19: Verify Switcher Style - Label Segment Note");
            Assert.assertEquals(transcyPage.getSwitcherStyleNoteLabelSegment(), ExpectedData.expectSwitcherStyleLabelSegmentNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteLabelSegment());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentNoteDefault);
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Style - Language Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleLanguageTitleContent(), ExpectedData.expectSwitcherStyleLanguageTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageTitleDefault);
            Thread.sleep(5000);

            log.info("Step 21: Verify Switcher Style - Language Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLanguage(), ExpectedData.expectSwitcherStyleLanguageSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLanguage());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageSettingDefault);
            Thread.sleep(5000);
//
            log.info("Step 22: Verify Switcher Style - Language Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusChecked());
            System.out.println("Expected result: " +transcyPage.getSwitcherStyleLanguageStatusChecked());
            Thread.sleep(5000);

            log.info("Step 23: Verify Switcher Style - Language Status: Enable");
            Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
            Thread.sleep(5000);

            log.info("Step 24: Verify Switcher Style - Language Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxLanguage(), ExpectedData.expectSwitcherStyleLanguageContentCheckboxDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxLanguage());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageContentCheckboxDefault);
            Thread.sleep(5000);

            log.info("Step 25: Verify Switcher Style - Currency Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleCurrencyTitleContent(), ExpectedData.expectSwitcherStyleCurrencyTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencyTitleDefault);
            Thread.sleep(5000);

            log.info("Step 26: Verify Switcher Style - Currency Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingCurrency(), ExpectedData.expectSwitcherStyleCurrencySettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingCurrency());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencySettingDefault);
            Thread.sleep(5000);
//
            log.info("Step 27: Verify Switcher Style - Currency Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherStyleCurrencyStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
            System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
            Thread.sleep(5000);

            log.info("Step 28: Verify Switcher Style - Currency Status: Enable");
            Assert.assertFalse(transcyPage.getSwitcherStyleCurrencyStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
            Thread.sleep(5000);

            log.info("Step 29: Verify Switcher Style - Currency Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxCurrency(), ExpectedData.expectSwitcherStyleCurrencyContentCheckboxDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxCurrency());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencyContentCheckboxDefault);
            Thread.sleep(5000);

            log.info("Step 30: Verify Switcher Style - Divider Format Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleDividerFormatTitleContent(), ExpectedData.expectSwitcherStyleDividerFormatTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleDividerFormatTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleDividerFormatTitleDefault);
            Thread.sleep(5000);

            log.info("Step 31: Verify Switcher Style - Divider Format Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingDividerFormat(), ExpectedData.expectSwitcherStyleDividerFormatSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingDividerFormat());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleDividerFormatSettingDefault);
            Thread.sleep(5000);

            log.info("Step 32: Verify Switcher Style - Font Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleFontTitleContent(), ExpectedData.expectSwitcherStyleFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleFontTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontTitleDefault);
            Thread.sleep(5000);

            log.info("Step 33: Verify Switcher Style - Font Value");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingFont(), ExpectedData.expectSwitcherStyleFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFont());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontValueDefault);
            Thread.sleep(5000);

            log.info("Step 34: Verify Switcher Style - Font Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFont(), ExpectedData.expectSwitcherStyleFontStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFont());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontStyleDefault);
            Thread.sleep(5000);

            log.info("Step 35: Verify Switcher Style - Font Note");
            Assert.assertEquals(transcyPage.getSwitcherStyleNoteFont(), ExpectedData.expectSwitcherStyleFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteFont());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontNoteDefault);
            Thread.sleep(5000);

            log.info("Step 36: Verify Switcher Style - Flag Style Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleFlagStyleTitleContent(), ExpectedData.expectSwitcherStyleFlagTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleFlagStyleTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagTitleDefault);
            Thread.sleep(5000);

            log.info("Step 37: Verify Switcher Style - Flag Style Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingFlagStyle(), ExpectedData.expectSwitcherStyleFlagSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFlagStyle());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagSettingDefault);
            Thread.sleep(5000);

            log.info("Step 38: Verify Switcher Style - Flag Style Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFlagStyle(), ExpectedData.expectSwitcherStyleFlagStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFlagStyle());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagStyleDefault);
            Thread.sleep(5000);

            log.info("=== Collapse Switcher Style Tab ===");
            transcyPage.clickToSwitcherStyleTab();

//        log.info("Step 50: Collapse Position Tab");
//        transcyPage.clickToPositionTab();

            log.info("=== Expand Switcher Disclosure Style Tab ===");
            transcyPage.clickToSwitcherDisclosureStyleTab();

            log.info("=== Verify Switcher Disclosure Style Tab ===");

            log.info("Step 01: Verify Switcher Disclosure Style Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleContent(), ExpectedData.expectSwitcherDisclosureStyleTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleDefault);
            Thread.sleep(5000);

            log.info("Step 02: Verify Switcher Disclosure Style - Width Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthTitleContent(), ExpectedData.expectSwitcherDisclosureStyleWidthTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleWidthTitleDefault);
            Thread.sleep(5000);

            log.info("Step 03: Verify Switcher Disclosure Style - Width Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthSetting(), ExpectedData.expectSwitcherDisclosureStyleWidthSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleWidthSettingDefault);
            Thread.sleep(5000);

            log.info("Step 04: Verify Switcher Disclosure Style - Width Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthValue(), ExpectedData.expectSwitcherDisclosureStyleWidthValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleWidthValueDefault);
            Thread.sleep(5000);

            log.info("Step 05: Verify Switcher Disclosure Style - Border Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderTitleContent(), ExpectedData.expectSwitcherDisclosureStyleBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleBorderTitleDefault);
            Thread.sleep(5000);

            log.info("Step 06: Verify Switcher Disclosure Style - Border Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderSetting(), ExpectedData.expectSwitcherDisclosureStyleBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleBorderSettingDefault);
            Thread.sleep(5000);

            log.info("Step 07: Verify Switcher Disclosure Style - Border Style");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderStyle(), ExpectedData.expectSwitcherDisclosureStyleBorderStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderStyle());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleBorderStyleDefault);
            Thread.sleep(5000);

            log.info("Step 08: Verify Switcher Disclosure Style - Active Effect Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectTitleContent(), ExpectedData.expectSwitcherDisclosureStyleActiveEffectTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleActiveEffectTitleDefault);
            Thread.sleep(5000);

            log.info("Step 09: Verify Switcher Disclosure Style - Active Effect Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectSetting(), ExpectedData.expectSwitcherDisclosureStyleActiveEffectSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleActiveEffectSettingDefault);
            Thread.sleep(5000);

            log.info("Step 10: Verify Switcher Disclosure Style - Active Effect Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectNote(), ExpectedData.expectSwitcherDisclosureStyleActiveEffectNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectNote());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleActiveEffectNoteDefault);
            Thread.sleep(5000);

            log.info("Step 11: Verify Switcher Disclosure Style - Element To Show Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleElementToShowTitleContent(), ExpectedData.expectSwitcherDisclosureStyleElementToShowTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleElementToShowTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleElementToShowTitleDefault);
            Thread.sleep(5000);

            log.info("Step 12: Verify Switcher Disclosure Style - Element To Show Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleElementToShowSetting(), ExpectedData.expectSwitcherDisclosureStyleElementToShowSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleElementToShowSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleElementToShowSettingDefault);
            Thread.sleep(5000);

            log.info("Step 13: Verify Switcher Disclosure Style - Language Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageTitleContent(), ExpectedData.expectSwitcherDisclosureStyleLanguageTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleLanguageTitleDefault);
            Thread.sleep(5000);

            log.info("Step 14: Verify Switcher Disclosure Style - Language Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageSetting(), ExpectedData.expectSwitcherDisclosureStyleLanguageSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleLanguageSettingDefault);
            Thread.sleep(5000);

            log.info("Step 15: Verify Switcher Disclosure Style - Language Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
            Thread.sleep(5000);

            log.info("Step 16: Verify Switcher Disclosure Style - Language Status: Enable");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
            Thread.sleep(5000);

            log.info("Step 17: Verify Switcher Disclosure Style - Language Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageCheckboxContent(), ExpectedData.expectSwitcherDisclosureStyleLanguageCheckboxContentDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageCheckboxContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleLanguageCheckboxContentDefault);
            Thread.sleep(5000);

            log.info("Step 18: Verify Switcher Disclosure Style - Currency Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencyTitleContent(), ExpectedData.expectSwitcherDisclosureStyleCurrencyTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleCurrencyTitleDefault);
            Thread.sleep(5000);

            log.info("Step 19: Verify Switcher Disclosure Style - Currency Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencySetting(), ExpectedData.expectSwitcherDisclosureStyleCurrencySettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencySetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleCurrencySettingDefault);
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Disclosure Style - Currency Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
            Thread.sleep(5000);

            log.info("Step 21: Verify Switcher Disclosure Style - Currency Status: Enable");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
            Thread.sleep(5000);

            log.info("Step 22: Verify Switcher Disclosure Style - Currency Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencyCheckboxContent(), ExpectedData.expectSwitcherDisclosureStyleCurrencyCheckboxContentDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyCheckboxContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleCurrencyCheckboxContentDefault);
//        Thread.sleep(5000);

            log.info("Step 23: Verify Switcher Disclosure Style - Title Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleTitleFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontTitleDefault);
            Thread.sleep(5000);

            log.info("Step 24: Verify Switcher Disclosure Style - Title Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontValue(), ExpectedData.expectSwitcherDisclosureStyleTitleFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontValueDefault);
            Thread.sleep(5000);

            log.info("Step 25: Verify Switcher Disclosure Style - Title Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontSetting(), ExpectedData.expectSwitcherDisclosureStyleTitleFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontSettingDefault);
            Thread.sleep(5000);

            log.info("Step 26: Verify Switcher Disclosure Style - Title Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontNote(), ExpectedData.expectSwitcherDisclosureStyleTitleFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontNote());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontNoteDefault);
            Thread.sleep(5000);

            log.info("Step 27: Verify Switcher Disclosure Style - Search Box Text Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontTitleDefault);
            Thread.sleep(5000);

            log.info("Step 28: Verify Switcher Disclosure Style - Search Box Text Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontValue(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontValueDefault);
            Thread.sleep(5000);

            log.info("Step 29: Verify Switcher Disclosure Style - Search Box Text Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontSetting(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontSettingDefault);
            Thread.sleep(5000);

            log.info("Step 30: Verify Switcher Disclosure Style - Search Box Text Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontNote(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontNote());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontNoteDefault);
            Thread.sleep(5000);

            log.info("Step 31: Verify Switcher Disclosure Style - Option Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleOptionFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontTitleDefault);
            Thread.sleep(5000);

            log.info("Step 32: Verify Switcher Disclosure Style - Option Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontValue(), ExpectedData.expectSwitcherDisclosureStyleOptionFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontValueDefault);
            Thread.sleep(5000);

            log.info("Step 33: Verify Switcher Disclosure Style - Option Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontSetting(), ExpectedData.expectSwitcherDisclosureStyleOptionFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontSettingDefault);
            Thread.sleep(5000);

            log.info("Step 34: Verify Switcher Disclosure Style - Option Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontNote(), ExpectedData.expectSwitcherDisclosureStyleOptionFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontNote());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontNoteDefault);
            Thread.sleep(5000);

            log.info("Step 35: Verify Switcher Disclosure Style - Selected Option Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontTitleDefault);
            Thread.sleep(5000);

            log.info("Step 36: Verify Switcher Disclosure Style - Selected Option Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontValue(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontValueDefault);
            Thread.sleep(5000);

            log.info("Step 37: Verify Switcher Disclosure Style - Selected Option Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontSetting(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontSettingDefault);
            Thread.sleep(5000);

            log.info("Step 38: Verify Switcher Disclosure Style - Selected Option Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontNote(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontNote());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontNoteDefault);
            Thread.sleep(5000);

            log.info("Step 39: Verify Switcher Disclosure Style - Flag Style Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleTitleContent(), ExpectedData.expectSwitcherDisclosureStyleFlagStyleTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleFlagStyleTitleDefault);
            Thread.sleep(5000);

            log.info("Step 40: Verify Switcher Disclosure Style - Flag Style Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleSetting(), ExpectedData.expectSwitcherDisclosureStyleFlagStyleSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleFlagStyleSettingDefault);
            Thread.sleep(5000);

            log.info("Step 41: Verify Switcher Disclosure Style - Flag Style Style");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleStyle(), ExpectedData.expectSwitcherDisclosureStyleFlagStyleStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleStyle());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleFlagStyleStyleDefault);
            Thread.sleep(5000);

            log.info("Step 42: Verify Switcher Disclosure Style - Button Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonTitleDefault);
            Thread.sleep(5000);

            log.info("Step 43: Verify Switcher Disclosure Style - Button - Width Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonWidthTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonWidthTitleDefault);
            Thread.sleep(5000);

            log.info("Step 44: Verify Switcher Disclosure Style - Button - Width Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonWidthSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonWidthSettingDefault);
            Thread.sleep(5000);

            log.info("Step 45: Verify Switcher Disclosure Style - Button - Width Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthValue(), ExpectedData.expectSwitcherDisclosureStyleButtonWidthValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonWidthValueDefault);
            Thread.sleep(5000);

            log.info("Step 46: Verify Switcher Disclosure Style - Button - Height Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonHeightTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonHeightTitleDefault);
            Thread.sleep(5000);

            log.info("Step 47: Verify Switcher Disclosure Style - Button - Height Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonHeightSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonHeightSettingDefault);
            Thread.sleep(5000);

            log.info("Step 48: Verify Switcher Disclosure Style - Button - Height Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightValue(), ExpectedData.expectSwitcherDisclosureStyleButtonHeightValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonHeightValueDefault);
            Thread.sleep(5000);

            log.info("Step 49: Verify Switcher Disclosure Style - Button - Shape Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonShapeTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonShapeTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonShapeTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonShapeTitleDefault);
            Thread.sleep(5000);

            log.info("Step 50: Verify Switcher Disclosure Style - Button - Shape Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonShapeSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonShapeSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonShapeSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonShapeSettingDefault);
            Thread.sleep(5000);

            log.info("Step 51: Verify Switcher Disclosure Style - Button - Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontTitleContent());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontTitleDefault);
            Thread.sleep(5000);

            log.info("Step 52: Verify Switcher Disclosure Style - Button - Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontValue(), ExpectedData.expectSwitcherDisclosureStyleButtonFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontValue());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontValueDefault);
            Thread.sleep(5000);

            log.info("Step 53: Verify Switcher Disclosure Style - Button - Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontSetting());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontSettingDefault);
            Thread.sleep(5000);

            log.info("Step 54: Verify Switcher Disclosure Style - Button - Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontNote(), ExpectedData.expectSwitcherDisclosureStyleButtonFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontNote());
            System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontNoteDefault);
            Thread.sleep(5000);

            log.info("=== Collapse Switcher Disclosure Style Tab ===");
            transcyPage.clickToSwitcherDisclosureStyleTab();

        }

    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }
}

