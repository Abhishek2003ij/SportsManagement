package com.Infosys.SportsManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Infosys.SportsManagement.Entity.EventBook;



public interface EventBookRepository extends JpaRepository<EventBook, Long> {

	@Query("select max(bookingId) from EventBook")
	public Long findLastBookingId();
	
	@Query("SELECT gb FROM EventBook gb WHERE gb.username = :username")
	List<EventBook> findByUsername(String username);
	
	@Query("SELECT CASE WHEN COUNT(gb) > 0 THEN true ELSE false END FROM EventBook gb WHERE gb.username = :username AND gb.slotId = :slotId")
    boolean isSlotBooked(@Param("slotId") Long slotId, @Param("username") String username);
}
