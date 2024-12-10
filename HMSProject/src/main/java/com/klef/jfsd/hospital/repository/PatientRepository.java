package com.klef.jfsd.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.hospital.model.Doctor;
import com.klef.jfsd.hospital.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>
{
    @Query("select p from Patient p where p.email=?1 and p.password=?2")
    public Patient checkpatlogin(String pemail,String ppwd);
    
    @Query("from Doctor d where d.department=?1")
     public List<Doctor> viewalldoctorsbydepartment(String department);
    
    public Patient findByEmail(String email);
    
  
}