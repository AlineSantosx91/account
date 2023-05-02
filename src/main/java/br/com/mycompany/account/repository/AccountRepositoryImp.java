package br.com.mycompany.account.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.mapper.AccountMapper;

@Repository
public class AccountRepositoryImp implements IAccountRepository{

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    @Autowired
    public AccountRepositoryImp(AccountRepository accountRepository, AccountMapper mapper) {
        this.accountRepository = accountRepository;
        this.mapper = mapper;
    }

    @Override
    public AccountEntity save(AccountRequest accountRequest) {
        //tratar de erro
        AccountEntity accountEntity = mapper.toAccountEntity(accountRequest);
        return accountRepository.save(accountEntity);
    }
}
