package com.example.unitjpa.jpamtest;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.unitjpa.model.Address;
import com.example.unitjpa.model.Order;
import com.example.unitjpa.model.OrderItem;
import com.example.unitjpa.repository.OrderRepository;
import com.example.unitjpa.repository.ProductRepository;

@SpringBootTest
public class OneToManymapping
{
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@Test
	void setdata()
	{
		Order order=new Order();
		order.setOrderTrackingnum(887);
		order.setStatus("inprograss");
		
		OrderItem oi1=new OrderItem();
		oi1.setProduct(productRepo.findById(1L).get());
		oi1.setQuentity(2);
		oi1.setPrice(oi1.getProduct().getPrice().multiply(new BigDecimal(2)));
		oi1.setImgurl("image2.jpg");
		order.getOrderItems().add(oi1);
		
		OrderItem oi2=new OrderItem();
		oi2.setProduct(productRepo.findById(2L).get());
		oi2.setQuentity(3);
		oi2.setPrice(oi1.getProduct().getPrice().multiply(new BigDecimal(3)));
		oi2.setImgurl("imcmg.jpg");
		order.getOrderItems().add(oi2);
		
		order.setTotalprice(order.totalamount());
		order.setTotalQuantity(2);
		
		Address as=new Address();
		as.setCountery("india");
		as.setState("andhra");
		as.setStreet("vongaveticolony");
		as.setZipcode("543234");
		order.setBillingAddress(as);
		orderRepo.save(order);	
	}
	
	@Test
	void fetchdata()
	{
		Order or=orderRepo.findById(1L).get();
		System.err.println(or.toString());
		System.out.println(or.getStatus());
		for(OrderItem item:or.getOrderItems())
		{
			System.out.println(item.getProduct().getName());
		}
			
	}
	
	@Test
	void deletedata()
	{
		orderRepo.deleteById(1L);
	}

}
