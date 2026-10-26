package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        //nextId++;
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

//    public String deleteProduct(Long id) {
//        boolean isDeleted = products.removeIf(p -> p.getId().equals(id));
//        if (isDeleted) {
//            return "Delete endpoint executed: ID: " + id + "product has been deleted successfully";
//        } else {
//            return "Unable to delete, ID: " + id + ": product is not found!";
//        }
//    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p ->p.getName().contains(name))
                .toList();
    }

}
