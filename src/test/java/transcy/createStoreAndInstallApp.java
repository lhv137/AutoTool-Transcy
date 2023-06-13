package transcy;

import commons.AbstractPage;
import commons.AbstractTest;
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
        Thread.sleep(3000);

        log.info("Step 02: Fill Email account Partner");
        transcyPage.inputToEmailAccountPartner(emailPartner);
        Thread.sleep(3000);

        log.info("Step 03: Press on Continue with Email button");
        transcyPage.clickToContinueWithEmailBtn();
        Thread.sleep(3000);

        log.info("Step 04: Fill Password account Partner");
        transcyPage.inputTPasswordAccountPartner(passwordPartner);
        Thread.sleep(3000);

        log.info("Step 05: Press on Login button");
        transcyPage.clickToLoginBtn();
        Thread.sleep(3000);

        log.info("Step 06: Press on Use a Recovery code button");
        transcyPage.clickToUseARecoveryCodeBtn();
        Thread.sleep(3000);

        log.info("Step 07: Fill Recovery code");
        transcyPage.inputRecoveryCode(recoveryCode);
        Thread.sleep(3000);

        log.info("Step 08: Press on Login button");
        transcyPage.clickToLoginPartnerAfterInputCodeBtn();
        Thread.sleep(3000);

        log.info("Step 09: Press Partner button");
        transcyPage.clickToSelectPartnerBtn();

    }

    @Test(priority = 2)
    public void CreateStoreTestTranscy() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void CreateStoreTest() throws InterruptedException {

        log.info("Step 01: Press Stores menu");
        transcyPage.selectMenuStoresBtn();
        Thread.sleep(3000);

        log.info("Step 02: Press Add Store button");
        transcyPage.clickToAddStore();
        Thread.sleep(3000);

        log.info("Step 03: Press Create Development Store button");
        transcyPage.clickToCreateDevelopmentStore();
        Thread.sleep(3000);

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
        Thread.sleep(20000);

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
            Thread.sleep(3000);

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
            Thread.sleep(5000);

            log.info("Step 06: Click to select Transcy UAT V4 App");
            transcyPage.clickToSelectTranscyUATV4App();

            log.info("Step 07: Click to Select Store button");
            transcyPage.clickToSelectStoreBtn();

            log.info("Step 08: Search Store Domain");
            transcyPage.searchStoreDomainToInstallApp(storeTest);

            log.info("Step 09: Select Store Domain to Install App");
            transcyPage.selectStoreDomainToInstallApp();
            Thread.sleep(10000);

//        log.info("Step 10: Click Choose Partner Account button");
//        transcyPage.clickToChooseAccountPartnerBtn();
//        Thread.sleep(5000);

            log.info("Step 11: Click Install Transcy V4 App button");
            transcyPage.clickToInstallTranscyV4AppBtn();

            log.info("Step 12: Click Choose Free Plan Transcy V4 App button");
            transcyPage.clickToChooseFreePlanTranscyV4AppBtn();

            log.info("Step 13: Click to Swicher menu button");
            transcyPage.clickSwitcherMenuBtn();
            Thread.sleep(5000);
        }

        @Test(priority = 5)
        public void CheckModalFirstTimeGoToMenuSwitcher () throws InterruptedException {
//      MODAL CONTENT FIRST TIME LOGIN

            String expectedTitle = "Manage switcher";
            String expectedTitle1 = "Activate Transcy Switcher";

            WebElement m = driver.findElement(By.xpath("//h2[@class='sc-2126ad3d-6 jxlOwl']"));
            System.out.println("Title:" + m.getText() + "-" + m.getCssValue("color"));
            Assert.assertEquals(m.getText(), expectedTitle);

            WebElement m1 = driver.findElement(By.xpath("//h2[@class='Polaris-Heading' and contains(text(),'Activate Transcy Switcher')]"));
            System.out.println("Title 1:" + m1.getText());
//        Assert.assertEquals(m1.getText(),expectedTitle1);
        }
        @Test(priority = 6)
        public void CheckModalSwitcherFirstTimeLogin () throws InterruptedException {
            String recoveryCode1 = "0C1F-40DE-7B7E";
            String email = "vilh+1@firegroup.io";
            String pass = "Vile@12345";
            String storeName = "arstoresandbox1.myshopify.com";
            String expectContentTitleModalFirst = "Switcher settings";
            String expectContentHeadingModal1 = "Switcher settings";
            String expectContentHeadingModal2 = "Switcher settings";
            String expectContentHeadingModal3 = "Switcher settings";
            String expectContentDescriptionModal1 = "Switcher settings";
            String expectContentDescriptionModal2 = "Switcher settings";
            String expectContentDescriptionModal3 = "Switcher settings";
            String expectContentTitleModalSecond = "Switcher settings";
            String expectContentDescriptionModalSecond = "Switcher settings";
            String expectContentHeaderTitle = "Switcher settings";
            String expectContentSubTitle = "You’re setting template Default for the desktop version.";
            String expectContentGeneralTitle = "General";
            String expectContentGeneralTab = "Switcher has nothing to show now\n" +
                    "Follow the three steps below to show your store to the world.\n" +
                    "Activate Transcy Switcher on storefront\n" +
                    "To get set up faster, use this step-by-step instructions\n" +
                    "Publish at least one language or one currency\n" +
                    "Turn on the Switcher visibility";


            log.info("Step 01: Login Partner Shopify");
            Thread.sleep(3000);
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get(partnerURL);

            log.info("Step 02: Press on Login Partner button");
            transcyPage.clickToLoginPartnerBtn();

//      DEMO VỚI PARTNER FIREAPPS DEV

            log.info("Step 02: Fill Email account Partner");
            transcyPage.inputToEmailAccountPartner(email);

            log.info("Step 03: Press on Continue with Email button");
            transcyPage.clickToContinueWithEmailBtn();

            log.info("Step 04: Fill Password account Partner");
            transcyPage.inputTPasswordAccountPartner(pass);

            log.info("Step 05: Press on Login button");
            transcyPage.clickToLoginBtn();

//        log.info("Step 06: Press on Use a Recovery code button");
//        transcyPage.clickToUseARecoveryCodeBtn();
//
//        log.info("Step 07: Fill Recovery code");
//        transcyPage.inputRecoveryCode(recoveryCode1);

//        log.info("Step 08: Press on Login button");
//        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

            log.info("Step 09: Press Store menu");
            transcyPage.selectMenuStoresBtn();

            log.info("Step 10: Fitler Store name");
            transcyPage.fitlerStoreToLogin(storeName);

            log.info("Step 11: Click To Login Store");
            transcyPage.clickToLoginStore();

            log.info("Step 09: Press Partner button");
            transcyPage.clickToChooseAccountBtn();

            log.info("Step 12: Click To App menu");
            transcyPage.clickToAppsMenu();

            log.info("Step 13: Click To Login Transcy App");
            transcyPage.clickToLoginTranscyApp();

            log.info("Step 13: Click to Swicher menu button");
            transcyPage.clickSwitcherMenuBtn();

            log.info("Step 14: Verify Header Title Content");
            Assert.assertEquals(transcyPage.getTextHeaderTitle(), expectContentHeaderTitle);
            System.out.println("Actual result: " + transcyPage.getTextHeaderTitle());
            System.out.println("Expected result: " + expectContentHeaderTitle);

            log.info("Step 15: Verify Header Description  Content");
            Assert.assertEquals(transcyPage.getTextHeaderDescription(), expectContentSubTitle);
            System.out.println("Actual result: " + transcyPage.getTextHeaderDescription());
            System.out.println("Expected result: " + expectContentSubTitle);

//        log.info("Step 16: Verify General Header Title");
////        transcyPage.clickToTempalatesTab();
////        WebElement selectText = driver.findElement(By.xpath("//*[@id='general-panel']/div/div/div/div[1]/div"));
////        selectText.getText();
////        System.out.println("Text is: " +selectText);
////        Assert.assertEquals(transcyPage.getTextGeneralTitle(),expectContentGeneralTitle);
//        System.out.println("Actual result: " + transcyPage.getTextGeneralTitle());
//        System.out.println("Expected result: " + expectContentGeneralTitle);

//        log.info("Step 17: Verify General Tab Content");
//        Assert.assertEquals(transcyPage.getTextTabContent(),expectContentGeneralTab);
//        System.out.println("Actual result: " + transcyPage.getTextTabContent());
//        System.out.println("Expected result: " + expectContentGeneralTab);

        }

//    @AfterClass
//    public void quitBrowser() {
//        closeBrowserAndDriver(driver);
//    }
    }

