package com.darkprograms.gaio.util;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/9/12
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Constants {

    public static String GAIO_VERSION = "1.50";

    public static String RESOURCES_DIR_NAME = "resources";
    public static String GAIO_DIR_NAME = "gaio";
    public static String[] RESOURCES_ADB_ARRAY = {"adb", "adb.exe", "AdbWinApi.dll", "AdbWinUsbApi.dll"};

    public static String RESOURCES_ROOT_NAME = RESOURCES_DIR_NAME + "/root";
    public static String RESOURCES_ROOT_STUFF = "stuff";
    public static String[] RESOURCES_ROOT_RUN_ME = {"RunMe.sh", "RunMe.bat"};
    public static String ROOT_DIR_NAME = "root";
    public static String[] RESOURCES_ROOT_ARRAY = {"adb", "adb.exe", "AdbWinApi.dll", "AdbWinUsbApi.dll", "busybox", "busybox.exe",
            "checklt30.bat", "fakebackup.ab", "ric", "rootkittablet.tar.gz", "RootMe.tar", "script1.sh", "su", "Superuser.apk", "tabletS.ab", "Term.apk",};

    public static String RESOURCES_UNLOCK_NAME = RESOURCES_DIR_NAME + "/unlock";
    public static String UNLOCK_DIR_NAME = "unlock";
    public static String[] RESOURCES_UNLOCK_ARRAY = {"adb", "adb.exe", "AdbWinApi.dll", "AdbWinUsbApi.dll", "busybox",
            "fastboot.exe", "freegee-sprint.tar", "freegee.bat", "freegee.sh"};

    public static String BUILD_PROP_COMMMAND = "cat /system/build.prop";

    public static String SUPPORTED_DEVICE = "geehrc4g_spr_us";
    public static String RO_DEVICE_NAME = "ro.product.name";

    public static String RO_DISPLAY_ID = "ro.build.display.id";

    public static String RO_VERSION_INC = "ro.build.version.incremental";

    public static String LG_DRIVER_URL = "http://www.lg.com/us/support-mobile/lg-LS970";

    public static String[] UNROOTABLE_VERSIONS = {"ZV9"};

    public static String ROOT_SUPPORTED = "<html>This software version is <font color='green'>supported and can be rooted</font></html>";
    public static String ROOT_UNSUPPORTED = "<html>This software version is <font color='red'>not supported and can not be rooted</font></html>";


    public static String GAIO_URL_BASE = "http://gaio.dark-hosting.net/gaio/";
    public static String GAIO_URL = "http://gaio.dark-hosting.net/";

    public static String GAIO_RECOVERY_JSON = "recovery.json";
    public static String GAIO_JSON = "gaio.json";
    public static String GAIO_LG_DRIVER_JSON = "lgdriver.json";

    public static String BOOT_IMG = "boot.img";

    public static String LG_DRIVER_PATH_X64 = "C:/Program Files (x86)/LG Electronics/LG United Mobile Driver";
    public static String LG_DRIVER_PATH_X32 = "C:/Program Files/LG Electronics/LG United Mobile Driver";

    public static String UNLOCKED_ABOOT_MD5 = "bc54a6a730658550713a0779b30bf6b7";

}
