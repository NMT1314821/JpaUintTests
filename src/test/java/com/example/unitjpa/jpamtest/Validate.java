package com.example.unitjpa.jpamtest;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.unitjpa.model.Product;
import com.example.unitjpa.repository.ProductRepository;

@SpringBootTest
public class Validate 
{
	@Autowired
	private ProductRepository proRepo;
	
	
	@Test
	void saveData()
	{
		Product pro=new Product();
		 pro.setName("Oracle");
		 pro.setDescri("developmentkits");
		 pro.setActive(true);
		 pro.setImagurl("Oracledev.jpg");
		 pro.setPrice(new BigDecimal(300));
		 pro.setSku("23units");
		 
		 Product pr=proRepo.save(pro);
		 System.out.println(pr.getId());
		 System.out.println(pr.toString());
		
		
	}
	
	@Test
	void saveDataAll()
	{
		Product pro=new Product();
		pro.setName("Microsoft");
		pro.setDescri("Offices XL,Powerpoin");
		pro.setImagurl("mirosoft.jpg");
		pro.setPrice(new BigDecimal(20));
		pro.setSku("24units");
		pro.setActive(false);
				
		Product pro1=new Product();
		pro1.setName("workbencg");
		pro1.setDescri("databasesstoring");
		pro1.setImagurl("db.jpg");
		pro1.setPrice(new BigDecimal(60));
		pro1.setSku("34nunits");
		pro.setActive(true);
		
		proRepo.saveAll(List.of(pro,pro1));
			
	}
	
	@Test
	void deleteByIdmethod()
	{
		long id=1L;
		proRepo.deleteById(id);
	}

	@Test
	void deleteallmethod()
	{
		proRepo.deleteAll();
	}
	@Test
	void countrecord()
	{
		long coutn=proRepo.count();
		System.out.println(coutn);
	}
	@Test
	void existById()
	{
		boolean b=proRepo.existsById(8L);
		System.out.println(b);
	}
	
	@Test
	void saveDataAllabc()
	{
		Product pro=new Product();
		pro.setName("cocola");
		pro.setDescri("mango flowers");
		pro.setImagurl("drinks.jpg");
		pro.setPrice(new BigDecimal(600));
		pro.setSku("28units");
		pro.setActive(false);
		
		
		Product pro1=new Product();
		pro1.setName("cocola");
		pro1.setDescri("maza folower");
		pro1.setImagurl("maza.jpg");
		pro1.setPrice(new BigDecimal(8700));
		pro1.setSku("389nunits");
		pro.setActive(true);
		
		proRepo.saveAll(List.of(pro,pro1));
			
	}
	
}
