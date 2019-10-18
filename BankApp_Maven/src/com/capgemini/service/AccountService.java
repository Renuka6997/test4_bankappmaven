package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exceptions.InsufficientOpeningBalanceException;

public interface AccountService {

	Account createAccount(int accountNumber, int amount) throws InsufficientOpeningBalanceException;

}