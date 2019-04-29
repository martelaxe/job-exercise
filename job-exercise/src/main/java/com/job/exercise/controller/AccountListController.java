package com.job.exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job.exercise.model.AccountList;
import com.job.exercise.service.AccountListService;

@RestController
public class AccountListController {

	@Autowired
	AccountListService accountListService;

	
	@GetMapping("/accountList")
	private List<AccountList> getAllAccountLists() {
		return accountListService.getAllAccountList();
	}
	
	@GetMapping("/accountList/{id}")
	private AccountList getAccountListById(@PathVariable("id") int id) {
		return accountListService.getAccountListById(id);
	}
	
    @DeleteMapping("/accountLists/{id}")
    private void deleteAccountListById(@PathVariable("id	") int id) {
    	accountListService.delete(id);
    }
    
    @PostMapping("/accountLists")
    private int saveNewAccountList(@RequestBody AccountList accountList) {
    	accountListService.saveOrUpdate(accountList);
        return accountList.getAccountId();
    }
}
