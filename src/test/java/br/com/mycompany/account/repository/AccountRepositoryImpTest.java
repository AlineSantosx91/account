package br.com.mycompany.account.repository;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.mapper.AccountMapper;

@ExtendWith(MockitoExtension.class)
class AccountRepositoryImpTest {

    @InjectMocks
    private AccountRepositoryImp accountRepositoryImp;
    @Mock
    private AccountRepository accountRepository;
    @Spy
    private AccountMapper mapper;

    @Test
    void shouldSaveAccount() {
        AccountRequest accountRequest = new AccountRequest();
        AccountEntity accountEntity = new AccountEntity("123");

        when(mapper.toAccountEntity(accountRequest)).thenReturn(accountEntity);
        accountRepositoryImp.save(accountRequest);

        verify(accountRepository, times(1)).save(accountEntity);
    }
}