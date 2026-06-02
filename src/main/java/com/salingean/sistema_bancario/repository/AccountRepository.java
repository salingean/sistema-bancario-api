package com.salingean.sistema_bancario.repository;

import com.salingean.sistema_bancario.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findByBlockedTrue();

}
