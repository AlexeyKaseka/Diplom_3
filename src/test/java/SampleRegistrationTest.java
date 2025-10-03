
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SampleRegistrationTest {

    @Test
    public void registrationTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Открываем главную страницу
        driver.get("https://stellarburgers.nomoreparties.site/");

        // Жмем кнопку личный кабинет
        By cabinet = By.xpath("//a[@href='/account']");
        driver.findElement(cabinet).click();

        // Кликаем на ссылку регистрации
        By register = By.cssSelector("a.Auth_link__1fOlj");
        driver.findElement(register).click();


        // Ищем набор полей ввода
        List<WebElement> fields = driver.findElements(By.cssSelector("input.input__textfield"));

        // Ищем Поле "Имя" - первое и вводим
        WebElement nameField = fields.get(0);
        nameField.sendKeys(RandomStringUtils.randomAlphabetic(8));

        // Ищем поле "Email" - второе и вводим
        WebElement emailField = fields.get(1);
        emailField.sendKeys(RandomStringUtils.randomAlphabetic(8) + "@test.ru");


        // Ищем поле пароль и вводим
        By password = By.cssSelector("input[type='password']");
        driver.findElement(password).sendKeys(RandomStringUtils.randomAlphabetic(8));

        By registredButton = By.xpath("//button[contains(@class, 'button_button__33qZ0') and contains(@class, 'button_button_type_primary__1O7Bx')]");
        driver.findElement(registredButton).click();


        // Ждем появления окна с регистрацией
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://stellarburgers.nomoreparties.site/login"));
        assertTrue(driver.getCurrentUrl().contains("/login"));

    }


    @Test
    public void faildRegistrationTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Открываем главную страницу
        driver.get("https://stellarburgers.nomoreparties.site/");

        // Жмем кнопку личный кабинет
        By cabinet = By.xpath("//a[@href='/account']");
        driver.findElement(cabinet).click();

        // Кликаем на ссылку регистрации
        By register = By.cssSelector("a.Auth_link__1fOlj");
        driver.findElement(register).click();


        // Ищем набор полей ввода
        List<WebElement> fields = driver.findElements(By.cssSelector("input.input__textfield"));

        // Ищем Поле "Имя" - первое и вводим
        WebElement nameField = fields.get(0);
        nameField.sendKeys(RandomStringUtils.randomAlphabetic(8));

        // Ищем поле "Email" - второе и вводим
        WebElement emailField = fields.get(1);
        emailField.sendKeys(RandomStringUtils.randomAlphabetic(8));


        // Ищем поле пароль и вводим
        By password = By.cssSelector("input[type='password']");
        driver.findElement(password).sendKeys("12345");

        By registredButton = By.xpath("//button[contains(@class, 'button_button__33qZ0') and contains(@class, 'button_button_type_primary__1O7Bx')]");
        driver.findElement(registredButton).click();


        // ASSERT: Проверяем что появилось сообщение об ошибке
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class, 'input__error') and contains(text(), 'Некорректный пароль')]")
        ));

        // Проверяем что ошибка отображается
        assertTrue("Должно отображаться сообщение об ошибке", errorMessage.isDisplayed());


    }

}

