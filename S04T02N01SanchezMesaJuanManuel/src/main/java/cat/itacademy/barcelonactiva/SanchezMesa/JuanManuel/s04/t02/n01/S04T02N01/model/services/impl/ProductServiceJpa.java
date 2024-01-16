package cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.services.impl;

import cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.domain.Product;
import cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.repository.ProductRepository;
import cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceJpa implements ProductService {
    @Autowired
    private ProductRepository repository;
    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(int id) {
        return repository.findById((long) id);
    }
    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }
    @Transactional
    @Override
    public Optional<Product> delete(int id) {
        Optional<Product> productdb = repository.findById(id);
        productdb.ifPresent((product -> {
            repository.delete(product);
        }));

        return productdb;
    }

    @Transactional
    @Override
    public Optional<Product> update(int id, Product product) {
        Optional<Product> productOptional = repository.findById(id);
        if (productOptional.isPresent()) {
            Product productDb = productOptional.orElseThrow();

            productDb.setName(product.getName());
            productDb.setNumberKg(product.getNumberKg());

            return Optional.of(repository.save(productDb));

        }
        return productOptional;
    }


}
