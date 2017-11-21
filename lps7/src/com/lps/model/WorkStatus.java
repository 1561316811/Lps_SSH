package com.lps.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="t_workstatus")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "workstatus_PK",
		allocationSize = 1)
public class WorkStatus implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 683152915918217364L;
	private Integer id;
     private String workStatus;
     private Set<User> users = new HashSet<User>(0);

    // Constructors

    /** default constructor */
    public WorkStatus() {
    }

	/** minimal constructor */
    public WorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
    
    /** full constructor */
    public WorkStatus(String workStatus, Set<User> users) {
        this.workStatus = workStatus;
        this.users = users;
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
    
    @Column(name="workStatus", unique=true, nullable=false, length=20)

    public String getWorkStatus() {
        return this.workStatus;
    }
    
    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="workStatus")

    public Set<User> getUsers() {
        return this.users;
    }
    
    public void setUsers(Set<User> users) {
        this.users = users;
    }
   








}