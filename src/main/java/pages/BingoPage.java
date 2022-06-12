package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.*;

import static java.lang.Thread.sleep;

@DefaultUrl("https://www.pragmaticplay.com/en/bingo/")

public class BingoPage extends PageObject {
    int carouselElementsSize;
    List<String> allTitles = new ArrayList<>();

    private final By carouselElementsLocator = By.xpath("//div[@class='slick-track']/div");
    private final By carouselCurrentElementTitleLocator = By.xpath("//div[@class='slick-slide slick-current slick-active']");
    private final By carouselCurrentElementLinkLocator = By.xpath("//div[@class='slick-slide slick-current slick-active']//img");
    private final By carouselNavigateRightIconLocator = By.xpath("//div[@class='right-arrow slick-arrow']");


    public int getCountOfElementsInCarouselMenu() {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.scrollBy(0,500)", "");
        List<WebElementFacade> carouselItems = findAll(carouselElementsLocator);
        carouselElementsSize = carouselItems.size();
        return carouselElementsSize;
    }

    public List<String> getElementsOfCarouselMenu() {
        for (int i = 1; i <= carouselElementsSize; i++) {
            allTitles.add(find(carouselCurrentElementTitleLocator).getText());
            find(carouselNavigateRightIconLocator).click();
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return allTitles;
    }

    public int getDuplicateElementsSize() {
        List<String> duplicateElements = new ArrayList<>();
        Set<String> uniqueElements = new HashSet<>();
        for (String s : getElementsOfCarouselMenu()) {
            if (!uniqueElements.add(s)) {
                duplicateElements.add(s);
            }
        }
        return duplicateElements.size();
    }

    public List<String> getElementsLinks() {
        List<String> allLinks = new ArrayList<>();
        String link = find(carouselCurrentElementLinkLocator).getAttribute("src").replace("-", "");
        String title = find(carouselCurrentElementTitleLocator).getText().replace(" ", "");
        allLinks.add(link);
        allLinks.add(title);
        find(carouselNavigateRightIconLocator).click();
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return allLinks;
    }
}
