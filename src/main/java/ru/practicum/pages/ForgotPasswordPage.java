package ru.practicum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {


    private final WebDriver driver;
    private final By forgotPasswordEnterButtonLocator = By.cssSelector(".Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Поиск и нажатие на кнопку 'Войти' на страницы восстановления пароля")
    public void clickForgotPasswordEnterButtonLocator() {

        driver.findElement(forgotPasswordEnterButtonLocator).click();
    }
}
