package com.example.wallet.controllers;

import com.example.wallet.controllers.dto.ChangeBalanceDto;
import com.example.wallet.controllers.dto.ChangeWalletDto;
import com.example.wallet.controllers.dto.WalletDto;
import com.example.wallet.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/")
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/wallet")
    public ResponseEntity<ChangeWalletDto> changeBalance(@RequestBody @Validated ChangeBalanceDto changeBalanceDto) {
        return ResponseEntity.status(HttpStatus.OK).body(walletService.changeBalance(changeBalanceDto));
       // return ResponseEntity.status(HttpStatus.OK).body(walletService.stressTest(changeBalanceDto));
    }


    @GetMapping("/wallets/{WALLET_UUID}")
    public ResponseEntity<WalletDto> getBalance(@PathVariable UUID WALLET_UUID) {
        return ResponseEntity.status(HttpStatus.OK).body(walletService.getBalance(WALLET_UUID));
    }
}
