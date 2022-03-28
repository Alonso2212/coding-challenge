package com.poker.poker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poker.poker.model.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	
}
