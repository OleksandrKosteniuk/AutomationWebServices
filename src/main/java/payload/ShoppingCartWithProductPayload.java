package payload;

public class ShoppingCartWithProductPayload {
    private Product product;
    private int productQuantity;
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void setProductQuantity(int quantity) {
        this.productQuantity = quantity;
    }
}
