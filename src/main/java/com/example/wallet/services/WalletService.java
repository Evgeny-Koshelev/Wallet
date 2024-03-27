package com.example.wallet.services;

import com.example.wallet.controllers.dto.ChangeBalanceDto;
import com.example.wallet.controllers.dto.ChangeWalletDto;
import com.example.wallet.controllers.dto.WalletDto;
import com.example.wallet.entities.Wallet;
import com.example.wallet.enums.OperationTypes;
import com.example.wallet.mapper.WalletMapper;
import com.example.wallet.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletMapper walletMapper;

    @Transactional
    public ChangeWalletDto changeBalance(ChangeBalanceDto changeBalanceDto) {
        WalletDto walletDto = getBalance(changeBalanceDto.getWalletId());
        if(walletDto.getId() != null) {
            BigDecimal amount = null;
            String message = null;
            switch (changeBalanceDto.getOperationType()) {
                case DEPOSIT:
                    amount = changeBalanceDto.getAmount();
                    message = "Was deposite: " + amount;
                    break;
                case WITHDRAW:
                    amount = changeBalanceDto.getAmount().multiply(BigDecimal.valueOf(-1));
                    message = "Was withdraw: " + amount;
                    break;

            }
            BigDecimal result = walletDto.getBalance().add(amount);
            if(result.compareTo(BigDecimal.ZERO) > 0) {
                walletRepository.changeBalance(walletDto.getId(),result);
                return new ChangeWalletDto("Success. " + message);
            }
            else
                return  new ChangeWalletDto("Not enough money");
        }
        else {
            return new ChangeWalletDto("Such uuid wallet not found");
        }
    }


    public WalletDto getBalance(UUID id) {
        Optional<Wallet> optionalWallet = walletRepository.findById(id);
        return optionalWallet.isPresent() ? walletMapper.toWalletDto(optionalWallet.get()) :
                new WalletDto(null, null, null);
    }

}


