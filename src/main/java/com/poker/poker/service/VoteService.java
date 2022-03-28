package com.poker.poker.service;

import java.util.List;

import com.poker.poker.model.Vote;

public interface VoteService {
	
	List<Vote> getVotesBySession(Long sessionId);	
	Vote createVote(Long sessionId, String value, Long userStoryId, String memberId);
	

}
