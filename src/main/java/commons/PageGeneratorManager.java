package commons;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageGeneratorManager {

    public static TranscyPO getShopifyPage(WebDriver driver) {
        return new TranscyPO(driver);
    }

    public static TranscyPO getTranscyPage(WebDriver driver){ return new TranscyPO(driver); }

}
