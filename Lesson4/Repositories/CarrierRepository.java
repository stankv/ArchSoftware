package Lesson4.Repositories;

import Lesson4.Interfaces.ICarrierRepo;
import Lesson4.Models.Carrier;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс репозиторий для имитации работы с базой данных перевозчиков
 */
public class CarrierRepository implements ICarrierRepo {
    private static CarrierRepository carrierRepository;
    private List<Carrier> carriers;

    private CarrierRepository() {
        // Заполняем базу данных
        carriers = new ArrayList<>();
        carriers.add(new Carrier(1, 1));
        carriers.add(new Carrier(2, 6));

    }

    public static CarrierRepository getCarrierRepository() {
        if (carrierRepository == null) {
            carrierRepository = new CarrierRepository();
        }
        return carrierRepository;
    }

    @Override
    public Carrier read(int id) throws RuntimeException {
        for (var carrier : carriers) {
            if (carrier.getId() == id) {
                return carrier;
            }
        }
        throw new RuntimeException("Перевозчик с этим номером ID не найден.");
    }
}
