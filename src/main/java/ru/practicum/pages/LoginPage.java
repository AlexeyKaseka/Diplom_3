package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


import static org.junit.Assert.assertTrue;
import static ru.practicum.util.EnvConfig.LOGIN_PAGE_PATH;
import static ru.practicum.util.EnvConfig.LOGIN_PAGE_URL;


public class LoginPage {

    private final WebDriver driver;
    private final By registrationLinkButtonLocator = By.cssSelector("a.Auth_link__1fOlj");
    private final By fieldsEmailAndPasswordLocator = By.cssSelector("input.input__textfield");
    private final By enterButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa");
    private final By forgotPasswordLinkLocator = By.cssSelector("a[href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistrationLinkButton() {

        driver.findElement(registrationLinkButtonLocator).click();
    }

    public void waitForLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }


    public void verifyLoginPageUrl() {
        assertTrue("URL должен содержать /login", driver.getCurrentUrl().contains(LOGIN_PAGE_PATH));
    }

    public List<WebElement> getInputFields() {
        return driver.findElements(fieldsEmailAndPasswordLocator);

    }

    public void enterEmail(String email) {
        List<WebElement> fields = getInputFields();
        fields.get(0).clear();
        fields.get(0).sendKeys(email);
    }

    public void enterPassword(String password) {
        List<WebElement> fields = getInputFields();
        fields.get(1).clear();
        fields.get(1).sendKeys(password);
    }

    public void clickEnterButton() {

        driver.findElement(enterButton).click();
    }

    public void clickForgotPasswordLinkLocator() {

        driver.findElement(forgotPasswordLinkLocator).click();
    }


}