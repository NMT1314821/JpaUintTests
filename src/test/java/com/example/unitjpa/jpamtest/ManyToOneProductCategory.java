package com.example.unitjpa.jpamtest;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.unitjpa.model.Product;
import com.example.unitjpa.model.ProductCategory;
import com.example.unitjpa.repository.ProductCategoryRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ManyToOneProductCategory
{

	@Autowired
	private ProductCategoryRepository productcatRepo;
	
	@Test
	void saveTheData()
	{
		ProductCategory procate=new ProductCategory();
		procate.setCategoryName("books");
		procate.setCategoryDesc("bookdesc");
		
		Product pro=new Product();
		pro.setName("corejava");
		pro.setSku("33units");
		pro.setDescri("corejavadesc");
		pro.setPrice(new BigDecimal(355));
		pro.setActive(true);
		pro.setImagurl("Imgjava.jpg");
		pro.setCategory(procate);
		procate.getPro().add(pro);
		
		Product pro2=new Product();
		pro2.setName("advancejava");
		pro2.setSku("3units");
		pro2.setDescri("advancejavadesc");
		pro2.setPrice(new BigDecimal(55));
		pro2.setActive(false);
		pro2.setImagurl("Imgadvance.jpg");
		pro2.setCategory(procate);
		procate.getPro().add(pro2);
		
		productcatRepo.save(procate);
	
	}
	
	
	@Test
	@Transactional
	void fetchdata()
	{
		ProductCategory pc=productcatRepo.findById(1L).get();
		System.out.println(pc.getPro().toString());
	}
	
}
