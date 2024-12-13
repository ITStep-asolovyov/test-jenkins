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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTests {
    private WebDriver getDriver() throws Exception {
        ChromeOptions options = new ChromeOptions()
                .addArguments("--no-sandbox")
                .addArguments("--disable-infobars")
                .addArguments("--disable-popup-blocking")
                .addArguments("--disable-notifications")
                .addArguments("--lang=en-US");

        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("enableVNC", true);
            put("enableVideo", true);
            put("name", "Test name");
            put("sessionTimeout", "15m");
        }});

        return new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                options
        );
    }

    @Test
    void testGoogle() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();
    }

}