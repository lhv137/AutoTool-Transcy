package transcy;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.TransyPO;
import org.testng.Assert;
import pageUI.Locators;


import java.time.Duration;
import java.util.Random;




public class createStoreAndInstallApp extends AbstractTest {
    private WebDriver driver;
    private TransyPO transcyPage;

//    PARNTER INFO
    String partnerURL = "https://www.shopify.com/partners";
    String emailPartner1 = "vilh+1@firegroup.io";
    String emailPartner = "vilh@fireapps.vn";
    String passwordPartner1 = "Vile@12345";
    String passwordPartner = "123321";
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
    public void beforeTest(){
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
        Thread.sleep(3000);

        log.info("Step 05: Fill Store name");
        transcyPage.inputStoreName(storeName);
        System.out.println("Store name:" + storeName);
        Thread.sleep(5000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,2000)");

        log.info("Step 06: Select Start with test data option");
        transcyPage.selectOprionStartWithTestData();
        Thread.sleep(5000);

        log.info("Step 07: Press Create Development store button");
        transcyPage.clickToAddDevelopmentStoreBtn();
        Thread.sleep(20000);

//        log.info("Step 08: Choose account to login");
//        transcyPage.clickToChooseAccountBtn();
//        Thread.sleep(10000);

    }
        @Test(priority = 3)
        public void AddStoreTestTranscy() throws InterruptedException {
        String storeNameAdmin = storeName + ".myshopify.com";

        log.info("Step 01: Go to Admin tool");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(adminToolUATURL);
        Thread.sleep(5000);

        log.info("Step 02: Fill Username Admin tool");
        transcyPage.inputUserNameAdminTool(userNameAdminTool);
        Thread.sleep(5000);

        log.info("Step 03: Fill Password Admin tool");
        transcyPage.inputPassWordAdminTool(passWordAdminTool);
        Thread.sleep(5000);

        log.info("Step 04: Login Admin tool");
        transcyPage.clickToLoginAdminToolBtn();
        Thread.sleep(5000);

        log.info("Step 05: Go to Manage Test Store menu");
        transcyPage.clickToManageTestStoreBtn();
        Thread.sleep(5000);

        log.info("Step 06: Fill Store Domain to Add Store test");
        transcyPage.inputStoreTestDomain(storeNameAdmin);
        System.out.println("Store name:" + storeNameAdmin);
        Thread.sleep(5000);

        log.info("Step 07: Click Add Store test");
        transcyPage.clickToAddTestStoreBtn();
        Thread.sleep(5000);

        log.info("Step 08: Handle Alert");
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void InstallTranscyAppUAT() throws InterruptedException {
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
        Thread.sleep(3000);

        log.info("Step 04: Go To Apps Menu");
        transcyPage.selectMenuAppsBtn();
        Thread.sleep(3000);

        log.info("Step 05: Search Transcy UAT V4 App");
        transcyPage.searchAppTranscyUATV4(appName);
        Thread.sleep(5000);

        log.info("Step 06: Click to select Transcy UAT V4 App");
        transcyPage.clickToSelectTranscyUATV4App();
        Thread.sleep(5000);

        log.info("Step 07: Click to Select Store button");
        transcyPage.clickToSelectStoreBtn();
        Thread.sleep(5000);

        log.info("Step 08: Search Store Domain");
        transcyPage.searchStoreDomainToInstallApp(storeTest);
        Thread.sleep(5000);

        log.info("Step 09: Select Store Domain to Install App");
        transcyPage.selectStoreDomainToInstallApp();
        Thread.sleep(10000);

//        log.info("Step 10: Click Choose Partner Account button");
//        transcyPage.clickToChooseAccountPartnerBtn();
//        Thread.sleep(5000);

        log.info("Step 11: Click Install Transcy V4 App button");
        transcyPage.clickToInstallTranscyV4AppBtn();
        Thread.sleep(15000);

        log.info("Step 12: Click Choose Free Plan Transcy V4 App button");
        transcyPage.clickToChoosePlanTranscyV4AppBtn();
        Thread.sleep(10000);

        log.info("Step 13: Click to Swicher menu button");
        transcyPage.clickSwitcherMenuBtn();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void CheckModalFirstTimeGoToMenuSwitcher() throws InterruptedException {

//      MODAL CONTENT FIRST TIME LOGIN

        String expectedTitle = "Manage switcher";
        String expectedTitle1 = "Activate Transcy Switcher";

        WebElement m = driver.findElement(By.xpath("//h2[@class='sc-2126ad3d-6 jxlOwl']"));
        System.out.println("Title:"+ m.getText() + "-" + m.getCssValue("color"));
        Assert.assertEquals(m.getText(),expectedTitle);

        WebElement m1 = driver.findElement(By.xpath("//h2[@class='Polaris-Heading' and contains(text(),'Activate Transcy Switcher')]"));
        System.out.println("Title 1:"+ m1.getText());
//        Assert.assertEquals(m1.getText(),expectedTitle1);
    }
    }


//    @AfterClass
//    public void quitBrowser() {
//        closeBrowserAndDriver(driver);
//    }

