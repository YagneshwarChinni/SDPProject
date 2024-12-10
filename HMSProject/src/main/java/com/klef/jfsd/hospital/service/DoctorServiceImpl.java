package com.klef.jfsd.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.hospital.model.BookAppointment;
import com.klef.jfsd.hospital.model.Doctor;
import com.klef.jfsd.hospital.model.Patient;
import com.klef.jfsd.hospital.model.Prescription;
import com.klef.jfsd.hospital.repository.BookAppointmentRepository;
import com.klef.jfsd.hospital.repository.DoctorRepository;
import com.klef.jfsd.hospital.repository.PatientRepository;
import com.klef.jfsd.hospital.repository.PrescriptionRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorrepository;
	
	@Autowired
	private PatientRepository patientrepository;
	
	@Autowired
	private BookAppointmentRepository bookedrepo;
	
	@Autowired
	private PrescriptionRepository prescriptionrepo;
//	
//	@Override
//	public String doctorRegistration(Doctor d) {
//		doctorrepository.save(d);
//		return "Doctor Registered Successfully";
//	}

	@Override
	public Doctor checkdoctorlogin(String email ,String password) {
		
	System.out.println(doctorrepository.checkdoctorlogin(email, password));
		return doctorrepository.checkdoctorlogin(email, password);
		
	}

	@Override
	public String updatedoctorprofile(Doctor d) {
		
		Doctor doctor=doctorrepository.findByEmail(d.getEmail());
		
		if(d.getContact()!=null)
		{
			doctor.setContact(d.getContact());
		}
		if(d.getDateofbirth()!=null)
		{
			doctor.setDateofbirth(d.getDateofbirth());
		}
		if(d.getName()!=null)
		{
			doctor.setName(d.getName());
		}
		if(d.getPassword()!=null)
		{
			doctor.setPassword(d.getPassword());
		}
		if(d.getLocation()!=null)
		{
			doctor.setLocation(d.getLocation());
		}
		 doctorrepository.save(doctor);
		 return "Doctor Profile Updated Successfully";
		
	}



	@Override
	public List<BookAppointment> viewallBookedAppointments(String doctorname) {
		
		return bookedrepo.viewallbookedappoint(doctorname);
	}


	@Override
	public int updateconsultantstatus(int id, String status) {
		
		return bookedrepo.updatestatus(id, status);
	}

	@Override
	public List<BookAppointment> viewallApprovedAppointments(String doctorname) {
		return bookedrepo.viewallapprovedappoint(doctorname);
	}

	@Override
	public String addprescription(Prescription p) {
		
		prescriptionrepo.save(p);
		return "Prescription Added Successfully";
	}

	@Override
	public Long getPendingAppointments(String doctorname) {
		
		return bookedrepo.countPendingAppointments(doctorname);
	}

	@Override
	public Long getAcceptedAppointments(String doctorname) {
		
		return bookedrepo.countAcceptedAppointments(doctorname);
	}

	
	

	


}
