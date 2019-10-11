package com.revature.services;

import java.util.Set;

import com.revature.models.IStory;

public interface IStoryservice {

	IStory findOne(int id);

	Set<IStory> findAll();

	IStory save(IStory story);

}