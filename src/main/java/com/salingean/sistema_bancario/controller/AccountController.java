package com.salingean.sistema_bancario.controller;

import com.salingean.sistema_bancario.dto.AccountResponse;
import com.salingean.sistema_bancario.dto.CreateAccountRequest;
import com.salingean.sistema_bancario.dto.TransferRequest;
import com.salingean.sistema_bancario.entity.Account;
import com.salingean.sistema_bancario.mapper.AccountMapper;
import com.salingean.sistema_bancario.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Tag(name = "Accounts", description = "Operations related to bank accounts")
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Operation(summary = "Search account by ID")
    @ApiResponse(responseCode = "200", description = "Account found")
    @ApiResponse(responseCode = "404", description = "Account not found")
    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable Long id) {

        return AccountMapper.toResponse(
                accountService.getAccountById(id)
        );
    }

    @Operation(summary = "List all accounts")
    @GetMapping
    public List<AccountResponse> getAllAccounts() {
        return accountService.getAllAccounts()
                .stream()
                .map(AccountMapper::toResponse)
                .toList();
    }

    @Operation(summary = "List blocked accounts")
    @GetMapping("/status/blocked")
    public List<AccountResponse> getBlockedAccounts() {
        return accountService.getBlockedAccounts()
                .stream()
                .map(AccountMapper::toResponse)
                .toList();
    }

    @Operation(summary = "Get account balance")
    @GetMapping("/{id}/balance")
    public BigDecimal getBalance(@PathVariable Long id) {
        return accountService.getBalance(id);
    }

    @Operation(summary = "Block an account")
    @PatchMapping("/{id}/block")
    public void blockAccount(@PathVariable Long id) {
        accountService.blockAccount(id);
    }

    @Operation(summary = "Transfer money between accounts",
            description = "Transfers an amount from one account to another after validating balance and account status.")
    @PostMapping("/transfer")
    public void transfer(@Valid @RequestBody TransferRequest transferRequest) {
        accountService.transfer(transferRequest.getSourceAccount(), transferRequest.getDestinationAccount(), transferRequest.getValue());
    }

    @Operation(summary = "Create a new account")
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
