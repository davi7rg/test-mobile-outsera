package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CalculadoraPage {
    private AppiumDriver driver;

    public CalculadoraPage(AppiumDriver driver) {
        this.driver = driver;
    }

    // Locators for calculator buttons
    private By getNumberButton(String number) {
        return By.id("com.android.calculator2:id/digit_" + number);
    }

    private By addButton = By.id("com.android.calculator2:id/op_add");
    private By subtractButton = By.id("com.android.calculator2:id/op_sub");
    private By multiplyButton = By.id("com.android.calculator2:id/op_mul");
    private By divideButton = By.id("com.android.calculator2:id/op_div");
    private By equalsButton = By.id("com.android.calculator2:id/eq");
    private By resultField = By.id("com.android.calculator2:id/result");

    // Methods
    public void enterNumber(String number) {
        for (char digit : number.toCharArray()) {
            driver.findElement(getNumberButton(String.valueOf(digit))).click();
        }
    }

    public void pressAdd() {
        driver.findElement(addButton).click();
    }

    public void pressSubtract() {
        driver.findElement(subtractButton).click();
    }

    public void pressMultiply() {
        driver.findElement(multiplyButton).click();
    }

    public void pressDivide() {
        driver.findElement(divideButton).click();
    }

    public void pressEquals() {
        driver.findElement(equalsButton).click();
    }

    public String getResult() {
        return driver.findElement(resultField).getText();
    }
}
