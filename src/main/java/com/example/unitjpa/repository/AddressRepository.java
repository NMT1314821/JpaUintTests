package com.example.unitjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unitjpa.model.Address;

public interface AddressRepository extends JpaRepository<Address,Long>
{
	

}
