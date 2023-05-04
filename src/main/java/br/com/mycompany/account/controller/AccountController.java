package br.com.mycompany.account.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.dto.AccountResponse;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.mapper.AccountMapper;
import br.com.mycompany.account.service.IAccountService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/accounts/")
public class AccountController {

    private final IAccountService accountService;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountController(IAccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PostMapping
    public ResponseEntity createAccount(@RequestBody @Valid AccountRequest accountRequest) {
        AccountEntity accountEntity = null;
        try {
            accountEntity = accountService.save(accountRequest);
        } catch (Exception e) {
            return new ResponseEntity("Algo errado aconteceu, tente novamente mais tarde",
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return getResponseEntitySuccess(accountEntity, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{accountId}")
    public ResponseEntity readAccount(@PathVariable Long accountId) {
        AccountEntity accountEntity = null;
        try {
            accountEntity = accountService.findByAccountId(accountId);
        } catch (NoSuchElementException e) {
            return getResponseEntityError(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return getResponseEntityError(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return getResponseEntitySuccess(accountEntity, HttpStatus.OK);
    }

    private ResponseEntity getResponseEntitySuccess(AccountEntity accountEntity, HttpStatus ok) {
        AccountResponse accountResponse = accountMapper.toAccountResponse(accountEntity);
        return new ResponseEntity(accountResponse, ok);
    }

    private ResponseEntity getResponseEntityError(HttpStatus status) {
        return new ResponseEntity("Algo errado aconteceu, tente novamente mais tarde", status);
    }

}
