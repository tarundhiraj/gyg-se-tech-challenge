package com.getyourguide.backendservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Supplier {
	private Long id;
	private String name;
	private String address;
	private String zip;
	private String city;
	private String country;
}
