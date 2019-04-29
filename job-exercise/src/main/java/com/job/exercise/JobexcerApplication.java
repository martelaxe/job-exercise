package com.job.exercise;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.job.exercise.model.AccountList;
import com.job.exercise.model.UserList;
import com.job.exercise.repository.AccountListRepository;
import com.job.exercise.repository.UserListRepository;

@SpringBootApplication
public class JobexcerApplication {
	@Autowired
	private UserListRepository userRepository;

	@Autowired
	private AccountListRepository accountListRepository;

	public static void main(String[] args) {
		SpringApplication.run(JobexcerApplication.class, args);

	}



	// Starting values for testing.
	@Bean
	InitializingBean sendDatabase() {
		return () -> {

			UserList userList = new UserList();

			userList.setName("User 1");
			userList.setUserId(1);

			userRepository.save(userList);

			AccountList account = new AccountList();

			account.setAccountCurrency("$0.00");
			account.setAccountName("Account 1 for User 1");

			account.setUserList(userList);

			accountListRepository.save(account);

			AccountList account2 = new AccountList();

			account2.setAccountCurrency("$0.00");
			account2.setAccountName("Account 2 for User1");
			account2.setUserList(userList);

			accountListRepository.save(account2);

			UserList userList2 = new UserList();

			userList2.setName("User 2");
			userList2.setUserId(2);
			userRepository.save(userList2);

			AccountList account3 = new AccountList();

			account3.setAccountCurrency("$0.00");
			account3.setAccountName("Account 1 for User2");
			account3.setUserList(userList2);

			accountListRepository.save(account3);

			UserList userList3 = new UserList();

			userList3.setName("User 3");
			userList3.setUserId(3);
			userRepository.save(userList3);

		};
	}

}
