package com.sbrf.reboot.service;

import com.sbrf.reboot.repository.AccountRepository;
import com.sbrf.reboot.repository.AccountService;
import com.sbrf.reboot.repository.account.Account;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);

        accountService = new AccountService(accountRepository);
    }

    @SneakyThrows
    @Test
    void contractExist() {
        long clientId = 1L;
        long contractNumber = 111L;
        Account account = new Account(clientId,contractNumber,
                new GregorianCalendar(1983, Calendar.DECEMBER,29));
        Set<Account> accounts = new HashSet<>();
        accounts.add(account);


        when(accountRepository.getAllAccountsByClientId(clientId)).thenReturn(accounts);

        assertTrue(accountService.isClientHasContract(clientId, contractNumber));
    }

    @SneakyThrows
    @Test
    void contractNotExist() {
        long clientId = 1L;
        long contractNumber = 111L;
        long badContractNumber = 222L;
        Account account = new Account(clientId,contractNumber,
                new GregorianCalendar(1983, Calendar.DECEMBER,29));
        Set<Account> accounts = new HashSet<>();
        accounts.add(account);


        when(accountRepository.getAllAccountsByClientId(clientId)).thenReturn(accounts);

        assertFalse(accountService.isClientHasContract(clientId, badContractNumber));
    }

    @SneakyThrows
    @Test
    void existOverdueContract() {
        long clientId = 1L;
        long contractNumber = 111L;
        Calendar calendar = new GregorianCalendar(1983, Calendar.DECEMBER,29);
        Account account = new Account(clientId,contractNumber, calendar);
        Set<Account> accounts = new HashSet<>();
        accounts.add(account);


        when(accountRepository.getAllAccounts()).thenReturn(accounts);

        assertTrue(accountService.isHasOverdueContract());
    }

    @SneakyThrows
    @Test
    void notExistOverdueContract() {
        long clientId = 1L;
        long contractNumber = 111L;
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH,1);
        Account account = new Account(clientId,contractNumber, calendar);
        Set<Account> accounts = new HashSet<>();
        accounts.add(account);


        when(accountRepository.getAllAccounts()).thenReturn(accounts);

        assertFalse(accountService.isHasOverdueContract());
    }

    @Test
    void repositoryHasTreeMethods() {
        assertEquals(2, AccountRepository.class.getMethods().length);
    }

    @Test
    void serviceHasTreeMethods() {
        assertEquals(2, AccountService.class.getMethods().length - Object.class.getMethods().length);
    }

}