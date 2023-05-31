package transcy;

import commons.AbstractPage;
import commons.AbstractTest;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;
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

    String storeURL = "https://www.shopify.com/partners";
    String emailPartner = "vilh@fireapps.vn";
    String passwordPartner = "123321";
    String recoverCode = "84D3-F13D-051B";
    String storeName = "store test transcy";

    @BeforeTest
    public void beforeTest(){
        driver = getBrowserDriver("chrome");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        transcyPage = PageGeneratorManager.getShopifyPage(driver);
        driver.manage().window().maximize();

    }
    @Test(invocationCount = 1)
    public void LoginPartnerFireAppsDev() throws InterruptedException {
//
//        Login Partner Shopify
        log.info("Pre-condition: Login Partner Shopify");
        driver.get(storeURL);


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
        transcyPage.inputRecoveryCode(recoverCode);

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

        log.info("Step 13: Fill Store name");
        transcyPage.inputStoreName(storeName);

        log.info("Step 13: Select Start with test data option");
        transcyPage.selectOprionStartWithTestData();

        log.info("Step 14: Press Create Development store button");
        transcyPage.clickToDevelopmentStoreBtn();



    }
    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }
}
