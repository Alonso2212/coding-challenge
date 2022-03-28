package com.poker.poker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.poker.poker.model.Member;
import com.poker.poker.model.Session;
import com.poker.poker.service.MemberService;

@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/sessions/{idSession}/members")
	public ResponseEntity<List<Member>> getMembersBySession(@PathVariable Long idSession){
		
		return ResponseEntity.ok().body(memberService.getMembers(idSession));
	}
	@PostMapping("/sessions/{idSession}/members")
	public ResponseEntity<Member> joinInSession(@PathVariable Long idSession,@RequestBody Member member){
		if (member.getIdMember()==null || member==null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "memberId is required");
		}
		
		return ResponseEntity.ok().body(memberService.joinSession(idSession, member));
	}
	
	@GetMapping("/sessions/{idSession}/members{idMember}")
	public  ResponseEntity<List<Member>> logutMember(@PathVariable Long idSession,@PathVariable String idMember){
		memberService.logOutMember(idMember, idSession);
		return ResponseEntity.ok().body(memberService.getMembers(idSession));
	}

}
