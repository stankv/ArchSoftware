// Конкретный Product (золото)

package Lesson2;

public class GoldReward implements iGameItem{
    @Override
    public void open() {
        System.out.println("Gold");
    }
}