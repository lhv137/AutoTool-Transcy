package swift;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import configs.swiftConfig;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.SwiftPO;

public class createStoreTestInPartner extends AbstractTest {
    private WebDriver driver;
    private SwiftPO swiftPage;


    @BeforeTest
    public void beforeTest(){
        driver = getBrowserDriver("chrome");
//        WebDriver driver;
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        swiftPage = PageGeneratorManager.getSwiftPage(driver);
        driver.manage().window().maximize();
    }

    @Test(priority = 1, description = "Login Partner Swift")
    public void LoginPartnerSwift() throws InterruptedException {
        log.info("=== Open Browser & Get Partner URL ===");
        driver.get(swiftConfig.partnerURL);

        log.info("Step 01: Press Login Partner Button");
        swiftPage.clickToLoginPartnerBtn();

        log.info("Step 02: Fill Email Account Partner");
        swiftPage.inputToEmailAccountPartner(swiftConfig.emailPartnerSwift);

        log.info("Step 03: Press Continue With Email Button");
        swiftPage.clickToContinueWithEmailBtn();
        Thread.sleep(15000);

        log.info("Step 04: Fill Password Account Partner");
        swiftPage.inputTPasswordAccountPartner(swiftConfig.passwordPartnerSwift);

        log.info("Step 05: Press Login Button");
        swiftPage.clickToLoginBtn();

        log.info("Step 06: Press Use A Recovery Code Button");
        swiftPage.clickToUseARecoveryCodeBtn();

        log.info("Step 07: Fill Recovery Code");
        swiftPage.inputRecoveryCode(swiftConfig.recoveryCodePartnerSwwift);

        log.info("Step 08: Press Login Button");
        swiftPage.clickToLoginPartnerAfterInputCodeBtn();

        log.info("Step 09: Press Partner Button");
        swiftPage.clickToSelectPartnerBtn();
    }

    @Test(priority = 2,invocationCount = 4)
    public void CreateStoreTestInPartner() throws InterruptedException {
        Thread.sleep(3000);
        log.info("=== Create Store Test ===");

        log.info("Step 01: Press Stores Menu");
        swiftPage.selectMenuStoresBtn();

        for(int Count = 1;Count<=10;Count++){
            String storeNameSwift = swiftConfig.storeName + Count;
            String storeDomain = storeNameSwift + ".myshopify.com";

            log.info("Step 02: Press Add Store Button");
            swiftPage.clickToAddStore();

            log.info("Step 03: Press Create Development Store Button");
            swiftPage.clickToCreateDevelopmentStore();

            log.info("Step 04: Select Store Test And Build Option");
            swiftPage.selectOptionStoreTest();

            log.info("Step 05: Fill Store name");
            swiftPage.inputStoreName(storeNameSwift);
            System.out.println("Store name: " + storeNameSwift);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,2000)");

            log.info("Step 06: Select Start With test Data Option");
            swiftPage.selectOprionStartWithTestData();

            log.info("Step 07: Press Create Development Store Button");
            swiftPage.clickToAddDevelopmentStoreBtn();

//        log.info("Step 08: Choose account to login");
//        transcyPage.clickToChooseAccountBtn();
//        Thread.sleep(10000);
            if(Count==4){
                break;
            }
            System.out.println("Count is ==> " + Count );
        }
        System.out.println("You have exited the loop");
    }

    @AfterTest
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }

}
