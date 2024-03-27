package com.example.wallet.repositories;

import com.example.wallet.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {

    @Modifying
    @Query("UPDATE Wallet SET balance = :newBalance WHERE id = :walletId")
    void changeBalance(UUID walletId, BigDecimal newBalance);

}
