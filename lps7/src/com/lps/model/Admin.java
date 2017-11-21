package com.lps.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_admin")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "admin_PK",
		allocationSize = 1)
public class Admin {

	// Fields

	private Integer id;
	private String userName;
	private String password;
	private Date registerTime;
	private String avatar;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** minimal constructor */
	public Admin(String userName, String password, Date registerTime) {
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public Admin(String userName, String password, Date registerTime, String avatar) {
		this.userName = userName;
		this.password = password;
		this.registerTime = registerTime;
		this.avatar = avatar;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "pk_generate")

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "userName", unique = true, nullable = false, length = 15)

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "password", nullable = false, length = 15)

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registerTime", nullable = false, length = 10)

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "avatar")

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
