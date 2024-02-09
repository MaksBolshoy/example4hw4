package ru.gb.homework4.example4hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Component;

/**
 * Репозиторий для управления хранением продуктов.
 */
@Component
public class ProductRepository {

    private Map<Long, Product> products = new ConcurrentHashMap<>();
    private AtomicLong counter = new AtomicLong();

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Product findById(Long id) {
        return products.get(id);
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(counter.incrementAndGet());
        }
        products.put(product.getId(), product);
        return product;
    }
}
