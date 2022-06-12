import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.BingoSteps;

import java.util.List;

@RunWith(SerenityRunner.class)
public class WhenBingoPageTests {

    @Steps
    BingoSteps steps;

    @Managed
    WebDriver driver;

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        steps.openBingoPage();
        steps.acceptAge();
    }

    // Scroll down to the "Our bingo variants" section and check that there are 9 "Bingo theme"
    @Test
    public void checkCountOfElementsInCarouselMenuEqualsNineTest() {
        int countOfElementsInCarouselMenu = steps.getCountOfElementsInCarouselMenu();
        Assertions.assertThat(countOfElementsInCarouselMenu)
                .as("The count of elements in carousel menu equals " + countOfElementsInCarouselMenu + " elements, versus 9")
                .isEqualTo(9);
    }

    //Check if the elements are not duplicated.
    @Test
    public void checkDuplicateOfElementsInCarouselMenuTest() {
        steps.getCountOfElementsInCarouselMenu();
        int countOfDuplicates = steps.getDuplicateElementsSize();
        Assertions.assertThat(countOfDuplicates)
                .as("In carousel bloc are present " + countOfDuplicates + " duplicates")
                .isEqualTo(0);
    }

    //Verify that the link to the image contains the name of the theme(like Rock'n'Swing, Bingo Blast, Boombox, etc.).
    @Test
    public void checkIfLinkContainsTheNameOfThemeTest() {
        int countOfElements = steps.getCountOfElementsInCarouselMenu();
        for (int i = 0; i < countOfElements; i++) {
            List<String> allLinks = steps.getElementsLinks();
            Assertions.assertThat(allLinks.get(0))
                    .as("The " + allLinks.get(0) + " link  contains wrong title (" + allLinks.get(1) + ")")
                    .contains(allLinks.get(1));
        }
    }

}
