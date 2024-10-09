package ie.atu.yr4lab2buildingtwointeractingmicroservices;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product getProductById(long id) {
        return productList.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void createProduct(Product product) {
        if (productList.stream().anyMatch(existingProduct -> existingProduct.getId() == product.getId())) {
            throw new IllegalArgumentException("Product with ID " + product.getId() + " already exists");
        }
        productList.add(product);
    }

    public boolean editProduct(long id, Product updatedProduct) {
        for (Product product : productList) {
            if (product.getId() == id) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return true;
            }
        }
        throw new IllegalArgumentException("Product with ID " + id + " not found");
    }

    public boolean deleteProduct(long id) {
        Product product = productList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found"));
        productList.remove(product);
        return true;
    }
}
