package configs;

import java.util.Random;

public class Config {

    //    PARNTER INFO
    public static final String partnerURL = "https://www.shopify.com/partners";
    public static final String emailPartner = "vilh@fireapps.vn";
    public static final String passwordPartner = "123321";
    public static final String recoveryCode = "64FF-7FA8-FC7A";
//    int number = new Random().nextInt(99999999);
    public static final String storeName = "storetesttranscy" + new Random().nextInt(99999999);

    //    ADMIN TOOL INFO
    public static final String adminToolUATURL = "https://transcy-stag-admin.onecommerce.app";
    public static final String userNameAdminTool = "admin";
    public static final String passWordAdminTool = "ShopifyAppsGreat2022";

    //    INSTALL TRANSCY UAT V4 APP
    public static final String appName = "Transcy UAT V4";

}
