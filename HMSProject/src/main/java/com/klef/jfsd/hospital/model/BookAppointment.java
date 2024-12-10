package com.klef.jfsd.hospital.model;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="BookAppointment_table")
public class BookAppointment {

  @Id
  @Column(name="BA_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name="BA_patientname",nullable=false,length = 30)
  private String name;
  @Column(name="BA_gender",nullable=false,length = 30)
  private String gender;
  @Column(name="BA_email",nullable=false,length = 30)
  private String email;
  @Column(name="BA_contactno",nullable=false,length = 30)
  private String contactno;
  @Column(name="BA_dept",nullable=false,length = 30)
  private String department;
  @Column(name="BA_doctorname",nullable=false,length = 30)
  private String doctorname;
  @Column(name="ApDate")
  private LocalDate apdate;
  @Column(name="ApTime")
  private String aptime;
  
  @Column(name="status")
  private String status;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
	//  @Column(name="BA_file",nullable = false)
//  private Blob image;
//  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	
	public LocalDate getApdate() {
		return apdate;
	}
	public void setApdate(LocalDate apdate) {
		this.apdate = apdate;
	}
	public String getAptime() {
		return aptime;
	}
	public void setAptime(String aptime) {
		this.aptime = aptime;
	}
//	public Blob getImage() {
//		return image;
//	}
//	public void setImage(Blob image) {
//		this.image = image;
//	}
//	 
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	  
}