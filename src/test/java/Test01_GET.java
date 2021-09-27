import api.ShoppingCartPageApi;
import driver.DriverManager;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;
import pages.ShoppingCartPage;
import payload.Product;
import static org.assertj.core.api.Assertions.assertThat;

public class Test01_GET {
    
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        ShoppingCartPageApi shoppingCartPageApi = new ShoppingCartPageApi();
        Product product = new Product("5156733",1);

        String guid = shoppingCartPageApi.getGuIdFromCreateShoppingCartPostApiCall();
        
    @Test
    public void addProductToBasket() {
        
        Response addProductToBasketResponse = given().
                contentType("application/json").
                accept("application/json").
                body(product.getAddProductToCardPayload()).
                when().
                post(shoppingCartPageApi.getAddProductToShoppingCartEndpoint(guid)).
                then().
                body(matchesJsonSchemaInClasspath("post.json")).
                body(shoppingCartPageApi.getProductCodeJsonPath(), equalTo(product.getProductId())).
                body(shoppingCartPageApi.getProductQtyJsonPath(), equalTo(product.getProductQty())).
                statusCode(200).
                extract().
                response();
    }
    
    @Test
    public void isProductAddedToShoppingCart(){
        shoppingCartPage.openShoppingCartPageByBrowser(guid);
        assertThat(shoppingCartPage.getProductLineItemLink().getAttribute("href").contains(product.getProductId()))
                .overridingErrorMessage("Product is not added to Shopping Cart")
                .isTrue();
    }
}