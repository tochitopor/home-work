package com.sbrf.reboot.repository;

import com.sbrf.reboot.repository.account.Account;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean isClientHasContract(long clientId, long contractNumber) {
        for(Account account : accountRepository.getAllAccountsByClientId(clientId)){
            if(account.getContract() == contractNumber){
                return true;
            }
        }
        return false;
    }

    public boolean isHasOverdueContract() {
        Calendar currentDate = new GregorianCalendar();
        for(Account account : accountRepository.getAllAccounts()){
            if(currentDate.after(account.getEndDate())){
                return true;
            }
        }
        return false;
    }
}
