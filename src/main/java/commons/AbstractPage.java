package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import java.util.List;
import java.util.Set;


public class AbstractPage {

    WebDriver driver;
    WebElement element;
    By by;
    Select select;
    JavascriptExecutor jsExecutor;
    WebDriverWait waitExplicit;
    List<WebElement> elements;
    Set<String> allWindows;
    Actions action;
    long shortTimeout = 3;
    long midTimeout = 5;
    long longTimeout = 30;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
    }

    /* WEB BROWSER */

    public void openURL(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }

    /* WEB ELEMENTS */

    public void clickToElement(String locator) {
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void clickToElement(String locator, String value) {
        locator = String.format(locator, value);
        element = driver.findElement(By.xpath(locator));
        element.click();
    }

    public void sendKeyToElement(String locator, String textValue, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        element.clear();
        element.sendKeys(textValue);
    }

    public void selectItemInDropdown(String locator, String valueItem) {
        select = new Select(driver.findElement(By.xpath(locator)));
        select.selectByVisibleText(valueItem);
    }

    public void selectItemInDropdownByIndex(String locator, int index) {
        element = driver.findElement(By.xpath(locator));
        select = new Select(element);
        select.selectByIndex(index);
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

    public boolean isElementDisplayed(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        element = driver.findElement(By.xpath(locator));
        return element.isDisplayed();
    }

    public boolean isElementSelected(String locator) {
        element = driver.findElement(By.xpath(locator));
        return element.isSelected();
    }

    public void switchToFrameOrIframe(String locator) {
        element = driver.findElement(By.xpath(locator));
        driver.switchTo().frame(element);
    }

    public void switchToWindowsByTitle(String title) {
        allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows) {
            driver.switchTo().window(runWindows);
            String currentWindow = driver.getTitle();
            if (currentWindow.equals(title)) {
                break;
            }
        }
    }
    public void waitToElementVisible(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(midTimeout));
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToElementVisible(String locator, String... values) {
        locator = String.format(locator, (Object[]) values);
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitToElementClickable(String locator) {
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitToElementClickable(String locator, String value){
        locator = String.format(locator, value);
        by = By.xpath(locator);
        waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
        waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void sleepInSecond(long numberInSecond) {
        try {
            Thread.sleep(numberInSecond * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendKeyBoardToElement(String locator, Keys key) {
        element = driver.findElement(By.xpath(locator));
        action.sendKeys(element, key).perform();
    }

    public int randomNumber(int boundNumber) {
        Random random = new Random();
        return random.nextInt(boundNumber);
    }
}
