package com.Infosys.SportsManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Infosys.SportsManagement.Entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback , Long> {
	@Query("select max(fId) from Feedback")
	  public Long findLastFeedbackId();

}
