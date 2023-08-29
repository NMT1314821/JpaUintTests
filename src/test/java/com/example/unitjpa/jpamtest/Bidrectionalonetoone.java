package com.example.unitjpa.jpamtest;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.unitjpa.model.Address;
import com.example.unitjpa.model.Order;
import com.example.unitjpa.repository.AddressRepository;

@SpringBootTest
public class Bidrectionalonetoone 
{

	@Autowired
	private AddressRepository addressRepo;
	
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
		as.setOrder(or);
		addressRepo.save(as);
	}
	
	//update the existing data
	@Test
	void updateData()
	{
		Address as=addressRepo.findById(1L).get();
		as.setCountery("pakistanji");
		as.getOrder().setStatus("deleverdall");
		addressRepo.save(as);
	}
	//delete the daata 
	@Test
	void deletedata()
	{
		addressRepo.deleteById(1L);
	}
	@Test
	void getData()
	{
		Address as=addressRepo.findById(2L).get();
		
	}
	
}
