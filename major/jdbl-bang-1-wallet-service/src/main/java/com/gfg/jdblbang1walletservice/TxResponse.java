package com.gfg.jdblbang1walletservice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TxResponse {
    private String userID;
    private double amount;
    private TxStatus status;
    private TxType txType;
    private  String txId;
}
