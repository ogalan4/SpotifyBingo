package steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import pages.HomePage;

import java.util.List;

public class HomeSteps {
    HomePage page;

    @Step("Opening home page")
    public void openHomePage() {
        page.open();
    }

    @Step("Accepting client age")
    public void acceptAge() {
        page.acceptAgeButtonClick();
    }

    @Step("Getting the list of menu elements")
    public List<WebElementFacade> getMenuElements() {
        return page.getMenuElements();
    }

    @Step("Getting the color of menu item")
    public String getColorItem(WebElement element) {
        return page.getColorItem(element);
    }

    @Step("Moving mouse over element")
    public void mouseOverElement(WebElement element) {
        page.mouseOverElement(element);
    }

    @Step("Selecting bingo subItem from menu items")
    public void selectBingoSubItem() {
        page.selectBingoSubItem();
    }

    @Step("Getting bingo item element")
    public WebElement getBingoItemElement() {
        return page.getBingoItemElement();
    }

}
