package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import java.util.List;

@DefaultUrl("https://www.pragmaticplay.com/en/")
public class HomePage extends PageObject {

    private final By acceptAgeButton = By.xpath("//span[contains(text(),'18 years or older')]");

    private final By headerMenuItem = By.xpath("//ul[@id='menu-top-menu']/li/a[text()]");

    private final By productsHeaderMenuItem = By.xpath("//a[@title='Games']");

    private final By bingoHeaderSubMenuItem = By.xpath("//li[@id='menu-item-11081']/a");

    public void acceptAgeButtonClick() {
        find(acceptAgeButton).click();
    }

    public List<WebElementFacade> getMenuElements() {
        List<WebElementFacade> locators;
        locators = findAll(headerMenuItem);
        return locators;
    }

    public String getColorItem(WebElement element) {
        String color;
        color = Color.fromString(element.getCssValue("color")).asHex();
        return color;
    }

    public void mouseOverElement(WebElement element) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).build().perform();
    }

    public void selectBingoSubItem() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(find(productsHeaderMenuItem)).build().perform();
    }

    public WebElement getBingoItemElement() {
        return find(bingoHeaderSubMenuItem);
    }
}

