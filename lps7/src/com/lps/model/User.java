package com.lps.model;
// default package

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t_user")
@TableGenerator(
		name = "pk_generate", 
		table = "tb_generator",
		pkColumnName = "gen_name", 
		valueColumnName = "gen_value", 
		pkColumnValue = "user_PK",
		allocationSize = 1)
public class User  implements java.io.Serializable {

     private Integer id;
     private WorkStatus workStatus;
     private String userName;
     private String password;
     private Integer workId;
     private Date birthday;
     private String telephonePhone;
     private String email;
     private String address;
     private String avatar;
     private String question;
     private String answer;
     private Date registerTime;


    // Constructors

    /** default constructor */
    public User() {
    }

	/** minimal constructor */
    public User(String userName, String password, String question, String answer, Date registerTime) {
        this.userName = userName;
        this.password = password;
        this.question = question;
        this.answer = answer;
        this.registerTime = registerTime;
    }
    
    /** full constructor */
    public User(WorkStatus workStatus, String userName, String password, Integer workId, Date birthday, String telephonePhone, String email, String address, String avatar, String question, String answer, Date registerTime) {
        this.workStatus = workStatus;
        this.userName = userName;
        this.password = password;
        this.workId = workId;
        this.birthday = birthday;
        this.telephonePhone = telephonePhone;
        this.email = email;
        this.address = address;
        this.avatar = avatar;
        this.question = question;
        this.answer = answer;
        this.registerTime = registerTime;
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
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="workStatus")

    public WorkStatus getWorkStatus() {
        return this.workStatus;
    }
    
    public void setWorkStatus(WorkStatus workStatus) {
        this.workStatus = workStatus;
    }
    
    @Column(name="userName", unique=true, nullable=false, length=45)

    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Column(name="password", nullable=false, length=45)

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="workId", unique=true)

    public Integer getWorkId() {
        return this.workId;
    }
    
    public void setWorkId(Integer workId) {
        this.workId = workId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="birthday", length=10)

    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    @Column(name="telephonePhone", length=15)

    public String getTelephonePhone() {
        return this.telephonePhone;
    }
    
    public void setTelephonePhone(String telephonePhone) {
        this.telephonePhone = telephonePhone;
    }
    
    @Column(name="email", length=20)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="address", length=200)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="avatar")

    public String getAvatar() {
        return this.avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    
    @Column(name="question", nullable=false, length=20)

    public String getQuestion() {
        return this.question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    @Column(name="answer", nullable=false, length=100)

    public String getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    @Column(name="registerTime",nullable=false, length=19)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRegisterTime() {
        return this.registerTime;
    }
    
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }


}