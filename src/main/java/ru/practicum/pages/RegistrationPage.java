package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


import static org.junit.Assert.assertTrue;

public class RegistrationPage {

    private final WebDriver driver;
    private final By fieldsEmailAndPasswordLocator = By.cssSelector("input.input__textfield");
    private final By passwordFieldLocator = By.cssSelector("input[type='password']");
    private final By registrationButtonLocator = By.xpath("//button[contains(@class, 'button_button__33qZ0') and contains(@class, 'button_button_type_primary__1O7Bx')]");
    private final By errorMessageLocator = By.xpath("//p[contains(@class, 'input__error') and contains(text(), 'Некорректный пароль')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getInputFields() {
        return driver.findElements(fieldsEmailAndPasswordLocator);
    }

    public void enterName(String name) {
        List<WebElement> fields = getInputFields();
        fields.get(0).clear();
        fields.get(0).sendKeys(name);
    }

    public void enterEmail(String email) {
        List<WebElement> fields = getInputFields();
        fields.get(1).clear();
        fields.get(1).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordFieldLocator).clear();
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }

    public void clickRegistrationButton() {

        driver.findElement(registrationButtonLocator).click();
    }

    public void waitForLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
    }


    public void verifyLoginPageUrl() {
        assertTrue("URL должен содержать /login", driver.getCurrentUrl().contains("/login"));
    }

    public void waitForErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
    }


    public void checkErrorMessageDisplayed() {
        WebElement errorMessage = driver.findElement(errorMessageLocator);
        assertTrue("Должно отображаться сообщение об ошибке", errorMessage.isDisplayed());
    }


}
