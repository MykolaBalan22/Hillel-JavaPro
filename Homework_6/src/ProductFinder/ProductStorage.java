package ProductFinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductStorage {
    final private List<Product> storage ;

    public ProductStorage() {
        this.storage = new ArrayList<>();
    }
    public void addProduct(Product value){
        Optional.ofNullable(value)
                .ifPresentOrElse(storage::add,()-> System.err.println("Your product does not exist!"));
    }
    public List<Product> getAllProductsByCategory(TypesOfProducts category){
        return storage.stream()
                .filter(product -> product.getProductType().equals(category))
                .filter(product -> product.getPrice()>250)
                .collect(Collectors.toList());
    }
    public List<Product> getDiscountBooks(){
        return storage.stream()
                .filter(product -> product.getProductType().equals(TypesOfProducts.BOOK))
                .filter(Product::isDiscount)
                .peek(book->book.setPrice(book.getPrice()*0.9))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ProductStorage{" +
                "storage=" + storage +
                '}';
    }
}
