package com.Infosys.SportsManagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Infosys.SportsManagement.Entity.EventUser;

public interface EventUserRepository extends JpaRepository<EventUser, String> {
    Optional<EventUser> findByUsername(String username);
    
    @Query("SELECT username from EventUser where type='Customer'")
    public List<String> findAllMemberUsers();
   }
