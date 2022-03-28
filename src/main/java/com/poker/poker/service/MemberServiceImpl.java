package com.poker.poker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.poker.poker.model.Member;
import com.poker.poker.model.UserStory;
import com.poker.poker.repository.MemberRepository;
import com.poker.poker.repository.SessionRepository;
import com.poker.poker.repository.UserStoryRepository;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private UserStoryRepository userStoryRepository; 

	@Override

	public List<Member> getMembers(Long sessionId) {
	Member member = new Member();
	member.setIdSession(sessionId);
	Example<Member> example = Example.of(member);
	return memberRepository.findAll(example);
	}

	@Override
	public Member joinSession(Long sessionId,Member member) {

		try {
			
				Member updateMember = new Member();
				updateMember.setIdMember(member.getIdMember());
				updateMember.setName(member.getName());
				updateMember.setIdSession(sessionId);
				updateMember.setInvitationLink("http://localhost:8080//sessions/"+sessionId.toString()+"/members");
				memberRepository.save(updateMember);	
				
				UserStory userStory = new UserStory();
				userStory.setIdSession(sessionId);		
				Example<UserStory> example = Example.of(userStory);
				updateMember.setUserStory(userStoryRepository.findAll(example));
				
				return updateMember;
			
		}catch (Exception e) {
 			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session does not exist");			
		}
		
		

	}

	@Override
	public void logOutMember(String memberId, Long sessionId) {
		
		try {
			Member member = new Member();
			member= memberRepository.getById(memberId);
			member.setIdSession(null);
			memberRepository.save(member);			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No member found in session");			
		}
		
	}

	@Override
	public Member getMember(String memberId) {
		return memberRepository.getById(memberId);
	}

}
