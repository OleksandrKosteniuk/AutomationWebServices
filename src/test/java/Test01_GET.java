import io.restassured.response.ResponseBody;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import org.openqa.selenium.*;

public class Test01_GET {
   
    @Test
    public void createBasket(){
        Response createBasketResponse = given().
                contentType("application/json").
                accept("application/json").
                when().
                post("https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts?lang=nl").
                then().
                extract().
                response();
        
        String guid = createBasketResponse.jsonPath().getString("guid");
        
        addProductToBasket(guid);
        
        openBasketPageByBrowser(guid);
    }
    
        public void addProductToBasket(String guid){
        Response addProductToBasketResponse = given().
                contentType("application/json").
                accept("application/json").
                body("{\"product\":{\"code\":\"5156733\"},\" quantity\":1}").
                log().
                all().
                when().
                post("https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts/"+guid+"/entries?lang=nl").
                then().
                body(matchesJsonSchemaInClasspath("post.json")).
                body("entry.product.code",equalTo("5156733")).
                body("quantity",equalTo(1)).
                statusCode(200).
                extract().
                response();
    }
    
    public void openBasketPageByBrowser(String guid){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Cookie cookie = new Cookie("kvn-cart",guid);
        
        driver.get("https://www.kruidvat.nl/cart");

        driver.manage().deleteAllCookies();
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.navigate().refresh();
    }
}