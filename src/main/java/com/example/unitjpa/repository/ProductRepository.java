package com.example.unitjpa.repository;

import java.math.BigDecimal;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
				//writing JPQL queries using @query qnnontation;
	
	@Query("SELECT p from Product p where p.name=?1 or p.descri=?2")
	List<Product> findBynameorDescrjpql(String name,String descri);
	
	
	
		//Writing jpaql query using @param annontaion no need to main the order 
	@Query("SELECT p from Product p where p.name=:name or p.descri=:descri")
	List<Product> findBynamePramjpaql(@Param("name")String name,@Param("descri")String descri);
	
	//we have to write nativesqlQuery also but we have to define 
	//value and nativeQuery attributes in the query methos.
	
	@Query(value="select * from protb p where p.name=?1 or p.descri=?2", nativeQuery=true)
	List<Product> findbynameordescrnativesqlquery(String name,String descri);
	
	
	@Query(value="select * from protb p where p.name=:name or p.descri=:descri",nativeQuery = true)
	List<Product> findbynamenativesqlqueryparam(@Param("name")String name,
												@Param("descri")String descri);
	
	
	
	List<Product> findAllOrderByNameDesc();
	
	Product findByPrice(@Param("price")BigDecimal price);
	
	
	@Query(nativeQuery=true)
	Product findBySku(@Param("sku") String sku);
	
	@Query(nativeQuery=true)
	Product findByDescri(String descri);
	
	@Query(nativeQuery = true)
	List<Product> findAllOrderByNameAsc();
	
}
