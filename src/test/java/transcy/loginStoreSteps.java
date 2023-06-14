package transcy;

import commons.AbstractTest;
import commons.ExpectedData;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.TransyPO;

public class loginStoreSteps extends AbstractTest {
    private WebDriver driver;
    private TransyPO transcyPage;

//  Data Partner Sandbox
    String emailSandboxPartner = "vilh+1@firegroup.io";
    String passSandboxPartner = "Vile@12345";
    String storeNameSandboxPartner = "https://admin.shopify.com/store/arstoresandbox1";

    @BeforeTest
    public void beforeTest() {
//        driver = getBrowserDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        transcyPage = PageGeneratorManager.getShopifyPage(driver);
        driver.manage().window().maximize();
    }
    @Test(description = "Login Store with Partner Sandbox And Go To Switcher Menu", priority = 1)
    public void LoginStorePartnerSandBoxAndGoToSwitcherMenu () throws InterruptedException {

        log.info("Step 01: Login Partner Shopify");
        Thread.sleep(3000);
//        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(storeNameSandboxPartner);

        log.info("Step 02: Fill Email account Partner");
        transcyPage.inputToEmailAccountPartner(emailSandboxPartner);

        log.info("Step 03: Press on Continue with Email button");
        transcyPage.clickToContinueWithEmailBtn();

        log.info("Step 04: Fill Password account Partner");
        transcyPage.inputTPasswordAccountPartner(passSandboxPartner);

        log.info("Step 05: Press on Login button");
        transcyPage.clickToLoginBtn();
        Thread.sleep(15000);
//
//        log.info("Step 06: Select Partner Account");
//        transcyPage.clickToChooseAccountBtn();
//        Thread.sleep(5000);

        log.info("Step 06: Click To App menu");
        transcyPage.clickToAppsMenu();
        Thread.sleep(5000);

        log.info("Step 07: Click To Login Transcy App");
        transcyPage.clickToLoginTranscyApp();
        Thread.sleep(5000);

        log.info("Step 08: Click to Switcher menu button");
        transcyPage.clickSwitcherMenuBtn();
    }

    @Test(priority = 2)
    public void VerifySwitcherSettingsDefaultCustomizationTab () throws InterruptedException {

        log.info("Step 01: Go to Customization Setting Tab");
        transcyPage.clickToCustomizationTab();

//        log.info("Step 02: Verify Position Title");
//        Assert.assertEquals(transcyPage.getPositionTitleContent(), ExpectedData.expectPositionTitle);
//        System.out.println("Actual result: " + transcyPage.getPositionTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectPositionTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 03: Verify Preference Title");
//        Assert.assertEquals(transcyPage.getPreferenceTitleContent(), ExpectedData.expectPreferenceTitle);
//        System.out.println("Actual result: " + transcyPage.getPreferenceTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectPreferenceTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 04: Verify Preference Setting type");
//        Assert.assertEquals(transcyPage.getPreferenceSettingType(), ExpectedData.expectPreferenceSettingType);
//        System.out.println("Actual result: " + transcyPage.getPreferenceSettingType());
//        System.out.println("Expected result: " + ExpectedData.expectPreferenceSettingType);
//        Thread.sleep(5000);
//
//        log.info("Step 05: Verify Preference Setting position");
//        Assert.assertEquals(transcyPage.getPreferenceSettingPosition(), ExpectedData.expectPreferenceSettingPosition);
//        System.out.println("Actual result: " + transcyPage.getPreferenceSettingPosition());
//        System.out.println("Expected result: " + ExpectedData.expectPreferenceSettingPosition);
//        Thread.sleep(5000);
//
//        log.info("Step 06: Verify Offset Title");
//        Assert.assertEquals(transcyPage.getOffsetTitleContent(), ExpectedData.expectOffsetTitle);
//        System.out.println("Actual result: " + transcyPage.getOffsetTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectOffsetTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 07: Verify Offset Top");
//        Assert.assertEquals(transcyPage.getOffsetSettingTop(), ExpectedData.expectOffsetSettingTop);
//        System.out.println("Actual result: " + transcyPage.getOffsetSettingTop());
//        System.out.println("Expected result: " + ExpectedData.expectOffsetSettingTop);
//        Thread.sleep(5000);
//
//        log.info("Step 08: Verify Offset Right");
//        Assert.assertEquals(transcyPage.getOffsetSettingRight(), ExpectedData.expectOffsetSettingRight);
//        System.out.println("Actual result: " + transcyPage.getOffsetSettingRight());
//        System.out.println("Expected result: " + ExpectedData.expectOffsetSettingRight);
//        Thread.sleep(5000);
//
//        log.info("Step 09: Verify Switcher Style Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleTitleContent(), ExpectedData.expectSwitcherStyleTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 10: Collapse Position Tab");
//        transcyPage.clickToPositionTab();
//
//        log.info("Step 11: Expand Switcher Style Tab");
//        transcyPage.clickToSwitcherStyleTab();
//
//        log.info("Step 12: Verify Switcher Style - Width Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleWidthTitleContent(), ExpectedData.expectSwitcherStyleWidthTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleWidthTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 13: Verify Switcher Style - Width Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidth(), ExpectedData.expectSwitcherStyleWidthSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidth());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 14: Verify Switcher Style - Width Value");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidthValue(), ExpectedData.expectSwitcherStyleWidthValue);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidthValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthValue);
//        Thread.sleep(5000);
//
//        log.info("Step 15: Verify Switcher Style - Border Title");
//            Assert.assertEquals(transcyPage.getSwitcherStyleBorderTitleContent(), ExpectedData.expectSwitcherStyleBorderTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleBorderTitleContent());
//            System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 16: Verify Switcher Style - Border Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorder(), ExpectedData.expectSwitcherStyleBorderSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorder());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 17: Verify Switcher Style - Border Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorderStyle(), ExpectedData.expectSwitcherStyleBorderStyle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorderStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderStyle);
//        Thread.sleep(5000);
//
//        log.info("Step 18: Verify Switcher Style - Effect Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleEffectTitleContent(), ExpectedData.expectSwitcherStyleEffectTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleEffectTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 19: Verify Switcher Style - Effect Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingEffect(), ExpectedData.expectSwitcherStyleEffectSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingEffect());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 20: Verify Switcher Style - Hover & active Effect Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleHoverEffectTitleContent(), ExpectedData.expectSwitcherStyleHoverEffectTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleHoverEffectTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleHoverEffectTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 21: Verify Switcher Style - Hover & active Effect Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingHoverEffect(), ExpectedData.expectSwitcherStyleHoverEffectSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingHoverEffect());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleHoverEffectSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 22: Verify Switcher Style - Effect Note");
//        Assert.assertEquals(transcyPage.getSwitcherStyleNoteEffect(), ExpectedData.expectSwitcherStyleEffectNote);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteEffect());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectNote);
//        Thread.sleep(5000);
//
//        log.info("Step 23: Verify Switcher Style - Layout Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLayoutTitleContent(), ExpectedData.expectSwitcherStyleLayoutTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLayoutTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 24: Verify Switcher Style - Layout Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingLayout(), ExpectedData.expectSwitcherStyleLayoutSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLayout());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLayoutSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 25: Verify Switcher Style - Arrow Segment Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleArrowSegmentTitleContent(), ExpectedData.expectSwitcherStyleArrowSegmentTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleArrowSegmentTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 26: Verify Switcher Style - Arrow Segment Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingArrowSegment(), ExpectedData.expectSwitcherStyleArrowSegmentSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingArrowSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 27: Verify Switcher Style - Arrow Segment Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingStyleArrowSegment(), ExpectedData.expectSwitcherStyleArrowSegmentStyle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingStyleArrowSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentStyle);
//        Thread.sleep(5000);
//
//        log.info("Step 28: Verify Switcher Style - Label Segment Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLabelSegmentTitleContent(), ExpectedData.expectSwitcherStyleLabelSegmentTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLabelSegmentTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 29: Verify Switcher Style - Label Segment Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingLabelSegment(), ExpectedData.expectSwitcherStyleLabelSegmentSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLabelSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 30: Verify Switcher Style - Label Segment Note");
//        Assert.assertEquals(transcyPage.getSwitcherStyleNoteLabelSegment(), ExpectedData.expectSwitcherStyleLabelSegmentNote);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteLabelSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentNote);
//        Thread.sleep(5000);
//
//        log.info("Step 31: Verify Switcher Style - Language Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLanguageTitleContent(), ExpectedData.expectSwitcherStyleLanguageTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 32: Verify Switcher Style - Language Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingLanguage(), ExpectedData.expectSwitcherStyleLanguageSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLanguage());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageSetting);
//        Thread.sleep(5000);
////
//        log.info("Step 33: Verify Switcher Style - Language Status: Checked");
//        Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusChecked());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusChecked());
//        System.out.println("Expected result: " +transcyPage.getSwitcherStyleLanguageStatusChecked());
//        Thread.sleep(5000);
//
//        log.info("Step 34: Verify Switcher Style - Language Status: Enable");
//        Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusEnable());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
//        System.out.println("Expected result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
//        Thread.sleep(5000);
//
//        log.info("Step 35: Verify Switcher Style - Language Content Checkbox");
//        Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxLanguage(), ExpectedData.expectSwitcherStyleLanguageContentCheckbox);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxLanguage());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageContentCheckbox);
//        Thread.sleep(5000);
//
//        log.info("Step 36: Verify Switcher Style - Currency Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleCurrencyTitleContent(), ExpectedData.expectSwitcherStyleCurrencyTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencyTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 37: Verify Switcher Style - Currency Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingCurrency(), ExpectedData.expectSwitcherStyleCurrencySetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingCurrency());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencySetting);
//        Thread.sleep(5000);
////
//        log.info("Step 38: Verify Switcher Style - Currency Status: Checked");
//        Assert.assertTrue(transcyPage.getSwitcherStyleCurrencyStatusChecked());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
//        System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
//        Thread.sleep(5000);
//
//        log.info("Step 39: Verify Switcher Style - Currency Status: Enable");
//        Assert.assertFalse(transcyPage.getSwitcherStyleCurrencyStatusEnable());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
//        System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
//        Thread.sleep(5000);
//
//        log.info("Step 40: Verify Switcher Style - Currency Content Checkbox");
//        Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxCurrency(), ExpectedData.expectSwitcherStyleCurrencyContentCheckbox);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxCurrency());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencyContentCheckbox);
//        Thread.sleep(5000);
//
//        log.info("Step 41: Verify Switcher Style - Divider Format Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleDividerFormatTitleContent(), ExpectedData.expectSwitcherStyleDividerFormatTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleDividerFormatTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleDividerFormatTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 42: Verify Switcher Style - Divider Format Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingDividerFormat(), ExpectedData.expectSwitcherStyleDividerFormatSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingDividerFormat());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleDividerFormatSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 43: Verify Switcher Style - Font Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleFontTitleContent(), ExpectedData.expectSwitcherStyleFontTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleFontTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 44: Verify Switcher Style - Font Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingFont(), ExpectedData.expectSwitcherStyleFontSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFont());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 45: Verify Switcher Style - Font Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFont(), ExpectedData.expectSwitcherStyleFontStyle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFont());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontStyle);
//        Thread.sleep(5000);
//
//        log.info("Step 46: Verify Switcher Style - Font Note");
//        Assert.assertEquals(transcyPage.getSwitcherStyleNoteFont(), ExpectedData.expectSwitcherStyleFontNote);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteFont());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontNote);
//        Thread.sleep(5000);
//
//        log.info("Step 47: Verify Switcher Style - Flag Style Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleFlagStyleTitleContent(), ExpectedData.expectSwitcherStyleFlagTitle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleFlagStyleTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagTitle);
//        Thread.sleep(5000);
//
//        log.info("Step 48: Verify Switcher Style - Flag Style Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingFlagStyle(), ExpectedData.expectSwitcherStyleFlagSetting);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFlagStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagSetting);
//        Thread.sleep(5000);
//
//        log.info("Step 49: Verify Switcher Style - Flag Style Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFlagStyle(), ExpectedData.expectSwitcherStyleFlagStyle);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFlagStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagStyle);
//        Thread.sleep(5000);


    }

}
