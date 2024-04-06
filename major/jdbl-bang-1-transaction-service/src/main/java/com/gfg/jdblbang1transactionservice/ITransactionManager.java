package com.gfg.jdblbang1transactionservice;

import com.gfg.jdblbang1transactionservice.entity.TxRequest;
import com.gfg.jdblbang1transactionservice.entity.TxResponse;


public interface ITransactionManager {
    TxResponse CreateTx(TxRequest txRequest);
    TxResponse GetTransactionStatus(String txID) throws Exception;

    void receive(String walletResponse);
}
