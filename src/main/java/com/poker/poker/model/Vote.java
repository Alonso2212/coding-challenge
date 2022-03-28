package com.poker.poker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class Vote {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;		
	@Column(name="idMember")
	private String idMember;
	@Column(name="idUserStory")
	private Long idUserStory;
	@Column(name="sessionid")
	private Long sessionId;
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	@Column(name="value")
	private String value;
	
	public String getIdMember() {
		return idMember;
	}
	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}
	public Long getIdUserStory() {
		return idUserStory;
	}
	public void setIdUserStory(Long idUserStory) {
		this.idUserStory = idUserStory;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
