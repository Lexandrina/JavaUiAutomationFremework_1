package online.tekwillacademy.managers;

import org.openqa.selenium.WebElement;

public class ScrollManager {
    public static void scrollToElement(WebElement webElement) {
        //This section will scroll down to the button we want to click privacyToggle
        //JavascriptException javascriptException = (JavascriptException) DriverManager.getInstance().getDriver();
       // javascriptException.executeScript("arguments[0].scrollIntoView(false);", webElement);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
