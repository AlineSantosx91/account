package br.com.mycompany.account.repository;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.mapper.AccountMapper;

@Repository
public class AccountRepositoryImp implements IAccountRepository {

    private static final Logger logger = LoggerFactory.getLogger(AccountRepositoryImp.class);
    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Autowired
    public AccountRepositoryImp(AccountRepository accountRepository, AccountMapper mapper) {
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

    @Override
    public AccountEntity save(AccountRequest accountRequest) throws Exception {
        try {
            AccountEntity accountEntity = mapper.toAccountEntity(accountRequest);
            return accountRepository.save(accountEntity);
        } catch (Exception e) {
            logger.error("Erro ao salvar account", e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public AccountEntity findByAccountId(Long accountId) throws Exception {
        AccountEntity accountEntity;
        try {
            accountEntity = accountRepository.findById(accountId).orElseThrow(() -> new NoSuchElementException());
        } catch (Exception e) {
            logger.error("Erro ao obter dados do account", e.getMessage());
            throw new Exception(e.getMessage());
        }
        return accountEntity;
    }
}
