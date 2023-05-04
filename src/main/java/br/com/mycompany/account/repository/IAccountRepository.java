package br.com.mycompany.account.repository;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.entity.AccountEntity;

public interface IAccountRepository {

    AccountEntity save(AccountRequest accountRequest) throws Exception;
    AccountEntity findByAccountId(Long accountId) throws Exception;

}
