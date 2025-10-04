package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    private final By personalAccountButtonLocator = By.xpath("//a[@href='/account']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void сlickPersonalAccountButton() {
        driver.findElement(personalAccountButtonLocator).click();
    }





}
