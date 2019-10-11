package com.revature.repositories;

import java.util.Set;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.IUser;

public interface IUserRepository {

	IUser findOne(int id);

	Set<IUser> findAll();

	IUser save(IUser user);

}