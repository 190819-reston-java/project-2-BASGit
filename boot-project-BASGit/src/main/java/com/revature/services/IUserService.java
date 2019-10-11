package com.revature.services;

import java.util.Set;

import com.revature.models.IUser;

public interface IUserService {

	IUser findOne(int id);

	Set<IUser> findAll();

	IUser save(IUser user);

}