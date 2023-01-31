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
    public Product getMostCheapestBook (){
        return storage.stream()
                .filter(product -> product.getProductType().equals(TypesOfProducts.BOOK))
                .sorted((book1,book2)->(int)Math.ceil(book1.getPrice()-book2.getPrice()))
                .findFirst()
                .orElseThrow(()->  new RuntimeException("Product [ Category : "+TypesOfProducts.BOOK.name()+" ] not found "));
    }
    public List<Product> getLastTreeProducts() {
        return storage.stream()
                .sorted((first, second) -> {
                    int cmp = (first.getAddDate().getYear() - second.getAddDate().getYear());
                    if (cmp == 0) {
                        cmp = (first.getAddDate().getMonthValue() - second.getAddDate().getMonthValue());
                        if (cmp == 0) {
                            cmp = (first.getAddDate().getDayOfMonth() - second.getAddDate().getDayOfMonth());
                        }
                    }
                    return cmp;
                })
                .skip(storage.stream().count() - 3)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ProductStorage{" +
                "storage=" + storage +
                '}';
    }
}
