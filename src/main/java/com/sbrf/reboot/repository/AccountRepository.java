package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.account.Account;

import java.util.Set;

public interface AccountRepository {
    Set<Account> getAllAccountsByClientId(long clientId);
    Set<Account> getAllAccounts();
}
