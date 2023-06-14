package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class AbstractPage {

    static WebDriver driver;
    WebElement element;
    By by;
    Select select;
    JavascriptExecutor jsExecutor;
    WebDriverWait waitExplicit;
    Actions action;
    long shortTimeout = 3;
    static long midTimeout = 5;
    long longTimeout = 30;

    public AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
        action = new Actions(driver);
    }

    /* WEB ELEMENTS */

    public void clickToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void sendKeyToElement(String locator, String textValue, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(textValue);
    }


    public void scrollToElement(String locator, String attribute) {
        locator = String.format(locator, attribute);
        element = driver.findElement(By.xpath(locator));
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void scrollToEndOfPage(){
        jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public boolean isElementDisplayed(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public void switchToFrameOrIframe(String locator) {
        element = driver.findElement(By.xpath(locator));
        driver.switchTo().frame(element);
    }

    public void waitToElementVisible(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(midTimeout));
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    public void waitToElementClickable(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void sendKeyBoardToElement(String locator, Keys key) {
        element = driver.findElement(By.xpath(locator));
        action.sendKeys(element, key).perform();
    }

    public static String getElementText(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(midTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String text = driver.findElement(by).getText();
//        logConsole("Get text: " + text);
        return text;
    }
    public static String getAttribute(By by, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(midTimeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String att = driver.findElement(by).getAttribute(attribute);
//        logConsole("Get text: " + att);
        return att;
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }
}
