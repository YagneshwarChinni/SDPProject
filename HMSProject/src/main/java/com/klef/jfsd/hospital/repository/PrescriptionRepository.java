package com.klef.jfsd.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.hospital.model.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

	@Query("select p from Prescription p where p.email=?1")
	public List<Prescription> myprescription(String email);
}
