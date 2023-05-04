package br.com.mycompany.account.service;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.entity.AccountEntity;

public interface IAccountService {

    AccountEntity save(AccountRequest accountRequest) throws Exception;
    AccountEntity findByAccountId(Long accountId) throws Exception;

}
