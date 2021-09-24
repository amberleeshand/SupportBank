package training.supportbank;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String args[]) throws Exception {
        // Your code here!
        readInFile("Transactions2014.csv");
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter List All if you would like to see everyone's accounts");
        String userName = myObj.nextLine();
    }

    private static void readInFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        List<String> contents = Files.readAllLines(filePath);
        HashMap<String, Account> accountPayees = new HashMap<String, Account>();

        for (String line: contents) {
            String[] elements = line.split(",");
            String date = elements[0];
            String fromAccount = elements[1];
            String toUser = elements[2];
            String reasonForTransaction = elements[3];
            String amount = elements[4];
            if (!elements[4].equals("Amount")) {
                Transaction oneTransaction = new Transaction(date, fromAccount, toUser, reasonForTransaction, amount);
                // Tidy up elements and conditionally create accounts
                if (!accountPayees.containsKey(fromAccount)) {
                    Account oneAccount = new Account(fromAccount);
                    accountPayees.put(fromAccount, oneAccount);
                }
                accountPayees.get(fromAccount).addTransation(oneTransaction);
                if (!accountPayees.containsKey(toUser)) {
                    Account oneAccount = new Account(toUser);
                    accountPayees.put(toUser, oneAccount);
                }
                accountPayees.get(toUser).addTransation(oneTransaction);
            }
        }
//        System.out.println(accountPayees);
        accountPayees.forEach((name,account)-> System.out.printf("%s's balance is £%s%n",name, account.totalbalance()));

    }
}
