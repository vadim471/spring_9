package org.example.repository;
import org.example.model.Product;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
    @Modifying
    @Query("update product set purchased = :purchased where id = :id")
    void setPurchased(@Param("purchased") boolean purchased, @Param("id") Long id);

}
