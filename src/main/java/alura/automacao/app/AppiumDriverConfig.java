package alura.automacao.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppiumDriverConfig {

    private final AppiumDriver driver;

    private static AppiumDriverConfig instance;

    private AppiumDriverConfig() throws RuntimeException {
        try {
            final DesiredCapabilities configuration = new DesiredCapabilities();
            final File apk = new File("/opt/workspace/automacao-alura/src/main/resources/alura_esporte.apk");
            configuration.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
            configuration.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            configuration.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            final URL urlConexao = new URL("http://localhost:4723/wd/hub");
            this.driver = new AppiumDriver(urlConexao, configuration);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public static AppiumDriverConfig getInstance() {
        if(instance == null){
            instance = new AppiumDriverConfig();
        }
        return instance;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public boolean hasElement(final By byId) {
        try {
            driver.findElement(byId);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
