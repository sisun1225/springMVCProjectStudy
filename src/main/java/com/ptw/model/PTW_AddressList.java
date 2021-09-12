package com.ptw.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table
public class PTW_AddressList {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long memberNo;
	
	@Column(nullable = false)
	private String companyName;
	
}
