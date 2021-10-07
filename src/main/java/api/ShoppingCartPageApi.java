package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ShoppingCartPageApi {
    private final String PRODUCT_CODE_JSON_PATH = "entry.product.code";
    private final String PRODUCT_QUANTITY_JSON_PATH = "quantity";

    public String getProductCodeJsonPath() {
        return PRODUCT_CODE_JSON_PATH;
    }

    public String getProductQtyJsonPath() {
        return PRODUCT_QUANTITY_JSON_PATH;
    }

    public String getGuIdFromCreateShoppingCartPostApiCall(){
        String guid = given()
                .when()
                .post("https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts?lang=nl")
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("guid");
        return guid;
    }
    
    public String getAddProductToShoppingCartEndpoint(String guid){
        return "https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts/"+guid+"/entries?lang=nl";
    }
}
    

