package com.job.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.exercise.model.UserList;
import com.job.exercise.service.UserListService;

@RestController
public class UserListController {

	@Autowired
	UserListService userListService;

	@GetMapping("/userLists")
	private List<UserList> getAllUserLists() {
		return userListService.getAllUserList();
	}
	
	@GetMapping("/userLists/{id}")
	private UserList getUserListById(@PathVariable("id") int id) {
		return userListService.getUserListbyUserId(id);
	}
	
    @DeleteMapping("/userLists/{id}")
    private void deleteUserListById(@PathVariable("id") int id) {
    	userListService.deleteUserList(id);
    }
    
    @PostMapping("/userLists")
    private int saveNewUserList(@RequestBody UserList userList) {
    	userListService.saveOrUpdate(userList);
        return userList.getUserId();
    }
}
