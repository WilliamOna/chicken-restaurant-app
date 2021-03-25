package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.BuffaloChicken;

@Repository
public interface BuffaloChickenRepository extends JpaRepository<BuffaloChicken, Integer>{

}
