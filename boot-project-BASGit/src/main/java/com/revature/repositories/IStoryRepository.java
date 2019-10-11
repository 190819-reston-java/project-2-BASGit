package com.revature.repositories;

import java.util.Set;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.IStory;

public interface IStoryRepository {

	IStory findOne(int id);

	Set<IStory> findAll();

	IStory save(IStory story);

}