package com.klef.jfsd.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import jakarta.transaction.Transactional;
import com.klef.jfsd.hospital.model.BookAppointment;

@Repository
public interface BookAppointmentRepository  extends JpaRepository<BookAppointment, Integer>{
	
	 @Query("select d from BookAppointment d where d.doctorname=?1 and d.status='PENDING'")
	public List<BookAppointment> viewallbookedappoint(String doctorname);

	 
	 @Query("select d from BookAppointment d where d.doctorname=?1 and d.status='ACCEPTED'")
		public List<BookAppointment> viewallapprovedappoint(String doctorname);

	 
	@Query("SELECT EXTRACT(MONTH FROM b.apdate) AS month, COUNT(b) AS bookingCount " +
	        "FROM BookAppointment b GROUP BY EXTRACT(MONTH FROM b.apdate) ORDER BY month")
	public List<Object[]> getMonthlyBookings();

	    @Query("update  BookAppointment b set b.status=?2 where b.id=?1 ")
	    @Modifying //DML 
	    @Transactional  //To enable auto commit
	    public int updatestatus(int id,String status);
	    
	public List<BookAppointment> findByEmail(String Email);
	
	@Query("select count(b) from BookAppointment b where b.doctorname = ?1 and b.status = 'PENDING'")
	public Long countPendingAppointments(String doctorname);

	@Query("select count(b) from BookAppointment b where b.doctorname = ?1 and b.status = 'ACCEPTED'")
	public Long countAcceptedAppointments(String doctorname);


}
