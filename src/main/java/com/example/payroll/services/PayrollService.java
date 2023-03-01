package com.example.payroll.services;

import java.util.Optional;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.example.payroll.model.Payroll;
import com.example.payroll.repository.PayrollRepository;


@Service
public class PayrollService {
	
	@Autowired
	PayrollRepository payrollRepository;	
	
    private final static Logger logger = LoggerFactory.getLogger(PayrollService.class);


	public Optional<Payroll> getPayrollDetailsById(int id) {
		return payrollRepository.findById(id);
	}
	
	@KafkaListener(topics = {"#{'${kafka.consumer.topic}'}"})
    public void receive(@Payload String message) {

		try {
			JSONObject receivedJson = new JSONObject(message);
	        Optional<Payroll> payrollDetails = getPayrollDetailsById(receivedJson.getInt("employeeId"));
	        if (payrollDetails.isPresent()) {
	        	Payroll payroll = payrollDetails.get();
	        	payroll.setMonthlySalary(receivedJson.getLong("salary")/12);
	        	payrollRepository.save(payroll);
	        	logger.info("Payroll saved succesfully");
	        }
		}catch(JSONException e) {
			logger.error("Unable to fetch payroll details: {}"+e);
		}
    }

	public int savePayrollDetails(Payroll payroll) {
		Payroll payrollObject = payrollRepository.save(payroll);
		return payrollObject.getEmployeeId();
	}

}
