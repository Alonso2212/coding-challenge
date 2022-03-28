package com.poker.poker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.poker.poker.model.Session;
import com.poker.poker.repository.SessionRepository;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
	@Autowired
	private SessionRepository sessionRepository;
	
	@Override
	public List<Session> getSessions() {
		return sessionRepository.findAll();
	}
	@Override
	public Session getSession(Long id) {		
		try {
			return sessionRepository.findById(id).get();			
		}catch (Exception e) {			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found");
		}
	}
	@Override
	public Session createSession(String title) {
		Session session = new Session();
		session.setTitle(title);
		Long id = sessionRepository.save(session).getId();
		return sessionRepository.getById(id);
	}
	@Override
	public void deleteSession(Long id) {		
		try {
			sessionRepository.deleteById(id);			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Session not found");
			
		}
	}
}
