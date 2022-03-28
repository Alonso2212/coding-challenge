package com.poker.poker.service;

import java.util.List;

import com.poker.poker.model.UserStory;

public interface UserStoryService {

	List<UserStory> getUserStoriesBySession(Long sessionId);
	UserStory getUserStory(Long Id);
	UserStory createUserStory(Long sessionId,UserStory userStory);
	UserStory updateUserStory(Long sessionId,UserStory userStory,Long userStoryId);
	void deleteUserStory(Long sessionId,Long storyId);
	
}
