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
    public static final String FRAME_SHOPIFY_PAGE = "//*[@id='AppFrameMain']";
    public static final String SELECT_OPTION_STORE_TEST = "//input[@value='test_store']";
    public static final String ENTER_STORE_NAME = "//input[@id='PolarisTextField3']";
    public static final String SELECT_START_WITH_TEST_DATA = "//input[@id='PolarisRadioButton8']";
    public static final String CREATE_DEVELOPEMENT_STORE_BUTTON = "//span[text()='Create development store']";

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







//    public static final String DROPDOWN_STORE_INDUSTRY = "//select[@id='QuestionnaireSelect-store_industry']";
//    public static final String DROPDOWN_DESCRIBES = "//select[@id='QuestionnaireSelect-which_best_describes_you']";
//    public static final String NEXT_BUTTON = "//button[@aria-label='Next']";
//
//    //Account
//    public static final String CREATE_ACCOUNT_TEXTBOXES = "//input[@name='account[%s]']";
//    public static final String CREATE_ACCOUNT_BUTTON = "//button[text()='Create account']";
//    public static final String TITLE_CHOOSE_AN_ACCOUNT = "//h1[text()='Choose an account']";
//    public static final String CHOOSE_ACCOUNT_SELECT = "//div[@class='main-card-section']//a[last()-1]";
//
//    //Address info
//    public static final String ADDRESS_INFO_TEXTBOXES = "//input[@name='account_setup[%s]']";
//    public static final String ENTER_MY_STORE_BUTTON = "//button[@aria-label='Enter my store']";
//    public static final String COUNTRY_DROPDOWN = "//select[@name='account_setup[country]']";
//    public static final String STATES_DROPDOWN = "//select[@id='PolarisSelect3']";
//    public static final String PROVINCE_DROPDOWN = "//select[@id='PolarisSelect2']";
//
//    //Create an account
//    public static final String TITLE_CREATE_AN_ACCOUNT = "//h1[text()='Create an account']";
//
//    //Admin Page
//    public static final String SELECT_PLAN_MSG = "//p[text()='Your trial just started']";
//    public static final String STORE_NAME_LABEL = "//div[@class='_1lIG3']//span[text()='%s']";
//    public static final String APPS_MENU = "//a[@href='/admin/apps']";
//    public static final String DELETE_ORIGINAL = "//button[@aria-label='Delete origin-app-dev']";
//    public static final String CONFIRM_DELETE_ORIGINAL = "//div[@class='_1fyLs']//span[text()='Delete']";
//    public static final String DELETE_SUCCESS_MESSAGE = "//div[@id='Banner1Content']";
//    public static final String PRODUCT_MENU = "//span[text()='Products']/ancestor::a";
//    public static final String ADD_PRODUCT_BTN = "//span[text()='Add product']/ancestor::a";
//    public static final String PRODUCT_NAME_TEXTBOX = "//input[@name='title']";
//    public static final String SAVE_PRODUCT_BTN = "//span[text()='Save']/ancestor::button";
//    public static final String PREVIEW_PRODUCT_BTN = "//span[text()='Preview']/ancestor::button";
//    public static final String VISIT_SHOPIFY_APP_STORE_BTN = "//span[text()='Visit the Shopify App Store']/ancestor::a";
//    public static final String SEARCH_APPS_TEXTBOX = "//input[@type='search' and contains(@class, 'hero')]";
//    public static final String TRANSCY_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Transcy')]";
//    public static final String MESSENT_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Messent')]";
//    public static final String ADD_APP_BTN = "//input[@value='Add app']";
//    public static final String UPGRADE_YOUR_ACCOUNT_PAGE = "//h1[text()='Upgrade your account']";
//    public static final String SEARCH_BTN = "//button[@type='submit' and contains(@class, 'hero-search')]";
//    public static final String CHOOSE_PLAN = "//h4[text()='Choose your plan']";
//    public static final String CHOOSE_PLAN_FREE = "//div[@class='pricing-plan__content-scroll sticky-item']//div[1]//div[1]//form[1]//button[1]";
//    public static final String OBERLO_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Oberlo')]";
//
//    //FREE SHOPIFY APP
//    public static final String PRODUCT_REVIEW_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Product Reviews')]";
//    public static final String KIT_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Kit')]";
//    public static final String GOOGLE_CHANNEL_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Google channel')]";
//    public static final String SHOPIFY_EMAIL_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Shopify Email')]";
//    public static final String SHOPIFY_CHAT_APP_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Shopify Chat')]";
//    public static final String GEOLOCATION_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Geolocation')]";
//
//    //FREE OTHER APP
//    public static final String TRUSTEDSITE_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='TrustedSite ‑ Trust Badges')]";
//    public static final String FREE_TRUST_BADGE_IN_APPSTORE = "//h4[text()='Free Trust Badge']/ancestor::a";
//    public static final String SHIPPO_IN_APPSTORE = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Shippo')]";
//    public static final String PUSHOWL_WEB_PUSH_NOTIFICATION = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='PushOwl Web Push Notification')]";
//    public static final String ULTIMATE_TRUST_BADGES_FREE = "//h4[text()='Ultimate Trust Badges']/ancestor::a";
//    public static final String EASY_GDPR_COOKIE_BAR = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Easy GDPR + Cookie Bar')]";
//    public static final String FACEBOOK_AND_INSTAGRAM_AUTO_POST = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[(text()='Facebook & Instagram Auto Post')]";
//    public static final String PARCELPANNEL_ORDER_TRACKING_PRO = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'ParcelPanel Order Tracking Pro')]";
//    public static final String WISHLIST_PLUS = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'Wishlist Plus')]";
//    public static final String ULTIMATE_COUNTDOWN_TIMER = "//div[@class='ui-app-card' and not (contains(@data-target-href, 'ad'))]//h4[contains(text(), 'ULTIMATE Countdown Timer')]";
//
//    //Themes
//    public static final String ONLINE_STORE_MENU = "//a[@href='/admin/themes?channel=true']";
//    public static final String EXPLORE_FREE_THEMES_BUTTON = "//div/div[1]/div/div[2]/div/div[2]";
//
//
//    //Login
//    public static final String LOGIN_BUTTON = "//a[@href='/login' and @class='marketing-nav__item marketing-nav__item--user']";
//    public static final String LOGIN_TO_ANOTHER_ACCOUNT = "//a[text()='Log in to another Shopify ID']";
//    public static final String STORE_URL_TEXTBOX = "//input[@placeholder='myshop.myshopify.com']";
//    public static final String EMAIL_PASSWORD_TEXTBOXES = "//input[@name='account[%s]']";
//    public static final String DYNAMIC_BUTTON = "//button[text()='%s']";
//
//    public static final String DELETE_APP_CONFIRMATION_TEXT = "//section[contains(text(), 'By deleting origin-app-dev')]";
//
//    //Oberlo
//    //public static final String NEW_PASSWORD ="//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/div[2]/input";
//    //public static final String CONFIRM_NEW_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/div[3]/input";
//    //public static final String SAVE_PASSWORD ="//*[@id=\"app\"]/div/div[4]/div/div/div/div[3]/button";
//    public static final String NEW_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div/div[2]/div[2]/div[1]/input";
//    public static final String CONFIRM_NEW_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div/div[2]/div[3]/div[1]/input";
//    public static final String SAVE_PASSWORD = "//*[@id=\"app\"]/div/div[4]/div/div/div/div/div[3]/button/span";
//    public static final String SEARCH_PRODUCT_MENU = "//span[contains(text(),'Find products')]";
//    //public static final String SEARCH_PRODUCT_TEXTBOX = "//*[@id=\"keywords\"]";
//    public static final String SEARCH_PRODUCT_TEXTBOX = "//input[@id='keywords']";
//    public static final String SEARCH_BUTTON = "//span[contains(text(),'Search')]";
//    public static final String CLICK_TO_ORDER_TEXT1 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[3]/div[3]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT2 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div[3]/div[3]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT3 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[3]/div/div/div[2]/div/div[1]/div[3]/div[3]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT4 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[1]/div[3]/div[3]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT5 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[5]/div/div/div[2]/div/div[1]/div[3]/div[3]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT6 = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[6]/div/div/div[2]/div/div[1]/div[3]/div[3]/div[1]";
//    public static final String ADD_PRODUCT1_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[1]/div/div/div[2]/div/div[2]/button/span[2]";
//    public static final String ADD_PRODUCT2_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/button/span[2]";
//    public static final String ADD_PRODUCT3_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[3]/div/div/div[2]/div/div[2]/button/span[2]";
//    public static final String ADD_PRODUCT4_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/button/span[2]";
//    public static final String ADD_PRODUCT5_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[5]/div/div/div[2]/div/div[2]/button/span[2]";
//    public static final String ADD_PRODUCT6_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div/div[3]/div[2]/div/div[6]/div/div/div[2]/div/div[2]/button/span[2]";
//    public static final String IMPORT_LIST = "//span[contains(text(),'Import List')]";
//    //public static final String SELECT_ALL_PRODUCT_CHECKBOX ="//label[@class='bulk-actions__item btn-basic']";
//    public static final String SELECT_ALL_PRODUCT_CHECKBOX = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div[3]/div[2]/div/label";
//    public static final String IMPORT_ALL_PRODUCT_TO_STORE = "//*[@id=\"page-content\"]/div/div[2]/div/div[2]/div[3]/div[2]/div/button[1]";
//    public static final String PUSH_PRODUCTS = "//span[contains(text(),'Yes')]";
//    public static final String BACK_TO_SHOPIFY_ADMIN = "//span[contains(text(),'Shopify Admin')]";
//
//    //product default Oberlo
//    public static final String CLICK_TO_ORDER_TEXT_DEFAULT1 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[1]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT_DEFAULT2 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT_DEFAULT3 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
//    public static final String CLICK_TO_ORDER_TEXT_DEFAULT4 = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[4]/div/div/div[2]/div/div[1]/div[3]/div[4]/div[1]";
//    public static final String ADD_PRODUCT_DEFAULT1_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[1]/div/div/div[2]/div/div[2]/button";
//    public static final String ADD_PRODUCT_DEFAULT2_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[2]/div/div/div[2]/div/div[2]/button";
//    public static final String ADD_PRODUCT_DEFAULT3_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[3]/div/div/div[2]/div/div[2]/button";
//    public static final String ADD_PRODUCT_DEFAULT4_TO_IMPORT_LIST = "//*[@id=\"page-content\"]/div/div[3]/div/div/div/div/div[2]/div[1]/div/div/ul/li[4]/div/div/div[2]/div/div[2]/button";
}

