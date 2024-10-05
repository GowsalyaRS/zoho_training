package com.atmservice.filedatabase;
import java.util.List;
import com.atmservice.module.Account;
import java.util.Map;

public interface AccountFileProcess extends AddFileProcess,ClearFileProcess 
{
    List<Account> readAccountFile() throws Exception;
    void writeAccountFile(Account account) throws Exception;
    void modifyAccountFile( Map<Long ,Account> accounts) throws Exception ;
}

