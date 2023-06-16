package transcy;

import commons.AbstractTest;
import commons.ExpectedData;
import commons.PageGeneratorManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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

        log.info("Step 06: Click To App menu");
        transcyPage.clickToAppsMenu();
        Thread.sleep(5000);

        log.info("Step 07: Click To Login Transcy App");
        transcyPage.clickToLoginTranscyApp();
        Thread.sleep(5000);
//
//        log.info("Step 06: Select Partner Account");
//        transcyPage.clickToChooseAccountBtn();
//        Thread.sleep(10000);

        log.info("Step 08: Click to Switcher menu button");
        transcyPage.clickSwitcherMenuBtn();
    }

    @Test(priority = 2)
    public void VerifySwitcherSettingsDefaultCustomizationTab () throws InterruptedException {

        log.info("=== Go to Customization Setting Tab ===");
        transcyPage.clickToCustomizationTab();
//
//        log.info("=== Verify Position Tab ===");
//
//        log.info("Step 01: Verify Position Title");
//        Assert.assertEquals(transcyPage.getPositionTitleContent(), ExpectedData.expectPositionTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getPositionTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectPositionTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 02: Verify Preference Title");
//        Assert.assertEquals(transcyPage.getPreferenceTitleContent(), ExpectedData.expectPreferenceTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getPreferenceTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectPreferenceTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 03: Verify Preference Setting type");
//        Assert.assertEquals(transcyPage.getPreferenceSettingType(), ExpectedData.expectPreferenceSettingTypeDefault);
//        System.out.println("Actual result: " + transcyPage.getPreferenceSettingType());
//        System.out.println("Expected result: " + ExpectedData.expectPreferenceSettingTypeDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 04: Verify Preference Setting position");
//        Assert.assertEquals(transcyPage.getPreferenceSettingPosition(), ExpectedData.expectPreferenceSettingPositionDefault);
//        System.out.println("Actual result: " + transcyPage.getPreferenceSettingPosition());
//        System.out.println("Expected result: " + ExpectedData.expectPreferenceSettingPositionDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 05: Verify Offset Title");
//        Assert.assertEquals(transcyPage.getOffsetTitleContent(), ExpectedData.expectOffsetTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getOffsetTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectOffsetTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 06: Verify Offset Top");
//        Assert.assertEquals(transcyPage.getOffsetSettingTop(), ExpectedData.expectOffsetSettingTopValueDefault);
//        System.out.println("Actual result: " + transcyPage.getOffsetSettingTop());
//        System.out.println("Expected result: " + ExpectedData.expectOffsetSettingTopValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 07: Verify Offset Right");
//        Assert.assertEquals(transcyPage.getOffsetSettingRight(), ExpectedData.expectOffsetSettingRightValueDefault);
//        System.out.println("Actual result: " + transcyPage.getOffsetSettingRight());
//        System.out.println("Expected result: " + ExpectedData.expectOffsetSettingRightValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 08: Verify Switcher Style Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleTitleContent(), ExpectedData.expectSwitcherStyleTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("=== Collapse Position Tab ===");
//        transcyPage.clickToPositionTab();
//
//        log.info("=== Expand Switcher Style Tab ===");
//        transcyPage.clickToSwitcherStyleTab();
//
//        log.info("=== Verify Switcher Style Tab ===");
//
//        log.info("Step 01: Verify Switcher Style - Width Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleWidthTitleContent(), ExpectedData.expectSwitcherStyleWidthTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleWidthTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 02: Verify Switcher Style - Width Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidth(), ExpectedData.expectSwitcherStyleWidthSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidth());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 03: Verify Switcher Style - Width Value");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingWidthValue(), ExpectedData.expectSwitcherStyleWidthValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingWidthValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleWidthValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 04: Verify Switcher Style - Border Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleBorderTitleContent(), ExpectedData.expectSwitcherStyleBorderTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleBorderTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 05: Verify Switcher Style - Border Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorder(), ExpectedData.expectSwitcherStyleBorderSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorder());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 06: Verify Switcher Style - Border Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingBorderStyle(), ExpectedData.expectSwitcherStyleBorderStyleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingBorderStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleBorderStyleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 07: Verify Switcher Style - Effect Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleEffectTitleContent(), ExpectedData.expectSwitcherStyleEffectTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleEffectTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 08: Verify Switcher Style - Effect Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingEffect(), ExpectedData.expectSwitcherStyleEffectSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingEffect());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 09: Verify Switcher Style - Hover & active Effect Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleHoverEffectTitleContent(), ExpectedData.expectSwitcherStyleHoverEffectTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleHoverEffectTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleHoverEffectTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 10: Verify Switcher Style - Hover & active Effect Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingHoverEffect(), ExpectedData.expectSwitcherStyleHoverEffectSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingHoverEffect());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleHoverEffectSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 11: Verify Switcher Style - Effect Note");
//        Assert.assertEquals(transcyPage.getSwitcherStyleNoteEffect(), ExpectedData.expectSwitcherStyleEffectNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteEffect());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleEffectNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 12: Verify Switcher Style - Layout Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLayoutTitleContent(), ExpectedData.expectSwitcherStyleLayoutTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLayoutTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 13: Verify Switcher Style - Layout Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingLayout(), ExpectedData.expectSwitcherStyleLayoutSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLayout());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLayoutSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 14: Verify Switcher Style - Arrow Segment Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleArrowSegmentTitleContent(), ExpectedData.expectSwitcherStyleArrowSegmentTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleArrowSegmentTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 15: Verify Switcher Style - Arrow Segment Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingArrowSegment(), ExpectedData.expectSwitcherStyleArrowSegmentSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingArrowSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 16: Verify Switcher Style - Arrow Segment Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingStyleArrowSegment(), ExpectedData.expectSwitcherStyleArrowSegmentStyleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingStyleArrowSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleArrowSegmentStyleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 17: Verify Switcher Style - Label Segment Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLabelSegmentTitleContent(), ExpectedData.expectSwitcherStyleLabelSegmentTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLabelSegmentTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 18: Verify Switcher Style - Label Segment Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingLabelSegment(), ExpectedData.expectSwitcherStyleLabelSegmentSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLabelSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 19: Verify Switcher Style - Label Segment Note");
//        Assert.assertEquals(transcyPage.getSwitcherStyleNoteLabelSegment(), ExpectedData.expectSwitcherStyleLabelSegmentNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteLabelSegment());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLabelSegmentNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 20: Verify Switcher Style - Language Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLanguageTitleContent(), ExpectedData.expectSwitcherStyleLanguageTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 21: Verify Switcher Style - Language Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingLanguage(), ExpectedData.expectSwitcherStyleLanguageSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingLanguage());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageSettingDefault);
//        Thread.sleep(5000);
////
//        log.info("Step 22: Verify Switcher Style - Language Status: Checked");
//        Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusChecked());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusChecked());
//        System.out.println("Expected result: " +transcyPage.getSwitcherStyleLanguageStatusChecked());
//        Thread.sleep(5000);
//
//        log.info("Step 23: Verify Switcher Style - Language Status: Enable");
//        Assert.assertTrue(transcyPage.getSwitcherStyleLanguageStatusEnable());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
//        System.out.println("Expected result: " + transcyPage.getSwitcherStyleLanguageStatusEnable());
//        Thread.sleep(5000);
//
//        log.info("Step 24: Verify Switcher Style - Language Content Checkbox");
//        Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxLanguage(), ExpectedData.expectSwitcherStyleLanguageContentCheckboxDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxLanguage());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleLanguageContentCheckboxDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 25: Verify Switcher Style - Currency Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleCurrencyTitleContent(), ExpectedData.expectSwitcherStyleCurrencyTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencyTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 26: Verify Switcher Style - Currency Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingCurrency(), ExpectedData.expectSwitcherStyleCurrencySettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingCurrency());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencySettingDefault);
//        Thread.sleep(5000);
////
//        log.info("Step 27: Verify Switcher Style - Currency Status: Checked");
//        Assert.assertTrue(transcyPage.getSwitcherStyleCurrencyStatusChecked());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
//        System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusChecked());
//        Thread.sleep(5000);
//
//        log.info("Step 28: Verify Switcher Style - Currency Status: Enable");
//        Assert.assertFalse(transcyPage.getSwitcherStyleCurrencyStatusEnable());
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
//        System.out.println("Expected result: " + transcyPage.getSwitcherStyleCurrencyStatusEnable());
//        Thread.sleep(5000);
//
//        log.info("Step 29: Verify Switcher Style - Currency Content Checkbox");
//        Assert.assertEquals(transcyPage.getSwitcherStyleContentCheckboxCurrency(), ExpectedData.expectSwitcherStyleCurrencyContentCheckboxDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleContentCheckboxCurrency());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleCurrencyContentCheckboxDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 30: Verify Switcher Style - Divider Format Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleDividerFormatTitleContent(), ExpectedData.expectSwitcherStyleDividerFormatTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleDividerFormatTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleDividerFormatTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 31: Verify Switcher Style - Divider Format Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingDividerFormat(), ExpectedData.expectSwitcherStyleDividerFormatSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingDividerFormat());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleDividerFormatSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 32: Verify Switcher Style - Font Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleFontTitleContent(), ExpectedData.expectSwitcherStyleFontTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleFontTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 33: Verify Switcher Style - Font Value");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingFont(), ExpectedData.expectSwitcherStyleFontValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFont());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 34: Verify Switcher Style - Font Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFont(), ExpectedData.expectSwitcherStyleFontStyleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFont());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontStyleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 35: Verify Switcher Style - Font Note");
//        Assert.assertEquals(transcyPage.getSwitcherStyleNoteFont(), ExpectedData.expectSwitcherStyleFontNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleNoteFont());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFontNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 36: Verify Switcher Style - Flag Style Title");
//        Assert.assertEquals(transcyPage.getSwitcherStyleFlagStyleTitleContent(), ExpectedData.expectSwitcherStyleFlagTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleFlagStyleTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 37: Verify Switcher Style - Flag Style Setting");
//        Assert.assertEquals(transcyPage.getSwitcherStyleSettingFlagStyle(), ExpectedData.expectSwitcherStyleFlagSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleSettingFlagStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 38: Verify Switcher Style - Flag Style Style");
//        Assert.assertEquals(transcyPage.getSwitcherStyleLayoutFlagStyle(), ExpectedData.expectSwitcherStyleFlagStyleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherStyleLayoutFlagStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherStyleFlagStyleDefault);
//        Thread.sleep(5000);
//
//        log.info("=== Collapse Switcher Style Tab ===");
//        transcyPage.clickToSwitcherStyleTab();
//
////        log.info("Step 50: Collapse Position Tab");
////        transcyPage.clickToPositionTab();
//
//        log.info("=== Expand Switcher Disclosure Style Tab ===");
//        transcyPage.clickToSwitcherDisclosureStyleTab();
//
//        log.info("=== Verify Switcher Disclosure Style Tab ===");
//
//        log.info("Step 01: Verify Switcher Disclosure Style Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleContent(), ExpectedData.expectSwitcherDisclosureStyleTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 02: Verify Switcher Disclosure Style - Width Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthTitleContent(), ExpectedData.expectSwitcherDisclosureStyleWidthTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleWidthTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 03: Verify Switcher Disclosure Style - Width Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthSetting(), ExpectedData.expectSwitcherDisclosureStyleWidthSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleWidthSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 04: Verify Switcher Disclosure Style - Width Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleWidthValue(), ExpectedData.expectSwitcherDisclosureStyleWidthValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleWidthValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleWidthValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 05: Verify Switcher Disclosure Style - Border Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderTitleContent(), ExpectedData.expectSwitcherDisclosureStyleBorderTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleBorderTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 06: Verify Switcher Disclosure Style - Border Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderSetting(), ExpectedData.expectSwitcherDisclosureStyleBorderSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleBorderSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 07: Verify Switcher Disclosure Style - Border Style");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleBorderStyle(), ExpectedData.expectSwitcherDisclosureStyleBorderStyleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleBorderStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleBorderStyleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 08: Verify Switcher Disclosure Style - Active Effect Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectTitleContent(), ExpectedData.expectSwitcherDisclosureStyleActiveEffectTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleActiveEffectTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 09: Verify Switcher Disclosure Style - Active Effect Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectSetting(), ExpectedData.expectSwitcherDisclosureStyleActiveEffectSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleActiveEffectSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 10: Verify Switcher Disclosure Style - Active Effect Note");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleActiveEffectNote(), ExpectedData.expectSwitcherDisclosureStyleActiveEffectNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleActiveEffectNote());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleActiveEffectNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 11: Verify Switcher Disclosure Style - Element To Show Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleElementToShowTitleContent(), ExpectedData.expectSwitcherDisclosureStyleElementToShowTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleElementToShowTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleElementToShowTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 12: Verify Switcher Disclosure Style - Element To Show Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleElementToShowSetting(), ExpectedData.expectSwitcherDisclosureStyleElementToShowSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleElementToShowSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleElementToShowSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 13: Verify Switcher Disclosure Style - Language Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageTitleContent(), ExpectedData.expectSwitcherDisclosureStyleLanguageTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleLanguageTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 14: Verify Switcher Disclosure Style - Language Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageSetting(), ExpectedData.expectSwitcherDisclosureStyleLanguageSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleLanguageSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 15: Verify Switcher Disclosure Style - Language Status: Checked");
//        Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
//        System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusChecked());
//        Thread.sleep(5000);
//
//        log.info("Step 16: Verify Switcher Disclosure Style - Language Status: Enable");
//        Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
//        System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleLanguageStatusEnable());
//        Thread.sleep(5000);
//
//        log.info("Step 17: Verify Switcher Disclosure Style - Language Content Checkbox");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleLanguageCheckboxContent(), ExpectedData.expectSwitcherDisclosureStyleLanguageCheckboxContentDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleLanguageCheckboxContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleLanguageCheckboxContentDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 18: Verify Switcher Disclosure Style - Currency Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencyTitleContent(), ExpectedData.expectSwitcherDisclosureStyleCurrencyTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleCurrencyTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 19: Verify Switcher Disclosure Style - Currency Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencySetting(), ExpectedData.expectSwitcherDisclosureStyleCurrencySettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencySetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleCurrencySettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 20: Verify Switcher Disclosure Style - Currency Status: Checked");
//        Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
//        System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusChecked());
//        Thread.sleep(5000);
//
//        log.info("Step 21: Verify Switcher Disclosure Style - Currency Status: Enable");
//        Assert.assertTrue(transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
//        System.out.println("Expected result: " + transcyPage.getSwitcherDisclosureStyleCurrencyStatusEnable());
//        Thread.sleep(5000);
//
//        log.info("Step 22: Verify Switcher Disclosure Style - Currency Content Checkbox");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleCurrencyCheckboxContent(), ExpectedData.expectSwitcherDisclosureStyleCurrencyCheckboxContentDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleCurrencyCheckboxContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleCurrencyCheckboxContentDefault);
////        Thread.sleep(5000);
//
//        log.info("Step 23: Verify Switcher Disclosure Style - Title Font Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleTitleFontTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 24: Verify Switcher Disclosure Style - Title Font Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontValue(), ExpectedData.expectSwitcherDisclosureStyleTitleFontValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 25: Verify Switcher Disclosure Style - Title Font Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontSetting(), ExpectedData.expectSwitcherDisclosureStyleTitleFontSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 26: Verify Switcher Disclosure Style - Title Font Note");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleTitleFontNote(), ExpectedData.expectSwitcherDisclosureStyleTitleFontNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleTitleFontNote());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleTitleFontNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 27: Verify Switcher Disclosure Style - Search Box Text Font Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 28: Verify Switcher Disclosure Style - Search Box Text Font Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontValue(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 29: Verify Switcher Disclosure Style - Search Box Text Font Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontSetting(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 30: Verify Switcher Disclosure Style - Search Box Text Font Note");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontNote(), ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSearchBoxTextFontNote());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSearchBoxTextFontNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 31: Verify Switcher Disclosure Style - Option Font Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleOptionFontTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 32: Verify Switcher Disclosure Style - Option Font Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontValue(), ExpectedData.expectSwitcherDisclosureStyleOptionFontValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 33: Verify Switcher Disclosure Style - Option Font Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontSetting(), ExpectedData.expectSwitcherDisclosureStyleOptionFontSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 34: Verify Switcher Disclosure Style - Option Font Note");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleOptionFontNote(), ExpectedData.expectSwitcherDisclosureStyleOptionFontNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleOptionFontNote());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleOptionFontNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 35: Verify Switcher Disclosure Style - Selected Option Font Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 36: Verify Switcher Disclosure Style - Selected Option Font Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontValue(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 37: Verify Switcher Disclosure Style - Selected Option Font Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontSetting(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 38: Verify Switcher Disclosure Style - Selected Option Font Note");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleSelectedOptionFontNote(), ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleSelectedOptionFontNote());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleSelectedOptionFontNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 39: Verify Switcher Disclosure Style - Flag Style Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleTitleContent(), ExpectedData.expectSwitcherDisclosureStyleFlagStyleTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleFlagStyleTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 40: Verify Switcher Disclosure Style - Flag Style Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleSetting(), ExpectedData.expectSwitcherDisclosureStyleFlagStyleSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleFlagStyleSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 41: Verify Switcher Disclosure Style - Flag Style Style");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleFlagStyleStyle(), ExpectedData.expectSwitcherDisclosureStyleFlagStyleStyleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleFlagStyleStyle());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleFlagStyleStyleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 42: Verify Switcher Disclosure Style - Button Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 43: Verify Switcher Disclosure Style - Button - Width Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonWidthTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonWidthTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 44: Verify Switcher Disclosure Style - Button - Width Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonWidthSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonWidthSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 45: Verify Switcher Disclosure Style - Button - Width Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonWidthValue(), ExpectedData.expectSwitcherDisclosureStyleButtonWidthValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonWidthValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonWidthValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 46: Verify Switcher Disclosure Style - Button - Height Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonHeightTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonHeightTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 47: Verify Switcher Disclosure Style - Button - Height Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonHeightSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonHeightSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 48: Verify Switcher Disclosure Style - Button - Height Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonHeightValue(), ExpectedData.expectSwitcherDisclosureStyleButtonHeightValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonHeightValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonHeightValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 49: Verify Switcher Disclosure Style - Button - Shape Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonShapeTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonShapeTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonShapeTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonShapeTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 50: Verify Switcher Disclosure Style - Button - Shape Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonShapeSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonShapeSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonShapeSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonShapeSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 51: Verify Switcher Disclosure Style - Button - Font Title");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontTitleContent(), ExpectedData.expectSwitcherDisclosureStyleButtonFontTitleDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontTitleContent());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontTitleDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 52: Verify Switcher Disclosure Style - Button - Font Value");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontValue(), ExpectedData.expectSwitcherDisclosureStyleButtonFontValueDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontValue());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontValueDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 53: Verify Switcher Disclosure Style - Button - Font Setting");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontSetting(), ExpectedData.expectSwitcherDisclosureStyleButtonFontSettingDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontSetting());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontSettingDefault);
//        Thread.sleep(5000);
//
//        log.info("Step 54: Verify Switcher Disclosure Style - Button - Font Note");
//        Assert.assertEquals(transcyPage.getSwitcherDisclosureStyleButtonFontNote(), ExpectedData.expectSwitcherDisclosureStyleButtonFontNoteDefault);
//        System.out.println("Actual result: " + transcyPage.getSwitcherDisclosureStyleButtonFontNote());
//        System.out.println("Expected result: " + ExpectedData.expectSwitcherDisclosureStyleButtonFontNoteDefault);
//        Thread.sleep(5000);
//
//        log.info("=== Collapse Switcher Disclosure Style Tab ===");
//        transcyPage.clickToSwitcherDisclosureStyleTab();

        log.info("=== Collapse Position Tab ===");
        transcyPage.clickToPositionTab();

        log.info("=== Expand Switcher Color Schema Tab ===");
        transcyPage.clickToColorSchemaTab();

        log.info("=== Verify Setting Default Switcher Color Schema Tab ===");

        log.info("Step 01: Verify Color Schema Title");
        Assert.assertEquals(transcyPage.getColorSchemaTitleContent(), ExpectedData.expectColorSchemaTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaTitleDefault);
        Thread.sleep(5000);

        log.info("Step 02: Verify Color Schema - Switcher Color Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorTitleContent(), ExpectedData.expectColorSchemaSwitcherColorTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorTitleDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Color - Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherColorBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 04: Verify Color Schema - Switcher Color - Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherColorBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Color - Border Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorBorderTitleContent(), ExpectedData.expectColorSchemaSwitcherColorBorderTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorBorderTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorBorderTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Color - Border Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorBorderValueColor(), ExpectedData.expectColorSchemaSwitcherColorBorderSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorBorderValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorBorderSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Color - Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorTextTitleContent(), ExpectedData.expectColorSchemaSwitcherColorTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Color - Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorTextValueColor(), ExpectedData.expectColorSchemaSwitcherColorTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Color - Arrow Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorArrowTitleContent(), ExpectedData.expectColorSchemaSwitcherColorArrowTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorArrowTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorArrowTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Color - Arrow Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherColorArrowValueColor(), ExpectedData.expectColorSchemaSwitcherColorArrowSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherColorArrowValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherColorArrowSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Hover State Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateTitleContent(), ExpectedData.expectColorSchemaSwitcherHoverStateTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateTitleDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Hover State - Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherHoverStateBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 04: Verify Color Schema - Switcher Hover State - Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherHoverStateBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Hover State - Border Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateBorderTitleContent(), ExpectedData.expectColorSchemaSwitcherHoverStateBorderTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateBorderTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateBorderTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Hover State - Border Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateBorderValueColor(), ExpectedData.expectColorSchemaSwitcherHoverStateBorderSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateBorderValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateBorderSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Hover State - Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateTextTitleContent(), ExpectedData.expectColorSchemaSwitcherHoverStateTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Hover State - Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateTextValueColor(), ExpectedData.expectColorSchemaSwitcherHoverStateTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Hover State - Arrow Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateArrowTitleContent(), ExpectedData.expectColorSchemaSwitcherHoverStateArrowTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateArrowTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateArrowTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Hover State - Arrow Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherHoverStateArrowValueColor(), ExpectedData.expectColorSchemaSwitcherHoverStateArrowSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherHoverStateArrowValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherHoverStateArrowSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Active State Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateTitleContent(), ExpectedData.expectColorSchemaSwitcherActiveStateTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateTitleDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Active State - Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherActiveStateBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 04: Verify Color Schema - Switcher Active State - Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherActiveStateBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Active State - Border Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateBorderTitleContent(), ExpectedData.expectColorSchemaSwitcherActiveStateBorderTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateBorderTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateBorderTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Active State - Border Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateBorderValueColor(), ExpectedData.expectColorSchemaSwitcherActiveStateBorderSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateBorderValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateBorderSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Active State - Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateTextTitleContent(), ExpectedData.expectColorSchemaSwitcherActiveStateTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Active State - Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateTextValueColor(), ExpectedData.expectColorSchemaSwitcherActiveStateTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Active State - Arrow Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateArrowTitleContent(), ExpectedData.expectColorSchemaSwitcherActiveStateArrowTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateArrowTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateArrowTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Active State - Arrow Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherActiveStateArrowValueColor(), ExpectedData.expectColorSchemaSwitcherActiveStateArrowSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherActiveStateArrowValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherActiveStateArrowSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorTitleDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 04: Verify Color Schema - Switcher Disclosure Color - Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Border Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorBorderTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorBorderTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorBorderTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorBorderTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Border Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorBorderValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorBorderSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorBorderValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorBorderSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Title color Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorTitleColorTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorTitleColorTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorTitleColorTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorTitleColorTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Title color Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorTitleColorValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorTitleColorSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorTitleColorValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorTitleColorSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Select Box Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Select Box Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Select Box Border Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBorderTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBorderTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBorderTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBorderTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Select Box Border Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBorderValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBorderSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBorderValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxBorderSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Select Box Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Select Box Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Select Box Arrow Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxArrowTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxArrowTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxArrowTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxArrowTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Select Box Arrow Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxArrowValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxArrowTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxArrowValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectBoxArrowTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Option Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorOptionBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorOptionBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Option Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorOptionBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionBackgroundTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorOptionBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionBackgroundTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Option Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorOptionTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorOptionTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Option Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorOptionTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionTextTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorOptionTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorOptionTextTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Selected Option Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Selected Option Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Selected Option Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Selected Option Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectedOptionTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSelectedOptionTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Search Box Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Search Box Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Search Box Icon Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxIconTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxIconTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxIconTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxIconTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Search Box Icon Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxIconValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxIconSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxIconValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxIconSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Search Box Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Search Box Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSearchBoxTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorSearchBoxTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Button Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorButtonBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorButtonBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Button Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorButtonBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorButtonBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Color - Button Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorButtonTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorButtonTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Color - Button Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorButtonTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorButtonTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureColorButtonTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateTitleDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Select Box Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureColorSelectBoxBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Select Box Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Select Box Border Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Select Box Border Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxBorderSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Select Box Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Select Box Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Select Box Arrow Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Select Box Arrow Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateSelectBoxArrowSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Option Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Option Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Option Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Option Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateOptionTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionTextSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Button Background Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonBackgroundTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateButtonBackgroundTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonBackgroundTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateButtonBackgroundTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Button Background Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonBackgroundValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionButtonBackgroundSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonBackgroundValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionButtonBackgroundSettingDefault);
        Thread.sleep(5000);

        log.info("Step 03: Verify Color Schema - Switcher Disclosure Hover State - Button Text Title");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonTextTitleContent(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateButtonTextTitleDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonTextTitleContent());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateButtonTextTitleDefault);
        Thread.sleep(5000);

        log.info("Step 59: Verify Color Schema - Switcher Disclosure Hover State - Button Text Value");
        Assert.assertEquals(transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonTextValueColor(), ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionButtonTextSettingDefault);
        System.out.println("Actual result: " + transcyPage.getColorSchemaSwitcherDisclosureHoverStateButtonTextValueColor());
        System.out.println("Expected result: " + ExpectedData.expectColorSchemaSwitcherDisclosureHoverStateOptionButtonTextSettingDefault);
        Thread.sleep(5000);



    }
    @AfterClass
    public void quitBrowser() {
        closeBrowserAndDriver(driver);
    }

}
