package Lesson3_2.Service;

// 9. Добавить в интерфейс «Заправочная станция» методы: протирка лобового стекла, протирка фар, протирка зеркал.
public interface IWashStation {
    void wipeTheWindshield();
    void wipeHeadlights();
    void wipeMirrors();
}
