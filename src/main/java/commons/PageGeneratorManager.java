package commons;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageGeneratorManager {
    public static TransyPO getShopifyPage(WebDriver driver) {
        return new TransyPO(driver);
    }

}
