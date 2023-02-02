package ProductFinder;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductStorage {
    final private List<Product> storage ;

    public ProductStorage() {
        this.storage = new ArrayList<>();
    }
    public void addProduct(Product value){
        Optional.ofNullable(value)
                .ifPresentOrElse(storage::add,()-> System.err.println("Your product does not exist!"));
    }
    public List<Product> getAllProductsByCategory(ProductType category){
        return storage.stream()
                .filter(product -> product.getProductType().equals(category))
                .filter(product -> product.getPrice()>250)
                .collect(Collectors.toList());
    }
    public List<Product> getDiscountBooks(){
        return storage.stream()
                .filter(product -> product.getProductType().equals(ProductType.BOOK))
                .filter(Product::isDiscount)
                .peek(book->book.setPrice(book.getPrice()*0.9))
                .collect(Collectors.toList());
    }
    public Product getCheapestBook (){
        return storage.stream()
                .filter(product -> product.getProductType().equals(ProductType.BOOK))
                .sorted((book1,book2)->(int)Math.ceil(book1.getPrice()-book2.getPrice()))
                .findFirst()
                .orElseThrow(()->  new RuntimeException("Product [ Category : "+ ProductType.BOOK.name()+" ] not found "));
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
    public double getTotalPriceOfCategory (ProductType category , double priceLimit){
        return storage.stream()
                .filter(product -> product.getProductType().equals(category))
                .filter(product -> product.getAddDate().getYear()== LocalDate.now().getYear())
                .filter(product -> product.getPrice()<priceLimit)
                .map(Product::getPrice)
                .reduce(Double::sum)
                .get();
    }
    public Map<String, HashSet<Product>> groupProductsByType(){
        HashMap<String, HashSet<Product>> groupedStorage =new HashMap<>();
        Stream.of(ProductType.values())
                .map(Enum::toString)
                .forEach(type-> groupedStorage.put(type, new HashSet<>()));
        storage.stream()
                .forEach(product -> groupedStorage.get(product.getProductType().name()).add(product));
        return groupedStorage;
    }

    @Override
    public String toString() {
        return "ProductStorage{" +
                "storage=" + storage +
                '}';
    }
}
