package utils;

import models.Wallet;
import services.WalletService;

import java.util.Scanner;
import java.util.UUID;

public class DriverUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final WalletService walletService = new WalletService();
    public static boolean running = true;

    public static void printMenu() {
        System.out.println("1. Create wallet");
        System.out.println("2. Transfer amount");
        System.out.println("3. Account Statement");
        System.out.println("4. Overview");
        System.out.println("5. Exit");
    }
    public static void handleOptionCreateWallet() {
        System.out.println("enter user name");
        String username = scanner.nextLine();
        System.out.println("enter balance");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        Wallet wallet = walletService.addWallet(username, balance);
        System.out.println("wallet id: " + wallet.getId());
        System.out.println("wallet created");
    }
    public static void handleOptionTransferAmount() {
        System.out.println("enter wallet id (source)");
        UUID sourceWalletId = UUID.fromString(scanner.nextLine());
        System.out.println("enter wallet id (destination)");
        UUID destinationWalletId = UUID.fromString(scanner.nextLine());
        System.out.println("enter amount");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        walletService.transferAmount(sourceWalletId, destinationWalletId, amount);
        System.out.println("transfer successful");
    }
    public static void handleOptionAccountStatement() {
        System.out.println("enter wallet id");
        UUID walletId = UUID.fromString(scanner.nextLine());
        walletService.accountStatement(walletId);
    }
    public static void handleOptionOverview() {
        walletService.overview();
    }
    public static void handleOptionExit() {
        System.out.println("exited");
        running = false;
    }
}
