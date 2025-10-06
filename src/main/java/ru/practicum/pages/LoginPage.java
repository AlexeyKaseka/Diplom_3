package ru.practicum.pages;

import io.qameta.allure.Step;
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

    @Step("Поиск и нажатие на кнопку 'Зарегистрироваться' ведущую на страницу регистрации")
    public void clickRegistrationLinkButton() {

        driver.findElement(registrationLinkButtonLocator).click();
    }

    @Step("Ожидание стрнаницы логина")
    public void waitForLoginPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(LOGIN_PAGE_URL));
    }

    @Step("Проверка загрузки страницы логина")
    public void verifyLoginPageUrl() {
        assertTrue("URL должен содержать /login", driver.getCurrentUrl().contains(LOGIN_PAGE_PATH));
    }

    @Step("Поиск полей ввода")
    public List<WebElement> getInputFields() {
        return driver.findElements(fieldsEmailAndPasswordLocator);

    }

    @Step("Заполнение поля 'Email'")
    public void enterEmail(String email) {
        List<WebElement> fields = getInputFields();
        fields.get(0).clear();
        fields.get(0).sendKeys(email);
    }

    @Step("Заполнение поля 'Password'")
    public void enterPassword(String password) {
        List<WebElement> fields = getInputFields();
        fields.get(1).clear();
        fields.get(1).sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickEnterButton() {

        driver.findElement(enterButton).click();
    }

    @Step("Поиск и нажатие на кнопку 'Восстановить пароль' ведущую на страницу восстановления пароля")
    public void clickForgotPasswordLinkLocator() {

        driver.findElement(forgotPasswordLinkLocator).click();
    }


}