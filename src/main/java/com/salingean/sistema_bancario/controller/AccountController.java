package com.salingean.sistema_bancario.controller;

import com.salingean.sistema_bancario.dto.AccountResponse;
import com.salingean.sistema_bancario.dto.CreateAccountRequest;
import com.salingean.sistema_bancario.dto.TransferRequest;
import com.salingean.sistema_bancario.entity.Account;
import com.salingean.sistema_bancario.mapper.AccountMapper;
import com.salingean.sistema_bancario.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable Long id) {

        return AccountMapper.toResponse(
                accountService.getAccountById(id)
        );
    }

    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return accountService.getAllAccounts()
                .stream()
                .map(AccountMapper::toResponse)
                .toList();
    }

    @GetMapping("/status/blocked")
    public List<AccountResponse> getBlockedAccounts() {
        return accountService.getBlockedAccounts()
                .stream()
                .map(AccountMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}/balance")
    public BigDecimal getBalance(@PathVariable Long id) {
        return accountService.getBalance(id);
    }

    @PatchMapping("/{id}/block")
    public void blockAccount(@PathVariable Long id) {
        accountService.blockAccount(id);
    }

    @PostMapping("/transfer")
    public void transfer(@Valid @RequestBody TransferRequest transferRequest) {
        accountService.transfer(transferRequest.getSourceAccount(), transferRequest.getDestinationAccount(), transferRequest.getValue());
    }

    @PostMapping
    public AccountResponse createAccount(@Valid @RequestBody CreateAccountRequest createAccountRequest) {
        Account account = accountService.createAccount(
                createAccountRequest.getName(),
                createAccountRequest.getAccountNumber(),
                createAccountRequest.getBalance()
        );

        return AccountMapper.toResponse(account);
    }
}
