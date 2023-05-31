package transcy;

import commons.AbstractPage;
import commons.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.TranscyPO;


import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class createStoreAndInstallApp extends AbstractTest {

    private AbstractPage abstractPage;

    private TranscyPO transcyPage;

    String storeURL = "https://www.shopify.com/partners";
    String emailPartner = "vilh@fireapps.vn";
    String passwordPartner = "123321";
    String recoverCode = "9898-746E-BCEF";

    WebDriver driver;

    @Test
    public void Testcase01() throws InterruptedException {
//        driver = getBrowserDriver("chrome");
//        abstractPage = new AbstractPage(driver);
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));


//        Login Partner Shopify
        log.info("Pre-condition: Login Partner Shopify");
        driver.get(storeURL);


        log.info("Step 01: Press on Login Partner button");
//        transcyPage.PageGeneratorManager.getShopifyPage(driver);
//        transcyPage.clickToLoginPartnerBtn();
        driver.findElement(By.xpath("//a[@href='https://partners.shopify.com/organizations']")).click();

        log.info("Step 02: Fill Email account Partner");
//        transcyPage.inputToEmailAccountPartner(emailPartner);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailPartner);

        log.info("Step 03: Press on Continue with Email button");
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
//        transcyPage.clickToContinueWithEmailBtn();
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        log.info("Step 02: Fill Password account Partner");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='account_password']")).sendKeys(passwordPartner);

//        transcyPage.inputTPasswordAccountPartner(passwordPartner);

        log.info("Step 04: Press on Login button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        transcyPage.clickToLoginBtn();

        log.info("Step 05: Press on Use a Recovery code button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Use a recovery code']")).click();

//        transcyPage.clickToUseARecoveryCodeBtn();

        log.info("Step 06: Fill Recovery code");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='next-input']")).sendKeys(recoverCode);

//        transcyPage.inputRecoveryCode(recoverCode);

        log.info("Step 07: Press on Login button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

//        transcyPage.clickToLoginPartnerAfterInputCodeBtn();

        log.info("Step 08: Press Partner button");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[text()='FireApps Dev']/ancestor::a")).click();

//        transcyPage.clickToSelectPartnerBtn();



    }
//    @AfterClass
//    public void quitBrowser() {
//        closeBrowserAndDriver(driver);
//    }
}
