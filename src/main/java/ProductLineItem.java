public class ProductLineItem {
        public static String getProductLineItemBodyForRequest(int productId, int productQty){
            return "{\"product\":{\"code\":\""+productId+"\"},\" quantity\":"+productQty+"}";
        }
}