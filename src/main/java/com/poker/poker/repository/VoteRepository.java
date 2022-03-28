package com.poker.poker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poker.poker.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

}
