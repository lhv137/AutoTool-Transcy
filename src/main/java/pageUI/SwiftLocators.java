package pageUI;

public class SwiftLocators {

    //    Login Partner
    public static final String LOGIN_SHOPIFY_PARTNER_BUTTON = "//a[@href='https://partners.shopify.com/organizations']";
    public static final String ENTER_EMAIL_PARTNER_ACCOUNT = "//input[@type='email']";
    public static final String CONTINUE_WITH_EMAIL_BUTTON = "//button[@type='submit']";
    public static final String ENTER_PASSWORD_PARTNER_ACCOUNT = "//*[@id='account_password']";
    public static final String LOGIN_PARTNER_BUTTON = "//button[@type='submit']";
    public static final String SELECT_USE_RECOVERY_CODE = "//a[text()='Use a recovery code']";
    public static final String ENTER_RECOVERY_CODE = "//input[@class='next-input']";
    public static final String LOGIN_PARTNER_AFTER_ENTER_CODE_BUTTON = "//button[@type='submit']";

    //    SELECT PARTNER ACCOUNT
    public static final String SELECT_PARTNER_ACCOUNTS = "//span[text()='PerfectApps']/ancestor::a";

    //    CREATE STORE TEST
    public static final String SELECT_MENU_STORES_BUTTON = "//span[text()='Stores']/ancestor::a";
    public static final String SECLECT_ADD_STORE_BUTTON = "//*[@id='AppFrameMain']/div/div/div[1]/div/div/div[2]/div[2]";
    public static final String DROPDOWN_CLICK_DEVELOPMENT_STORE = "//span[text()='Create development store']/ancestor::a";
    public static final String FRAME_SHOPIFY_PAGE = "//*[@id='AppFrameMain']/div/div/div[2]/div";
    //    public static final String SELECT_OPTION_STORE_TEST = "//input[@type='radio' and @value='test_store']";
    public static final String SELECT_OPTION_STORE_TEST = "//span[text()='Create a store to test and build']";
    public static final String ENTER_STORE_NAME = "//input[@type='text']";
    public static final String SELECT_START_WITH_TEST_DATA = "//p[text()='Start with test data']";
    public static final String CREATE_DEVELOPMENT_STORE_BUTTON = "//span[text()='Create development store']";
    public static final String CLICK_TO_CHOOSE_ACCOUNT = "//div[@class='user-card__name' and contains(text(),'Vĩ Lê')]";


}
