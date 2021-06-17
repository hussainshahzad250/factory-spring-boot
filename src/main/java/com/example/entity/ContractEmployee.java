package com.example.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "CONTRACT_EMP")
@EqualsAndHashCode(callSuper=false)
@AttributeOverrides({ @AttributeOverride(name = "name", column = @Column(name = "FULLNAME")),
		@AttributeOverride(name = "startDate", column = @Column(name = "SDATE")) })
public class ContractEmployee extends Employee {
	
	@Column(name = "D_RATE")
	private int dailyRate;
	private int term;

}
