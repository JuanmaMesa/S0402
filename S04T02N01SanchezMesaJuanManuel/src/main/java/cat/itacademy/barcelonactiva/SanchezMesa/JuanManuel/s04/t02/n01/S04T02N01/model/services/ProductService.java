package cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.services;

import cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(int id);
    Product save(Product product);
    Optional delete(int id);
    Optional<Product> update(int id, Product product);



}
