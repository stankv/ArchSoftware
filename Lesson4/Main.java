package Lesson4;

import Lesson4.ClientApp.Start;
//import Lesson4.Services.CashRepository;

public class Main {
    public static void main(String[] args) {
        Start start = new Start();
        start.menuLoginRegister();;
    }
}

// ДЛЯ ТЕСТОВ:
// Пользователи (заданы в конструкторе Repositories/UserRepository.java)
//Login: Ivan, Password: 1111  CardNumber: 2
//Login: Petr, Password: 2222  CardNumber: 3
//Login: Stan, Password: 3333  CardNumber: 4
//Login: Anna, Password: 4444  CardNumber: 5

// Билеты (заданы в конструкторе Repositories/TicketRepository.java )
// дата билетов: 31-12-2023
// маршруты: 1 либо 2