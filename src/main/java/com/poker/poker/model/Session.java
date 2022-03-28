package com.poker.poker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idsession")
	private Long idSession;
	@Column(name="title")
	private String title;
	
	
	
	
	public Long getIdSession() {
		return idSession;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public Long getId() {
		return idSession;
	}
	public void setId(Long idSession) {
		this.idSession = idSession;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	

}
