package com.klef.jfsd.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor_table")
public class Doctor 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   @Column(name="dr_id")
   private int id;
   @Column(name="dr_name",nullable=false,length = 50)
   private String name;
   @Column(name="dr_gender",nullable=false,length = 20)
   private String gender;
   @Column(name="dr_dob",nullable=false,length = 20)
   private String dateofbirth;
   @Column(name="dr_department",nullable=false,length = 50)
   private String department;
   @Column(name="dr_salary",nullable=false)
   private double salary;
   @Column(name="dr_email",nullable=false,unique = true,length = 50)
   private String email;
   @Column(name="dr_password",nullable=false,length = 50)
   private String password;
   @Column(name="dr_location",nullable=false,length=50)
   private String location;
   
   @Column(name="dr_contact",nullable=false,length = 20)
   private String contact;
//   @Column(name="dr_status",nullable=false,length = 50)
//   private String status;
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
  public String getDateofbirth() {
    return dateofbirth;
  }
  public void setDateofbirth(String dateofbirth) {
    this.dateofbirth = dateofbirth;
  }
  public String getDepartment() {
    return department;
  }
  public void setDepartment(String department) {
    this.department = department;
  }
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String getContact() {
    return contact;
  }
  public void setContact(String contact) {
    this.contact = contact;
  }
//  public String getStatus() {
//    return status;
//  }
//  public void setStatus(String status) {
//    this.status = status;
//  }
  

}