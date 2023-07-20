package com.example.unitjpa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unitjpa.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> 
{
	
	//single field retrive
	Product findByName(String name);
	
	//multiple field retrive
	
	List<Product> findByNameOrDescri(String name,String des);
	
	//find unique fields using distinct
	
	Product findDistinctByName(String name);
	
	//GraterThan or LessThan
	
	List<Product> findByPriceGreaterThan(BigDecimal price);
	
	List<Product> findByPriceLessThan(BigDecimal price);

	List<Product> findByNameContaining(String name);
	
	List<Product> findByNameLike(String name);
	
	
	//it consider present value onwors
	List<Product> findByPriceBetween(BigDecimal price,BigDecimal price2);
	
	//in
	
	List<Product> findByNameIn(List<String> name);
	
	List<Product> findTop2ByOrderByNameDesc();
	
}
