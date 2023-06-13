package transcy;

import commons.AbstractPage;
import commons.AbstractTest;
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
    String emailPartner1 = "vilh+1@firegroup.io";
    String emailPartner = "vilh@fireapps.vn";
    String passwordPartner1 = "Vile@12345";
    String passwordPartner = "123321";
            Random rand = new Random();
    //    List<String> listRecoveryCode = Arrays.asList("BA1B-9AA3-4330", "BA1B-9AA3-4331", "BA1B-9AA3-4332");

    String recoveryCode = "9716-6562-7A3B";
    int number = new Random().nextInt(99999999);


    String storeName = "storetesttranscy" + number;

    //    ADMIN TOOL INFO
    String adminToolUATURL = "https://transcy-stag-admin.onecommerce.app";
    String userNameAdminTool = "admin";
    String passWordAdminTool = "ShopifyAppsGreat2022";

    //    INSTALL TRANSCY UAT V4 APP
    String appName = "Transcy UAT V4";
    private Object wait;

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
//
//        Login Partner Shopify
        log.info("Pre-condition: Login Partner Shopify");
        driver.get(partnerURL);

        log.info("Step 01: Press on Login Partner button");
        transcyPage.clickToLoginPartnerBtn();

        log.info("Step 02: Fill Email account Partner");
        transcyPage.inputToEmailAccountPartner(emailPartner);

        log.info("Step 03: Press on Continue with Email button");
        transcyPage.clickToContinueWithEmailBtn();

        log.info("Step 04: Fill Password account Partner");
        transcyPage.inputTPasswordAccountPartner(passwordPartner);

        log.info("Step 05: Press on Login button");
        transcyPage.clickToLoginBtn();

        log.info("Step 06: Press on Use a Recovery code button");
        transcyPage.clickToUseARecoveryCodeBtn();

        log.info("Step 07: Fill Recovery code");
        transcyPage.inputRecoveryCode(recoveryCode);

        log.info("Step 08: Press on Login button");
        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

        log.info("Step 09: Press Partner button");
        transcyPage.clickToSelectPartnerBtn();

    }

    @Test(priority = 2)
    public void CreateStoreTest() throws InterruptedException {

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
        System.out.println("Store name:" + storeName);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,2000)");

        log.info("Step 06: Select Start with test data option");
        transcyPage.selectOprionStartWithTestData();

        log.info("Step 07: Press Create Development store button");
        transcyPage.clickToAddDevelopmentStoreBtn();
//        log.info("Step 17: Choose account to login");

//        log.info("Step 08: Choose account to login");
//        transcyPage.clickToChooseAccountBtn();
//        Thread.sleep(10000);
    }

        @Test(priority = 3)
        public void AddStoreTestTranscy () throws InterruptedException {
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
            System.out.println("Store name:" + storeNameAdmin);

            log.info("Step 07: Click Add Store test");
            transcyPage.clickToAddTestStoreBtn();

            log.info("Step 08: Handle Alert");
            Alert alert = driver.switchTo().alert();
            alert.accept();
            Thread.sleep(10000);
        }

        @Test(priority = 4)
        public void InstallTranscyAppUAT () throws InterruptedException {
            String storeDomain = ".myshopify.com";
            String storeTest = storeName + storeDomain;
            String recoveryCode1 = "C3E2-2575-BE34";

            // Login Partner Shopify
            log.info("Step 01: Re-Login Partner Shopify");
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(partnerURL);

            log.info("Step 02: Press on Login Partner button");
            transcyPage.clickToLoginPartnerBtn();

//      DEMO VỚI PARTNER FIREAPPS DEV
//
//        log.info("Step 02: Fill Email account Partner");
//        transcyPage.inputToEmailAccountPartner(emailPartner);
//        Thread.sleep(5000);
//
//        log.info("Step 03: Press on Continue with Email button");
//        transcyPage.clickToContinueWithEmailBtn();
//        Thread.sleep(5000);
//
//        log.info("Step 04: Fill Password account Partner");
//        transcyPage.inputTPasswordAccountPartner(passwordPartner);
//
//        log.info("Step 05: Press on Login button");
//        transcyPage.clickToLoginBtn();
//        Thread.sleep(3000);
//
//        log.info("Step 06: Press on Use a Recovery code button");
//        transcyPage.clickToUseARecoveryCodeBtn();
//        Thread.sleep(3000);
//
//        log.info("Step 07: Fill Recovery code");
//        transcyPage.inputRecoveryCode(recoveryCode1);
//        Thread.sleep(3000);
//
//        log.info("Step 08: Press on Login button");
//        transcyPage.clickToLoginPartnerAfterInputCodeBtn();
//        Thread.sleep(3000);

//      END DEMO VỚI PARTNER FIREAPPS DEV

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

//        log.info("Step 10: Click Choose Partner Account button");
//        transcyPage.clickToChooseAccountPartnerBtn();
//        Thread.sleep(5000);

            log.info("Step 11: Click Install Transcy V4 App button");
            transcyPage.clickToInstallTranscyV4AppBtn();

            log.info("Step 12: Click Choose Free Plan Transcy V4 App button");
            transcyPage.clickToChooseFreePlanTranscyV4AppBtn();

            log.info("Step 13: Click to Swicher menu button");
            transcyPage.clickSwitcherMenuBtn();
        }

        @Test(priority = 5)
        public void CheckModalFirstTimeGoToMenuSwitcher () throws InterruptedException {
//      MODAL CONTENT FIRST TIME LOGIN

            String expectedTitle = "Manage switcher";
            String expectedTitle1 = "Activate Transcy Switcher";
            String expectContentTitleModalFirst = "Switcher settings";
            String expectContentHeadingModal1 = "Switcher settings";
            String expectContentHeadingModal2 = "Switcher settings";
            String expectContentHeadingModal3 = "Switcher settings";
            String expectContentDescriptionModal1 = "Switcher settings";
            String expectContentDescriptionModal2 = "Switcher settings";
            String expectContentDescriptionModal3 = "Switcher settings";
            String expectContentTitleModalSecond = "Switcher settings";
            String expectContentDescriptionModalSecond = "Switcher settings";

            WebElement m = driver.findElement(By.xpath("//h2[@class='sc-2126ad3d-6 jxlOwl']"));
            System.out.println("Title:" + m.getText() + "-" + m.getCssValue("color"));
            Assert.assertEquals(m.getText(), expectedTitle);

            WebElement m1 = driver.findElement(By.xpath("//h2[@class='Polaris-Heading' and contains(text(),'Activate Transcy Switcher')]"));
            System.out.println("Title 1:" + m1.getText());
//        Assert.assertEquals(m1.getText(),expectedTitle1);
        }
        @Test(priority = 6)
        public void CheckSettingsDefaultSwitcher () throws InterruptedException {
            String recoveryCode1 = "0C1F-40DE-7B7E";
            String email = "vilh+1@firegroup.io";
            String pass = "Vile@12345";
            String storeName = "arstoresandbox1.myshopify.com";

            String expectContentHeaderTitle = "Switcher settings";
            String expectContentSubTitle = "You’re setting template Default for the desktop version.";
            String expectContentGeneralTitle = "General";
            String expectContentGeneralTab = "Switcher has nothing to show now\n" +
                    "Follow the three steps below to show your store to the world.\n" +
                    "Activate Transcy Switcher on storefront\n" +
                    "To get set up faster, use this step-by-step instructions\n" +
                    "Publish at least one language or one currency\n" +
                    "Turn on the Switcher visibility";
            String expectContentSwitcherDisplayTitle = "Switcher display";
            String expectContentSwitcherDisplaySetting = "Only admin";
            String expectContentSwitcherDisplayLabel = "Switcher visibility";
            String expectContentSwitcherDisplayNote = "Only admin: You or visitors with admin access can preview the Switcher to check if it works correctly before going public.";
            String expectContentSwitcherDisclosureTitle = "Switcher disclosure";
            String expectContentSwitcherDisclosureSetting = "Dropdown";
            String expectContentGeolocationTitle = "Geolocation";
            String expectContentGeolocationDescription = "Supports Transcy Switcher only.";
            String expectContentBlockPlan = "Upgrade to a higher plan to use this feature. Learn more";
            String expectContentButtonBlockPlan = "Upgrade now";
            String expectContentUnLockFeature = "To unlock feature, contact us to verify your store.";
            String expectContentButtonUnLockFeature = "Contact us";
            String expectContentActiveTemplateTitle = "Active template";
            String expectContentDefaultTemplate = "Default";
            String expectContentTemplateNote = "You are using this template.";
            String expectContentTemplateButton = "Customize";
            String expectContentTranscyTemplate = "Transcy’s templates";
            String expectContentMoreItemsSetting = "More items";
            String expectContentTranscyTemplateDefault = "Posh";
            String expectContentTranscyTemplateButton = "Apply";


            log.info("Step 01: Login Partner Shopify");
            Thread.sleep(3000);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://admin.shopify.com/store/arstoresandbox1");

//            log.info("Step 02: Press on Login Partner button");
//            transcyPage.clickToLoginPartnerBtn();

//      DEMO VỚI PARTNER FIREAPPS DEV

            log.info("Step 02: Fill Email account Partner");
            transcyPage.inputToEmailAccountPartner(email);

            log.info("Step 03: Press on Continue with Email button");
            transcyPage.clickToContinueWithEmailBtn();

            log.info("Step 04: Fill Password account Partner");
            transcyPage.inputTPasswordAccountPartner(pass);

            log.info("Step 05: Press on Login button");
            transcyPage.clickToLoginBtn();
            Thread.sleep(15000);

//        log.info("Step 06: Press on Use a Recovery code button");
//        transcyPage.clickToUseARecoveryCodeBtn();
//
//        log.info("Step 07: Fill Recovery code");
//        transcyPage.inputRecoveryCode(recoveryCode1);

//        log.info("Step 08: Press on Login button");
//        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

//            log.info("Step 09: Press Store menu");
//            transcyPage.selectMenuStoresBtn();
//
//            log.info("Step 10: Fitler Store name");
//            transcyPage.fitlerStoreToLogin(storeName);
//
//            log.info("Step 11: Click To Login Store");
//            transcyPage.clickToLoginStore();
//
//            log.info("Step 09: Press Partner button");
//            transcyPage.clickToChooseAccountBtn();

            log.info("Step 12: Click To App menu");
            transcyPage.clickToAppsMenu();

            log.info("Step 13: Click To Login Transcy App");
            transcyPage.clickToLoginTranscyApp();
            Thread.sleep(5000);

            log.info("Step 13: Click to Swicher menu button");
            transcyPage.clickSwitcherMenuBtn();

            log.info("Step 14: Verify Header Title Content");
            Assert.assertEquals(transcyPage.getTextHeaderTitle(), expectContentHeaderTitle);
            System.out.println("Actual result: " + transcyPage.getTextHeaderTitle());
            System.out.println("Expected result: " + expectContentHeaderTitle);
            Thread.sleep(5000);

            log.info("Step 15: Verify Header Description  Content");
            Assert.assertEquals(transcyPage.getTextHeaderDescription(), expectContentSubTitle);
            System.out.println("Actual result: " + transcyPage.getTextHeaderDescription());
            System.out.println("Expected result: " + expectContentSubTitle);
            Thread.sleep(5000);

//        log.info("Step 16: Verify General Header Title");
//////        transcyPage.clickToTempalatesTab();
//        WebElement selectText = driver.findElement(By.cssSelector(".Polaris-Tabs__Wrapper"));
//        selectText.getText();
//        System.out.println("Text is: " +selectText);
//////        Assert.assertEquals(transcyPage.getTextGeneralTitle(),expectContentGeneralTitle);
////        System.out.println("Actual result: " + transcyPage.getTextGeneralTitle());
//        System.out.println("Expected result: " + expectContentGeneralTitle);

            log.info("Step 17: Verify General Tab Content");
            Assert.assertEquals(transcyPage.getTextTabContent(),expectContentGeneralTab);
            System.out.println("Actual result: " + transcyPage.getTextTabContent());
            System.out.println("Expected result: " + expectContentGeneralTab);
            Thread.sleep(5000);

            log.info("Step 18: Verify Switcher Display Title");
            Assert.assertEquals(transcyPage.getSwitcherDisplayTitle(),expectContentSwitcherDisplayTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayTitle());
            System.out.println("Expected result: " + expectContentSwitcherDisplayTitle);
            Thread.sleep(5000);

            log.info("Step 19: Verify Switcher Visibility Status");
            Assert.assertEquals(transcyPage.getSwitcherDisplayStatus(),true);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayStatus());
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Display Label");
            Assert.assertEquals(transcyPage.getSwitcherDisplayLabel(),expectContentSwitcherDisplayLabel);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayLabel());
            System.out.println("Expected result: " + expectContentSwitcherDisplayLabel);
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Display Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisplaySetting(),expectContentSwitcherDisplaySetting);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplaySetting());
            System.out.println("Expected result: " + expectContentSwitcherDisplaySetting);
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Display Note");
            Assert.assertEquals(transcyPage.getSwitcherDisplayNote(),expectContentSwitcherDisplayNote);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisplayNote());
            System.out.println("Expected result: " + expectContentSwitcherDisplayNote);
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Diclosure Title");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureTitle(),expectContentSwitcherDisclosureTitle);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureTitle());
            System.out.println("Expected result: " + expectContentSwitcherDisclosureTitle);
            Thread.sleep(5000);

            log.info("Step 20: Verify Switcher Diclosure Setting");
            Assert.assertEquals(transcyPage.getSwitcherDisclosureSetting(),expectContentSwitcherDisclosureSetting);
            System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureSetting());
            System.out.println("Expected result: " + expectContentSwitcherDisclosureSetting);
            Thread.sleep(5000);

            log.info("Step 20: Verify Geolocation Title");
            Assert.assertEquals(transcyPage.getGeolocationTitle(),expectContentGeolocationTitle);
            System.out.println("Actual result: " + transcyPage.getGeolocationTitle());
            System.out.println("Expected result: " + expectContentGeolocationTitle);
            Thread.sleep(5000);

            log.info("Step 20: Verify Geolocation Description");
            Assert.assertEquals(transcyPage.getGeolocationDescription(),expectContentGeolocationDescription);
            System.out.println("Actual result: " + transcyPage.getGeolocationDescription());
            System.out.println("Expected result: " + expectContentGeolocationDescription);
            Thread.sleep(5000);

            log.info("Step 20: Verify Banner Upgrade");
            Assert.assertEquals(transcyPage.getBannerUpgradeContent(),expectContentBlockPlan);
            System.out.println("Actual result: " + transcyPage.getBannerUpgradeContent());
            System.out.println("Expected result: " + expectContentBlockPlan);
            Thread.sleep(5000);

            log.info("Step 20: Verify Button Banner Upgrade");
            Assert.assertEquals(transcyPage.getButtonUpgradeContent(),expectContentButtonBlockPlan);
            System.out.println("Actual result: " + transcyPage.getButtonUpgradeContent());
            System.out.println("Expected result: " + expectContentButtonBlockPlan);
            Thread.sleep(5000);

            log.info("Step 20: Verify Unlock Feature Content");
            Assert.assertEquals(transcyPage.getUnLockFeatureModalContent(),expectContentUnLockFeature);
            System.out.println("Actual result: " + transcyPage.getUnLockFeatureModalContent());
            System.out.println("Expected result: " + expectContentUnLockFeature);
            Thread.sleep(5000);

            log.info("Step 20: Verify Button Unlock Feature Content");
            Assert.assertEquals(transcyPage.getButtonUnLockFeatureModalContent(),expectContentButtonUnLockFeature);
            System.out.println("Actual result: " + transcyPage.getButtonUnLockFeatureModalContent());
            System.out.println("Expected result: " + expectContentButtonUnLockFeature);
            Thread.sleep(5000);

            log.info("Step 20: Go to Templates Setting Tab");
            transcyPage.clickToTempalatesTab();

            log.info("Step 20: Verify Active Template Title");
            Assert.assertEquals(transcyPage.getActiveTemplateContent(),expectContentActiveTemplateTitle);
            System.out.println("Actual result: " + transcyPage.getActiveTemplateContent());
            System.out.println("Expected result: " + expectContentActiveTemplateTitle);
            Thread.sleep(5000);

            log.info("Step 20: Verify Active Template Default");
            Assert.assertEquals(transcyPage.getDefaultTemplateContent(),expectContentDefaultTemplate);
            System.out.println("Actual result: " + transcyPage.getDefaultTemplateContent());
            System.out.println("Expected result: " + expectContentDefaultTemplate);
            Thread.sleep(5000);

            log.info("Step 20: Verify Active Template Note");
            Assert.assertEquals(transcyPage.getStatusTemplateNote(),expectContentTemplateNote);
            System.out.println("Actual result: " + transcyPage.getStatusTemplateNote());
            System.out.println("Expected result: " + expectContentTemplateNote);
            Thread.sleep(5000);

            log.info("Step 20: Verify Active Template Button");
            Assert.assertEquals(transcyPage.getTemplateButton(),expectContentTemplateButton);
            System.out.println("Actual result: " + transcyPage.getTemplateButton());
            System.out.println("Expected result: " + expectContentTemplateButton);
            Thread.sleep(5000);

            log.info("Step 20: Verify Transcy Templates Title");
            Assert.assertEquals(transcyPage.getTranscyTemplateContent(),expectContentTranscyTemplate);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateContent());
            System.out.println("Expected result: " + expectContentTranscyTemplate);
            Thread.sleep(5000);

            log.info("Step 20: Verify More Items Setting");
            Assert.assertEquals(transcyPage.getMoreItemsSettingContent(),expectContentMoreItemsSetting);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateContent());
            System.out.println("Expected result: " + expectContentMoreItemsSetting);
            Thread.sleep(5000);

            log.info("Step 20: Verify Transcy Templates Default");
            Assert.assertEquals(transcyPage.getTranscyTemplateDefault(),expectContentTranscyTemplateDefault);
            System.out.println("Actual result: " + transcyPage.getTranscyTemplateDefault());
            System.out.println("Expected result: " + expectContentTranscyTemplateDefault);
            Thread.sleep(5000);

            log.info("Step 20: Verify Transcy Templates Button");
            Assert.assertEquals(transcyPage.getButtonTranscyTemplateDefault(),expectContentTranscyTemplateButton);
            System.out.println("Actual result: " + transcyPage.getButtonTranscyTemplateDefault());
            System.out.println("Expected result: " + expectContentTranscyTemplateButton);
            Thread.sleep(5000);


        }

    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }
    }

