package Lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        ItemFabric generator = new GoldGenerator();
        generator.openReward();
        generator = new GemGenerator();
        generator.openReward();

        System.out.println("--------------------------------");

        Random rnd = ThreadLocalRandom.current();
        List<ItemFabric> fabricList = new ArrayList<>();

        int numberOfRewards = 4;
        fabricList.add(new GoldGenerator());
        fabricList.add(new GemGenerator());
        fabricList.add(new SilverGenerator());
        fabricList.add(new PlatinumGenerator());

        for(int i = 0; i < 20; i++) {
            int index = Math.abs(rnd.nextInt(numberOfRewards));
            ItemFabric fabric = fabricList.get(index);
            fabric.openReward();
        }
    }
}

