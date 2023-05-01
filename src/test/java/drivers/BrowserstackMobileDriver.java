package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    private final DriverConfig config;

    public BrowserstackMobileDriver() {
        this.config = ConfigFactory.create(DriverConfig.class, System.getProperties());
    }
    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        // DesiredCapabilities capabilities = new DesiredCapabilities();

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        //mutableCapabilities.setCapability("browserstack.user", config.userBrowserstack());
        mutableCapabilities.setCapability("browserstack.user", config.userBrowserstack());
        mutableCapabilities.setCapability("browserstack.key", config.keyBrowserstack());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", config.deviceBrowserstack());
        mutableCapabilities.setCapability("os_version", config.osVersionBrowserstack());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "tests.tests.tests.browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(config.urlBrowserstack()), mutableCapabilities); //http://hub.browserstack.com/wd/hub
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}