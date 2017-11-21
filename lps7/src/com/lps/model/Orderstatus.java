package com.lps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "t_orderstatus")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "orderstatus_PK",
		allocationSize = 1)

public class Orderstatus implements java.io.Serializable {

	// Fields

	private Integer id;
	private String orderstatus;

	// Constructors

	/** default constructor */
	public Orderstatus() {
	}

	/** full constructor */
	public Orderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "orderstatus", unique = true, length = 20)

	public String getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

}