package com.job.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.exercise.model.UserList;
import com.job.exercise.repository.UserListRepository;

@Service
public class UserListService {

	 @Autowired
	 UserListRepository userListRepository;
	 
	 public List<UserList> getAllUserList(){
		 List<UserList> userLists = new ArrayList<UserList>();
		 userListRepository.findAll().forEach(userList-> userLists.add(userList));
		 return userLists;
	 }
	 
	 public UserList getUserListbyUserId(int id) {
		 return userListRepository.findById(id).get();
	 }
	 
	 public void saveOrUpdate(UserList userList) {
		 userListRepository.save(userList);
	 }
	 
	 public void deleteUserList(int id) {
		 userListRepository.deleteById(id);
	 }
	 
	 
	 
}
