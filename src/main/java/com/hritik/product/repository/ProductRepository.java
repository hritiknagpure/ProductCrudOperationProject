package com.hritik.product.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hritik.product.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Page<Product> findByNameContaining(String name, Pageable pageable);
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
            
    Page<Product> searchByName(String keyword, Pageable pageable);
    

    
}
