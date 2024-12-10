package com.klef.jfsd.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.hospital.model.Admin;
import com.klef.jfsd.hospital.model.Doctor;
import com.klef.jfsd.hospital.model.Patient;

import com.klef.jfsd.hospital.service.AdminService;

@RestController
@RequestMapping("hms")
public class AdminController 
{
	@Autowired
	private AdminService adminservice;
	
	
	@GetMapping("/count")
    public Map<String, Object> count() {
        Map<String, Object> response = new HashMap<>();
        
        // Fetch the counts for doctors, patients, pharmacists, and booked appointments
        response.put("doctorCount", adminservice.drcount());
        response.put("prescriptionCount", adminservice.prcount());
        response.put("patientCount", adminservice.ptcount());

        // Fetch monthly booked appointments, which returns List<Object[]>
        List<Object[]> monthlyBookings = adminservice.bookedAppointcount();
        response.put("monthlyBookings", monthlyBookings);

        return response;
    }
	
	
	@PostMapping("checkadminlogin")
	public Admin checkdoctorlogin(@RequestBody Admin request)
	{
		String username=request.getUsername();
		String password=request.getPassword();
		//System.out.println(email);
		//System.out.println(password);
		Admin a=adminservice.checkadminlogin(username, password);
		System.out.println(a);
		return a;
	}

	@PostMapping("adddoctor")
	public String  adddoctor(@RequestBody Doctor doctor )
	{
		return adminservice.adddoctor(doctor);
	}
	
	
	
	@GetMapping("viewalldr")
	public List<Doctor> viewalldoctors()
	{
		
		return adminservice.displayallDoctors();
	}
	
	
	@GetMapping("viewallpt")
	public List<Patient> viewallstudents()
	
	{
		System.out.println(adminservice.viewAllPatients());
		return adminservice.viewAllPatients();
	}
	
	
	
	@DeleteMapping("deletedoctor")
	public String deletedoctor(@RequestParam("id") int id)
	{
		return adminservice.deletedr(id);
	}
	
	@DeleteMapping("deletepatient/{id}")
	public String deletepatient(@PathVariable("id") int id)
	{
		return adminservice.deletepat(id);
	}
	
	@DeleteMapping("deletepharmacist/{id}")
	public String deletepharamacist(@PathVariable("id") int id)
	{
		return adminservice.deletept(id);
	}
	
	@GetMapping("displaydr")
	public Doctor diplaydoctorbyid(@RequestParam("id") int did)
	{
		return adminservice.displayDoctorByID(did);
	}
	
	@GetMapping("displaypa")
	public Patient diplaypatientbyid(@RequestParam("id") int pid)
	{
		return adminservice.displayPatientByID(pid);
	}
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
		
	
	
	
	

}
