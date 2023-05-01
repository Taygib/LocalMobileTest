package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:testing.properties"})
public interface DriverConfig extends Config {

    @Key("BrowserstackUrl")
    @DefaultValue("http://hub.browserstack.com/wd/hub")
    String urlBrowserstack();

    @Key("BrowserstackUser")
    @DefaultValue("automationautoma_lxrP0g")
    String userBrowserstack();

    @Key("BrowserstackKey")
    @DefaultValue("6p7oVykLsdXn3zYAyhCD")
    String keyBrowserstack();

    @Key("deviceName")
    @DefaultValue("Google Pixel 3")
    String deviceBrowserstack();

    @Key("platformVersion")
    @DefaultValue("9.0")
    String osVersionBrowserstack();
}