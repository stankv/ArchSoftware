package Lesson4.Models;

import java.util.Objects;

/**
 * Модель пользователя
 */
public class User {
    private int id;
    private String userName;
    private int hashPassword;
    private long cardNumber;


    public User(int id, String userName, int hashPassword, long cardNumber) {
        this.id = id;
        this.userName = userName;
        this.hashPassword = hashPassword;
        this.cardNumber = cardNumber;
    }

    public int getId(){
        return this.id;
    }
    public String getUserName() {
        return this.userName;
    }
    public long getCardNumber(){
        return this.cardNumber;
    }



    @Override
    public String toString() {
        return "Пользователь { " +
                "id: " + id +
                ", Имя: " + userName +
                ", Номер карты: " + (String.format("%016d", cardNumber)) +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) return false;
        User client = (User) o;
        return this.equals(client);
    }


    public boolean equals(User client) {
        return id == client.id && hashPassword == client.hashPassword && cardNumber == client.cardNumber && userName.equals(client.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, hashPassword, cardNumber);
    }

    public int getHashPassword() {
        return  hashPassword;
    }
}
