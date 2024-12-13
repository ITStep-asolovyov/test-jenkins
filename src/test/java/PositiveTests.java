import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTests {

    @Test
    public void test1() {

        MutableCapabilities capabilities = new DesiredCapabilities();
        Configuration.remote = "http://localhost:4444/wd/hub";
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", new HashMap<String,Object>(){
            {
                put("enableVNC", true);
                put("enableVideo",true);
            }
        });

open("www.google.com");    }

}