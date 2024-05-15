package dao;

import data.Db;
import models.Wallet;

import java.util.List;
import java.util.UUID;

public class WalletDaoImpl implements WalletDao{
    private final Db db = Db.getInstance();
    @Override
    public List<Wallet> getAllWallets() {
        return db.wallets;
    }

    @Override
    public Wallet getWalletById(UUID id) {
        for (Wallet wallet : db.wallets) {
            if (wallet.getId().equals(id)) {
                return wallet;
            }
        }
        return null;
    }

    @Override
    public void addWallet(Wallet wallet) {
        db.wallets.add(wallet);
    }
}
