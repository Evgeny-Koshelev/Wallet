package com.example.wallet.controllers.dto;

import com.example.wallet.enums.OperationTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeWalletDto {
    private String message;
}
