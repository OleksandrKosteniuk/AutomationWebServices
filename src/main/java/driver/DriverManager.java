package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static WebDriver instance;
    private static final int IMPLICITLY_WAIT_TIMEOUT = 10;
    private static final int PAGE_LOAD_TIMEOUT = 20;

    private DriverManager() {
    }

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }
    
    public static WebDriver getDriver() {
        if (instance == null) {
                    instance = new ChromeDriver();
                    instance.manage().window().maximize();
                    instance.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
                    instance.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
                    return instance;
                }
        else return instance;
    }
}
