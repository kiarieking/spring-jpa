package com.kingara.First_project.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByAvailable(boolean available);
    List<Product> findByProductname(String productname);
}
