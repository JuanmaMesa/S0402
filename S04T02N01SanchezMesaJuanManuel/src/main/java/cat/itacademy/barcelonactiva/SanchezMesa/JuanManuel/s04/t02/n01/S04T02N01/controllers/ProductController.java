package cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.controllers;


import cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.domain.Product;
import cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/findAll")
    public List<Product>list(){
        return productService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product productNew = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productNew);

    }
    @PutMapping ("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product){
        Optional<Product> productOptional = productService.update(id, product);
        if (productOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id){
        Optional<Product> productOptional = productService.delete(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("getOne/{id}")
    public ResponseEntity<?> view(@PathVariable int id){
        Optional<Product> productOptional=productService.findById(id);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(productOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }








}
