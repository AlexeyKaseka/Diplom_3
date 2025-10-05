
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;

import org.junit.Before;
import org.junit.Test;


import ru.practicum.pages.LoginPage;
import ru.practicum.pages.MainPage;
import ru.practicum.pages.RegistrationPage;
import ru.practicum.api.UserApi;
import ru.practicum.api.User;


import static org.junit.Assert.assertNull;


public class RegistrationTest extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private User user;
    private UserApi userApi;
    private String accessToken;

    @Before
    public void setUp() {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        user = new User();
        userApi = new UserApi();
        user.withName(RandomStringUtils.randomAlphabetic(8))
                .withEmail(RandomStringUtils.randomAlphabetic(8) + "@test.ru")
                .withPassword(RandomStringUtils.randomAlphabetic(8));

    }

    @Test
    public void registrationTestWithValidData() throws InterruptedException {


        mainPage.openMainPage();
        mainPage.сlickPersonalAccountButton();
        loginPage.clickRegistrationLinkButton();
        registrationPage.enterName(user.getName());
        registrationPage.enterEmail(user.getEmail());
        registrationPage.enterPassword(user.getPassword());
        registrationPage.clickRegistrationButton();
        loginPage.waitForLoginPage();
        loginPage.verifyLoginPageUrl();

        accessToken = userApi.getAccessToken(user);
        userApi.loginUserAndCheckStatus(user);

    }


    @Test
    public void faildRegistrationWithInvalidPasswordTest() throws InterruptedException {


        mainPage.openMainPage();
        mainPage.сlickPersonalAccountButton();
        loginPage.clickRegistrationLinkButton();
        registrationPage.enterName(user.getName());
        registrationPage.enterEmail(user.getEmail());
        registrationPage.enterPassword("12345");
        registrationPage.clickRegistrationButton();
        registrationPage.waitForErrorMessage();
        registrationPage.checkErrorMessageDisplayed();


        String accessToken = userApi.getAccessToken(user);
        assertNull("Пользователь не должен быть создан при невалидном пароле", accessToken);

    }


    @After
    public void tearDown() {
        driver.quit();

        if (accessToken != null) {
            userApi.deleteUser(accessToken);

        }


    }

}