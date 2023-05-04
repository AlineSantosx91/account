package br.com.mycompany.account.repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

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
    void shouldSaveAccount() throws Exception {
        AccountRequest accountRequest = new AccountRequest();
        AccountEntity accountEntity = new AccountEntity("123");

        when(mapper.toAccountEntity(accountRequest)).thenReturn(accountEntity);
        accountRepositoryImp.save(accountRequest);

        verify(accountRepository, times(1)).save(accountEntity);
    }

    @Test
    void shouldGetErrorWhenSaveAccount() {
        AccountRequest accountRequest = new AccountRequest();
        when(accountRepository.save(any())).thenThrow(DataIntegrityViolationException.class);
        Assertions.assertThrows(Exception.class, () -> {
            accountRepositoryImp.save(accountRequest);
        });
    }

    @Test
    void shouldGetAccountById() {
        Optional<AccountEntity> accountEntity = Optional.empty();

        when(accountRepository.findById(2L)).thenReturn(accountEntity);

        Assertions.assertThrows(Exception.class, () -> {
            accountRepositoryImp.findByAccountId(2L);
        });
    }

    @Test
    void shouldGetErrorWhenGetAccountByWrongId() throws Exception {
        Optional<AccountEntity> accountEntity = Optional.of(new AccountEntity());

        when(accountRepository.findById(3L)).thenReturn(accountEntity);
        AccountEntity byAccountId = accountRepositoryImp.findByAccountId(3L);

        Assertions.assertNotNull(byAccountId);
    }
}