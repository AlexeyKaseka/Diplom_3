package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {


    private final WebDriver driver;
    private final By forgotPasswordEnterButtonLocator = By.cssSelector(".Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForgotPasswordEnterButtonLocator() {

        driver.findElement(forgotPasswordEnterButtonLocator).click();
    }
}
