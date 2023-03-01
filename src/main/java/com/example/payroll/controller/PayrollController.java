package com.example.payroll.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.payroll.model.Payroll;
import com.example.payroll.services.PayrollService;

@RestController
public class PayrollController {
	
	@Autowired
	PayrollService payrollService;
	
	@GetMapping("/payroll/{id}")
	public ResponseEntity<Payroll> getPayrollDetails(@PathVariable int id) {
		Optional<Payroll> payrollObject = payrollService.getPayrollDetailsById(id);
		if(payrollObject.isPresent()) 
		return new ResponseEntity<Payroll>(payrollObject.get(), HttpStatus.OK);
		else 
		return new ResponseEntity<Payroll>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/payroll")
	public ResponseEntity<String> createPayroll(@RequestBody Payroll payroll) {
		int employeeId = payrollService.savePayrollDetails(payroll);
		return new ResponseEntity<String>("payroll created with employeeId: "+ employeeId, HttpStatus.OK);
		
	}

}
