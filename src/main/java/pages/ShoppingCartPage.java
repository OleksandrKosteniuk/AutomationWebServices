package pages;

import abstractClasses.AbstractFragment;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends AbstractFragment {

    //ProductLineItemLink
    private static final By PRODUCT_LINE_ITEM_LINK = By.xpath("//*[@class='product-summary__wrapper']/a");

    public WebElement getProductLineItemLink() {
        return findElement(PRODUCT_LINE_ITEM_LINK);
    }
    
    public void openShoppingCartPageByBrowser(String guid){
        Cookie cookie = new Cookie("kvn-cart",guid);
        DriverManager.getDriver().get("https://www.kruidvat.nl/cart");
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().manage().addCookie(cookie);
        DriverManager.getDriver().navigate().refresh();
    }
}
