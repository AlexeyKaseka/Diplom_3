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
    public void bunsSectionIsSelectedByDefaultTest() {

        mainPage.openMainPage();
        mainPage.getActiveSectionText();
        mainPage.isBunsSectionActive();
        assertTrue("После загрузки главной страницы раздел 'Булки' должен быть выбран по умолчанию",
                mainPage.isBunsSectionActive());


    }

    @Test
    public void sauceSectionSelectedTest() {
        mainPage.openMainPage();
        mainPage.clickSaucesSection();
                assertTrue("Раздел 'Соусы' должен быть активен",
                mainPage.isSaucesSectionActive());

    }


    @Test
    public void fillingSectionSelectedTest() {
        mainPage.openMainPage();
        mainPage.clickFillingSection();
                assertTrue("Раздел 'Начинки' должен быть активен",
                mainPage.isFillingsSectionActive());


    }


    @Test
    public void bunsSectionCanBeSelectedAfterSaucesTest() {
        mainPage.openMainPage();
        mainPage.clickSaucesSection();
        mainPage.clickBunSection();
        mainPage.getActiveSectionText();
              assertTrue("Раздел 'Булки' должен быть активен",
                mainPage.isBunsSectionActive());


    }


}
