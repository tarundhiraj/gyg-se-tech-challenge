package com.getyourguide.backendservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getyourguide.backendservice.bean.Activity;
import com.getyourguide.backendservice.repository.ActivityRepository;

@Service
public class ActivityService {
    
    
    @Autowired
    private ActivityRepository activityRepository;
	
	
	public List<Activity> getActivities() {
		 return activityRepository.getAllActivities();
	}
	
	public List<Activity> getFilteredActivitiesByTitle(String title) {
		return activityRepository.filterByTitle(title);
	}
}
