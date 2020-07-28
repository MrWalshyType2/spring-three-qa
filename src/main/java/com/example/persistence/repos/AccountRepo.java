package com.example.persistence.repos;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

}
