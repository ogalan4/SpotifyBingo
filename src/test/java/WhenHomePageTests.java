import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import steps.HomeSteps;

import java.util.List;

@RunWith(SerenityRunner.class)
public class WhenHomePageTests {
    @Steps
    HomeSteps steps;

    @Managed
    WebDriver driver;

    public String colourBeforeChanging;
    public String colourAfterChanging;

    @Before
    public void setUp() {
        driver.manage().window().maximize();
        steps.openHomePage();
        steps.acceptAge();
    }

    //Check if all header menu items (Home, Products, Client Hub, Company, News, Contact) are colored when cursor is moved.
    @Test
    public void checkIfHeaderMenuItemsChangeColorByCursorMoving() {
        List<WebElementFacade> menuElements = steps.getMenuElements();
        for (WebElement element : menuElements) {
            System.out.println(element.getText());
            colourBeforeChanging = steps.getColorItem(element);
            steps.mouseOverElement(element);
            colourAfterChanging = steps.getColorItem(element);
            Assertions.assertThat(colourBeforeChanging)
                    .as("The color of " + element.getText() + " was not change after moving over it")
                    .isNotEqualTo(colourAfterChanging);
        }
    }

    //Check if "Bingo" option in menu "Products" changes color when cursor is move over.
    @Test
    public void checkBingoSubMenuItemChangesColorByCursorMoving() {
        WebElement bingoItem = steps.getBingoItemElement();
        steps.selectBingoSubItem();
        colourBeforeChanging = steps.getColorItem(bingoItem);
        steps.mouseOverElement(bingoItem);
        colourAfterChanging = steps.getColorItem(bingoItem);
        Assertions.assertThat(colourBeforeChanging)
                .as("The colour of " + bingoItem.getText() + " was not change after moving on it")
                .isNotEqualTo(colourAfterChanging);
    }
}
