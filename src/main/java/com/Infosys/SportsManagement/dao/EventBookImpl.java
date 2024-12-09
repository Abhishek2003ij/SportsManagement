package com.Infosys.SportsManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Infosys.SportsManagement.Entity.EventBook;


@Service
@Repository
public class EventBookImpl implements EventBookDao {
 @Autowired
 private EventBookRepository repository;

 @Override
 public void save(EventBook eventBook) {
  repository.save(eventBook);
 }

 @Override
 public Long generateBookingId() {
  Long newId=repository.findLastBookingId();
  if(newId==null) {
   newId=1000001L;
  }
  else {
   newId=newId+1L;
  }
  return newId;
 }

 @Override
 public List<EventBook> getBookList() {
  return repository.findAll();
 }

 @Override
 public EventBook findBookInfoById(Long id) {
  // TODO Auto-generated method stub
  return repository.findById(id).get();
 }
 
 @Override
 public void deleteById(Long id) {
  repository.deleteById(id);
 }

@Override
public List<EventBook> getBookingByUsername(String username) {
	return repository.findByUsername(username);
}

public boolean isSlotBooked(Long slotId, String username) {
   return repository.isSlotBooked(slotId, username);
}
 
}
