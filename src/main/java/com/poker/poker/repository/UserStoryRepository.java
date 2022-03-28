package com.poker.poker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poker.poker.model.UserStory;

public interface UserStoryRepository extends JpaRepository<UserStory, Long>{

}
