package com.poker.poker.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.poker.poker.model.UserStory;
import com.poker.poker.model.Vote;
import com.poker.poker.repository.UserStoryRepository;
import com.poker.poker.repository.VoteRepository;

@Service
@Transactional
public class VoteServiceImpl implements VoteService {

	@Autowired
	private VoteRepository voteRepository;
	@Autowired
	private UserStoryRepository userStoryRepository;
	@Override
	public List<Vote> getVotesBySession(Long sessionId) {
		try {
		Vote vote=new Vote();
		vote.setSessionId(sessionId);
		Example<Vote> example = Example.of(vote);
		List<Vote> votes = voteRepository.findAll(example);
		List<Vote> votesReturned =new ArrayList<Vote>();
		
		
		votes.forEach(e->{
			Vote voteToReturn = new Vote();
			voteToReturn.setId(e.getId());
			voteToReturn.setIdMember(e.getIdMember());
			voteToReturn.setIdUserStory(e.getIdUserStory());
			voteToReturn.setSessionId(e.getSessionId());
			voteToReturn.setValue("Confidential");			
			votesReturned.add(voteToReturn);
			
		});
		
		
		return votesReturned;
		}catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found");
		}
	}

	@Override
	public Vote createVote(Long sessionId, String value,Long userStoryId,String memberId) {		
		Vote vote = new Vote(); 
		vote.setSessionId(sessionId);
		vote.setValue(value);
		vote.setIdMember(memberId);
		vote.setIdUserStory(userStoryId);
		voteRepository.save(vote);
		UserStory userStory= userStoryRepository.getById(userStoryId);
		userStory.setVotes(userStory.getVotes()+1);
		userStoryRepository.save(userStory);
		return vote;
	}

}
