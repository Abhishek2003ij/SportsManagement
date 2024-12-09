package com.Infosys.SportsManagement.dao;

import java.util.List;

import com.Infosys.SportsManagement.Entity.Feedback;

public interface FeedbackDao {
	public void saveNewFeedback(Feedback feedback);
    public List<Feedback> displayAllFeedbacks(); 
    public Long generateFeedbackId();
}
