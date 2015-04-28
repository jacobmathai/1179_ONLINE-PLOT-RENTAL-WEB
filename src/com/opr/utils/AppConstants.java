package com.opr.utils;

public interface AppConstants {

    // ================ Message Settings ================
    public static String Login_Sucess = "Sucess! Login successfull";
    public static String Login_Failed = "Login Failed! Invalid Credentials.";
    public static String REGISTERED_SUCCESSFULLY = "Registered successfully.";
    public static String REGISTRATION_FAILED = "Registration Failed.";
    // ============== DB Settings ==================
    public static String DRIVER_URL = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://localhost:3306/opr_db";
    public static String USERNAME = "root";
    public static String PASSWORD = "mysql";
    public static String TYPE_USER = "user";
    public static String TYPE_ADMIN = "admin";
    public static String DATE_FORMAT = "dd-MM-yyyy";
    public static String DONE = "DONE";
    public static String PENDING = "pending";
    public static String APPROVED = "approved";
    public static String TIME_FORMAT = "hh:mm:ss";
    public static boolean DEBUG = true;
    public static String COMMON = "Common";
    public static String NO_COMMENTS = "No Comments";
    public static String UN_CHECKED = "Un_Checked";
    public static String CHECKED = "Checked";
    public static String SESSION = "session";
    public static String SUCCESS = "success";
    public static String FAILED = "fail";
    public static String TRUE = "true";
    public static String FALSE = "false";
    public static String QUALITY = "Good";
    public static String IS_ON = "on";
    public static String IS_OFF = "";
    public static String ANY = "Any";
    public static String FOR_SALE = "For_Sale";
    public static String FOR_RENT = "For_Rent";
    public static int MIN_PRICE = 0;
    public static String BOOKED = "booked";
    public static String ALERT = "alert";
    public static String ALL = "All";
    public static String BUILDING = "building";
    public static String PLOT = "plot";
    public static String USER_EXIST = "exist";
    // ======== File Upload =============
    int BYTES_DOWNLOAD = 1024;
    String NAVIGATE_FOLDER = "NAVIGATE";
    String REAL_FOLDER = "REAL";
    String SEARCH_FOLDER = "SEARCH";
    String VIDEO_FOLDER = "VIDEO";
    String TEMP_FOLDER = "TEMP";
    String PHOTO_ONE = "photo_01_";
    String PHOTO_TWO = "photo_02_";
    String PHOTO_THREE = "photo_03_";
    String PHOTO_FOUR = "photo_04_";
    // ==========Image Size ==============
    int REAL_IMG_HEIGHT = 670;
    int REAL_IMG_WIDTH = 1600;
    int NAVIGATE_IMG_HEIGHT = 112;
    int NAVIGATE_IMG_WIDTH = 113;
    int SEARCH_IMG_HEIGHT = 507;
    int SEARCH_IMG_WIDTH = 768;
    // =================MAIL & MSG================
    public static String SMSURL = "";
    public static String EMS_MAIL_ID = "javavfs10@gmail.com";
    public String CONNECT_MAIL = "javavfs13@gmail.com";
    public String CONNECT_PASSWORD = "netbeans";
    public String CONTACT_MAIL = "opr.infos@gmail.com";
    public String CONTACT_PASS = "thinkforce";
    // =================Ajax=================
    String DEFAULT_SEARCH = "default";
    String GCM_KEY = "AIzaSyBcJj9lOY1dmQ8MOmC7v6UJSgNK_QIiKO0";
}
