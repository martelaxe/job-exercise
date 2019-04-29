package com.job.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.exercise.model.AccountList;
import com.job.exercise.repository.AccountListRepository;

@Service
public class AccountListService {

    @Autowired
    AccountListRepository accountListRepository;

    public List<AccountList> getAllAccountList() {
        List<AccountList> accountLists = new ArrayList<AccountList>();
        accountListRepository.findAll().forEach(accountList -> accountLists.add(accountList));
        return accountLists;
    }

    public AccountList getAccountListById(int id) {
        return accountListRepository.findById(id).get();
    }

    public void saveOrUpdate(AccountList accountList) {	
    	accountListRepository.save(accountList);
    }

    public void delete(int id) {
    	accountListRepository.deleteById(id);
    }
}