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
public class PatientServiceImpl implements PatientService 
{
	
  @Autowired
  private PatientRepository patientRepository;

  @Autowired
  private BookAppointmentRepository bookappointmentRepository;
  
  @Autowired
  private DoctorRepository doctorRepository;
  
  @Autowired
  private PrescriptionRepository prescriptionRepo;
  

  
  @Override
  public String patientRegistration(Patient pat) {
    patientRepository.save(pat);
    return "Patient Registered Successfully";
  }

  @Override  
  public Patient checkpatlogin(String email, String pwd) {
    return patientRepository.checkpatlogin(email, pwd);
  }



  @Override
  public Patient displaypatientbyID(int pid) {
    return patientRepository.findById(pid).get();
  }

  @Override
  public String addAppointment(BookAppointment appointment)
  {
	appointment.setStatus("PENDING");
    bookappointmentRepository.save(appointment);
    return "Appointment should be approved by Doctor. Thank you for Booking!!!";
  }

  @Override
  public List<Doctor> ViewAllDoctors() {
    return (List<Doctor>)doctorRepository.findAll();
  }

  @Override
  public List<Doctor> viewalldoctorsbydepartment(String department) {
    return patientRepository.viewalldoctorsbydepartment(department);
  }

  @Override
  public String updatepatientprofile(Patient p) {
      Patient patient = patientRepository.findByEmail(p.getEmail());

      if (patient == null) {
          throw new RuntimeException("Patient with email " + p.getEmail() + " not found.");
      }

      if (p.getContact() != null && !p.getContact().equals(patient.getContact())) {
          patient.setContact(p.getContact());
      }
      if (p.getDateofbirth() != null && !p.getDateofbirth().equals(patient.getDateofbirth())) {
          patient.setDateofbirth(p.getDateofbirth());
      }
      if (p.getName() != null && !p.getName().equals(patient.getName())) {
          patient.setName(p.getName());
      }
      if (p.getPassword() != null && !p.getPassword().equals(patient.getPassword())) {
          patient.setPassword(p.getPassword());
      }
      if (p.getLocation() != null && !p.getLocation().equals(patient.getLocation())) {
          patient.setLocation(p.getLocation());
      }

      patientRepository.save(patient);
      return "Patient Profile Updated Successfully";
  }

@Override
public List<BookAppointment> viewmyappointments(String email) {
	return bookappointmentRepository.findByEmail(email);
	
}

@Override
public Patient myprofile(String email) {
	
	Patient patient= (Patient)patientRepository.findByEmail(email);
	return patient;
	
}

@Override
public List<Prescription> myprescription(String email) {
	
	return prescriptionRepo.myprescription(email);
}


}