package com.example.unitjpa.jpamtest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import com.example.unitjpa.model.Product;
import com.example.unitjpa.repository.ProductRepository;
@SpringBootTest
public class PaginationAndSorting
{
	@Autowired
	private ProductRepository pr;
	
	@Test
	void pagination()
	{
		int pagenum=0;
		int pageSize=3;
		
		Pageable pageble=PageRequest.of(pagenum, pageSize);
		Page<Product> page=pr.findAll(pageble);
		List<Product> lis=page.getContent();
		lis.forEach((s)->{
			System.out.println(s);
		});
		
		int pa=page.getTotalPages();
		System.out.println(pa);
		
	}
	
	@Test
	void sortingimple()
	{
		String SortBy="price";
		String sortDir="desc";
		
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(SortBy).ascending():
				Sort.by(SortBy).descending();
		List<Product> por=pr.findAll(sort);
		por.forEach((s)->{
			System.out.println(s);
		});
	}
	
	@Test
	void sortingMultiplefields()
	{
		String sortByName="name";
		String sortByDesc="descri";
		String sortDir="desc";
		
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortByName).ascending():
				Sort.by(sortByName).descending();
		Sort sort1=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
				Sort.by(sortByDesc).ascending():
				Sort.by(sortByDesc).descending();
		
		Sort groupsort=sort.and(sort1);
		List<Product> por=pr.findAll(groupsort);
		por.forEach((s)->{
			System.out.println(s);
		});
	}	
		@Test
		void pageingandsorting()
		{
			
			String sortby="price";
			int pagenum=0;
			int pagesize=3;
			String sortDir="desc";
			
			Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
					Sort.by(sortby).ascending():
					Sort.by(sortby).descending();
			
			Pageable pageble=PageRequest.of(pagenum, pagesize,sort);
			Page<Product> page=pr.findAll(pageble);
			List<Product>lis=page.getContent();
			lis.forEach((s)->{
				System.out.println(s);
			});
		}

}
