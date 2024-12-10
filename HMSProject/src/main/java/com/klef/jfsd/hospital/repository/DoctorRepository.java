package com.klef.jfsd.hospital.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.hospital.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	@Query("select d from Doctor d where d.email=?1 and d.password=?2")
	public Doctor checkdoctorlogin(String email,String password);
	
	public Doctor findByEmail(String email);
	
}
