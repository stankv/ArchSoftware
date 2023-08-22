package Lesson2;

public class PlatinumGenerator extends ItemFabric {
    
    @Override
    public iGameItem createItem() {
        return new PlatinumReward();
    }
}
