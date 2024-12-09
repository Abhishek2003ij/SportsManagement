package com.Infosys.SportsManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Infosys.SportsManagement.Entity.EventUser;
import com.Infosys.SportsManagement.dao.EventUserRepository;

@Service
public class EventUserService implements UserDetailsService {
   @Autowired
   private EventUserRepository repository;
   private String type;
   private EventUser users;
   
   public void save(EventUser user) {
    repository.save(user);
   }
   
   public String getType() {
    return type;
   }
   
   public void delete(String username) {
	    repository.deleteById(username);
   }
   
   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       users = repository.findByUsername(username).get();
       type = users.getType();
       return users;
   }

   public EventUser findByUsername(String username) {
       return repository.findByUsername(username).orElse(null);
   }
   
   public EventUser getUser()  {
	   return users;
   }
   
   public List<String> getAllMembers() {
	   return repository.findAllMemberUsers();
   }
   
   public List<EventUser> getAllUsers() {
	   return repository.findAll();
   }
   
}
