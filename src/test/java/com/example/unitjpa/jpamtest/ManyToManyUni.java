package com.example.unitjpa.jpamtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.unitjpa.model.Role;
import com.example.unitjpa.model.User;
import com.example.unitjpa.repository.UserRepository;

@SpringBootApplication
public class ManyToManyUni 
{
	@Autowired
	private UserRepository userRepo;
	
	@Test
	void saveData()
	{
		User user=new User();
		user.setFirstName("naveen");
		user.setLastName("chinni");
		user.setEmail("navi131@gmail.com");
		user.setPassword("abc123");
		
		Role admin=new Role();
		admin.setName("ROLE_ADMIN");
		
		Role customer=new Role();
		customer.setName("ROLE_CUSTOMER");
		
		user.getRoles().add(admin);
		user.getRoles().add(customer);
		
		userRepo.save(user);
		

	}
	

}
