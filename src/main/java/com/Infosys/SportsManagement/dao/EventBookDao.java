package com.Infosys.SportsManagement.dao;

import java.util.List;

import com.Infosys.SportsManagement.Entity.EventBook;

public interface EventBookDao {
    void save(EventBook gymBook);
    Long generateBookingId();
    List<EventBook> getBookList();
    EventBook findBookInfoById(Long id); // Removed static modifier
    void deleteById(Long id);
    List<EventBook> getBookingByUsername(String username);
    boolean isSlotBooked(Long slotId, String username);
}
