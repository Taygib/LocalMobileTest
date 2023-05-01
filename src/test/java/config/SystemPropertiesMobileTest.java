package config;

public class SystemPropertiesMobileTest {

    public String urlBrowserstack() {
        String baseUrl = System.getProperty("Browserstack", "http://hub.browserstack.com/wd/hub");
        return baseUrl;
    }

    public String userBrowserstack() {
        String user = System.getProperty("user", "automationautoma_lxrP0g");
        return user;
    }

    public String keyBrowserstack() {
        String key = System.getProperty("key", "6p7oVykLsdXn3zYAyhCD");
        return key;
    }

    public String deviceBrowserstack() {
        String device = System.getProperty("device", "Google Pixel 3");
        return device;
    }

    public String osVersionBrowserstack() {
        String osVersion = System.getProperty("osVersion", "9.0");
        return osVersion;
    }
}
