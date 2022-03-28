package com.poker.poker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.poker.poker.model.Vote;
import com.poker.poker.service.UserStoryService;
import com.poker.poker.service.VoteService;

@RestController
public class VoteController {
	
	@Autowired
	private VoteService voteService;
	@Autowired
	private UserStoryService userStoryService;
	
	@GetMapping("/sessions/{idSession}/votes")
	public ResponseEntity<List<Vote>> getVotesBySession(@PathVariable Long idSession){
		return ResponseEntity.ok().body(voteService.getVotesBySession(idSession));
	}
	@PostMapping("/sessions/{idSession}/votes")
	public ResponseEntity<Vote> emitVote(@PathVariable Long idSession,@RequestBody Vote vote){
		if(userStoryService.getUserStory(vote.getIdUserStory()).getStatus() =="VOTING") {
			return ResponseEntity.ok().body(voteService.createVote(idSession, vote.getValue(), vote.getIdUserStory(), vote.getIdMember()));			
		}else {
			return ResponseEntity.badRequest().body(vote);
		}
	}

}
