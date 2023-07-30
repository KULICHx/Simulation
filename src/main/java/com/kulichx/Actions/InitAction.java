package com.kulichx.Actions;

import com.kulichx.Coordinates;
import com.kulichx.Entitys.*;
import com.kulichx.Map;

import java.util.HashMap;
import java.util.Random;

public class InitAction extends Action {

    private Map map;

    public Map initMap() {
        map = new Map(10,10);

        HashMap<Integer, Integer> pool = createObjectPoolForMap(map);

        for (int i = 0; i < pool.size(); i++) {
            int amountOfEntity = pool.get(i);

            for (int j = 0; j < amountOfEntity; j++) {
                if (i == 0) {
                    Grass grass = new Grass(new Coordinates(1,1));
                    map.setEntity(assignRandomCoordinatesToEntity(grass),grass);
                }
                if (i == 1) {
                    Herbivore herbivore = new Herbivore(new Coordinates(1,1),1,10);
                    map.setEntity(assignRandomCoordinatesToEntity(herbivore),herbivore);
                }
                if (i == 2) {
                    Predator predator = new Predator(new Coordinates(1,1),2,10, 5);
                    map.setEntity(assignRandomCoordinatesToEntity(predator),predator);
                }
                if (i == 3) {
                    Tree tree = new Tree(new Coordinates(1,1));
                    map.setEntity(assignRandomCoordinatesToEntity(tree),tree);
                }
                if (i == 4) {
                    Rock rock = new Rock(new Coordinates(1,1));
                    map.setEntity(assignRandomCoordinatesToEntity(rock),rock);
                }
            }
        }
        return map;
    }


    private HashMap<Integer, Integer> createObjectPoolForMap(Map map) {
        HashMap<Integer, Integer> pool = new HashMap<>();

        int x = map.getWidth();
        int y = map.getHeight();
        int mapArea = x * y;

        int amountOfGrass = mapArea / 2;
        pool.put(0, amountOfGrass);

        int amountOfHerbivores = amountOfGrass / 10;
        pool.put(1, amountOfHerbivores);

        int amountOfPredators = amountOfHerbivores / 5;
        pool.put(2, amountOfPredators);

        int amountOfTress = amountOfGrass / 10;
        pool.put(3, amountOfTress);

        int amountOfRocks = amountOfGrass / 10;
        pool.put(4, amountOfRocks);

        return pool;
    }


    private <T extends Entity> Coordinates assignRandomCoordinatesToEntity(T entity) {
        Random random = new Random();

        int randomX = random.nextInt(map.getWidth());
        int randomY = random.nextInt(map.getHeight());

        Coordinates coordinates = new Coordinates(randomY, randomX);

        entity.coordinates = coordinates;
        return coordinates;
    }
}