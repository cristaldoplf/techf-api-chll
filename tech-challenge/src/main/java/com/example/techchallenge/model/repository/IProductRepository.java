package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE stock < ?1")
    List<Product> findProductByStock(Integer integer);

//    @Query(value = "SELECT * FROM Product p inner join supplier on supplier.id = p.fk_supplier where supplier.name = '?1'", nativeQuery = true)
//    List<Product> findProductsBySupplier(String supplierName);

}
