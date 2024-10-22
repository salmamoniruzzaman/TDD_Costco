package testComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BrowserTest {
    public WebDriver driver;
    String browserName = "chrome";

    public WebDriver initializeDriver(){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        return driver;

    }

    @BeforeMethod(alwaysRun = true)
    public void launchApplication(){
        driver = initializeDriver();
        driver.get("https://www.costco.com");
        driver.navigate().forward();
    }

    @AfterMethod(alwaysRun = true)
    public void driverClose(){
        driver.close();
    }



}
