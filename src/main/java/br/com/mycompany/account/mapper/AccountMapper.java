package br.com.mycompany.account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.entity.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "accountId", ignore = true)
    AccountEntity toAccountEntity(AccountRequest accountRequest);
}
