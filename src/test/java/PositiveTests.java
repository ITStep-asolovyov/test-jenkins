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

    @Test
    public void test1() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "My Test");
            put("sessionTimeout", "15m");
            put("enableVNC", true);
            put("enableVideo", true);
            put("env", new ArrayList<String>() {{
                add("TZ=UTC");
            }});
            put("labels", new HashMap<String, Object>() {{
                put("manual", "true");
            }});
        }});

        WebDriver driver = new RemoteWebDriver(
                URI.create("http://localhost:4444/wd/hub").toURL(),
                options
        );

        driver.get("https://www.google.com");
        driver.quit();
}}