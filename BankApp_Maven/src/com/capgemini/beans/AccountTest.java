package com.capgemini.beans;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientOpeningBalanceException;
import com.capgemini.repo.AccountRepo;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class AccountTest {

	@Mock
	AccountRepo accountRepo;
	
	AccountService accountService;
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);//actual mock object is created
		accountService = new AccountServiceImpl(accountRepo);
	}

	@Test(expected=com.capgemini.exceptions.InsufficientOpeningBalanceException.class)
	public void whenTheAmountIsLessThanFiveHundredSystemShouldThrowException() throws InsufficientOpeningBalanceException {
		accountService.createAccount(101, 300);
	}
	
	@Test
	public void whenTheValidInfoIsPassedAccountShouldBeCreated() throws InsufficientOpeningBalanceException
	{
		Account account=new Account();
		account.setAccountNumber(101);
		account.setAmount(5000);
		
		when(accountRepo.save(account)).thenReturn(true);
		
		assertEquals(account, accountService.createAccount(101, 5000));
	}

}
