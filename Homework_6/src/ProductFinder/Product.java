package ProductFinder;

import java.time.LocalDate;

public class Product {
    private TypesOfProducts productType;
    private double price ;
    private boolean discount;
    private LocalDate addDate ;

    public Product(TypesOfProducts productType, double price, boolean discount, LocalDate addDate) {
        this.productType = productType;
        this.price = price;
        this.discount = discount;
        this.addDate = addDate;
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

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", price=" + price +
                ", discount=" + discount +
                ", addDate=" + addDate +
                '}';
    }
}
