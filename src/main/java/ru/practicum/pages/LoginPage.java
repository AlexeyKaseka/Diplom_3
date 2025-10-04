package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;



    private final By registrationLinkButtonLocator = By.cssSelector("a.Auth_link__1fOlj");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegistrationLinkButton() {
        driver.findElement(registrationLinkButtonLocator).click();
    }


}
