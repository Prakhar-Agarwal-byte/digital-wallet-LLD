package services;

import dao.WalletDao;
import dao.WalletDaoImpl;
import exceptions.InvalidWalletIdException;
import models.Transaction;
import models.TransactionType;
import models.Wallet;

import java.sql.Date;
import java.time.Instant;
import java.util.UUID;

public class WalletService {
    private final WalletDao walletDao = new WalletDaoImpl();

    public void transferAmount(UUID sourceWalletId, UUID destinationWalletId, double amount) {
        Wallet sourceWallet = null;
        Wallet destinationWallet = null;
        for (Wallet wallet: walletDao.getAllWallets()) {
            if (wallet.getId().equals(sourceWalletId)) {
                sourceWallet = wallet;
            }
            if (wallet.getId().equals(destinationWalletId)) {
                destinationWallet = wallet;
            }
        }
        if (sourceWallet == null || destinationWallet == null) {
            throw new InvalidWalletIdException();
        }
        sourceWallet.withdrawAmount(amount);
        destinationWallet.addAmount(amount);
        Transaction sourceTransaction = new Transaction(Date.from(Instant.now()), amount, TransactionType.WITHDRAWAL);
        sourceWallet.getTransactions().add(sourceTransaction);
        Transaction destinationTransaction = new Transaction(Date.from(Instant.now()), amount, TransactionType.DEPOSIT);
        destinationWallet.getTransactions().add(destinationTransaction);
    }

    public Wallet addWallet(String username, double amount) {
        Wallet wallet = new Wallet(username, amount);
        walletDao.addWallet(wallet);
        return wallet;
    }

    public void accountStatement(UUID walletId) {
        for (Wallet wallet: walletDao.getAllWallets()) {
            if (wallet.getId().equals(walletId)) {
                System.out.println("account statement");
                for (Transaction transaction: wallet.getTransactions()) {
                    System.out.println(transaction.toString());
                }
            }
        }
    }

    public void overview() {
        for (Wallet wallet: walletDao.getAllWallets()) {
            System.out.println("id: "+wallet.getId() + " balance:" + wallet.getBalance());
        }
    }
}
