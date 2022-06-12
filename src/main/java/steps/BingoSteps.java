package steps;

import net.thucydides.core.annotations.Step;
import pages.BingoPage;
import pages.HomePage;

import java.util.List;

public class BingoSteps {
    BingoPage page;
    HomePage homePage;

    @Step("Opening bingo page")
    public void openBingoPage() {
        page.open();
    }

    @Step("Accepting client age")
    public void acceptAge() {
        homePage.acceptAgeButtonClick();
    }

    @Step("Getting count of elements in carousel menu")
    public int getCountOfElementsInCarouselMenu() {
        return page.getCountOfElementsInCarouselMenu();
    }

    @Step("Getting count of duplicate elements")
    public int getDuplicateElementsSize() {
        return page.getDuplicateElementsSize();
    }

    @Step("Getting elements links")
    public List<String> getElementsLinks() {
        return page.getElementsLinks();
    }

}
