package br.com.mycompany.account.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mycompany.account.dto.AccountRequest;
import br.com.mycompany.account.dto.AccountResponse;
import br.com.mycompany.account.entity.AccountEntity;
import br.com.mycompany.account.service.IAccountService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/accounts")
public class AccountController {

    private final IAccountService accountService;
    private final ModelMapper modelMapper;

    @Autowired
    public AccountController(IAccountService accountService, ModelMapper modelMapper) {
        this.accountService = accountService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody AccountRequest accountRequest) {
        AccountEntity accountEntity = accountService.save(accountRequest);
        AccountResponse accountResponse = modelMapper.map(accountEntity, AccountResponse.class);
        return ResponseEntity.ok(accountResponse);
    }

}
