package br.com.mycompany.account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.dto.AccountResponse;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.utils.DocumentNumberUtils;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {

    @Mapping(target = "accountId", ignore = true)
    @Mapping(target = "documentNumber", source = "documentNumber", qualifiedByName = "getDocumentNumberWithoutFormatting")
    public abstract AccountEntity toAccountEntity(AccountRequest accountRequest);

    @Mapping(target = "documentNumber", source = "documentNumber", qualifiedByName = "getObfuscatedDocumentNumber")
    @Mapping(target = "accountId", source = "accountId")
    public abstract AccountResponse toAccountResponse(AccountEntity accountEntity);

    @Named("getObfuscatedDocumentNumber")
    protected String getObfuscatedDocumentNumber(String documentNumber){
        return DocumentNumberUtils.getCPFCNPJObfuscate(documentNumber);
    }

    @Named("getDocumentNumberWithoutFormatting")
    protected String getDocumentNumberWithoutFormatting(String documentNumber){
        return DocumentNumberUtils.getDocumentNumberWithoutFormatting(documentNumber);
    }
}
