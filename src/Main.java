import java.util.Scanner;

import static utils.DriverUtils.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (running) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    handleOptionCreateWallet();
                    break;
                case 2:
                    try {
                        handleOptionTransferAmount();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    handleOptionAccountStatement();
                    break;
                case 4:
                    handleOptionOverview();
                    break;
                case 5:
                    handleOptionExit();
                    break;
                default:
                    System.out.println("invalid option");
                    break;
            }
        }
    }
}