package com.example.techchallenge.model.repository;

import com.example.techchallenge.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


public interface ISaleRepository extends JpaRepository<Sale, Integer> {
    @Query("SELECT s FROM Sale s WHERE date = ?1")
    List<Sale> findSalesByDate(LocalDate date);

//    @Query(value = "SELECT * FROM Sale INNER JOIN product on sale.id = product.fk_product INNER JOIN supplier on supplier.id = product.fk_supplier WHERE supplier.id = '?1'", nativeQuery = true)
//    List<Sale> findSalesBySupplierName(Integer id);



}
