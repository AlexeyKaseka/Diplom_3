import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.practicum.api.User;
import ru.practicum.api.UserApi;
import ru.practicum.pages.ForgotPasswordPage;
import ru.practicum.pages.LoginPage;
import ru.practicum.pages.MainPage;
import ru.practicum.pages.RegistrationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LoginTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private ForgotPasswordPage forgotPasswordPage;
    private User user;
    private UserApi userApi;
    private String accessToken;

    @Before
    public void setUp() {

        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
        user = new User();
        userApi = new UserApi();
        user.withName(RandomStringUtils.randomAlphabetic(8))
                .withEmail(RandomStringUtils.randomAlphabetic(8) + "@test.ru")
                .withPassword(RandomStringUtils.randomAlphabetic(8));

    }

    @Test
    public void loginFromMainPageEnterButtonTest() {

        userApi.createUser(user);


        mainPage.openMainPage();
        mainPage.mainPageEnterButton();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForMainPage();
        mainPage.verifyMainPageUrl();


        accessToken = userApi.getAccessToken(user);
        userApi.loginUserAndCheckStatus(user);


    }

    @Test
    public void loginFromPersonalAccountButtonTest() {

        userApi.createUser(user);


        mainPage.openMainPage();
        mainPage.сlickPersonalAccountButton();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForMainPage();
        mainPage.verifyMainPageUrl();


        accessToken = userApi.getAccessToken(user);
        userApi.loginUserAndCheckStatus(user);


    }


    @Test
    public void loginFromRegistrationEnterButtonTest() {

        userApi.createUser(user);


        mainPage.openMainPage();
        mainPage.сlickPersonalAccountButton();
        loginPage.clickRegistrationLinkButton();
        registrationPage.clickRegistrationEnterButton();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForMainPage();
        mainPage.verifyMainPageUrl();


        accessToken = userApi.getAccessToken(user);
        userApi.loginUserAndCheckStatus(user);


    }

    @Test
    public void loginFromForgotPasswordEnterButtonTest() {

        userApi.createUser(user);


        mainPage.openMainPage();
        mainPage.сlickPersonalAccountButton();
        loginPage.clickForgotPasswordLinkLocator();
        forgotPasswordPage.clickForgotPasswordEnterButtonLocator();
        loginPage.enterEmail(user.getEmail());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickEnterButton();
        mainPage.waitForMainPage();
        mainPage.verifyMainPageUrl();


        accessToken = userApi.getAccessToken(user);
        userApi.loginUserAndCheckStatus(user);


    }




    @After
    public void tearDown() {
        driver.quit();

        if (accessToken != null) {
            userApi.deleteUser(accessToken);

        }


    }


}
