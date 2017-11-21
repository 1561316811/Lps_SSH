package com.lps.model;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


/**
 * AbstractPayPath entity provides the base persistence definition of the PayPath entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_paypath")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "paypath_PK",
		allocationSize = 1)

public  class PayPath  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private String payPath;


    // Constructors

    /** default constructor */
    public PayPath() {
    }

    
    /** full constructor */
    public PayPath(String payPath) {
        this.payPath = payPath;
    }

   
    // Property accessors
    @Id 
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")
    @Column(name="id", unique=true, nullable=false)

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name="payPath", unique=true, length=20)

    public String getPayPath() {
        return this.payPath;
    }
    
    public void setPayPath(String payPath) {
        this.payPath = payPath;
    }
   








}