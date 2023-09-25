package com.snowflex.snowflack.dao;

import com.snowflex.snowflack.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
