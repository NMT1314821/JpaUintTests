package com.example.unitjpa.jpamtest;
import java.math.BigDecimal;
import java.util.List;

import org.hibernate.boot.model.source.internal.hbm.AbstractEntitySourceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.unitjpa.model.Product;
import com.example.unitjpa.repository.ProductRepository;

@SpringBootTest
public class QueryMethods 
{
	@Autowired
	private ProductRepository proRepo;
	
	@Test
	void findByIdMethod()
	{
		Product por=proRepo.findByName("Oracle");
		System.out.println(por.getId());
		System.out.println(por.getDescri());
				
	}
	
	@Test
	void findbymulti()
	{
		List<Product> por=proRepo.findByNameOrDescri("cocola", "maza folower");
		por.forEach((s)->
		{
		
				System.out.println(s.getDescri());
				System.out.println(s.getId());
				System.out.println(s.getPrice());
		
		});
	}
	
	@Test
	void uniqueNamesMethod()
	{
		Product pr=proRepo.findDistinctByName("Oracle");
		System.out.println(pr.getId());
		System.out.println(pr.getDescri());
		
	}
	
	@Test
	void graterThenMethod()
	{
		List<Product> pro=proRepo.findByPriceGreaterThan(new BigDecimal(798));
		pro.forEach((s)->{
			
			System.out.println(s.getId());
			System.out.println(s.getDescri());
			System.out.println(s.getName());
		});
	}
	
	@Test
	void lessThanPriceMethod()
	{
		List<Product> pr=proRepo.findByPriceLessThan(new BigDecimal(577));
		pr.forEach((s)->
		{
			System.out.println(s.getId());
			System.out.println(s.getDescri());
			System.out.println(s.getImagurl());
			System.out.println(s.getName());
		}
				);
	}
	
	@Test
	void nameContainingMethod()
	{
		List<Product> pr=proRepo.findByNameContaining("coco");
		pr.forEach((s)->
		{
			System.out.println(s.getDescri());
			System.out.println(s.getName());
			System.out.println(s.getId());
		}
				);
	}
	
	@Test
	void nameLike()
	{
		List<Product> pr=proRepo.findByNameLike("cocola");
		pr.forEach((s)->{
			
			System.err.println(s.getId());
			System.out.println(s.getDescri());
			System.out.println(s.getName());
		}
				);
		
	}
	
	@Test
	void findBetween()
	{
		
		BigDecimal n=new BigDecimal(300);
		BigDecimal a=new BigDecimal(500);
		
		
		List<Product> pro=proRepo.findByPriceBetween(n,a);
		pro.forEach((s)->{
			
			System.out.println(s.getId());
			System.out.println(s.getDescri());
			System.out.println(s.getName());
			System.out.println(s.getPrice());
		});
	}
	@Test
	void findinmethod()
	{
		List<Product> pro=proRepo.findByNameIn(List.of("cocola","Oracle"));
		pro.forEach((s)->{
			System.out.println(s.getId());
			System.out.println(s.getDescri());
		});
	}
	
	@Test
	void findordermethod()
	{
		List<Product> pro=proRepo.findTop2ByOrderByNameDesc();
		pro.forEach((s)->
		{
			System.out.println(s.getName());
			System.out.println(s.getId());
		}
	);
	}
	
	@Test
	void jpqltest()
	{
		List<Product> pro=proRepo.findBynameorDescrjpql("Oracle","mango flowers");
		pro.forEach((s->{
		System.out.println(s.getId());
		System.out.println(s.getDescri());
		System.out.println(s.getName());
		}));
	}
	
	@Test
	void jpaqusingparam()
	{
		List<Product> pro=proRepo.findBynamePramjpaql("Oracle","mango flowers");
		pro.forEach((s)->{
			System.out.println(s.getId());
			System.out.println(s.getDescri());
			System.out.println(s.getSku());
		});
	}
	
	@Test
	void nativeSqlQuery()
	{
		List<Product> pro=proRepo.findbynameordescrnativesqlquery("Oracle","mango flowers");
		pro.forEach((s)->{
			System.out.println(s.getId());
			System.out.println(s.getDescri());
			System.out.println(s.getName());
			System.out.println(s.getSku());
		});
	}
	
	@Test
	void natisqlparam()
	{
		List<Product> pro=proRepo.findbynamenativesqlqueryparam("cocola","mango flowers");
		pro.forEach((s)->{
			System.out.println(s.getId());
			System.out.println(s.getDescri());
		});
	}
	//using NamedQuery() 
	
	@Test
	void namedquery()
	{
		Product pr=proRepo.findByPrice(new BigDecimal(500));
		System.out.println(pr.getId());
		System.out.println(pr.getName());
		System.out.println(pr.getSku());
		
	}
	@Test
	void multiplenamequeries()
	{
		List<Product> pr=proRepo.findAllOrderByNameDesc();
		pr.forEach((s)->{
			System.out.println(s.getName());
			System.out.println(s.getId());
			System.out.println(s.getImagurl());
		}
				);
	}
	@Test
	void findpricemn()
	{
		Product pr=proRepo.findByPrice(new BigDecimal(500));
		System.out.println(pr.getName());
		System.out.println(pr.getId());
		System.out.println(pr.getSku());
	}
	@Test
	void namednativeQuery()
	{
		Product pr=proRepo.findBySku("23units");
		System.out.println(pr.getId());
		System.out.println(pr.getDescri());
		System.out.println(pr.getName());
	}
	@Test
	void multiplenamequery()
	{
		Product pro=proRepo.findByDescri("developmentkits");
		System.out.println(pro.getId());
		System.out.println(pro.getName());
	}
	
	@Test
	void multiplenamedquery()
	{
		List<Product> pro=proRepo.findAllOrderByNameAsc();
		pro.forEach((s)->{
			 System.out.println(s.getId());
			 System.out.println(s.getName());
			 System.out.println(s.getPrice());
			 System.out.println(s.getSku());
			 
		});
	}
	
	
	
}
