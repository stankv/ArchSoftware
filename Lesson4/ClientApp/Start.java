package Lesson4.ClientApp;

import Lesson4.Interfaces.ICustomer;
import Lesson4.Models.Ticket;
import Lesson4.Providers.Customer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Основной класс клиентского приложения.
 */
public class Start extends EnterData {
    // Связь с основной логикой осуществляется через интерфейс ICustomer.
    private ICustomer customer;
    private int ticketRouteNumber;
    private Date ticketDate;

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Вход и регистрация
     */
    public void menuLoginRegister() {
        boolean run = true;
        while (run) {
            printMessageLine("Сервис покупки билетов");
            printMessageLine("Войти - 1\nЗарегистрироваться - 2\nВыход - 0");
            System.out.print(">> ");
            int choice = 0;
            try {
                choice = inputInt(0, 2);
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
                continue;
            }
            System.out.println("----------------------------------------------------------------");
            run = menuLoginRegisterChoice(choice);
        }
    }

    /**
     * Логика ветвления запуска программы
     *
     * @param choice
     * @return
     */
    private boolean menuLoginRegisterChoice(int choice) {
        switch (choice) {
            case 1:
                login();
                if (customer.getUser() == null) {
                    break;
                } else {
                    menuBuyingTicket();
                    break;
                }
            case 2:
                register();
                if (customer == null) {
                    break;
                } else {
                    menuBuyingTicket();
                    break;
                }
            default:
                return false;
        }
        return true;
    }

    /**
     * Меню входа зарегистрированного пользователя
     */
    private void login() {
        printMessageLine("Вход в систему");
        System.out.print("Имя: ");
        String userName = inputString();
        System.out.print("Пароль: ");
        int passwordHash = inputString().hashCode();
        System.out.println("----------------------------------------------------------------");
        customer = new Customer();
        try {
            customer.setUser(Authentication.authentication(customer.getUserProvider(), userName, passwordHash));
        } catch (RuntimeException ex) {
            System.out.println("Ошибка аутентификации!");
            System.out.println(ex.getMessage());
            System.out.println("----------------------------------------------------------------");
            return;
        }
        printMessageLine("Вход выполнен успешно.");
    }

    /**
     * Меню регистрации нового пользователя
     */
    private void register() {
        printMessageLine("Регистрация нового пользователя");
        System.out.print("Имя: ");
        String userName = inputString();
        System.out.print("Пароль: ");
        int passwordHash = inputString().hashCode();
        System.out.print("Повторите пароль: ");
        int passwordHash2 = inputString().hashCode();
        if (passwordHash != passwordHash2) {
            System.out.println("----------------------------------------------------------------");
            printMessageLine("Пароли не совпадают!");
            return;
        }
        System.out.print("Номер карты: ");
        long cardNumber = inputLong(1L, 9999_9999_9999_9999L);
        System.out.println("----------------------------------------------------------------");
        customer = new Customer();
        int id;
        try {
            id = customer.getUserProvider().createClient(userName, passwordHash, cardNumber);
            customer.setUser(Authentication.authentication(customer.getUserProvider(), userName, passwordHash));
        } catch (RuntimeException ex) {
            System.out.println("Ошибка регистрации нового пользователя!");
            System.out.println(ex.getMessage());
            System.out.println("----------------------------------------------------------------");
            return;
        }
        printMessageLine("Пользователь " + customer.getUser().getUserName() + " с ID " + id + " успешно зарегистрирован");
    }

    /**
     * Меню покупки билетов
     */
    private void menuBuyingTicket() {
        boolean run = true;
        while (run) {
            printMessageLine("Сервис покупки билетов | Пользователь: " + customer.getUser().getUserName() + " |");
            printMessageLine("Выбор номера маршрута и печать всех билетов - 1\n" +
                    "Выход - 0");
            System.out.print(">> ");
            int choice = 0;
            try {
                choice = inputInt(0, 1);
            } catch (RuntimeException ex) {
                System.out.println("----------------------------------------------------------------");
                printMessageLine(ex.getMessage());
                continue;
            }
            System.out.println("----------------------------------------------------------------");
            run = menuBuyingTicketChoice(choice);
        }
    }

    /**
     * Логика ветвления меню покупки билетов
     *
     * @param choice
     * @return
     */
    private boolean menuBuyingTicketChoice(int choice) {
        switch (choice) {
            case 1:
                ticketRouteNumber = menuSelectRoute();
                if (ticketRouteNumber > 0) {
                    ticketDate = selectDate();
                    if (ticketDate != null) {
                        try {
                            customer.setSelectedTickets(customer.searchTicket(ticketDate, ticketRouteNumber));
                        } catch (RuntimeException ex) {
                            printMessageLine(ex.getMessage());
                            return true;
                        }
                        printAllTickets(customer.getSelectedTickets());
                        menuBuyTicket();
                        return true;
                    }
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    /**
     * Метод ввода номера маршрута
     *
     * @return номер маршрута
     */
    private int menuSelectRoute() {
        printMessageLine("Ввод номера маршрута и даты. | Пользователь: " + customer.getUser().getUserName() + " |");
        System.out.print("Введите номер маршрута: ");
        //Здесь ограничиваем число маршрутов.
        int min = 1;
        int max = 2;
        int numRoute;
        try {
            numRoute = inputInt(min, max);
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return -1;
        }
        System.out.println("----------------------------------------------------------------");
        return numRoute;
    }

    /**
     * Метод ввода даты поездки
     *
     * @return дата поездки
     */
    private Date selectDate() {
        System.out.print("Введите дату (ДД-ММ-ГГГГ): ");
        Date date;
        try {
            date = inputDate();
        } catch (RuntimeException ex) {
            printMessageLine(ex.getMessage());
            return null;
        }
        System.out.println("----------------------------------------------------------------");
        return date;
    }

    /**
     * Метод вывода в консоль списка билетов
     *
     * @param tickets список билетов
     */
    private void printAllTickets(List<Ticket> tickets) {
        for (var t : tickets) {
            System.out.println(t.toString());
        }
        System.out.println("----------------------------------------------------------------");
    }

    /**
     * Метод покупки билета
     */
    private void menuBuyTicket() {
        printMessageLine("Покупка билета. | Пользователь: " + customer.getUser().getUserName() + " |");
        System.out.print("Купить билет: " + "маршрут " + ticketRouteNumber + "   дата " + formatter.format(ticketDate) + " (y/n): ");
        String answer = inputString();
        System.out.println("----------------------------------------------------------------");
        menuBuyTicketConfirm(answer);
    }

    /**
     * Логика ветвления меню подтверждения покупки
     *
     * @param answer
     */
    private void menuBuyTicketConfirm(String answer) {
        if (answer.equalsIgnoreCase("Y")) {
            for (var t : customer.getSelectedTickets()) {
                if (formatter.format(t.getDate()).equals(formatter.format(ticketDate)) 
                    && t.getRouteNumber() == ticketRouteNumber && t.getValid()) {
                    boolean flag = false;
                    try {
                        flag = customer.buyTicket(t);
                    } catch (RuntimeException ex) {
                        printMessageLine(ex.getMessage());
                        return;
                    }
                    if (flag) {
                        printMessageLine(t.toPrint());
                        return;
                    }
                }
            }
        }
    }

    /**
     * Метод вывода в консоль элемента сообщения
     *
     * @param message
     */
    private void printMessageLine(String message) {
        System.out.println(message);
        System.out.println("=====================================================================================");
    }
}
