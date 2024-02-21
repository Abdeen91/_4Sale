package core;

import helper.PropertiesLoader;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Config {

    private final String platform;
    private boolean isAndroid;
    private boolean isIos;


    public Config() {
        Logger.getLogger("org.openqa.core.remote").setLevel(Level.OFF);
        platform = System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM"));
        SelectPlatform(platform);
    }


    private void SelectPlatform(String platform) {
        isAndroid = platform.equalsIgnoreCase("Android");
        isIos = platform.equalsIgnoreCase("iOS");
    }


    public boolean isAndroid() {
        return isAndroid;
    }

    public boolean isIos() {
        return isIos;
    }
}
