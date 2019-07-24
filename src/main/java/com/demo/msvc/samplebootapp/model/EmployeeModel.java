package com.demo.msvc.samplebootapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeModel {
	private String id;
	private String name;
	private String designation;
}
