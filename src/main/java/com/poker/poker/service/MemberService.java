package com.poker.poker.service;

import java.util.List;

import com.poker.poker.model.Member;
import com.poker.poker.model.Session;

public interface MemberService {
	
	List<Member> getMembers(Long sessionId);	
	Member getMember(String memberId);
	Member joinSession(Long sessionId,Member member);
	void logOutMember(String memberId, Long sessionId);

}
