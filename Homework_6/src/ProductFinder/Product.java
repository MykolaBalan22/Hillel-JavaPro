package ProductFinder;

public class Product {
    private TypesOfProducts productType;
    private double price ;
    private boolean discount;

    public Product(TypesOfProducts productType, double price, boolean discount) {
        this.productType = productType;
        this.price = price;
        this.discount = discount;
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

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}
