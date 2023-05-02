package br.com.mycompany.account.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mapstruct.factory.Mappers.getMapper;

import org.junit.jupiter.api.Test;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.dto.AccountResponse;
import br.com.mycompany.account.entity.AccountEntity;

class AccountMapperTest {

    AccountMapper accountMapper = getMapper(AccountMapper.class);

    @Test
    public void shouldValidateToAccountResponse() {
        AccountResponse accountResponse = accountMapper.toAccountResponse(
                new AccountEntity("33366655544"));
        assertEquals(accountResponse.getDocumentNumber(), "***666555**");
    }

    @Test
    public void shouldValidateToAccountEntity() {
        AccountRequest accountRequest = new AccountRequest();
        accountRequest.setDocumentNumber("33366655544");
        AccountEntity accountEntity = accountMapper.toAccountEntity(accountRequest);
        assertEquals(accountEntity.getDocumentNumber(), "33366655544");
    }

}