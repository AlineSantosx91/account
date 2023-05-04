package br.com.mycompany.account.service;

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
    void shouldCallAccountRepositorySave() throws Exception {
        AccountRequest accountRequest = new AccountRequest();
        accountServiceImp.save(accountRequest);
        verify(accountRepository, times(1)).save(accountRequest);
    }

    @Test
    void shouldCallAccountRepositoryFindByAccountId() throws Exception {
        accountServiceImp.findByAccountId(1L);
        verify(accountRepository, times(1)).findByAccountId(1L);
    }
}