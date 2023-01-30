package ProductFinder;

public class Product {
    private TypesOfProducts productType;
    private double price ;

    public Product(TypesOfProducts productType, double price) {
        this.productType = productType;
        this.price = price;
    }

    public TypesOfProducts getProductType() {
        return productType;
    }

    public void setProductType(TypesOfProducts productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", price=" + price +
                '}';
    }
}
