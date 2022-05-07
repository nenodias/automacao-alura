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
            final AppiumDriverConfig config = new AppiumDriverConfig();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
