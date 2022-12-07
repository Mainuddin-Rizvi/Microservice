package com.mainuddin.ProductService.repos;

import com.mainuddin.ProductService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
