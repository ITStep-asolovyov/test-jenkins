import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTests {

    @Test
    public void test1() throws MalformedURLException {
        System.out.println("Starting test configuration...");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", false);
            put("sessionTimeout", "5m");
        }});

        System.out.println("Connecting to Selenoid...");
        URL selenoidUrl = URI.create("http://localhost:4444/wd/hub").toURL();
        WebDriver driver = new RemoteWebDriver(selenoidUrl, capabilities);

        System.out.println("Opening website...");
        driver.get("https://www.google.com");

        System.out.println("Test completed successfully!");
        driver.quit();
    }
}