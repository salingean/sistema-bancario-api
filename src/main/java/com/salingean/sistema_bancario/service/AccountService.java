package com.salingean.sistema_bancario.service;

import com.salingean.sistema_bancario.entity.Account;
import com.salingean.sistema_bancario.entity.Transaction;
import com.salingean.sistema_bancario.exception.*;
import com.salingean.sistema_bancario.repository.AccountRepository;
import com.salingean.sistema_bancario.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account createAccount(String name, String accountNumber, BigDecimal balance) {
        Account account = new Account(name, accountNumber, balance);
        accountRepository.save(account);
        return account;
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account not found"));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getBlockedAccounts() {
        return accountRepository.findByBlockedTrue();
    }

    public BigDecimal getBalance(Long id) {
        return getAccountById(id).getBalance();
    }


    public void blockAccount(Long id) {
        Account account = getAccountById(id);
        if (!account.isBlocked()) {
            account.setBlocked(true);
            accountRepository.save(account);
        } else {
            throw new AccountAlreadyBlockedException("It is not possible to block an account that has already been blocked");
        }
    }

    @Transactional
    public void transfer(Long sourceAccount, Long destinationAccount, BigDecimal value) {

        if (sourceAccount.equals(destinationAccount)) {
            throw new SameAccountTransferException("It is not possible to transfer to the same account");
        }

        if (value.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransferValueException("Invalid value");
        }
            Account source = getAccountById(sourceAccount);
            Account destination = getAccountById(destinationAccount);

        if (source.isBlocked() || destination.isBlocked()) {
            throw new BlockedAccountException("It is not possible to perform transactions with blocked accounts");
        }

        if (source.getBalance().compareTo(value) < 0) {
            throw new InsufficientBalanceException("No balance in account");
        }

        source.setBalance(source.getBalance().subtract(value));
        destination.setBalance(destination.getBalance().add(value));

        accountRepository.save(source);
        accountRepository.save(destination);

        Transaction transaction = new Transaction(source, destination, value, LocalDateTime.now());
        transactionRepository.save(transaction);

    }
}
