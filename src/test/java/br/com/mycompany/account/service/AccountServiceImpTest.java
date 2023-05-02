package br.com.mycompany.account.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.repository.IAccountRepository;

@ExtendWith(MockitoExtension.class)
class AccountServiceImpTest {

    @InjectMocks
    private AccountServiceImp accountServiceImp;

    @Mock
    private IAccountRepository accountRepository;

    @Test
    void shouldCallAccountRepository() {
        AccountRequest accountRequest = new AccountRequest();
        accountServiceImp.save(accountRequest);

        verify(accountRepository, times(1)).save(accountRequest);
    }
}