package com.klef.jfsd.hospital.service;

import java.util.List;

import com.klef.jfsd.hospital.model.BookAppointment;
import com.klef.jfsd.hospital.model.Doctor;

import com.klef.jfsd.hospital.model.Patient;
import com.klef.jfsd.hospital.model.Prescription;

public interface PatientService 
{
     public String patientRegistration(Patient pat);
     public Patient checkpatlogin(String email,String pwd);
    // public String updatePatientProfile(Patient patient);
     public Patient displaypatientbyID(int pid);
     
     public String addAppointment(BookAppointment appointment);
     public List<Doctor> ViewAllDoctors();
     public List<Doctor> viewalldoctorsbydepartment(String department);

     public Patient myprofile(String email);
     public String updatepatientprofile(Patient p);
     public List<BookAppointment> viewmyappointments(String email);
     
     public List<Prescription> myprescription(String email);	
     

}