package com.dersler.new_play_sales.Repository;

import com.dersler.new_play_sales.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {



}
