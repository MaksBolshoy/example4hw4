package ru.gb.homework4.example4hw4;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Сервис, использующий ProductRepository для получения информации о продуктах.
 */
@Service
class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        productRepository.save(new Product(null, "Apple", "Fruits"));
        productRepository.save(new Product(null, "Carrot", "Vegetables"));
        productRepository.save(new Product(null, "Milk", "Dairy"));
        return productRepository.findAll();
    }

    public Product getProductByID(Long id) {
        return productRepository.findById(id);
    }
}
