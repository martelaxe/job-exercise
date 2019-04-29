package com.job.exercise.repository;

import org.springframework.data.repository.CrudRepository;

import com.job.exercise.model.UserList;

public interface UserListRepository extends CrudRepository<UserList, Integer> {}  