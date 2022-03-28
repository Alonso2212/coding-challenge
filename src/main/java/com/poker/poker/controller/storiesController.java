package com.poker.poker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.poker.poker.model.UserStory;

import com.poker.poker.service.UserStoryService;

@RestController
public class storiesController {
	
	@Autowired
	private UserStoryService userStoryService;
	
	@GetMapping("/sessions/{idSession}/stories")
	public ResponseEntity<List<UserStory>> getStoriesBySession(@PathVariable Long idSession){		
		return ResponseEntity.ok().body(userStoryService.getUserStoriesBySession(idSession));
	}
	
	@PostMapping("/sessions/{idSession}/stories")
	public ResponseEntity<UserStory> createStory(@PathVariable Long idSession,@RequestBody UserStory userStory){		
		return ResponseEntity.ok().body(userStoryService.createUserStory(idSession,userStory));
	}

	@PutMapping("/sessions/{idSession}/stories/{userStoryId}")
	public ResponseEntity<UserStory> updateStory(@PathVariable Long idSession,@PathVariable Long userStoryId,@RequestBody UserStory userStory){		
		return ResponseEntity.ok().body(userStoryService.updateUserStory(idSession, userStory,userStoryId));
	}
	
	@DeleteMapping("/sessions/{idSession}/stories/{userStoryId}")
	public ResponseEntity<List<UserStory>> deleteStory(@PathVariable Long idSession,@PathVariable Long userStoryId,@RequestBody UserStory userStory){		
		userStoryService.deleteUserStory(idSession, userStoryId);
		return ResponseEntity.ok().body(userStoryService.getUserStoriesBySession(idSession));
	}
	
	

}
