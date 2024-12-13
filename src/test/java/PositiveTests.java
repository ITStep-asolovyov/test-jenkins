import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PositiveTests {

    @Test
    public void test1() {
        Configuration.remote = "http://localhost:8081/wd/hub";
open("www.google.com");    }

}