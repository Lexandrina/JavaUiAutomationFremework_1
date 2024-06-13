package online.tekwillacademy.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = "Chrome";
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                System.out.println("The Chrome Driver was initiated!");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                System.out.println("The FIrefox Driver was initiated!");
                break;

            case "Safari":
                driver = new SafariDriver();
                System.out.println("The FIrefox Driver was initiated!");
                break;
            case "EDGE":
                driver = new EdgeDriver();
                System.out.println();
                break;
            default:
                System.out.println("The webDriverType " + webDriverType + " is not detected");
        }
        driver.manage().window().maximize();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }

    public void quiteTheDriver(){
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("The Driver was reset to null, same as instance Object");
    }
}
