package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static ru.practicum.util.EnvConfig.BASE_URL;

public class MainPage {

    private final WebDriver driver;

    private final By personalAccountButtonLocator = By.xpath("//a[@href='/account']");
    private final By mainPageEnterButtonLocator = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    public void openMainPage() {

        driver.get(BASE_URL);
    }


    public void сlickPersonalAccountButton() {

        driver.findElement(personalAccountButtonLocator).click();
    }

    public void mainPageEnterButton() {

        driver.findElement(mainPageEnterButtonLocator).click();
    }

    public void waitForMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(BASE_URL));
    }

    public void verifyMainPageUrl() {
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }


}
