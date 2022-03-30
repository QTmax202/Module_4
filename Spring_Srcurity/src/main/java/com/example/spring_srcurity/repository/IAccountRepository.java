package com.example.spring_srcurity.repository;

import com.example.spring_srcurity.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByGmail(String username);

    Boolean existsByGmail(String username);

    Optional<Account> findAccountByGmailAndPassword(String username,String password);

}
