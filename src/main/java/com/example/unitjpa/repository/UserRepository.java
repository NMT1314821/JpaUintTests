package com.example.unitjpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.unitjpa.model.User;

public interface UserRepository extends JpaRepository<User,Long>
{

}
