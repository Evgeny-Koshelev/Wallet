package com.example.wallet.controllers.dto;

import com.example.wallet.enums.OperationTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeBalanceDto {

    @NotNull
    private UUID walletId;

    @NotNull
    private OperationTypes operationType;

    @NotNull
    private BigDecimal amount;

}
