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

    @Step("Загрузка главной страницы")
    public void openMainPage() {

        driver.get(BASE_URL);
    }

    @Step("Поиск и нажатие на кнопку 'Личный кабинет'")
    public void сlickPersonalAccountButton() {

        driver.findElement(personalAccountButtonLocator).click();
    }

    @Step("Поиск и нажатие кнопки'Войти' на главной")
    public void mainPageEnterButton() {

        driver.findElement(mainPageEnterButtonLocator).click();
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitForMainPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(BASE_URL));
    }

    @Step("Проверка загрузки главной страницы")
    public void verifyMainPageUrl() {
        assertEquals(BASE_URL, driver.getCurrentUrl());
    }

    public String getActiveSectionText() {
        return driver.findElement(activeSectionLocator).getText();
    }

    @Step("Проверка активности раздела 'Булки'")
    public boolean isBunsSectionActive() {
        return getActiveSectionText().contains("Булки");
    }

    @Step("Ожидание и нажатие на раздел 'Соус'")
    public void clickSaucesSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(saucesSectionLocator)).click();
        wait.until(driver -> isSaucesSectionActive());
    }

    @Step("Проверка активности раздела 'Соусы'")
    public boolean isSaucesSectionActive() {
        return getActiveSectionText().contains("Соусы");
    }

    @Step("Ожидание и нажатие на раздел 'Начинки'")
    public void clickFillingSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(fillingsSectionLocator)).click();
        wait.until(driver -> isFillingsSectionActive());
    }

    @Step("Проверка активности раздела 'Начинки'")
    public boolean isFillingsSectionActive() {
        return getActiveSectionText().contains("Начинки");
    }

    @Step("Ожидание и нажатие на раздел 'Булки'")
    public void clickBunSection() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(bunsSectionLocator)).click();
        wait.until(driver -> isBunsSectionActive());
    }

}
