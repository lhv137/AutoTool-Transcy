package transcy;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.ExpectedData;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    String recoveryCode = "16E2-1DE1-B2BB";
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
            System.out.println("Store name: " + storeNameAdmin);

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
            log.info("Step 01: Verify Title Content on Modal");
            Assert.assertEquals(transcyPage.getContentTitleFirstModal(), ExpectedData.expectContentTitleModalFirst);
            System.out.println("Actual result: " + transcyPage.getContentTitleFirstModal());
            System.out.println("Expected result: " + ExpectedData.expectContentTitleModalFirst);
            Thread.sleep(5000);

            log.info("Step 02: Verify Heading Content on Modal 1");
            Assert.assertEquals(transcyPage.getContentHeadingModal1(), ExpectedData.expectContentHeadingModal1);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal1());
            System.out.println("Expected result: " + ExpectedData.expectContentHeadingModal1);
            Thread.sleep(5000);

            log.info("Step 03: Verify Content on Modal 1");
            Assert.assertEquals(transcyPage.getContentDescriptionModal1(), ExpectedData.expectContentDescriptionModal1);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal1());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModal1);
            Thread.sleep(5000);

            log.info("Step 04: Verify Image URL on Modal 1");
            Assert.assertEquals(transcyPage.getImageURLModal1(), ExpectedData.getExpectURLImageModal1);
            System.out.println("Actual result: " + transcyPage.getImageURLModal1());
            System.out.println("Expected result: " + ExpectedData.getExpectURLImageModal1);
            Thread.sleep(5000);

            log.info("Step 05: Go To Modal 2");
            transcyPage.clickToNextButton();

            log.info("Step 06: Verify Heading Content on Modal 2");
            Assert.assertEquals(transcyPage.getContentHeadingModal2(), ExpectedData.expectContentHeadingModal2);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal2());
            System.out.println("Expected result: " + ExpectedData.expectContentHeadingModal2);
            Thread.sleep(5000);

           log.info("Step 07: Verify Content on Modal 2");
            Assert.assertEquals(transcyPage.getContentDescriptionModal2(), ExpectedData.expectContentDescriptionModal2);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal2());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModal2);
            Thread.sleep(5000);

            log.info("Step 08: Verify Image URL on Modal 2");
            Assert.assertEquals(transcyPage.getImageURLModal2(), ExpectedData.getExpectURLImageModal2);
            System.out.println("Actual result: " + transcyPage.getImageURLModal2());
            System.out.println("Expected result: " + ExpectedData.getExpectURLImageModal2);
            Thread.sleep(5000);

            log.info("Step 09: Go To Modal 3");
            transcyPage.clickToNextButton();

            log.info("Step 10: Verify Heading Content on Modal 3");
            Assert.assertEquals(transcyPage.getContentHeadingModal3(), ExpectedData.expectContentHeadingModal3);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal3());
            System.out.println("Expected result: " + ExpectedData.expectContentHeadingModal3);
            Thread.sleep(5000);

            log.info("Step 11: Verify Content on Modal 3");
            Assert.assertEquals(transcyPage.getContentDescriptionModal3(), ExpectedData.expectContentDescriptionModal3);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal3());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModal3);
            Thread.sleep(5000);

            log.info("Step 11: Verify Image URL on Modal 3");
            Assert.assertEquals(transcyPage.getImageURLModal3(), ExpectedData.getExpectURLImageModal3);
            System.out.println("Actual result: " + transcyPage.getImageURLModal3());
            System.out.println("Expected result: " + ExpectedData.getExpectURLImageModal3);
            Thread.sleep(5000);

            log.info("Step 12: Go To Next Modal");
            transcyPage.clickToExploreNowButton();

            log.info("Step 13: Verify Title Content on Second Modal");
            Assert.assertEquals(transcyPage.getContentTitleSecondModal(), ExpectedData.expectContentTitleModalSecond);
            System.out.println("Actual result: " + transcyPage.getContentTitleSecondModal());
            System.out.println("Expected result: " + ExpectedData.expectContentTitleModalSecond);
            Thread.sleep(5000);

            log.info("Step 14: Verify Description Content on Second Modal");
            Assert.assertEquals(transcyPage.getContentDescriptionSecondModal(), ExpectedData.expectContentDescriptionModalSecond);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionSecondModal());
            System.out.println("Expected result: " + ExpectedData.expectContentDescriptionModalSecond);
            Thread.sleep(5000);

            log.info("Step 15: Click OK Do It Later Button");
            transcyPage.clickToDoItLaterButton();
        }

        @Test(enabled = false,priority = 6)
        public void VerifySwitcherSettingsDefaultGeneralTab () throws InterruptedException {

            log.info("Step 01: Verify Header Title Content");
            Assert.assertEquals(transcyPage.getTextHeaderTitle(), ExpectedData.expectContentHeaderTitle);
            System.out.println("Actual result: " + transcyPage.getTextHeaderTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentHeaderTitle);
            Thread.sleep(5000);

            log.info("Step 02: Verify Header Description  Content");
            Assert.assertEquals(transcyPage.getTextHeaderDescription(), ExpectedData.expectContentSubTitle);
            System.out.println("Actual result: " + transcyPage.getTextHeaderDescription());
            System.out.println("Expected result: " + ExpectedData.expectContentSubTitle);
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
            Assert.assertEquals(transcyPage.getTextTabContent(), ExpectedData.expectContentGeneralTab);
            System.out.println("Actual result: " + transcyPage.getTextTabContent());
            System.out.println("Expected result: " + ExpectedData.expectContentGeneralTab);
            Thread.sleep(5000);

            log.info("Step 04: Verify Switcher Display Title");
            Assert.assertEquals(transcyPage.getSwitcherDisplayTitle(), ExpectedData.expectContentSwitcherDisplayTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplayTitle);
            Thread.sleep(5000);

            log.info("Step 05: Verify Switcher Visibility Status");
            Assert.assertEquals(transcyPage.getSwitcherDisplayStatus(), true);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayStatus());
            Thread.sleep(5000);

            log.info("Step 06: Verify Switcher Display Label");
            Assert.assertEquals(transcyPage.getSwitcherDisplayLabel(), ExpectedData.expectContentSwitcherDisplayLabel);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayLabel());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplayLabel);
            Thread.sleep(5000);

            log.info("Step 07: Verify Switcher Display Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisplaySetting(), ExpectedData.expectContentSwitcherDisplaySetting);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplaySetting());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplaySetting);
            Thread.sleep(5000);

            log.info("Step 08: Verify Switcher Display Note");
            Assert.assertEquals(transcyPage.getSwitcherDisplayNote(), ExpectedData.expectContentSwitcherDisplayNote);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayNote());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisplayNote);
            Thread.sleep(5000);

            log.info("Step 09: Verify Switcher Diclosure Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureTitle(), ExpectedData.expectContentSwitcherDisclosureTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisclosureTitle);
            Thread.sleep(5000);

            log.info("Step 10: Verify Switcher Diclosure Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureSetting(), ExpectedData.expectContentSwitcherDisclosureSetting);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureSetting());
            System.out.println("Expected result: " + ExpectedData.expectContentSwitcherDisclosureSetting);
            Thread.sleep(5000);

            log.info("Step 11: Verify Geolocation Title");
            Assert.assertEquals(transcyPage.getGeolocationTitle(), ExpectedData.expectContentGeolocationTitle);
            System.out.println("Actual result: " + transcyPage.getGeolocationTitle());
            System.out.println("Expected result: " + ExpectedData.expectContentGeolocationTitle);
            Thread.sleep(5000);

            log.info("Step 12: Verify Geolocation Description");
            Assert.assertEquals(transcyPage.getGeolocationDescription(), ExpectedData.expectContentGeolocationDescription);
            System.out.println("Actual result: " + transcyPage.getGeolocationDescription());
            System.out.println("Expected result: " + ExpectedData.expectContentGeolocationDescription);
            Thread.sleep(5000);

            log.info("Step 13: Verify Banner Upgrade");
            Assert.assertEquals(transcyPage.getBannerUpgradeContent(), ExpectedData.expectContentBlockPlan);
            System.out.println("Actual result: " + transcyPage.getBannerUpgradeContent());
            System.out.println("Expected result: " + ExpectedData.expectContentBlockPlan);
            Thread.sleep(5000);

            log.info("Step 14: Verify Button Banner Upgrade");
            Assert.assertEquals(transcyPage.getButtonUpgradeContent(), ExpectedData.expectContentButtonBlockPlan);
            System.out.println("Actual result: " + transcyPage.getButtonUpgradeContent());
            System.out.println("Expected result: " + ExpectedData.expectContentButtonBlockPlan);
            Thread.sleep(5000);

            log.info("Step 15: Verify Unlock Feature Content");
            Assert.assertEquals(transcyPage.getUnLockFeatureModalContent(), ExpectedData.expectContentUnLockFeature);
            System.out.println("Actual result: " + transcyPage.getUnLockFeatureModalContent());
            System.out.println("Expected result: " + ExpectedData.expectContentUnLockFeature);
            Thread.sleep(5000);

            log.info("Step 16: Verify Button Unlock Feature Content");
            Assert.assertEquals(transcyPage.getButtonUnLockFeatureModalContent(), ExpectedData.expectContentButtonUnLockFeature);
            System.out.println("Actual result: " + transcyPage.getButtonUnLockFeatureModalContent());
            System.out.println("Expected result: " + ExpectedData.expectContentButtonUnLockFeature);
            Thread.sleep(5000);
        }
        @Test(enabled = false,priority = 7)
        public void VerifySwitcherSettingsDefaultTemplatesTab () throws InterruptedException {

            log.info("Step 01: Go to Templates Setting Tab");
            transcyPage.clickToTempalatesTab();

            log.info("Step 02: Verify Active Template Title");
            Assert.assertEquals(transcyPage.getActiveTemplateContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getActiveTemplateContent());
            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 03: Verify Active Template Default");
            Assert.assertEquals(transcyPage.getDefaultTemplateContent(), ExpectedData.expectContentDefaultTemplate);
            System.out.println("Actual result: " + transcyPage.getDefaultTemplateContent());
            System.out.println("Expected result: " + ExpectedData.expectContentDefaultTemplate);
            Thread.sleep(5000);

            log.info("Step 04: Verify Active Template Note");
            Assert.assertEquals(transcyPage.getStatusTemplateNote(), ExpectedData.expectContentTemplateNote);
            System.out.println("Actual result: " + transcyPage.getStatusTemplateNote());
            System.out.println("Expected result: " + ExpectedData.expectContentTemplateNote);
            Thread.sleep(5000);

            log.info("Step 05: Verify Active Template Button");
            Assert.assertEquals(transcyPage.getTemplateButton(), ExpectedData.expectContentTemplateButton);
            System.out.println("Actual result: " + transcyPage.getTemplateButton());
            System.out.println("Expected result: " + ExpectedData.expectContentTemplateButton);
            Thread.sleep(5000);

            log.info("Step 06: Verify Transcy Templates Title");
            Assert.assertEquals(transcyPage.getTranscyTemplateContent(), ExpectedData.expectContentTranscyTemplate);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateContent());
            System.out.println("Expected result: " + ExpectedData.expectContentTranscyTemplate);
            Thread.sleep(5000);

            log.info("Step 07: Verify More Items Setting");
            Assert.assertEquals(transcyPage.getMoreItemsSettingContent(), ExpectedData.expectContentMoreItemsSetting);
            System.out.println("Actual result: " + transcyPage.getMoreItemsSettingContent());
            System.out.println("Expected result: " + ExpectedData.expectContentMoreItemsSetting);
            Thread.sleep(5000);

            log.info("Step 08: Verify Transcy Templates Default");
            Assert.assertEquals(transcyPage.getTranscyTemplateDefault(), ExpectedData.expectContentTranscyTemplateDefault);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateDefault());
            System.out.println("Expected result: " + ExpectedData.expectContentTranscyTemplateDefault);
            Thread.sleep(5000);

            log.info("Step 09: Verify Transcy Templates Button");
            Assert.assertEquals(transcyPage.getButtonTranscyTemplateDefault(), ExpectedData.expectContentTranscyTemplateButton);
            System.out.println("Actual result: " + transcyPage.getButtonTranscyTemplateDefault());
            System.out.println("Expected result: " + ExpectedData.expectContentTranscyTemplateButton);
            Thread.sleep(5000);
        }
        @Test(priority = 8)
        public void VerifySwitcherSettingsDefaultCustomizationTab () throws InterruptedException {

            log.info("Step 01: Go to Customization Setting Tab");
            transcyPage.clickToCustomizationTab();

            log.info("Step 02: Verify Position Title");
//            Assert.assertEquals(transcyPage.getPositionTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getPositionTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 03: Verify Preference Title");
//            Assert.assertEquals(transcyPage.getPreferenceTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getPreferenceTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 04: Verify Preference Setting type");
//            Assert.assertEquals(transcyPage.getPreferenceSettingType(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getPreferenceSettingType());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 05: Verify Preference Setting position");
//            Assert.assertEquals(transcyPage.getPreferenceSettingPosition(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getPreferenceSettingPosition());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 06: Verify Offset Title");
//            Assert.assertEquals(transcyPage.getOffsetTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getOffsetTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 07: Verify Offset Top");
//            Assert.assertEquals(transcyPage.getOffsetSettingTop(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getOffsetSettingTop());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 08: Verify Offset Right");
//            Assert.assertEquals(transcyPage.getOffsetSettingRight(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getOffsetSettingRight());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 09: Verify Switcher Style Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 10: Verify Switcher Style - Width Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleWidthTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleWidthTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 11: Verify Switcher Style - Width Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidth(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidth());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 12: Verify Switcher Style - Width Value");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidthValue(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidthValue());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 13: Verify Switcher Style - Border Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleBorderTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleBorderTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 14: Verify Switcher Style - Border Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorder(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorder());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 15: Verify Switcher Style - Border Style");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorderStyle(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorderStyle());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 16: Verify Switcher Style - Effect Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleEffectTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleEffectTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 17: Verify Switcher Style - Effect Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingEffect(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingEffect());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 18: Verify Switcher Style - Hover & active Effect Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleHoverEffectTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleHoverEffectTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 19: Verify Switcher Style - Hover & active Effect Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingHoverEffect(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingHoverEffect());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Style - Effect Note");
//            Assert.assertEquals(transcyPage.getSwitcherStyleNoteEffect(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteEffect());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 21: Verify Switcher Style - Layout Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 22: Verify Switcher Style - Layout Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLayout(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLayout());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 23: Verify Switcher Style - Arrow Segment Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleArrowSegmentTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleArrowSegmentTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 24: Verify Switcher Style - Arrow Segment Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingArrowSegment(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingArrowSegment());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 25: Verify Switcher Style - Arrow Segment Style");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingStyleArrowSegment(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingStyleArrowSegment());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 26: Verify Switcher Style - Label Segment Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleLabelSegmentTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLabelSegmentTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 27: Verify Switcher Style - Label Segment Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLabelSegment(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLabelSegment());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 28: Verify Switcher Style - Label Segment Note");
//            Assert.assertEquals(transcyPage.getSwitcherStyleNoteLabelSegment(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteLabelSegment());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 29: Verify Switcher Style - Language Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleLanguageTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 30: Verify Switcher Style - Language Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLanguage(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLanguage());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 31: Verify Switcher Style - Language Status");
//            Assert.assertEquals(transcyPage.getSwitcherStyleLanguageStatus(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusChecked());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 32: Verify Switcher Style - Language Content Checkbox");
//            Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxLanguage(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxLanguage());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 33: Verify Switcher Style - Currency Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleCurrencyTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 34: Verify Switcher Style - Currency Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingCurrency(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingCurrency());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 35: Verify Switcher Style - Currency Status");
//            Assert.assertEquals(transcyPage.getSwitcherStyleCurrencyStatus(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 36: Verify Switcher Style - Currency Content Checkbox");
//            Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxCurrency(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxCurrency());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 37: Verify Switcher Style - Divider Format Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleDividerFormatTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleDividerFormatTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 38: Verify Switcher Style - Divider Format Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingDividerFormat(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingDividerFormat());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 39: Verify Switcher Style - Font Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleFontTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleFontTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 40: Verify Switcher Style - Font Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingFont(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFont());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 41: Verify Switcher Style - Font Style");
//            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFont(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFont());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 42: Verify Switcher Style - Font Note");
//            Assert.assertEquals(transcyPage.getSwitcherStyleNoteFont(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteFont());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 43: Verify Switcher Style - Flag Style Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleFlagStyleTitleContent(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleFlagStyleTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 44: Verify Switcher Style - Flag Style Setting");
//            Assert.assertEquals(transcyPage.getSwitcherStyleSettingFlagStyle(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFlagStyle());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 45: Verify Switcher Style - Flag Style Style");
//            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFlagStyle(), ExpectedData.expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFlagStyle());
//            System.out.println("Expected result: " + ExpectedData.expectContentActiveTemplateTitle);
            Thread.sleep(5000);


        }

//    @AfterClass
//    public void quitBrowser() {
//        closeBrowserAndDriver(driver);
//    }
}

