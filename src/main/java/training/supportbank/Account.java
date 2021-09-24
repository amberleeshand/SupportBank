package training.supportbank;

import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    String User;
    BigDecimal amount;
    List<Transaction> transactionList = new ArrayList<>();


    public Account(String fromUser) {
        this.User = fromUser;
        this.amount = new BigDecimal(0);

    }

    public void getAmount(){
        System.out.println(this.amount);
    }

    public void addTransation(Transaction transaction){
        transactionList.add(transaction);
    }

    public BigDecimal totalbalance(){
        BigDecimal balance = new BigDecimal(0);
        for (Transaction transaction: transactionList) {
            if (transaction.getFromUser().equals(User)) {
                balance = balance.subtract(transaction.getAmount());
            } else if (transaction.getToUser().equals(User)) {
                balance = balance.add(transaction.getAmount());
            }
        }
        return balance;
    }

    public void processTransaction(Transaction theTransaction){
        //Debit or credit?
        if (User.equals(theTransaction.toUser)) {
            amount.add(theTransaction.amount);
        } else if (User.equals(theTransaction.fromUser)) {
            amount.subtract(theTransaction.amount);
        }
    }

    public void put(String fromAccount, Account oneAccount) {
    }
    public BigDecimal getTheAmount(){
        return amount;
    }
}