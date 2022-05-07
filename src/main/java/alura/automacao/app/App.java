package alura.automacao.app;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            final DesiredCapabilities configuration = new DesiredCapabilities();
            final File apk = new File("/opt/workspace/automacao-campanha/src/main/resources/alura_esporte.apk");
            configuration.setCapability(MobileCapabilityType.APP, apk);
            configuration.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            configuration.setCapability(MobileCapabilityType.PLATFORM_VERSION, "30");
            configuration.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus S API 30");
            configuration.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            configuration.setPlatform(Platform.ANDROID);
            final URL urlConexao = new URL("http://localhost:4723/wd/hub");
            final AppiumDriver driver = new AppiumDriver(urlConexao, configuration);
            driver.getStatus();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
