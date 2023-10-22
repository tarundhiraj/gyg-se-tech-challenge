package com.getyourguide.backendservice.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.getyourguide.backendservice.bean.Activity;
import com.getyourguide.backendservice.service.ActivityService;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/activity")
public class ActivityController {
    
    @Autowired
    private ActivityService activityService;
    
    private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);

    @GetMapping("/debug")
    public void debug(@RequestParam(name = "title", required = false, defaultValue = "NONE") String title, Model model) {
        try {
            model.addAttribute("title", title);
            List<Activity> activities = activityService.getActivities();
            model.addAttribute("activities", activities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @GetMapping(params = "title")
    public ResponseEntity<List<Activity>> filteredActivities(@RequestParam("title") String titleFilter) throws IOException{
        List<Activity> activities = activityService.getFilteredActivitiesByTitle(titleFilter);
        logger.info("Fetched " + activities.size() + " Activities for filter " + titleFilter);
        return ResponseEntity.ok(activities);
    }

    @GetMapping
    public ResponseEntity<List<Activity>> activities() throws IOException{
        List<Activity> activities = activityService.getActivities();
        logger.info("Fetched " + activities.size() + " Activities");
        return ResponseEntity.ok(activities);
    }
    
   
}