package ru.practicum.pages;

import io.qameta.allure.Step;
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
    private final By activeSectionLocator = By.cssSelector(".tab_tab__1SPyG.tab_tab_type_current__2BEPc");
    private final By bunsSectionLocator = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Булки']/parent::div");
    private final By saucesSectionLocator = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Соусы']/parent::div");
    private final By fillingsSectionLocator = By.xpath("//div[contains(@class, 'tab_tab__1SPyG')]//span[text()='Начинки']/parent::div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public void openMainPage() {

        driver.get(BASE_URL);
    }

    @Step
    public void сlickPersonalAccountButton() {

        driver.findElement(personalAccountButtonLocator).click();
    }

    @Step
    public void mainPageEnterButton() {

        driver.findElement(mainPageEnterButtonLocator).click();
    }

    @Step
    public void waitForMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(BASE_URL));
    }

    @Step
    public void verifyMainPageUrl() {
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    public String getActiveSectionText() {
        return driver.findElement(activeSectionLocator).getText();
    }

    @Step
    public boolean isBunsSectionActive() {
        return getActiveSectionText().contains("Булки");
    }

    @Step
    public void clickSaucesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saucesSectionLocator)).click();
        wait.until(driver -> isSaucesSectionActive());
    }

    @Step
    public boolean isSaucesSectionActive() {
        return getActiveSectionText().contains("Соусы");
    }

    @Step
    public void clickFillingSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fillingsSectionLocator)).click();
        wait.until(driver -> isFillingsSectionActive());
    }

    @Step
    public boolean isFillingsSectionActive() {
        return getActiveSectionText().contains("Начинки");
    }

    @Step
    public void clickBunSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(bunsSectionLocator)).click();
        wait.until(driver -> isBunsSectionActive());
    }

}
