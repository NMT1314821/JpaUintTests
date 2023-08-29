package com.example.unitjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unitjpa.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long>
{

}
