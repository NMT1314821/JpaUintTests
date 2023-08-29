package com.example.unitjpa.jpamtest;

import java.math.BigDecimal;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.unitjpa.model.Address;
import com.example.unitjpa.model.Order;
import com.example.unitjpa.repository.OrderRepository;

@SpringBootTest
public class OneToOneTestUnidirectional
{
	@Autowired
	private OrderRepository orderRepo;
	
	
	
	//save the data into the db;
	@Test
	void savedata()
	{
		Order or=new Order();
		or.setOrderTrackingnum(12390);
		or.setTotalprice(new BigDecimal(900));
		or.setTotalQuantity(5);
		or.setStatus("inprograss");	
		Address as=new Address();
		as.setCountery("india");
		as.setState("andhra");
		as.setStreet("vongaveticolony");
		as.setZipcode("543234");
		or.setBillingAddress(as);
		orderRepo.save(or);
	}
	
	//update the existing entity using id;
	@Test
	void update()
	{
		Order or=orderRepo.findById(1L).get();
		or.setOrderTrackingnum(9090);
		or.getBillingAddress().setState("assam");
		orderRepo.save(or);
	}
	
	//delete the entity it takes nothing;
	@Test
	void delete()
	{
		orderRepo.deleteById(1L);
	}
	//get the data using id;
	
	@Test
	void getdata()
	{
		Order or=orderRepo.findById(2l).get();
		System.out.println(or.toString());
	}
	

}
