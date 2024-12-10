package com.klef.jfsd.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prescription_table")
public class Prescription {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) 
@Column(name="prescriptionid")
private int prescriptionid;
@Column(name="patient_id",nullable=false,length = 50)
private int id;
@Column(name="patient_email",nullable=false,length = 50)
private String email;
@Column(name="patient_gender",nullable=false,length = 50)
private String gender;
@Column(name="doctorname",nullable=false,length = 50)
private String doctorname;
@Column(name="department",nullable=false,length = 50)
private String department;
@Column(name="prescrip_medicine",nullable=false,length = 1000)
private String medicine;
@Column(name="prescrip_additionalinformation",nullable=false,length = 1000)
private String additionalinformation;
@Column(name="prescrip_date")
private String date;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDoctorname() {
	return doctorname;
}
public void setDoctorname(String doctorname) {
	this.doctorname = doctorname;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getMedicine() {
	return medicine;
}
public void setMedicine(String medicine) {
	this.medicine = medicine;
}
public String getAdditionalinformation() {
	return additionalinformation;
}
public void setAdditionalinformation(String additionalinformation) {
	this.additionalinformation = additionalinformation;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
}
