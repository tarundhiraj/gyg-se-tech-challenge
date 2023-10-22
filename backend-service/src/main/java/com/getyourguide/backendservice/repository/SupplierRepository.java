package com.getyourguide.backendservice.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getyourguide.backendservice.bean.Supplier;

@Component
public class SupplierRepository {
	private Map<Long, Supplier> suppliers;
	
	private static final Logger logger = LoggerFactory.getLogger(ActivityRepository.class);
	
	public SupplierRepository() {
		
		this.suppliers = new HashMap<>();
		int readRecords = loadSuppliers();
		logger.info("Total " + readRecords + " Suppliers Read");
	}
	
	private int loadSuppliers() {
		List<Supplier> supplierList = new ArrayList<>();
		try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("static/suppliers.json");
            InputStream inputStream = resource.getInputStream();
            supplierList = objectMapper.readValue(inputStream, new TypeReference<List<Supplier>>() {
            });
        } catch (IOException e) {
        	logger.info("An Error occured while accessing json resources");
            e.printStackTrace();
        }
		
		for (Supplier supplier : supplierList) {
			this.suppliers.put(supplier.getId(), supplier);
		}
        return supplierList.size();
	}
	
	public List<Supplier> getAllSuppliers() {
		return this.suppliers.values().stream().collect(Collectors.toList());
	}
	
	public Supplier getSupplyById(Long id) {
		return this.suppliers.get(id);
	}
	
}
