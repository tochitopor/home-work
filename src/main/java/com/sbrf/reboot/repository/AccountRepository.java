package com.sbrf.reboot.repository;

import java.io.IOException;
import java.util.Set;

public interface AccountRepository {
    Set<Long> getAllAccountsByClientId(long clientId) throws IOException;
    boolean updateAccountByClientId(long clientId, long oldAccount, long newAccount) throws IOException;
}
