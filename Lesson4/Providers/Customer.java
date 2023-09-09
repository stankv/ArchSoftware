package Lesson4.Providers;

import Lesson4.Interfaces.ICustomer;
import Lesson4.Models.Ticket;
import Lesson4.Models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Класс, содержащий основную логику покупки билетов
 */
public class Customer implements ICustomer {
    private TicketProvider ticketProvider;
    private CashProvider cashProvider;
    private UserProvider userProvider;
    private User client;
    private List<Ticket> selectedTickets;

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Конструктор класса
     */
    public Customer() {
        //Здесь создаются экземпляры классов работы с базами данных
        //Так как при уничтожении класса Customer нам больше не нужны экземпляры классов - провайдеров,
        //было решено организовать композицию с классами - провайдерами.
        this.cashProvider = new CashProvider();
        this.ticketProvider = new TicketProvider();
        this.userProvider = new UserProvider();
    }

    @Override
    public List<Ticket> getSelectedTickets() {
        return selectedTickets;
    }

    @Override
    public void setSelectedTickets(List<Ticket> selectedTickets) {
        this.selectedTickets = selectedTickets;
    }

    @Override
    public UserProvider getUserProvider() {
        return userProvider;
    }

    @Override
    public User getUser() {
        return client;
    }

    @Override
    public void setUser(User client) {
        this.client = client;
    }

    @Override
    public boolean buyTicket(Ticket ticket) throws RuntimeException {
        boolean flag;
        cashProvider.authorization(client);
        flag = cashProvider.buy(ticket);
        if (flag) {
            flag = ticketProvider.updateTicketStatus(ticket);
        }
        return flag;
    }

    @Override
    public List<Ticket> searchTicket(Date date, int route) throws RuntimeException {
        List<Ticket> result = new ArrayList<>();
        var list = ticketProvider.getTickets(route);
        for (Ticket ticket : list) {
            if (formatter.format(ticket.getDate()).equals(formatter.format(date))) {
                result.add(ticket);
            }
        }
        if (result.isEmpty()) {
            throw new RuntimeException("На эту дату билетов нет");
        }
        return result;
    }
}
