package com.example.payroll.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.payroll.model.Payroll;

public interface PayrollRepository extends MongoRepository<Payroll, Integer> {

}
