package br.com.mycompany.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.repository.IAccountRepository;

@Service
public class AccountServiceImp implements IAccountService {

    private final IAccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(IAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountEntity save(AccountRequest accountRequest) throws Exception {
        return accountRepository.save(accountRequest);
    }
}
