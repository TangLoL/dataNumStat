package com.fiberhome.dao;


import com.fiberhome.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer,Integer>{

}
