import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;


public class Test01_GET {
    @Test
    public void addToCart() {
        given()
                .post(ShoppingCart.getEndpointForCreateShoppingCartPostCall())
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(201);
    }

    @Test
        public void AddProductToShoppingCart(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .body(ProductLineItem.getProductLineItemBodyForRequest(5156733,1))
                .when()
                .post(ShoppingCart.getEndpointForAddProductToShoppingCartPostCall(ShoppingCart.getValueFromCreateShoppingCartResponse("guid")))
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
    }
}