package Lesson4.Models;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {

    private int balance;
    private long card;
    private long oldCard;



    public BankAccount() {
        this.card = oldCard + 1;
        oldCard = this.card;
        balance = 1000;
    }

    @Override
    public String toString() {
        return "Банковский счет: " +
                " карта= " + (String.format("%016d", card)) +
                ", баланс= " + balance +
                " }";
    }


    public long getCard() {
        return card;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance){
        this.balance =balance;
    }
}
