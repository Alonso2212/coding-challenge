package com.poker.poker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.poker.poker.model.UserStory;
import com.poker.poker.repository.UserStoryRepository;

@Service
@Transactional
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	private UserStoryRepository storyRepository;
	
	@Override
	public List<UserStory> getUserStoriesBySession(Long sessionId) {
		
		UserStory userStory = new UserStory();
		userStory.setIdSession(sessionId);		
		Example<UserStory> example = Example.of(userStory);
		return storyRepository.findAll(example);
		
	}

	@Override
	public UserStory createUserStory(Long sessionId, UserStory userStory) {		
		UserStory story = new UserStory();
		story.setDescription(userStory.getDescription());
		story.setIdMember(userStory.getIdMember());
		story.setStatus("PENDING");
		story.setIdSession(sessionId);
		story.setVotes((long) 0);
		Long id=storyRepository.save(story).getId();
		return storyRepository.getById(id);		
	}

	@Override
	public UserStory updateUserStory(Long sessionId, UserStory userStory,Long userStoryId) {
		
		
		UserStory storyUpdate = new UserStory();
		try {
			if(storyRepository.getById(userStoryId)!=null) {
			storyUpdate.setId(userStoryId);
			storyUpdate.setDescription(userStory.getDescription());
			storyUpdate.setIdSession(sessionId);
			storyUpdate.setIdMember(userStory.getIdMember());
			storyUpdate.setStatus("VOTING");
			storyUpdate.setVotes((long) 0);
			storyRepository.save(storyUpdate);
			return storyUpdate;	
			}else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not update, user story not found");	
			}
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not update, user story not found");
		}
		
		
	}

	@Override
	public void deleteUserStory(Long sessionId, Long storyId) {
		try {		
		storyRepository.deleteById(storyId);
		}catch(Exception e) {			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not delete, user story not found");
		}
		
	}

	@Override
	public UserStory getUserStory(Long Id) {
		
		return storyRepository.getById(Id);
	}

}
