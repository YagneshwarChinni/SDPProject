package com.klef.jfsd.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.hospital.model.BookAppointment;
import com.klef.jfsd.hospital.model.Doctor;

import com.klef.jfsd.hospital.model.Patient;
import com.klef.jfsd.hospital.model.Prescription;
import com.klef.jfsd.hospital.service.PatientService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("hms")
public class PatientController 
{
	@Autowired
	private PatientService patientService;


	@PostMapping("patreg")
	public String patreg(@RequestBody Patient patient) {
		return patientService.patientRegistration(patient); 
	}

	@PostMapping("insertpat")
	public String insertpat(HttpServletRequest request, HttpSession session) {
		String name = request.getParameter("pname");
		String gender = request.getParameter("pgender");
		String dob = request.getParameter("pdob");
		String location = request.getParameter("plocation");
		String email = request.getParameter("pemail");
		String password = request.getParameter("ppwd");
		String contact = request.getParameter("pcontact");

		Patient pat = new Patient();
		pat.setName(name);
		pat.setGender(gender);
		pat.setDateofbirth(dob);
		pat.setLocation(location);
		pat.setEmail(email);
		pat.setPassword(password);
		pat.setContact(contact);

		String msg = patientService.patientRegistration(pat);
		session.setAttribute("message", msg);
		return "regsuccess";
	}

	@PostMapping("checkpatlogin")
	public Patient checkpatlogin(@RequestBody Patient request) {
	    String pemail = request.getEmail();
	    String ppwd = request.getPassword();

	    Patient pat = patientService.checkpatlogin(pemail, ppwd);

	    System.out.println("patient details"+pat);
	    return pat; // return patient object if login is successful
	}

	
	@PostMapping("/addappointment")
	  public String addappointment(@RequestBody BookAppointment appointment) 
	  {
	    System.out.println(appointment);
	  return patientService.addAppointment(appointment);
	  }
	
	
	  
	  @GetMapping("/viewalldoctors")
	  public List<Doctor> viewalldoctors()
  {
		  System.out.println("All doctors list"+patientService.ViewAllDoctors());
	    return patientService.ViewAllDoctors();
	  }
	  
	   @GetMapping("viewdoctorsbydepartment")
	   public List<Doctor> viewdoctorsbydepartment(@RequestParam String department)
	   {
	        List<Doctor> doctors = patientService.viewalldoctorsbydepartment(department);
	        return doctors;

	   }
	   
	   @PutMapping("updatepatientprofile")
	   public String updatepatientprofile(@RequestBody Patient p)
	   {
		 
		  try {
			  
			   String s=patientService.updatepatientprofile(p);
			   
			   return s;
		  }
		  catch(Exception e)
		  {
			  return e.toString();
		  }
	   }
	   
	   @GetMapping("viewmyappointments")
	   public List<BookAppointment> viewmyappointments(@RequestParam String email)
	   {
	        return patientService.viewmyappointments(email);

	   }
	   
	   
	   
	   @GetMapping("patientprofile/{email}")
	   public Patient doctorprofile( @PathVariable("email") String email)
	   {
		   return patientService.myprofile(email);
	   }
	   
	   @GetMapping("/viewallmyprescription")
		  public List<Prescription> viewallmyprescription(@RequestParam String email)
	  {
			 
		    return patientService.myprescription(email);
		  }
	   
	   
}
