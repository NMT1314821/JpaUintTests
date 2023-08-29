package com.example.unitjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unitjpa.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>
{

	
}
