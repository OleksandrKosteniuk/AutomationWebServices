import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ShoppingCart {
    public static String getEndpointForCreateShoppingCartPostCall(){
        return "https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts?lang=nl";
    }
    
    public static String getValueFromCreateShoppingCartResponse(String string){
        return post(getEndpointForCreateShoppingCartPostCall()).jsonPath().get(string);
    }
    
    public static String getEndpointForAddProductToShoppingCartPostCall(String guid){
        return "https://www.kruidvat.nl/api/v2/kvn/users/anonymous/carts/"+guid+"/entries?lang=nl";
    }
}
