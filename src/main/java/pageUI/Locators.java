package pageUI;

public class Locators {
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
    public static final String SELECT_PARTNER_ACCOUNTS = "//span[text()='FireApps Dev']/ancestor::a";

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


    //    LOGIN ADMIN TOOL + ADD STORE TEST
    public static final String FILL_USERNAME_ADMIN_TOOL = "//input[@type='username']";
    public static final String FILL_PASSWORD_ADMIN_TOOL = "//input[@type='password']";
    public static final String ENTER_LOGIN_ADMIN_TOOL_BUTTON = "//button[@type='submit']";
    public static final String CLICK_MANGE_TEST_STORE_BUTTON = "//span[text()='Manage Test Store']";
    public static final String FILL_STORE_TEST_ADMIN_TOOL = "//input[@name='shopify_domain']";
    public static final String CLICK_ADD_STORE_TEST_BUTTON = "//button[@type='submit']";

//    INSTALL TRANSCY UAT

    public static final String SELECT_MENU_APPS_BUTTON = "//span[text()='Apps']/ancestor::a";
    public static final String SEARCH_TRANSCY_UAT_V4_APP = "//input[@type='text']";
    public static final String SELECT_TRANSCY_UAT_V4_APP = "//a[text()='Transcy UAT V4']";
    public static final String SELECT_STORE_BUTTON_TO_INSTALL_TRANSCY_APP = "//span[text()='Select store']/ancestor::a";
    public static final String SEARCH_STORE_TO_INSTALL_TRANSCY_APP = "//input[@type='text']";
    public static final String SELECT_STORE_TO_INSTALL_TRANSCY_APP = "//*[@id='StoresListItemName']/span";
    public static final String CLICK_INSTALL_BUTTON_ON_MODAL = "//span[text()='Install']";
    public static final String CLICK_CHOOSE_ACCOUNT_TO_INSTALL = "//div[@class='user-card__name' and contains(text(),'Vi Le')]";
    public static final String CLICK_INSTALL_TRANSCY_UAT_V4_APP_BUTTON = "//span[text()='Install unlisted app']";
    public static final String IFRAME_TRANSCY_UAT_V4_APP = "//iframe[@title='Transcy UAT V4']";
    public static final String CLICK_CHOOSE_FREE_PLAN_BUTTON = "//span[text()='Get started']";
    public static final String CLICK_CHOOSE_BASIC_PLAN_BUTTON = "//span[text()='Get started']";
    public static final String SELECT_MENU_SWITCHER_BUTTON = "//span[text()='Switcher']";
    public static final String SELECT_NEXT_BUTTON_IN_MODAL = "//span[text()='Next']";
    public static final String SELECT_EXPLORE_NOW_BUTTON_IN_MODAL = "//span[text()='Explore now']";
    public static final String SELECT_CLOSE_BUTTON_IN_MODAL = "//button[@class='modal__close-button--default']";

//  CONTENT MODAL SWITCHER
    public static final String CONTENT_TITLE = "//h2[@class='sc-2126ad3d-6 jxlOwl']";
    public static final String CONTENT_TITLE_1 = "//h2[@class='Polaris-Heading' and contains(text(),'Activate Transcy Switcher')]";
    public static final String CONTENT_DESCRIPTION = "//span[@class='Polaris-TextStyle--variationSubdued' and contains(text(),'Turn on Switcher visibility to activate Switcher on the store theme and display it on the storefront.')]";




}



