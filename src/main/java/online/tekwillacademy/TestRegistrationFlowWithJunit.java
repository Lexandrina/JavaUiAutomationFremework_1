package online.tekwillacademy;

import online.tekwillacademy.managers.DataGeneratorManager;
import online.tekwillacademy.managers.DriverManager;
import online.tekwillacademy.pageobjects.AccountPage;
import online.tekwillacademy.pageobjects.HomePage;
import online.tekwillacademy.pageobjects.RegisterPage;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import javax.swing.*;

public class TestRegistrationFlowWithJunit {
    @Test
    @Disabled
    @DisplayName("Successful registration of a user by valid credentials")
    public void registerWithValidData() {

        WebDriver driver = online.tekwillacademy.managers.DriverManager.getInstance().getDriver();
        driver.get("https://tekwillacademy-opencart.online/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();

        RegisterPage registerPage = new RegisterPage(driver);

        String name = DataGeneratorManager.getRandomName();
        String email = DataGeneratorManager.getRandomEmail();
//      String password = DataGeneratorManager.getRandomPassword(10, 20);
        // System.out.println("Email: " + email + " / Password: " + password);

        registerPage.completeTheRegisterForm(name, name, email, password);
        registerPage.enablePrivacyToggle();
        registerPage.clickOnContinueButton();

        Thread.sleep(1000);

        AccountPage accountPage = new AccountPage(driver);

        Assertions.assertTrue(accountPage.isLogoutButtonDisplayed(), "The logOut Button is displayed");

        driver.quit();
    }

    @AfterEach
    public void executeScriptAfterEachTest() {
        DriverManager.getInstance();
    }
}
