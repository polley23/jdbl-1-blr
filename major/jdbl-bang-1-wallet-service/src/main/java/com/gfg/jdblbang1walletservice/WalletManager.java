package com.gfg.jdblbang1walletservice;

public interface WalletManager {
    void receiveTx(String tx);
    WalletResponse getWalletAmount(String username) throws Exception;
}
