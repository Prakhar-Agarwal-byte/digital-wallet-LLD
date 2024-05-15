package dao;

import models.Wallet;

import java.util.List;
import java.util.UUID;

public interface WalletDao {
    List<Wallet> getAllWallets();
    Wallet getWalletById(UUID id);
    void addWallet(Wallet wallet);
}
