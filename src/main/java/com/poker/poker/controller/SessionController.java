package com.poker.poker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.poker.poker.model.Session;
import com.poker.poker.service.SessionService;

@RestController
public class SessionController {
	
	@Autowired
	private SessionService sessionService;
	
	@PostMapping("/sessions")
	public ResponseEntity<Session> createSession(@RequestBody Session session){	
		if(session.getTitle()=="" || session.getTitle()==null) {			
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Session title is required");
		}
		
		Long id= sessionService.createSession(session.getTitle()).getId();
		Session responseSession = new Session();
		responseSession.setId(id);
		responseSession.setTitle(session.getTitle());
		//To do crear link de invitacion
		return ResponseEntity.ok().body(sessionService.getSession(id));
	}
	
	@GetMapping("/sessions")
	public ResponseEntity<List<Session>> getSessions(){
		return ResponseEntity.ok().body(sessionService.getSessions());
	}
	
	@GetMapping("/sessions/{id}")
	public ResponseEntity<Session> getSession(@PathVariable long id){
		return ResponseEntity.ok().body(sessionService.getSession(id));
	}
	@DeleteMapping("/sessions/{id}")
	public ResponseEntity<Session> deleteSession(@PathVariable long id){
		Session session = new Session();
		session = sessionService.getSession(id);
		try {
		sessionService.deleteSession(id);
		return ResponseEntity.ok().body(session);
		}catch(Exception e) {
			System.out.println("entra");
		}
		return null;
	}
	
}
