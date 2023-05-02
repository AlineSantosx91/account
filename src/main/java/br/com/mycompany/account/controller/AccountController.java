package br.com.mycompany.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.dto.AccountResponse;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.mapper.AccountMapper;
import br.com.mycompany.account.service.IAccountService;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final IAccountService accountService;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountController(IAccountService accountService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AccountRequest accountRequest) {
        AccountEntity accountEntity = accountService.save(accountRequest);
        AccountResponse accountResponse = accountMapper.toAccountResponse(accountEntity);
        return ResponseEntity.ok(accountResponse);
    }

}
