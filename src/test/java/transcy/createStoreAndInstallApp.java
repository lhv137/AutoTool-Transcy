package transcy;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.TransyPO;

import java.time.Duration;
import java.util.concurrent.TimeUnit;



public class createStoreAndInstallApp extends AbstractTest {
    private WebDriver driver;

    private TransyPO transcyPage;
    public static final int RAMDOM_BOUND = 10000000;

//    PARNTER INFO
    String partnerURL = "https://www.shopify.com/partners";
    String emailPartner = "vilh@fireapps.vn";
    String passwordPartner = "123321";
    String recoveryCode = "C78A-75BE-2440";
    String storeName = "storetesttranscy" + RAMDOM_BOUND;

//    ADMIN TOOL INFO
    String adminToolUATURL = "https://transcy-stag-admin.onecommerce.app";
    String userNameAdminTool = "admin";
    String passWordAdminTool = "ShopifyAppsGreat2022";
    String storeNameAdmin = storeName;

//    INSTALL TRANSCY UAT V4 APP
    String appName = "Transcy UAT V4";

    @BeforeTest
    public void beforeTest(){
//        driver = getBrowserDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        transcyPage = PageGeneratorManager.getShopifyPage(driver);
        driver.manage().window().maximize();

    }
    @Test(invocationCount = 1)
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
        Thread.sleep(5000);
        transcyPage.clickToContinueWithEmailBtn();


        log.info("Step 02: Fill Password account Partner");
        transcyPage.inputTPasswordAccountPartner(passwordPartner);

        log.info("Step 04: Press on Login button");
        transcyPage.clickToLoginBtn();

        log.info("Step 05: Press on Use a Recovery code button");
        transcyPage.clickToUseARecoveryCodeBtn();

        log.info("Step 06: Fill Recovery code");
        transcyPage.inputRecoveryCode(recoveryCode);

        log.info("Step 07: Press on Login button");
        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

        log.info("Step 08: Press Partner button");
        transcyPage.clickToSelectPartnerBtn();

        Thread.sleep(5000);

        log.info("Step 09: Press Stores menu");
        transcyPage.selectMenuStoresBtn();

        log.info("Step 10: Press Add Store button");
        transcyPage.clickToAddStore();

        log.info("Step 11: Press Create Development Store button");
        transcyPage.clickToCreateDevelopmentStore();

        log.info("Step 12: Select Store test and Build option");
        transcyPage.selectOptionStoreTest();
        Thread.sleep(5000);
        System.out.println("Tesst");

        log.info("Step 13: Fill Store name");
        transcyPage.inputStoreName(storeName);

        log.info("Step 13: Select Start with test data option");
        transcyPage.selectOprionStartWithTestData();

        log.info("Step 14: Press Create Development store button");
        transcyPage.clickToDevelopmentStoreBtn();
    }

        @Test(invocationCount = 1)
        public void AddStoreTestTranscy() throws InterruptedException {

        log.info("Step 01: Go to Admin tool");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(adminToolUATURL);
        Thread.sleep(5000);

        log.info("Step 02: Fill Username Admin tool");
        transcyPage.inputUserNameAdminTool(userNameAdminTool);

        log.info("Step 02: Fill Password Admin tool");
        transcyPage.inputPassWordAdminTool(passWordAdminTool);

        log.info("Step 02: Login Admin tool");
        transcyPage.clickToLoginAdminToolBtn();

        log.info("Step 03: Login Admin tool");
        transcyPage.clickToManageTestStoreBtn();

        log.info("Step 04: Fill Store Domain to Add Store test");
        transcyPage.inputStoreTestDomain(storeNameAdmin);

        log.info("Step 05: Click Add Store test");
        transcyPage.clickToAddTestStoreBtn();

        log.info("Step 06: Handle Alert");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(3000);
        driver.close();
    }

    @Test(invocationCount = 1)
    public void InstallTranscyAppUAT() throws InterruptedException {
        //        Login Partner Shopify
        log.info("Pre-condition: Login Partner Shopify");
        driver.get(partnerURL);

        log.info("Step 01: Press on Login Partner button");
        transcyPage.clickToLoginPartnerBtn();

        log.info("Step 02: Fill Email account Partner");
        transcyPage.inputToEmailAccountPartner(emailPartner);

        log.info("Step 03: Press on Continue with Email button");
        Thread.sleep(5000);
        transcyPage.clickToContinueWithEmailBtn();

        log.info("Step 02: Fill Password account Partner");
        transcyPage.inputTPasswordAccountPartner(passwordPartner);

        log.info("Step 04: Press on Login button");
        transcyPage.clickToLoginBtn();

        log.info("Step 05: Press on Use a Recovery code button");
        transcyPage.clickToUseARecoveryCodeBtn();

        log.info("Step 06: Fill Recovery code");
        transcyPage.inputRecoveryCode(recoveryCode);

        log.info("Step 07: Press on Login button");
        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

        log.info("Step 08: Press Partner button");
        transcyPage.clickToSelectPartnerBtn();
        Thread.sleep(5000);

        log.info("Step 09: Go To Apps Menu");
//        driver.switchTo().newWindow(WindowType.TAB);
//        driver.get(partnerURL);
//        Thread.sleep(5000);
        transcyPage.selectMenuAppsBtn();
        Thread.sleep(3000);


        log.info("Step 10: Search Transcy UAT V4App");
        transcyPage.searchAppTranscyUATV4(appName);
        Thread.sleep(3000);


        log.info("Step 11: Click to select Transcy UAT V4 App");
        transcyPage.clickToSelectTranscyUATV4App();
        Thread.sleep(3000);


        log.info("Step 11: Click to Select Store Button");
        transcyPage.clickToSelectStoreBtn();
        Thread.sleep(3000);


        log.info("Step 12: Search Store Domain");
        transcyPage.searchStoreDomainToInstallApp(storeNameAdmin);
        Thread.sleep(5000);

        log.info("Step 12: Select Store Domain to Install App");
        transcyPage.selectStoreDomainToInstallApp();

        log.info("Step 13: Click Install Button");
        transcyPage.clickToInstallBtn();

//        log.info("Step 02: Press on Login Partner button");
//        transcyPage.clickToLoginPartnerBtn();
//
//        log.info("Step 03: Press Partner button");
//        transcyPage.clickToSelectPartnerBtn();

    }


    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }
}
