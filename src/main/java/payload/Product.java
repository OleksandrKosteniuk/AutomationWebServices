package payload;

import org.apache.commons.text.StringSubstitutor;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private String productId;
    private int productQty;
    
    public Product(String productId, int productQty) {
        this.productId = productId;
        this.productQty = productQty;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public int getProductQty() {
        return productQty;
    }
    
    public String getAddProductToCardPayload(){
        
        //Template String
        String addProductToCartTemplate = "{\"product\":{\"code\":\"${code}\"},\"quantity\":${quantity}}";

        //Prepare value map of variables to replace to template String
        Map<String, Object> valuesProduct = new HashMap<>();

        valuesProduct.put("code", productId);
        valuesProduct.put("quantity", productQty);

        //Initialize StringSubsctitutor instance with value map
        StringSubstitutor stringSubstitutor = new StringSubstitutor(valuesProduct);

        //replace value map to template string
        String result = stringSubstitutor.replace(addProductToCartTemplate);

        System.out.println(result);
        return result;
    }
}
