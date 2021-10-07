package payload;

import org.apache.commons.text.StringSubstitutor;
import java.util.Map;

public class PayloadManager {
    public String getAddProductToCardPayload(Map<String, Object> valuesProduct, String payloadTemplate){
        
        //Initialize StringSubsctitutor instance with value map
        StringSubstitutor stringSubstitutor = new StringSubstitutor(valuesProduct);

        //replace value map to template string
        String result = stringSubstitutor.replace(payloadTemplate);
        
        return result;
    }
}
