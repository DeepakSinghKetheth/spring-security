package com.springsecurity.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Employee {

	@Id
	private String id;
	private String username;
	private String password;
	private double salary;
	private String designation;
}
