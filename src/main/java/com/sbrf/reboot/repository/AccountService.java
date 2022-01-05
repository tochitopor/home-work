package com.sbrf.reboot.repository;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isClientHasContract(long clientId, long contractNumber) throws IOException {
        return accountRepository.getAllAccountsByClientId(clientId).contains(contractNumber);
    }

    public boolean updateAccountByClientId(long clientId, long oldAccount, long newAccount) throws IOException {
        return accountRepository.getAllAccountsByClientId(clientId).contains(oldAccount) &
                 accountRepository.updateAccountByClientId(clientId, oldAccount, newAccount);
    }
}
