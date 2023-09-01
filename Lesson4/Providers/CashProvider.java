package Lesson4.Providers;

import Lesson4.Models.Carrier;
import Lesson4.Models.Ticket;
import Lesson4.Models.User;
import Lesson4.Repositories.CarrierRepository;
import Lesson4.Repositories.CashRepository;

/**
 * Класс - провайдер для взаимодействия с банком и базой перевозчиков
 */
public class CashProvider {
    private long cardNumber;
    private boolean isAuthorized;
    private CashRepository cashRepository;
    private CarrierRepository carrierRepository;



    /**
     * Конструктор класса
     */
    public CashProvider() {
        // Класс репозитория находится в единственном экземпляре для того, чтобы не создавать несколько подключений
        // к базе данных.
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }


    /**
     * Метод авторизации клиента. Здесь должно быть реализовано обращение к банку для подтверждения личности клиента.
     *
     * @param client
     */
    public void authorization(User client) {
        //Здесь должна быть реализована сверка аккаунта приложения и банковского аккаунта.
        cardNumber = client.getCardNumber();
        isAuthorized = true;
    }
    /**

     Метод покупки билета*
     @param ticket билет
     @return результат выполнения операции
     @throws RuntimeException
     */
    public boolean buy(Ticket ticket) throws RuntimeException {
        if (isAuthorized) {
            Carrier carrier = carrierRepository.read(1);
            return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
        }
        return false;
    }

}