package online.tekwillacademy;

import online.tekwillacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        //Putem declara Driverul in felul urmator
//        DriverManager manager = DriverManager.getInstance();
//        WebDriver driver = manager.getDriver();

        //
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getCurrentUrl();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-safari-driver/4.20.0");
        Thread.sleep(10000);
        driver.close();

        driver.switchTo().window(currentTabName);
        driver.get("https://tekwill.md/tekwill-academy/");
        Thread.sleep(10000);
        driver.quit();

        System.out.println("The test is finished the driver is closed!");
    }
}