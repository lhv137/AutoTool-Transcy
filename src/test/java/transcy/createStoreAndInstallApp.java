package transcy;

import commons.AbstractTest;
import configs.Config;
import expectedData.ExpectedDataSwitcherSettingDefault;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.TransyPO;

public class createStoreAndInstallApp extends AbstractTest {
    private WebDriver driver;
    private TransyPO transcyPage;

    @BeforeTest
    public void beforeTest() {
//        driver = getBrowserDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        transcyPage = PageGeneratorManager.getShopifyPage(driver);
        driver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Login Partner FireApps Dev")
    public void LoginPartnerFireAppsDev() throws InterruptedException {

        Thread.sleep(3000);
        log.info("=== Open Browser & Get Partner URL ===");
        driver.get(Config.partnerURL);

        log.info("Step 01: Press Login Partner Button");
        transcyPage.clickToLoginPartnerBtn();

        log.info("Step 02: Fill Email Account Partner");
        transcyPage.inputToEmailAccountPartner(Config.emailPartner);

        log.info("Step 03: Press Continue With Email Button");
        transcyPage.clickToContinueWithEmailBtn();

        log.info("Step 04: Fill Password Account Partner");
        transcyPage.inputTPasswordAccountPartner(Config.passwordPartner);

        log.info("Step 05: Press Login Button");
        transcyPage.clickToLoginBtn();

        log.info("Step 06: Press Use A Recovery Code Button");
        transcyPage.clickToUseARecoveryCodeBtn();

        log.info("Step 07: Fill Recovery Code");
        transcyPage.inputRecoveryCode(Config.recoveryCode);

        log.info("Step 08: Press Login Button");
        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

        log.info("Step 09: Press Partner Button");
        transcyPage.clickToSelectPartnerBtn();

    }

    @Test(priority = 2, description = "Create Store Test In Partnrt FireApps Dev")
    public void CreateStoreTestInPartner() throws InterruptedException {
        Thread.sleep(3000);
        log.info("=== Create Store Test ===");

        log.info("Step 01: Press Stores Menu");
        transcyPage.selectMenuStoresBtn();

        log.info("Step 02: Press Add Store Button");
        transcyPage.clickToAddStore();

        log.info("Step 03: Press Create Development Store Button");
        transcyPage.clickToCreateDevelopmentStore();

        log.info("Step 04: Select Store Test And Build Option");
        transcyPage.selectOptionStoreTest();

        log.info("Step 05: Fill Store name");
        transcyPage.inputStoreName(Config.storeName);
        System.out.println("Store name: " + Config.storeName);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2000)");

        log.info("Step 06: Select Start With test Data Option");
        transcyPage.selectOprionStartWithTestData();

        log.info("Step 07: Press Create Development Store Button");
        transcyPage.clickToAddDevelopmentStoreBtn();

//        log.info("Step 08: Choose account to login");
//        transcyPage.clickToChooseAccountBtn();
//        Thread.sleep(10000);
    }

        @Test(priority = 3, description = "Add Store Test In Admin Tool Transcy UAT")
        public void AddStoreTestTranscyInAdminTool () throws InterruptedException {
            String storeNameAdmin = Config.storeName + ".myshopify.com";

            log.info("=== Open Admin & Add Store Test ===");

            log.info("Step 01: Go To Admin Tool");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(Config.adminToolUATURL);

            log.info("Step 02: Fill Username Admin Tool");
            transcyPage.inputUserNameAdminTool(Config.userNameAdminTool);

            log.info("Step 03: Fill Password Admin Tool");
            transcyPage.inputPassWordAdminTool(Config.passWordAdminTool);

            log.info("Step 04: Login Admin tool");
            transcyPage.clickToLoginAdminToolBtn();

            log.info("Step 05: Go To Manage Test Store Menu");
            transcyPage.clickToManageTestStoreBtn();

            log.info("Step 06: Fill Store Domain To Add Store Test");
            transcyPage.inputStoreTestDomain(storeNameAdmin);
            System.out.println("Store domain: " + storeNameAdmin);

            log.info("Step 07: Click Add Store Test");
            transcyPage.clickToAddTestStoreBtn();

            log.info("Step 08: Handle Alert");
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(10000);
        }

        @Test(priority = 4, description = "Install Transcy UAT App In FireApp Dev")
        public void InstallTranscyAppUAT () throws InterruptedException {
            String storeTest = Config.storeName + ".myshopify.com";

            log.info("=== Re-Login Partner & Install Transcy UAT App ===");

            // Login Partner Shopify
            log.info("Step 01: Re-Login Partner Shopify");
            Thread.sleep(3000);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(Config.partnerURL);

            log.info("Step 02: Press Login Partner Button");
            transcyPage.clickToLoginPartnerBtn();

            log.info("Step 03: Select Partner Button");
            transcyPage.clickToSelectPartnerBtn();

            log.info("Step 04: Go To Apps Menu");
            transcyPage.selectMenuAppsBtn();

            log.info("Step 05: Search Transcy UAT V4 App");
            transcyPage.searchAppTranscyUATV4(Config.appName);

            log.info("Step 06: Click To Select Transcy UAT V4 App");
            transcyPage.clickToSelectTranscyUATV4App();

            log.info("Step 07: Click To Select Store Button");
            transcyPage.clickToSelectStoreBtn();

            log.info("Step 08: Search Store Domain");
            transcyPage.searchStoreDomainToInstallApp(storeTest);

            log.info("Step 09: Select Store Domain to Install App");
            transcyPage.selectStoreDomainToInstallApp();

//            log.info("Step 10: Click Choose Partner Account Button");
//            transcyPage.clickToChooseAccountPartnerBtn();
//            Thread.sleep(5000);

            log.info("Step 10: Click Install Transcy V4 App Button");
            transcyPage.clickToInstallTranscyV4AppBtn();

            log.info("Step 11: Click Choose Free Plan Transcy V4 App Button");
            transcyPage.clickToChooseFreePlanTranscyV4AppBtn();

            log.info("Step 12: Click To Switcher Menu Button");
            transcyPage.clickSwitcherMenuBtn();
        }

        @Test(priority = 5, description = "Verify Modal In First Time Go To Switcher Menu")
        public void VerifyModalFirstTimeGoToMenuSwitcher () throws InterruptedException {

            log.info("=== Verify Setting Default In Modal ===");

            log.info("Step 01: Verify Title Content On Modal");
            Assert.assertEquals(transcyPage.getContentTitleFirstModal(), ExpectedDataSwitcherSettingDefault.expectContentTitleModalFirstDefault);
            System.out.println("Actual result: " + transcyPage.getContentTitleFirstModal());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentTitleModalFirstDefault);
            Thread.sleep(3000);

            log.info("Step 02: Verify Heading Content On Modal 1");
            Assert.assertEquals(transcyPage.getContentHeadingModal1(), ExpectedDataSwitcherSettingDefault.expectContentHeadingModal1Default);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal1());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentHeadingModal1Default);
            Thread.sleep(3000);

            log.info("Step 03: Verify Content On Modal 1");
            Assert.assertEquals(transcyPage.getContentDescriptionModal1(), ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal1Default);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal1());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal1Default);
            Thread.sleep(3000);

            log.info("Step 04: Verify Image URL On Modal 1");
            Assert.assertEquals(transcyPage.getImageURLModal1(), ExpectedDataSwitcherSettingDefault.getExpectURLImageModal1Default);
            System.out.println("Actual result: " + transcyPage.getImageURLModal1());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.getExpectURLImageModal1Default);
            Thread.sleep(3000);

            log.info("=== Go To Modal 2 ===");
            transcyPage.clickToNextButton();

            log.info("Step 05: Verify Heading Content On Modal 2");
            Assert.assertEquals(transcyPage.getContentHeadingModal2(), ExpectedDataSwitcherSettingDefault.expectContentHeadingModal2Default);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal2());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentHeadingModal2Default);
            Thread.sleep(3000);

           log.info("Step 06: Verify Content On Modal 2");
            Assert.assertEquals(transcyPage.getContentDescriptionModal2(), ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal2Default);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal2());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal2Default);
            Thread.sleep(3000);

            log.info("Step 07: Verify Image URL On Modal 2");
            Assert.assertEquals(transcyPage.getImageURLModal2(), ExpectedDataSwitcherSettingDefault.getExpectURLImageModal2Default);
            System.out.println("Actual result: " + transcyPage.getImageURLModal2());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.getExpectURLImageModal2Default);
            Thread.sleep(3000);

            log.info("=== Go To Modal 3 ===");
            transcyPage.clickToNextButton();

            log.info("Step 08: Verify Heading Content On Modal 3");
            Assert.assertEquals(transcyPage.getContentHeadingModal3(), ExpectedDataSwitcherSettingDefault.expectContentHeadingModal3Default);
            System.out.println("Actual result: " + transcyPage.getContentHeadingModal3());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentHeadingModal3Default);
            Thread.sleep(3000);

            log.info("Step 09: Verify Content On Modal 3");
            Assert.assertEquals(transcyPage.getContentDescriptionModal3(), ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal3Default);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal3());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal3Default);
            Thread.sleep(3000);

            log.info("Step 10: Verify Image URL On Modal 3");
            Assert.assertEquals(transcyPage.getImageURLModal3(), ExpectedDataSwitcherSettingDefault.getExpectURLImageModal3Default);
            System.out.println("Actual result: " + transcyPage.getImageURLModal3());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.getExpectURLImageModal3Default);
            Thread.sleep(3000);

            log.info("=== Go To Modal 4 ===");
            transcyPage.clickToExploreNowButton();

            log.info("Step 11: Verify Title Content On Modal 4");
            Assert.assertEquals(transcyPage.getContentTitleModal4(), ExpectedDataSwitcherSettingDefault.expectContentTitleModal4Default);
            System.out.println("Actual result: " + transcyPage.getContentTitleModal4());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentTitleModal4Default);
            Thread.sleep(3000);

            log.info("Step 12: Verify Description Content On Modal 4");
            Assert.assertEquals(transcyPage.getContentDescriptionModal4(), ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal4Default);
            System.out.println("Actual result: " + transcyPage.getContentDescriptionModal4());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentDescriptionModal4Default);
            Thread.sleep(3000);

            log.info("=== Click OK Do It Later Button ===");
            transcyPage.clickToDoItLaterButton();
        }

        @Test(priority = 6, description = "Verify Switcher Setting Default In General Tab")
        public void VerifySwitcherSettingsDefaultGeneralTab () throws InterruptedException {

            log.info("=== Verify Setting Default General Setting Tab ===");

            log.info("Step 01: Verify Header Title Content");
            Assert.assertEquals(transcyPage.getTextHeaderTitle(), ExpectedDataSwitcherSettingDefault.expectContentHeaderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getTextHeaderTitle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentHeaderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 02: Verify Header Description  Content");
            Assert.assertEquals(transcyPage.getTextHeaderDescription(), ExpectedDataSwitcherSettingDefault.expectContentSubTitleDefault);
            System.out.println("Actual result: " + transcyPage.getTextHeaderDescription());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentSubTitleDefault);
            Thread.sleep(3000);

    //        log.info("Step 16: Verify General Header Title");
    //////        transcyPage.clickToTempalatesTab();
    //        WebElement selectText = driver.findElement(By.cssSelector(".Polaris-Tabs__Wrapper"));
    //        selectText.getText();
    //        System.out.println("Text is: " +selectText);
    //////        Assert.assertEquals(transcyPage.getTextGeneralTitle(),expectContentGeneralTitle);
    ////        System.out.println("Actual result: " + transcyPage.getTextGeneralTitle());
    //        System.out.println("Expected result: " + expectContentGeneralTitle);

            log.info("Step 03: Verify General Tab Content");
            Assert.assertEquals(transcyPage.getTextTabContent(), ExpectedDataSwitcherSettingDefault.expectContentGeneralTabDefault);
            System.out.println("Actual result: " + transcyPage.getTextTabContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentGeneralTabDefault);
            Thread.sleep(3000);

            log.info("Step 04: Verify Switcher Display Title");
            Assert.assertEquals(transcyPage.getSwitcherDisplayTitle(), ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplayTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayTitle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplayTitleDefault);
            Thread.sleep(3000);

            log.info("Step 05: Verify Switcher Visibility Status");
            Assert.assertTrue(transcyPage.getSwitcherDisplayStatus());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayStatus());
            Thread.sleep(3000);

            log.info("Step 06: Verify Switcher Display Label");
            Assert.assertEquals(transcyPage.getSwitcherDisplayLabel(), ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplayLabelDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayLabel());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplayLabelDefault);
            Thread.sleep(3000);

            log.info("Step 07: Verify Switcher Display Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisplaySetting(), ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplaySettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplaySetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplaySettingDefault);
            Thread.sleep(3000);

            log.info("Step 08: Verify Switcher Display Note");
            Assert.assertEquals(transcyPage.getSwitcherDisplayNote(), ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplayNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisplayNoteDefault);
            Thread.sleep(3000);

            log.info("Step 09: Verify Switcher Diclosure Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureTitle(), ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisclosureTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureTitle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisclosureTitleDefault);
            Thread.sleep(3000);

            log.info("Step 10: Verify Switcher Diclosure Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureSetting(), ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisclosureSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentSwitcherDisclosureSettingDefault);
            Thread.sleep(3000);

            log.info("Step 11: Verify Geolocation Title");
            Assert.assertEquals(transcyPage.getGeolocationTitle(), ExpectedDataSwitcherSettingDefault.expectContentGeolocationTitleDefault);
            System.out.println("Actual result: " + transcyPage.getGeolocationTitle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentGeolocationTitleDefault);
            Thread.sleep(3000);

            log.info("Step 12: Verify Geolocation Description");
            Assert.assertEquals(transcyPage.getGeolocationDescription(), ExpectedDataSwitcherSettingDefault.expectContentGeolocationDescriptionDefault);
            System.out.println("Actual result: " + transcyPage.getGeolocationDescription());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentGeolocationDescriptionDefault);
            Thread.sleep(3000);

            log.info("Step 13: Verify Banner Upgrade");
            Assert.assertEquals(transcyPage.getBannerUpgradeContent(), ExpectedDataSwitcherSettingDefault.expectContentBlockPlanDefault);
            System.out.println("Actual result: " + transcyPage.getBannerUpgradeContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentBlockPlanDefault);
            Thread.sleep(3000);

            log.info("Step 14: Verify Button Banner Upgrade");
            Assert.assertEquals(transcyPage.getButtonUpgradeContent(), ExpectedDataSwitcherSettingDefault.expectContentButtonBlockPlanDefault);
            System.out.println("Actual result: " + transcyPage.getButtonUpgradeContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentButtonBlockPlanDefault);
            Thread.sleep(3000);

            log.info("Step 15: Verify Unlock Feature Content");
            Assert.assertEquals(transcyPage.getUnLockFeatureModalContent(), ExpectedDataSwitcherSettingDefault.expectContentUnLockFeatureDefault);
            System.out.println("Actual result: " + transcyPage.getUnLockFeatureModalContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentUnLockFeatureDefault);
            Thread.sleep(3000);

            log.info("Step 16: Verify Button Unlock Feature Content");
            Assert.assertEquals(transcyPage.getButtonUnLockFeatureModalContent(), ExpectedDataSwitcherSettingDefault.expectContentButtonUnLockFeatureDefault);
            System.out.println("Actual result: " + transcyPage.getButtonUnLockFeatureModalContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentButtonUnLockFeatureDefault);
            Thread.sleep(3000);
        }
        @Test(priority = 7, description = "Verify Switcher Setting Default In Templates Tab")
        public void VerifySwitcherSettingsDefaultTemplatesTab () throws InterruptedException {

            log.info("=== Go to Templates Setting Tab ===");
            transcyPage.clickToTempalatesTab();

            log.info("=== Verify Setting Default Templates Setting Tab ===");

            log.info("Step 01: Verify Active Template Title");
            Assert.assertEquals(transcyPage.getActiveTemplateContent(), ExpectedDataSwitcherSettingDefault.expectContentActiveTemplateTitleDefault);
            System.out.println("Actual result: " + transcyPage.getActiveTemplateContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentActiveTemplateTitleDefault);
            Thread.sleep(3000);

            log.info("Step 02: Verify Active Template Default");
            Assert.assertEquals(transcyPage.getDefaultTemplateContent(), ExpectedDataSwitcherSettingDefault.expectContentDefaultTemplateDefault);
            System.out.println("Actual result: " + transcyPage.getDefaultTemplateContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentDefaultTemplateDefault);
            Thread.sleep(3000);

            log.info("Step 03: Verify Active Template Note");
            Assert.assertEquals(transcyPage.getStatusTemplateNote(), ExpectedDataSwitcherSettingDefault.expectContentTemplateNoteDefault);
            System.out.println("Actual result: " + transcyPage.getStatusTemplateNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentTemplateNoteDefault);
            Thread.sleep(3000);

            log.info("Step 04: Verify Active Template Button");
            Assert.assertEquals(transcyPage.getTemplateButton(), ExpectedDataSwitcherSettingDefault.expectContentTemplateButtonDefault);
            System.out.println("Actual result: " + transcyPage.getTemplateButton());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentTemplateButtonDefault);
            Thread.sleep(3000);

            log.info("Step 05: Verify Transcy Templates Title");
            Assert.assertEquals(transcyPage.getTranscyTemplateContent(), ExpectedDataSwitcherSettingDefault.expectContentTranscyTemplateDefault);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentTranscyTemplateDefault);
            Thread.sleep(3000);

            log.info("Step 06: Verify More Items Setting");
            Assert.assertEquals(transcyPage.getMoreItemsSettingContent(), ExpectedDataSwitcherSettingDefault.expectContentMoreItemsSettingDefault);
            System.out.println("Actual result: " + transcyPage.getMoreItemsSettingContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentMoreItemsSettingDefault);
            Thread.sleep(3000);

            log.info("Step 07: Verify Transcy Templates Default");
            Assert.assertEquals(transcyPage.getTranscyTemplateDefault(), ExpectedDataSwitcherSettingDefault.expectContentTranscyTemplateDefaultDefault);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateDefault());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentTranscyTemplateDefaultDefault);
            Thread.sleep(3000);

            log.info("Step 08: Verify Transcy Templates Button");
            Assert.assertEquals(transcyPage.getButtonTranscyTemplateDefault(), ExpectedDataSwitcherSettingDefault.expectContentTranscyTemplateButtonDefault);
            System.out.println("Actual result: " + transcyPage.getButtonTranscyTemplateDefault());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectContentTranscyTemplateButtonDefault);
            Thread.sleep(3000);
        }
        @Test(priority = 8, description = "Verify Switcher Setting Default In Customization Tab")
        public void VerifySwitcherSettingsDefaultCustomizationTab () throws InterruptedException {


            log.info("=== Go to Customization Setting Tab ===");
            transcyPage.clickToCustomizationTab();

            log.info("=== Verify Setting Default Position Tab ===");

            log.info("Step 01: Verify Position Title");
            Assert.assertEquals(transcyPage.getPositionTitleContent(), ExpectedDataSwitcherSettingDefault.expectPositionTitleDefault);
            System.out.println("Actual result: " + transcyPage.getPositionTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectPositionTitleDefault);
            Thread.sleep(3000);

            log.info("Step 02: Verify Preference Title");
            Assert.assertEquals(transcyPage.getPreferenceTitleContent(), ExpectedDataSwitcherSettingDefault.expectPreferenceTitleDefault);
            System.out.println("Actual result: " + transcyPage.getPreferenceTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectPreferenceTitleDefault);
            Thread.sleep(3000);

            log.info("Step 03: Verify Preference Setting type");
            Assert.assertEquals(transcyPage.getPreferenceSettingType(), ExpectedDataSwitcherSettingDefault.expectPreferenceSettingTypeDefault);
            System.out.println("Actual result: " + transcyPage.getPreferenceSettingType());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectPreferenceSettingTypeDefault);
            Thread.sleep(3000);

            log.info("Step 04: Verify Preference Setting position");
            Assert.assertEquals(transcyPage.getPreferenceSettingPosition(), ExpectedDataSwitcherSettingDefault.expectPreferenceSettingPositionDefault);
            System.out.println("Actual result: " + transcyPage.getPreferenceSettingPosition());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectPreferenceSettingPositionDefault);
            Thread.sleep(3000);

            log.info("Step 05: Verify Offset Title");
            Assert.assertEquals(transcyPage.getOffsetTitleContent(), ExpectedDataSwitcherSettingDefault.expectOffsetTitleDefault);
            System.out.println("Actual result: " + transcyPage.getOffsetTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectOffsetTitleDefault);
            Thread.sleep(3000);

            log.info("Step 06: Verify Offset Top");
            Assert.assertEquals(transcyPage.getOffsetSettingTop(), ExpectedDataSwitcherSettingDefault.expectOffsetSettingTopValueDefault);
            System.out.println("Actual result: " + transcyPage.getOffsetSettingTop());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectOffsetSettingTopValueDefault);
            Thread.sleep(3000);

            log.info("Step 07: Verify Offset Right");
            Assert.assertEquals(transcyPage.getOffsetSettingRight(), ExpectedDataSwitcherSettingDefault.expectOffsetSettingRightValueDefault);
            System.out.println("Actual result: " + transcyPage.getOffsetSettingRight());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectOffsetSettingRightValueDefault);
            Thread.sleep(3000);

            log.info("Step 08: Verify Switcher Style Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleTitleDefault);
            Thread.sleep(3000);

            log.info("=== Collapse Position Tab ===");
            transcyPage.clickToPositionTab();

            log.info("=== Expand Switcher Style Tab ===");
            transcyPage.clickToSwitcherStyleTab();

            log.info("=== Verify Setting Default Switcher Style Tab ===");

            log.info("Step 01: Verify Switcher Style - Width Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleWidthTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleWidthTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleWidthTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleWidthTitleDefault);
            Thread.sleep(3000);

            log.info("Step 02: Verify Switcher Style - Width Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidth(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleWidthSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidth());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleWidthSettingDefault);
            Thread.sleep(3000);

            log.info("Step 03: Verify Switcher Style - Width Value");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidthValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleWidthValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidthValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleWidthValueDefault);
            Thread.sleep(3000);

            log.info("Step 04: Verify Switcher Style - Border Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 05: Verify Switcher Style - Border Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorder(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorder());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 06: Verify Switcher Style - Border Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorderStyle(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleBorderStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorderStyle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleBorderStyleDefault);
            Thread.sleep(3000);

            log.info("Step 07: Verify Switcher Style - Effect Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleEffectTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleEffectTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleEffectTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleEffectTitleDefault);
            Thread.sleep(3000);

            log.info("Step 08: Verify Switcher Style - Effect Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingEffect(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleEffectSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingEffect());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleEffectSettingDefault);
            Thread.sleep(3000);

            log.info("Step 09: Verify Switcher Style - Hover & active Effect Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleHoverEffectTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleHoverEffectTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleHoverEffectTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleHoverEffectTitleDefault);
            Thread.sleep(3000);

            log.info("Step 10: Verify Switcher Style - Hover & active Effect Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingHoverEffect(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleHoverEffectSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingHoverEffect());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleHoverEffectSettingDefault);
            Thread.sleep(3000);

            log.info("Step 11: Verify Switcher Style - Effect Note");
            Assert.assertEquals(transcyPage.getSwitcherStyleNoteEffect(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleEffectNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteEffect());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleEffectNoteDefault);
            Thread.sleep(3000);

            log.info("Step 12: Verify Switcher Style - Layout Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLayoutTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLayoutTitleDefault);
            Thread.sleep(3000);

            log.info("Step 13: Verify Switcher Style - Layout Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLayout(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLayoutSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLayout());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLayoutSettingDefault);
            Thread.sleep(3000);

            log.info("Step 14: Verify Switcher Style - Arrow Segment Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleArrowSegmentTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleArrowSegmentTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleArrowSegmentTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleArrowSegmentTitleDefault);
            Thread.sleep(3000);

            log.info("Step 15: Verify Switcher Style - Arrow Segment Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingArrowSegment(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleArrowSegmentSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingArrowSegment());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleArrowSegmentSettingDefault);
            Thread.sleep(3000);

            log.info("Step 16: Verify Switcher Style - Arrow Segment Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingStyleArrowSegment(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleArrowSegmentStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingStyleArrowSegment());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleArrowSegmentStyleDefault);
            Thread.sleep(3000);

            log.info("Step 17: Verify Switcher Style - Label Segment Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleLabelSegmentTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLabelSegmentTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLabelSegmentTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLabelSegmentTitleDefault);
            Thread.sleep(3000);

            log.info("Step 18: Verify Switcher Style - Label Segment Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLabelSegment(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLabelSegmentSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLabelSegment());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLabelSegmentSettingDefault);
            Thread.sleep(3000);

            log.info("Step 19: Verify Switcher Style - Label Segment Note");
            Assert.assertEquals(transcyPage.getSwitcherStyleNoteLabelSegment(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLabelSegmentNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteLabelSegment());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLabelSegmentNoteDefault);
            Thread.sleep(3000);

            log.info("Step 20: Verify Switcher Style - Language Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleLanguageTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLanguageTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLanguageTitleDefault);
            Thread.sleep(3000);

            log.info("Step 21: Verify Switcher Style - Language Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingLanguage(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLanguageSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLanguage());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLanguageSettingDefault);
            Thread.sleep(3000);

            log.info("Step 22: Verify Switcher Style - Language Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusChecked());
            System.out.println("Expected result: " +transcyPage.getSwitcherStyleLanguageStatusChecked());
            Thread.sleep(3000);

            log.info("Step 23: Verify Switcher Style - Language Status: Enable");
            Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
            Thread.sleep(3000);

            log.info("Step 24: Verify Switcher Style - Language Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxLanguage(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLanguageContentCheckboxDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxLanguage());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleLanguageContentCheckboxDefault);
            Thread.sleep(3000);

            log.info("Step 25: Verify Switcher Style - Currency Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleCurrencyTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleCurrencyTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleCurrencyTitleDefault);
            Thread.sleep(3000);

            log.info("Step 26: Verify Switcher Style - Currency Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingCurrency(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleCurrencySettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingCurrency());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleCurrencySettingDefault);
            Thread.sleep(3000);

            log.info("Step 27: Verify Switcher Style - Currency Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherStyleCurrencyStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
            System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
            Thread.sleep(3000);

            log.info("Step 28: Verify Switcher Style - Currency Status: Enable");
            Assert.assertFalse(transcyPage.getSwitcherStyleCurrencyStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
            Thread.sleep(3000);

            log.info("Step 29: Verify Switcher Style - Currency Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxCurrency(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleCurrencyContentCheckboxDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxCurrency());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleCurrencyContentCheckboxDefault);
            Thread.sleep(3000);

            log.info("Step 30: Verify Switcher Style - Divider Format Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleDividerFormatTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleDividerFormatTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleDividerFormatTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleDividerFormatTitleDefault);
            Thread.sleep(3000);

            log.info("Step 31: Verify Switcher Style - Divider Format Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingDividerFormat(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleDividerFormatSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingDividerFormat());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleDividerFormatSettingDefault);
            Thread.sleep(3000);

            log.info("Step 32: Verify Switcher Style - Font Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleFontTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleFontTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontTitleDefault);
            Thread.sleep(3000);

            log.info("Step 33: Verify Switcher Style - Font Value");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingFont(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFont());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontValueDefault);
            Thread.sleep(3000);

            log.info("Step 34: Verify Switcher Style - Font Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFont(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFont());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontStyleDefault);
            Thread.sleep(3000);

            log.info("Step 35: Verify Switcher Style - Font Note");
            Assert.assertEquals(transcyPage.getSwitcherStyleNoteFont(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteFont());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFontNoteDefault);
            Thread.sleep(3000);

            log.info("Step 36: Verify Switcher Style - Flag Style Title");
            Assert.assertEquals(transcyPage.getSwitcherStyleFlagStyleTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFlagTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleFlagStyleTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFlagTitleDefault);
            Thread.sleep(3000);

            log.info("Step 37: Verify Switcher Style - Flag Style Setting");
            Assert.assertEquals(transcyPage.getSwitcherStyleSettingFlagStyle(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFlagSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFlagStyle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFlagSettingDefault);
            Thread.sleep(3000);

            log.info("Step 38: Verify Switcher Style - Flag Style Style");
            Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFlagStyle(), ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFlagStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFlagStyle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherStyleFlagStyleDefault);
            Thread.sleep(3000);

            log.info("=== Collapse Switcher Style Tab ===");
            transcyPage.clickToSwitcherStyleTab();

//        log.info("=== Collapse Position Tab ===");
//        transcyPage.clickToPositionTab();

            log.info("=== Expand Switcher Disclosure Style Tab ===");
            transcyPage.clickToSwitcherDisclosureStyleTab();

            log.info("=== Verify Setting Default Switcher Disclosure Style Tab ===");

            log.info("Step 01: Verify Switcher Disclosure Style Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleDefault);
            Thread.sleep(3000);

            log.info("Step 02: Verify Switcher Disclosure Style - Width Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleWidthTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleWidthTitleDefault);
            Thread.sleep(3000);

            log.info("Step 03: Verify Switcher Disclosure Style - Width Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleWidthSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleWidthSettingDefault);
            Thread.sleep(3000);

            log.info("Step 04: Verify Switcher Disclosure Style - Width Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleWidthValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleWidthValueDefault);
            Thread.sleep(3000);

            log.info("Step 05: Verify Switcher Disclosure Style - Border Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 06: Verify Switcher Disclosure Style - Border Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 07: Verify Switcher Disclosure Style - Border Style");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderStyle(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleBorderStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderStyle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleBorderStyleDefault);
            Thread.sleep(3000);

            log.info("Step 08: Verify Switcher Disclosure Style - Active Effect Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleActiveEffectTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleActiveEffectTitleDefault);
            Thread.sleep(3000);

            log.info("Step 09: Verify Switcher Disclosure Style - Active Effect Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleActiveEffectSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleActiveEffectSettingDefault);
            Thread.sleep(3000);

            log.info("Step 10: Verify Switcher Disclosure Style - Active Effect Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectNote(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleActiveEffectNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleActiveEffectNoteDefault);
            Thread.sleep(3000);

            log.info("Step 11: Verify Switcher Disclosure Style - Element To Show Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleElementToShowTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleElementToShowTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleElementToShowTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleElementToShowTitleDefault);
            Thread.sleep(3000);

            log.info("Step 12: Verify Switcher Disclosure Style - Element To Show Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleElementToShowSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleElementToShowSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleElementToShowSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleElementToShowSettingDefault);
            Thread.sleep(3000);

            log.info("Step 13: Verify Switcher Disclosure Style - Language Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleLanguageTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleLanguageTitleDefault);
            Thread.sleep(3000);

            log.info("Step 14: Verify Switcher Disclosure Style - Language Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleLanguageSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleLanguageSettingDefault);
            Thread.sleep(3000);

            log.info("Step 15: Verify Switcher Disclosure Style - Language Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
            Thread.sleep(3000);

            log.info("Step 16: Verify Switcher Disclosure Style - Language Status: Enable");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
            Thread.sleep(3000);

            log.info("Step 17: Verify Switcher Disclosure Style - Language Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageCheckboxContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleLanguageCheckboxContentDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageCheckboxContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleLanguageCheckboxContentDefault);
            Thread.sleep(3000);

            log.info("Step 18: Verify Switcher Disclosure Style - Currency Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencyTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleCurrencyTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleCurrencyTitleDefault);
            Thread.sleep(3000);

            log.info("Step 19: Verify Switcher Disclosure Style - Currency Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencySetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleCurrencySettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencySetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleCurrencySettingDefault);
            Thread.sleep(3000);

            log.info("Step 20: Verify Switcher Disclosure Style - Currency Status: Checked");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
            Thread.sleep(3000);

            log.info("Step 21: Verify Switcher Disclosure Style - Currency Status: Enable");
            Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
            System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
            Thread.sleep(3000);

            log.info("Step 22: Verify Switcher Disclosure Style - Currency Content Checkbox");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencyCheckboxContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleCurrencyCheckboxContentDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyCheckboxContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleCurrencyCheckboxContentDefault);
            Thread.sleep(3000);

            log.info("Step 23: Verify Switcher Disclosure Style - Title Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontTitleDefault);
            Thread.sleep(3000);

            log.info("Step 24: Verify Switcher Disclosure Style - Title Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontValueDefault);
            Thread.sleep(3000);

            log.info("Step 25: Verify Switcher Disclosure Style - Title Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontSettingDefault);
            Thread.sleep(3000);

            log.info("Step 26: Verify Switcher Disclosure Style - Title Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontNote(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleTitleFontNoteDefault);
            Thread.sleep(3000);

            log.info("Step 27: Verify Switcher Disclosure Style - Search Box Text Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontTitleDefault);
            Thread.sleep(3000);

            log.info("Step 28: Verify Switcher Disclosure Style - Search Box Text Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontValueDefault);
            Thread.sleep(3000);

            log.info("Step 29: Verify Switcher Disclosure Style - Search Box Text Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontSettingDefault);
            Thread.sleep(3000);

            log.info("Step 30: Verify Switcher Disclosure Style - Search Box Text Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontNote(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSearchBoxTextFontNoteDefault);
            Thread.sleep(3000);

            log.info("Step 31: Verify Switcher Disclosure Style - Option Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontTitleDefault);
            Thread.sleep(3000);

            log.info("Step 32: Verify Switcher Disclosure Style - Option Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontValueDefault);
            Thread.sleep(3000);

            log.info("Step 33: Verify Switcher Disclosure Style - Option Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontSettingDefault);
            Thread.sleep(3000);

            log.info("Step 34: Verify Switcher Disclosure Style - Option Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontNote(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleOptionFontNoteDefault);
            Thread.sleep(3000);

            log.info("Step 35: Verify Switcher Disclosure Style - Selected Option Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontTitleDefault);
            Thread.sleep(3000);

            log.info("Step 36: Verify Switcher Disclosure Style - Selected Option Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontValueDefault);
            Thread.sleep(3000);

            log.info("Step 37: Verify Switcher Disclosure Style - Selected Option Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontSettingDefault);
            Thread.sleep(3000);

            log.info("Step 38: Verify Switcher Disclosure Style - Selected Option Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontNote(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleSelectedOptionFontNoteDefault);
            Thread.sleep(3000);

            log.info("Step 39: Verify Switcher Disclosure Style - Flag Style Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleFlagStyleTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleFlagStyleTitleDefault);
            Thread.sleep(3000);

            log.info("Step 40: Verify Switcher Disclosure Style - Flag Style Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleFlagStyleSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleFlagStyleSettingDefault);
            Thread.sleep(3000);

            log.info("Step 41: Verify Switcher Disclosure Style - Flag Style Style");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleStyle(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleFlagStyleStyleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleStyle());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleFlagStyleStyleDefault);
            Thread.sleep(3000);

            log.info("Step 42: Verify Switcher Disclosure Style - Button Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonTitleDefault);
            Thread.sleep(3000);

            log.info("Step 43: Verify Switcher Disclosure Style - Button - Width Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonWidthTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonWidthTitleDefault);
            Thread.sleep(3000);

            log.info("Step 44: Verify Switcher Disclosure Style - Button - Width Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonWidthSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonWidthSettingDefault);
            Thread.sleep(3000);

            log.info("Step 45: Verify Switcher Disclosure Style - Button - Width Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonWidthValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonWidthValueDefault);
            Thread.sleep(3000);

            log.info("Step 46: Verify Switcher Disclosure Style - Button - Height Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonHeightTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonHeightTitleDefault);
            Thread.sleep(3000);

            log.info("Step 47: Verify Switcher Disclosure Style - Button - Height Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonHeightSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonHeightSettingDefault);
            Thread.sleep(3000);

            log.info("Step 48: Verify Switcher Disclosure Style - Button - Height Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonHeightValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonHeightValueDefault);
            Thread.sleep(3000);

            log.info("Step 49: Verify Switcher Disclosure Style - Button - Shape Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonShapeTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonShapeTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonShapeTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonShapeTitleDefault);
            Thread.sleep(3000);

            log.info("Step 50: Verify Switcher Disclosure Style - Button - Shape Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonShapeSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonShapeSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonShapeSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonShapeSettingDefault);
            Thread.sleep(3000);

            log.info("Step 51: Verify Switcher Disclosure Style - Button - Font Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontTitleContent(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontTitleDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontTitleDefault);
            Thread.sleep(3000);

            log.info("Step 52: Verify Switcher Disclosure Style - Button - Font Value");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontValue(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontValueDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontValue());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontValueDefault);
            Thread.sleep(3000);

            log.info("Step 53: Verify Switcher Disclosure Style - Button - Font Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontSetting(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontSettingDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontSetting());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontSettingDefault);
            Thread.sleep(3000);

            log.info("Step 54: Verify Switcher Disclosure Style - Button - Font Note");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontNote(), ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontNoteDefault);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontNote());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectSwitcherDisclosureStyleButtonFontNoteDefault);
            Thread.sleep(3000);

            log.info("=== Collapse Switcher Disclosure Style Tab ===");
            transcyPage.clickToSwitcherDisclosureStyleTab();

//        log.info("=== Collapse Position Tab ===");
//        transcyPage.clickToPositionTab();

            log.info("=== Expand Switcher Color Scheme Tab ===");
            transcyPage.clickToColorSchemeTab();

            log.info("=== Verify Setting Default Switcher Color Scheme Tab ===");

            log.info("Step 01: Verify Color Scheme Title");
            Assert.assertEquals(transcyPage.getColorSchemeTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeTitleDefault);
            Thread.sleep(3000);

            log.info("Step 02: Verify Color Scheme - Switcher Color Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorTitleDefault);
            Thread.sleep(3000);

            log.info("Step 03: Verify Color Scheme - Switcher Color - Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 04: Verify Color Scheme - Switcher Color - Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 03: Verify Color Scheme - Switcher Color - Border Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 04: Verify Color Scheme - Switcher Color - Border Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorBorderValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorBorderValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 05: Verify Color Scheme - Switcher Color - Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 06: Verify Color Scheme - Switcher Color - Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 07: Verify Color Scheme - Switcher Color - Arrow Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorArrowTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorArrowTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorArrowTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorArrowTitleDefault);
            Thread.sleep(3000);

            log.info("Step 08: Verify Color Scheme - Switcher Color - Arrow Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherColorArrowValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorArrowSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherColorArrowValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherColorArrowSettingDefault);
            Thread.sleep(3000);

            log.info("Step 09: Verify Color Scheme - Switcher Hover State Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateTitleDefault);
            Thread.sleep(3000);

            log.info("Step 10: Verify Color Scheme - Switcher Hover State - Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 11: Verify Color Scheme - Switcher Hover State - Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 12: Verify Color Scheme - Switcher Hover State - Border Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 13: Verify Color Scheme - Switcher Hover State - Border Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateBorderValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateBorderValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 14: Verify Color Scheme - Switcher Hover State - Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 15: Verify Color Scheme - Switcher Hover State - Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 16: Verify Color Schema - Switcher Hover State - Arrow Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateArrowTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateArrowTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateArrowTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateArrowTitleDefault);
            Thread.sleep(3000);

            log.info("Step 17: Verify Color Schema - Switcher Hover State - Arrow Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherHoverStateArrowValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateArrowSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherHoverStateArrowValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherHoverStateArrowSettingDefault);
            Thread.sleep(3000);

            log.info("Step 18: Verify Color Schema - Switcher Active State Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateTitleDefault);
            Thread.sleep(3000);

            log.info("Step 19: Verify Color Schema - Switcher Active State - Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 20: Verify Color Schema - Switcher Active State - Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 21: Verify Color Schema - Switcher Active State - Border Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 22: Verify Color Schema - Switcher Active State - Border Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateBorderValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateBorderValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 23: Verify Color Schema - Switcher Active State - Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 24: Verify Color Schema - Switcher Active State - Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 25: Verify Color Schema - Switcher Active State - Arrow Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateArrowTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateArrowTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateArrowTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateArrowTitleDefault);
            Thread.sleep(3000);

            log.info("Step 26: Verify Color Schema - Switcher Active State - Arrow Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherActiveStateArrowValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateArrowSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherActiveStateArrowValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherActiveStateArrowSettingDefault);
            Thread.sleep(3000);

            log.info("Step 27: Verify Color Schema - Switcher Disclosure Color Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorTitleDefault);
            Thread.sleep(3000);

            log.info("Step 28: Verify Color Schema - Switcher Disclosure Color - Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 29: Verify Color Schema - Switcher Disclosure Color - Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 30: Verify Color Schema - Switcher Disclosure Color - Border Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 31: Verify Color Schema - Switcher Disclosure Color - Border Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorBorderValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorBorderValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 32: Verify Color Schema - Switcher Disclosure Color - Title color Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorTitleColorTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorTitleColorTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorTitleColorTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorTitleColorTitleDefault);
            Thread.sleep(3000);

            log.info("Step 33: Verify Color Schema - Switcher Disclosure Color - Title color Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorTitleColorValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorTitleColorSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorTitleColorValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorTitleColorSettingDefault);
            Thread.sleep(3000);

            log.info("Step 34: Verify Color Schema - Switcher Disclosure Color - Select Box Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 35: Verify Color Schema - Switcher Disclosure Color - Select Box Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 36: Verify Color Schema - Switcher Disclosure Color - Select Box Border Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 37: Verify Color Schema - Switcher Disclosure Color - Select Box Border Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBorderValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBorderValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 38: Verify Color Schema - Switcher Disclosure Color - Select Box Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 39: Verify Color Schema - Switcher Disclosure Color - Select Box Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 40: Verify Color Schema - Switcher Disclosure Color - Select Box Arrow Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxArrowTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxArrowTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxArrowTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxArrowTitleDefault);
            Thread.sleep(3000);

            log.info("Step 41: Verify Color Schema - Switcher Disclosure Color - Select Box Arrow Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxArrowValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxArrowTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxArrowValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectBoxArrowTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 42: Verify Color Schema - Switcher Disclosure Color - Option Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorOptionBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorOptionBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 43: Verify Color Schema - Switcher Disclosure Color - Option Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorOptionBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionBackgroundTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorOptionBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionBackgroundTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 44: Verify Color Schema - Switcher Disclosure Color - Option Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorOptionTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorOptionTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 45: Verify Color Schema - Switcher Disclosure Color - Option Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorOptionTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionTextTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorOptionTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorOptionTextTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 46: Verify Color Schema - Switcher Disclosure Color - Selected Option Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 47: Verify Color Schema - Switcher Disclosure Color - Selected Option Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 48: Verify Color Schema - Switcher Disclosure Color - Selected Option Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 49: Verify Color Schema - Switcher Disclosure Color - Selected Option Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectedOptionTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSelectedOptionTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 50: Verify Color Schema - Switcher Disclosure Color - Search Box Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 51: Verify Color Schema - Switcher Disclosure Color - Search Box Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 52: Verify Color Schema - Switcher Disclosure Color - Search Box Icon Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxIconTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxIconTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxIconTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxIconTitleDefault);
            Thread.sleep(3000);

            log.info("Step 53: Verify Color Schema - Switcher Disclosure Color - Search Box Icon Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxIconValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxIconSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxIconValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxIconSettingDefault);
            Thread.sleep(3000);

            log.info("Step 54: Verify Color Schema - Switcher Disclosure Color - Search Box Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 55: Verify Color Schema - Switcher Disclosure Color - Search Box Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSearchBoxTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorSearchBoxTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 56: Verify Color Schema - Switcher Disclosure Color - Button Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorButtonBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorButtonBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 57: Verify Color Schema - Switcher Disclosure Color - Button Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorButtonBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorButtonBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 58: Verify Color Schema - Switcher Disclosure Color - Button Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorButtonTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorButtonTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Button Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorButtonTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorButtonTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureColorButtonTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 60: Verify Color Schema - Switcher Disclosure Hover State Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateTitleDefault);
            Thread.sleep(3000);

            log.info("Step 61: Verify Color Schema - Switcher Disclosure Hover State - Select Box Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureColorSelectBoxBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 62: Verify Color Schema - Switcher Disclosure Hover State - Select Box Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 63: Verify Color Schema - Switcher Disclosure Hover State - Select Box Border Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderTitleDefault);
            Thread.sleep(3000);

            log.info("Step 64: Verify Color Schema - Switcher Disclosure Hover State - Select Box Border Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxBorderSettingDefault);
            Thread.sleep(3000);

            log.info("Step 65: Verify Color Schema - Switcher Disclosure Hover State - Select Box Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 66: Verify Color Schema - Switcher Disclosure Hover State - Select Box Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 67: Verify Color Schema - Switcher Disclosure Hover State - Select Box Arrow Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowTitleDefault);
            Thread.sleep(3000);

            log.info("Step 68: Verify Color Schema - Switcher Disclosure Hover State - Select Box Arrow Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateSelectBoxArrowSettingDefault);
            Thread.sleep(3000);

            log.info("Step 69: Verify Color Schema - Switcher Disclosure Hover State - Option Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 70: Verify Color Schema - Switcher Disclosure Hover State - Option Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 71: Verify Color Schema - Switcher Disclosure Hover State - Option Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 72: Verify Color Schema - Switcher Disclosure Hover State - Option Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateOptionTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionTextSettingDefault);
            Thread.sleep(3000);

            log.info("Step 73: Verify Color Schema - Switcher Disclosure Hover State - Button Background Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonBackgroundTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateButtonBackgroundTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonBackgroundTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateButtonBackgroundTitleDefault);
            Thread.sleep(3000);

            log.info("Step 74: Verify Color Schema - Switcher Disclosure Hover State - Button Background Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonBackgroundValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionButtonBackgroundSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonBackgroundValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionButtonBackgroundSettingDefault);
            Thread.sleep(3000);

            log.info("Step 75: Verify Color Schema - Switcher Disclosure Hover State - Button Text Title");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonTextTitleContent(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateButtonTextTitleDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonTextTitleContent());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateButtonTextTitleDefault);
            Thread.sleep(3000);

            log.info("Step 76: Verify Color Schema - Switcher Disclosure Hover State - Button Text Value");
            Assert.assertEquals(transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonTextValueColor(), ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionButtonTextSettingDefault);
            System.out.println("Actual result: " + transcyPage.getColorSchemeSwitcherDisclosureHoverStateButtonTextValueColor());
            System.out.println("Expected result: " + ExpectedDataSwitcherSettingDefault.expectColorSchemeSwitcherDisclosureHoverStateOptionButtonTextSettingDefault);
            Thread.sleep(3000);
        }

    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }
}

