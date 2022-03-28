package com.poker.poker.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Member {
	@Id	
	@Column(name="idMember")
	private String idMember;
	@Column(name="name")
	private String name;
	@Column(name="idSession")
	private Long idSession;
	
	@OneToMany	
	private List<UserStory> userStory;
	
	public String getIdMember() {
		return idMember;
	}
	public void setIdMember(String idMember) {
		this.idMember = idMember;
	}
	public Long getIdSession() {
		return idSession;
	}
	public List<UserStory> getUserStory() {
		return userStory;
	}
	public void setUserStory(List<UserStory> userStory) {
		this.userStory = userStory;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
	private String invitationLink;
	
	public String getInvitationLink() {
		return invitationLink;
	}
	public void setInvitationLink(String invitationLink) {
		this.invitationLink = invitationLink;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
