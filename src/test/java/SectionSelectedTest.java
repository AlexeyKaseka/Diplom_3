import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.practicum.pages.MainPage;

import static org.junit.Assert.assertTrue;

public class SectionSelectedTest extends BaseTest {

    private MainPage mainPage;

    @Before
    public void setUp() {

        mainPage = new MainPage(driver);

    }

    @Test
    @DisplayName("Проверка активности раздела 'Булки' по умолчанию")
    @Description("Позитивный тест: При загрузке главной страницы раздел 'Булки' должен быть выбран автоматически")
    public void bunsSectionIsSelectedByDefaultTest() {

        mainPage.openMainPage();
        mainPage.getActiveSectionText();
        mainPage.isBunsSectionActive();
        assertTrue("После загрузки главной страницы раздел 'Булки' должен быть выбран по умолчанию",
                mainPage.isBunsSectionActive());


    }

    @Test
    @DisplayName("Проверка переключения на раздел 'Соусы'")
    @Description("Позитивный тест: Раздел 'Соусы' выбирается кликом по соответствующей вкладке")
    public void sauceSectionSelectedTest() {
        mainPage.openMainPage();
        mainPage.clickSaucesSection();
                assertTrue("Раздел 'Соусы' должен быть активен",
                mainPage.isSaucesSectionActive());

    }


    @Test
    @DisplayName("Проверка переключения на раздел 'Начинки'")
    @Description("Позитивный тест: Раздел 'Начинки' выбирается кликом по соответствующей вкладке")
    public void fillingSectionSelectedTest() {
        mainPage.openMainPage();
        mainPage.clickFillingSection();
                assertTrue("Раздел 'Начинки' должен быть активен",
                mainPage.isFillingsSectionActive());


    }


    @Test
    @DisplayName("Проверка возврата к разделу 'Булки' после выбора другого раздела")
    @Description("Позитивный тест: Разделу 'Булки' выбирается кликом по соответствующей вкладке после переключения на другие разделы")
    public void bunsSectionCanBeSelectedAfterSaucesTest() {
        mainPage.openMainPage();
        mainPage.clickSaucesSection();
        mainPage.clickBunSection();
        mainPage.getActiveSectionText();
              assertTrue("Раздел 'Булки' должен быть активен",
                mainPage.isBunsSectionActive());


    }


}
