package training.supportbank;

import java.math.BigDecimal;


public class Transaction {
    String date;
    String fromUser;
    String toUser;
    String reason;
    BigDecimal amount;


    public Transaction(String date, String fromUser, String toUser, String reason, String amount) {
        this.date = date;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.reason = reason;
        this.amount = new BigDecimal(amount);

    }


    public String getDate(){
        return this.date;
    }

//    public String toString(){
//        return fromUser + " paid " + toUser + " £"+amount + " for " + reason + " on " +date;
//    }

    public BigDecimal getAmount(){
        return amount;

    }

    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public String getReason() {
        return reason;
    }
}

