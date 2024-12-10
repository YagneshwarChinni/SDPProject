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
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.hospital.model.BookAppointment;
import com.klef.jfsd.hospital.model.Doctor;
import com.klef.jfsd.hospital.model.Patient;
import com.klef.jfsd.hospital.model.Prescription;
import com.klef.jfsd.hospital.service.DoctorService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import jakarta.mail.internet.MimeMessage;

@RestController
@RequestMapping("hms")
public class DoctorController {

	@Autowired
	private DoctorService doctorservice;
	
	 @Autowired
	    private JavaMailSender mailSender;
	
	@GetMapping("/")
	public String home()
	{
		return "Welcome to SSB Hospital";
	}
	                                       
	
	
	@PostMapping("checkdoctorlogin")
	public Doctor checkdoctorlogin(@RequestBody Doctor request)
	{
		String email=request.getEmail();
		String password=request.getPassword();
		//System.out.println(email);
		//System.out.println(password);
		Doctor doctor=doctorservice.checkdoctorlogin(email, password);
		System.out.println(doctor);
		return doctor;
	}
	   
	   @PutMapping("updatedoctorprofile")
	   public String updatedoctorprofile(@RequestBody Doctor d)
	   {
		 
		  try {
			  
			   String s=doctorservice.updatedoctorprofile(d);
			   
			   return s;
		  }
		  catch(Exception e)
		  {
			  return e.toString();
		  }
	   }
	   
//	   @GetMapping("doctorprofile/{email}")
//	   public Doctor doctorprofile( @PathVariable("email") String email)
//	   {
//		   return doctorservice.myprofile(email);
//	   }
//	   
	   
//	   @GetMapping("viewallpatients")
//	   public List<Patient> viewallpatients()
//	   {
//		 return doctorservice.viewallpatients();
//	   }
	   
	   @GetMapping("viewallbookedappointments")
	   public List<BookAppointment> viewallBookedAppointments(@RequestParam String doctorname)
	   {
		 return doctorservice.viewallBookedAppointments(doctorname);
	   }
	   
	   
	   
	   @GetMapping("viewallapprovedappoint")
	   public List<BookAppointment> viewallapprovedappoint(@RequestParam String doctorname)
	   {
		 return doctorservice.viewallApprovedAppointments(doctorname);
	   }
	   

		@PostMapping("changepatientstatus")
		public String changepatientstatus(@RequestParam int id,@RequestParam String status)
		{
			doctorservice.updateconsultantstatus(id, status);
			return "Status updated successfully!";
		}
	   
		@PostMapping("/sendemail")
		    public String sendEmail(
		    		    @RequestParam("patientmail") String email,
		    		    @RequestParam("meetingLink") String meetingLink,
		    		    @RequestParam("doctorname") String doctorName
		    ) {
		        try {
		            // Create a MimeMessage
		            MimeMessage mimeMessage = mailSender.createMimeMessage();
		            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		            // Set the email details
		            helper.setTo(email);
		            helper.setSubject("Online Consultation Meeting with Dr. " + doctorName);
		            helper.setFrom("sathyavathani.nandha@gmail.com");

		            // Create the email content
		            String htmlContent =
		                "<h3>Online Consultation Details</h3>" +
		                "<p><strong>Doctor:</strong> Dr. " + doctorName + "</p>" +
		                "<p><strong>Meeting Link:</strong> <a href='" + meetingLink + "'>" + meetingLink + "</a></p>";

		            helper.setText(htmlContent, true); // Enable HTML content

		            // Send the email
		            mailSender.send(mimeMessage);

		            return "Email Sent Successfully!";
		        } catch (Exception e) {
		            e.printStackTrace();
		            return "Error while sending email: " + e.getMessage();
		        }
		    }
				@PostMapping("/addprescription")
		public String addprescription(@RequestBody Prescription p) {
		    System.out.println("Received Prescription: " + p);
		    return doctorservice.addprescription(p);
		}
		
		@GetMapping("/pendingappointcount")
		public Long PendingAppointments(  @RequestParam("doctorname")  String doctorname) {
			
		    return doctorservice.getPendingAppointments(doctorname);
		}
		@GetMapping("/acceptedappointscount")
		public Long AcceptedAppointmentst(@RequestParam("doctorname") String doctorname) {
			
		    return doctorservice.getAcceptedAppointments(doctorname);
		}
		

}
