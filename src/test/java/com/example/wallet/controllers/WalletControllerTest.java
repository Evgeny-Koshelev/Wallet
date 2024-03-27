package com.example.wallet.controllers;

import com.example.wallet.controllers.dto.ChangeBalanceDto;
import com.example.wallet.controllers.dto.ChangeWalletDto;
import com.example.wallet.controllers.dto.WalletDto;
import com.example.wallet.enums.OperationTypes;
import com.example.wallet.services.WalletService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WalletControllerTest {

    private final WalletService walletService = Mockito.mock();

    @Test
    void changeBalanceTest() throws IOException {

        ChangeBalanceDto changeBalanceDto = new ChangeBalanceDto(UUID.fromString("cd5f8a74-b3a6-4c7a-9ef2-5cc5c76c33de"),
                OperationTypes.DEPOSIT,
                BigDecimal.valueOf(10.00));

        ChangeWalletDto changeWalletDto = new ChangeWalletDto("Success. Was deposite: 10.00");

        Mockito.when(walletService.changeBalance(changeBalanceDto)).thenReturn(changeWalletDto);
        WalletController walletController = new WalletController(walletService);
        walletController.changeBalance(changeBalanceDto);
        Mockito.verify(walletService).changeBalance(Mockito.any());
        assertTrue(true);
    }

    @Test
    void getBalanceTest() throws IOException {

        UUID walletId = UUID.fromString("cd5f8a74-b3a6-4c7a-9ef2-5cc5c76c33de");

        WalletDto walletDto = new WalletDto(UUID.fromString("cd5f8a74-b3a6-4c7a-9ef2-5cc5c76c33de"),
                UUID.fromString("1c1195b6-114d-4bcc-9613-b463e701bee5"),
                        BigDecimal.valueOf(1000.00));

        Mockito.when(walletService.getBalance(walletId)).thenReturn(walletDto);
        WalletController walletController = new WalletController(walletService);
        walletController.getBalance(walletId);
        Mockito.verify(walletService).getBalance(Mockito.any());
        assertTrue(true);
    }
}
