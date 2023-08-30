package Lesson2;

public class GoldFabric extends ItemFabric {
    
    @Override
    public iGameItem createItem() {
        return new GoldReward();
    }
}
