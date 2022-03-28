package com.poker.poker.service;

import java.util.List;

import com.poker.poker.model.Session;

public interface SessionService {

	List<Session> getSessions();
	Session getSession(Long id);
	Session createSession(String title);
	void deleteSession(Long id);
	
}
