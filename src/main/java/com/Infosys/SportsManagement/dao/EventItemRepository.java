package com.Infosys.SportsManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Infosys.SportsManagement.Entity.EventItem;

public interface EventItemRepository extends JpaRepository<EventItem, Long> {
	@Query("select max(itemId) from EventItem")
	public Long findLastItemId();
	
	@Query("select totalSeat from EventItem where itemId=?1")
	public Integer findTotalSeatById(Long id);
}
