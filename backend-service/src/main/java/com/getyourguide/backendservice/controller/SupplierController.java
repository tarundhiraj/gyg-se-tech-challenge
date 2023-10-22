package com.getyourguide.backendservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.getyourguide.backendservice.bean.Supplier;
import com.getyourguide.backendservice.service.SupplierService;


@RestController
@RequestMapping(path="supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	private Logger logger = LoggerFactory.getLogger(SupplierController.class);
	
	@GetMapping
	public ResponseEntity<List<Supplier>> suppliers() {
		List<Supplier> suppliers = supplierService.getAllSuppliers();
		logger.info("Fetched " + suppliers.size() + " Suppliers");
		return ResponseEntity.ok(suppliers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Supplier> supplierById(@PathVariable Long id) {
		Supplier supplier = supplierService.getSupplierById(id);
		if(supplier != null) {
			return ResponseEntity.ok(supplier);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
