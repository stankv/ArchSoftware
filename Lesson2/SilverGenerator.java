package Lesson2;

public class SilverGenerator extends ItemFabric {
    
    @Override
    public iGameItem createItem() {
        return new SilverReward();
    }
}
