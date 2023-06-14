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


//  CONTENT MODAL SWITCHER

//    BUTTON
    public static final String SELECT_NEXT_BUTTON_IN_MODAL = "//span[text()='Next']";
    public static final String SELECT_EXPLORE_NOW_BUTTON_IN_MODAL = "//span[text()='Explore now']";
    public static final String SELECT_CLOSE_BUTTON_IN_MODAL = "//button[@class='modal__close-button--default']";
    public static final String SELECT_OK_DO_IT_LATER_BUTTON = "//span[text()='OK, I do it later']";
    public static final String SELECT_ACTIVE_SWITCHER_BUTTON = "//span[text()='Activate Switcher now']";
    public static final String FILTER_STORE_BUTTON = "//input[@type='text']";
    public static final String LOGIN_STORE_BUTTON = "//button[@type='submit']";
    public static final String APPS_STORE_BUTTON = "//span[text()='Apps']";
    public static final String SELECT_APPS_TRANSCY_BUTTON = "//div[@class='OAwvw' and contains(text(),'Transcy UAT V4')]";

//    FIRST MODAL
    public static final String CONTENT_TITLE_MODAL_FIRST = "//h2[@class='sc-2126ad3d-6 jxlOwl']";
    public static final String CONTENT_HEADING_MODAL_1 = "//h2[@class='Polaris-Heading' and contains(text(),'Activate Transcy Switcher')]";
    public static final String CONTENT_HEADING_MODAL_2 = "//h2[@class='Polaris-Heading' and contains(text(),'Choose or customize templates')]";
    public static final String CONTENT_HEADING_MODAL_3 = "//h2[@class='Polaris-Heading' and contains(text(),'Publish switcher & preview')]";
    public static final String CONTENT_DESCRIPTION_MODAL_1 = "//span[contains(text(),'Turn on Switcher visibility to activate Switcher o')]";
    public static final String CONTENT_DESCRIPTION_MODAL_2 = "//span[contains(.,'Explore different template options or customize switcher that fits to your store.')]";
    public static final String CONTENT_DESCRIPTION_MODAL_3 = "//span[contains(.,'Complete decorating your store with Transcy Switcher!')]";
    public static final String IMAGE_LINK_MODAL_1 = "//img[contains(@src,'1.4d4939b3.png')]";
//    src="/_next/static/media/switcher_step_1.4d4939b3.png"
    public static final String IMAGE_LINK_MODAL_2 = "//img[contains(@src,'2.c4b31408.png')]";
//    src="/_next/static/media/switcher_step_2.c4b31408.png"
    public static final String IMAGE_LINK_MODAL_3 = "//img[contains(@src,'3.6edca819.png')]";
//    src="/_next/static/media/switcher_step_3.6edca819.png"

//    SECOND MODAL
    public static final String CONTENT_TITLE_MODAL_SECOND = "//h2[@class='sc-2126ad3d-6 jxlOwl']";
    public static final String CONTENT_DESCRIPTION_MODAL_SECOND = "//*[@id='modal-root']/div/div[2]/div/div/div/div[1]";


//    DEFAULT SETTING
    public static final String HEADER_TITLE_CONTENT = "//h1[text()='Switcher settings']";
    public static final String SUB_TITLE_CONTENT = "//div[@class='page-subtitle']";
    public static final String GENERAL_TITLE_CONTENT = "(//span[@class='Polaris-Tabs__Title'][contains(.,'General')])[2]";
    public static final String GENERAL_TAB_CONTENT = "(//div[contains(@class,'Polaris-Card')])[3]";
    public static final String SWITCHER_DISPLAY_TITLE = "//h2[contains(.,'Switcher display')]";
    public static final String SWITCHER_DISPLAY_STATUS = "//button[@class='switch__slider']";
    public static final String SWITCHER_DISPLAY_LABEL = "//label[text()='Switcher visibility']";
    public static final String SWITCHER_DISPLAY_SETTING = "//button[contains(.,'Only admin')]";
    public static final String SWITCHER_DISPLAY_NOTE = "(//span[@class='Polaris-TextStyle--variationSubdued'])[4]";
    public static final String SWITCHER_DISCLOSURE = "//span[contains(.,'Switcher disclosure')]";
    public static final String SWITCHER_DISCLOSURE_SETTING = "//span[contains(text(),'Dropdown')]";
    public static final String GEOLOCATION_TITLE = "//h2[contains(.,'Geolocation')]";
    public static final String GEOLOCATION_DESCRIPTION = "//span[normalize-space()='Supports Transcy Switcher only.']";
    public static final String BANNER_UPGRADE = "//span[contains(.,'Upgrade to a higher plan to use this feature.')]";
    public static final String BUTTON_UPGRADE_IN_BANNER = "//button[contains(.,'Upgrade now')]";
    public static final String TEXT_UNLOCK_FEATURE = "//span[contains(text(),'To unlock feature, contact us to verify your store')]";
    public static final String BUTTON_UNLOCK_FEATURE = "//span[contains(text(),'Contact us')]";
    public static final String TEMPLATES_TITLE_CONTENT = "//*[@id='templates']";
    public static final String ACTIVE_TEMPLATE_TITLE = "//h2[contains(.,'Active template')]";
    public static final String DEFAULT_TEMPLATE_CONTENT = "//span[contains(text(),'Default')]";
    public static final String STATUS_TEMPLATE_NOTE = "//span[normalize-space()='You are using this template.']";
    public static final String STATUS_TEMPLATE_BUTTON = "//span[contains(text(),'Customize')]";
    public static final String TRANSCY_TEMPLATES_TITLE = "//h2[contains(text(),'Transcy’s templates')]";
    public static final String MORE_ITEMS_SETTING_TITLE = "//span[contains(text(),'More items')]";
    public static final String TRANSCY_TEMPLATE_DEFAULT = "//h2[normalize-space()='Posh']";
    public static final String TRANSCY_BUTTON_TEMPLATE_DEFAULT = "//span[contains(text(),'Apply')]";
    public static final String CUSTOMIZE_TITLE_CONTENT = "//*[@id='customization']";
    public static final String POSITIONS_TITLE_CONTENT = "//span[@class='Polaris-Button__Text'][contains(.,'Positions')]";
    public static final String PREFERENCE_TITLE_CONTENT = "//span[contains(.,'Preference')]";
    public static final String PREFERENCE_SETTING_TYPE = "//span[contains(text(),'Floating on page corner')]";
    public static final String PREFERENCE_SETTING_POSITION = "//span[contains(text(),'Top-right')]";
    public static final String OFFSET_TITLE_CONTENT = "//span[contains(text(),'Offset')]";
    public static final String OFFSET_SETTING_TOP = "(//input[contains(@class,'Input--suffixed')])[1]";
    public static final String OFFSET_SETTING_RIGHT = "(//input[contains(@class,'Input--suffixed')])[2]";
    public static final String SWITCHER_STYLE_CONTENT_TITLE = "//span[contains(text(),'Switcher style')]";
    public static final String SWITCHER_STYLE_CONTENT_WIDTH = "//span[normalize-space()='Width']";
    public static final String SWITCHER_STYLE_WIDTH_SETTING = "//span[contains(text(),'Auto')]";
    public static final String SWITCHER_STYLE_WIDTH_VALUE = "(//input[@autocomplete='off'])[1]";
    public static final String SWITCHER_STYLE_BORDER_CONTENT_TITLE = "//span[normalize-space()='Border']";
    public static final String SWITCHER_STYLE_BORDER_SETTING = "//span[@class='Polaris-Button__Text'][normalize-space()='Rounded']";
    public static final String SWITCHER_STYLE_BORDER_STYLE = "//span[contains(text(),'Thin')]";
    public static final String SWITCHER_STYLE_EFFECT_CONTENT_TITLE = "//span[normalize-space()='Effect']";
    public static final String SWITCHER_STYLE_EFFECT_SETTING = "(//span[contains(.,'No shadow')])[2]";
    public static final String SWITCHER_STYLE_HOVER_EFFECT_CONTENT_TITLE = "//span[normalize-space()='Hover and active effect']";
    public static final String SWITCHER_STYLE_HOVER_EFFECT_SETTING = "(//span[contains(.,'No shadow')])[4]";
    public static final String SWITCHER_STYLE_EFFECT_NOTE = "//span[contains(text(),'Add shadow effect to make the Switcher more lively')]";
    public static final String SWITCHER_STYLE_LAYOUT_CONTENT_TITLE = "//span[normalize-space()='Layout']";
    public static final String SWITCHER_STYLE_LAYOUT_SETTING = "//span[contains(text(),'Arrow and label')]";
    public static final String SWITCHER_STYLE_ARROW_SEGMENT_CONTENT_TITLE = "//span[normalize-space()='Arrow segment']";
    public static final String SWITCHER_STYLE_ARROW_SEGMENT_SETTING = "//span[contains(text(),'Chevron down icon')]";
    public static final String SWITCHER_STYLE_ARROW_SEGMENT_LAYOUT = "(//span[@class='Polaris-Button__Text'][contains(.,'Regular')])[1]";
    public static final String SWITCHER_STYLE_LABEL_SEGMENT_CONTENT_TITLE = "//span[normalize-space()='Label segment']";
    public static final String SWITCHER_STYLE_LABEL_SEGMENT_SETTING = "//span[contains(text(),'Language and Currency')]";
    public static final String SWITCHER_STYLE_LABEL_SEGMENT_NOTE = "//span[contains(text(),'Don’t want to convert price? Show only language.')]";
    public static final String SWITCHER_STYLE_LANGUAGE_CONTENT_TITLE = "//span[normalize-space()='Language']";
    public static final String SWITCHER_STYLE_LANGUAGE_CONTENT_SETTING = "//span[contains(text(),'English name and flag')]";
    public static final String SWITCHER_STYLE_LANGUAGE_CHECKBOX = "(//input[@type='checkbox'])[1]";
    public static final String SWITCHER_STYLE_LANGUAGE_CHECKBOX_CONTENT = "(//span[contains(.,'Flag goes first')])[1]";
    public static final String SWITCHER_STYLE_CURRENCY_CONTENT_TITLE = "//span[normalize-space()='Currency']";
    public static final String SWITCHER_STYLE_CURRENCY_CONTENT_SETTING = "//span[contains(text(),'Name, Symbol')]";
    public static final String SWITCHER_STYLE_CURRENCY_CHECKBOX = "(//input[@type='checkbox'])[2]";
    public static final String SWITCHER_STYLE_CURRENCY_CHECKBOX_CONTENT = "(//span[contains(.,'Flag goes first')])[2]";
    public static final String SWITCHER_STYLE_DIVIDER_FORMAT_CONTENT_TITLE = "//span[normalize-space()='Divider format']";
    public static final String SWITCHER_STYLE_DIVIDER_FORMAT_CONTENT_SETTING = "//span[contains(text(),'Language - Currency')]";
    public static final String SWITCHER_STYLE_FONT_CONTENT_TITLE = "//span[normalize-space()='Font']";
    public static final String SWITCHER_STYLE_FONT_SETTING = "(//input[contains(@type,'number')])[2]";
    public static final String SWITCHER_STYLE_FONT_LAYOUT = "(//span[contains(.,'Regular')])[4]";
    public static final String SWITCHER_STYLE_FONT_NOTE = "//span[contains(text(),'Other font properties will be inherited from your ')]";
    public static final String SWITCHER_STYLE_FLAG_STYLE_CONTENT_TITLE = "//span[normalize-space()='Flag style']";
    public static final String SWITCHER_STYLE_FLAG_STYLE_SETTING = "//span[contains(text(),'Rounded rectangle')]";
    public static final String SWITCHER_STYLE_FLAG_STYLE = "//span[contains(text(),'Small')]";











}



