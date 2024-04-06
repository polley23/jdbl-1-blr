package com.gfg.jdblbang1transactionservice.entity;

import lombok.Data;

@Data
public class TxRequest {
    private String userID;
    private double amount;
    private TxType txType;
}
