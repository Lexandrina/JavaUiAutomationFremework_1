package online.tekwillacademy;

import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.managers.ScrollManager;
import org.openqa.selenium.*;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        //Putem declara Driverul in felul urmator
//        DriverManager manager = DriverManager.getInstance();
//        WebDriver driver = manager.getDriver();

        //Declararea driverului in mod optimizat
        WebDriver driver = DriverManager.getInstance().getDriver();
        String currentTabName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://tekwillacademy-opencart.online/");
        System.out.println("The current URL is: " + driver.getCurrentUrl());
        System.out.println("The current title is: " + driver.getTitle());

        WebElement userDropDownIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
        userDropDownIcon.click();

        WebElement registerOption = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Register']"));
        registerOption.click();

        System.out.println("The current URL is: " + driver.getCurrentUrl());
        System.out.println("The current title is: " + driver.getTitle());

        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys("Gabriel");

        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys("Test");

        WebElement emailInput = driver.findElement(By.id("input-email"));
        String emailData = DataGeneratorManager.getRandomEmail();
        emailInput.sendKeys(emailData);
        System.out.println("Email: " + emailData);

        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys("Password123!");

        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
      //  ScrollManager.scrollToElement(privacyToggle);
        Thread.sleep(3000);
        privacyToggle.click();

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        Thread.sleep(500);

        System.out.println("The current URL is: " + driver.getCurrentUrl());
        System.out.println("The current title is: " + driver.getTitle());

        driver.close();

        driver.switchTo().window(currentTabName);
        driver.get("https://tekwill.md/tekwill-academy/");
//        Thread.sleep(10000);
        driver.quit();

        System.out.println("The test is finished the driver is closed!");
    }
}