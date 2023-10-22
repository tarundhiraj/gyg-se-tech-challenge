package com.getyourguide.backendservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getyourguide.backendservice.bean.Supplier;
import com.getyourguide.backendservice.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.getAllSuppliers();
	}
	
	public Supplier getSupplierById(Long id) {
		return this.supplierRepository.getSupplyById(id);
	}	
}
