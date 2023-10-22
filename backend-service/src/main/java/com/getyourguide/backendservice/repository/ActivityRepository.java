package com.getyourguide.backendservice.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getyourguide.backendservice.bean.Activity;

@Component
public class ActivityRepository {
	private List<Activity> activities;
	
    private static final Logger logger = LoggerFactory.getLogger(ActivityRepository.class);
	
	public ActivityRepository() {
		this.activities = new ArrayList<>();
		int recordsRead = loadActivities();
		logger.info("Total activities read: " + recordsRead);
	}
	
	private int loadActivities() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ClassPathResource resource = new ClassPathResource("static/activities.json");
            InputStream inputStream = resource.getInputStream();
            activities = objectMapper.readValue(inputStream, new TypeReference<List<Activity>>() {
            });
        } catch (IOException e) {
        	logger.info("An Error occured while accessing json resources");
            e.printStackTrace();
        }
        return activities.size();
	}
	
	public List<Activity> getAllActivities() {
		return this.activities;
	}
	
	public List<Activity> filterByTitle(String title) {
		List<Activity> filteredActivity = new ArrayList<>();
		for(Activity activity : this.activities) {
			String activityTitleUpper = activity.getTitle().toUpperCase();
			String filterTitle = title.toUpperCase();
			if (activityTitleUpper.equals(filterTitle) || activityTitleUpper.startsWith(filterTitle) || activityTitleUpper.endsWith(filterTitle) || activityTitleUpper.contains(filterTitle)) {
				filteredActivity.add(activity);
			}
		}
		return filteredActivity;
	}
}
