package ie.atu.yr4lab2buildingtwointeractingmicroservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("get")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("create")
    public ResponseEntity<String> createProduct(@RequestBody Product newProduct) {
        productService.createProduct(newProduct);
        return new ResponseEntity<>("Product successfully created\n", HttpStatus.CREATED);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<String> editProduct(@PathVariable long id, @RequestBody Product changedProduct) {
        boolean status = productService.editProduct(id, changedProduct);

        if(status){
            return new ResponseEntity<>("Product successfully edited\n", HttpStatus.CREATED);
        }else
            return new ResponseEntity<>("Product not found\n", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> editProduct(@PathVariable long id) {
        boolean status = productService.deleteProduct(id);

        if(status){
            return new ResponseEntity<>("Product successfully deleted\n", HttpStatus.CREATED);
        }else
            return new ResponseEntity<>("Product not found\n", HttpStatus.BAD_REQUEST);
    }
}
