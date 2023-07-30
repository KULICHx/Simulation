package com.kulichx.Actions;

import com.kulichx.Coordinates;
import com.kulichx.Entitys.*;
import com.kulichx.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class InitAction extends Action {


    public Map initMap() {
        Map map = new Map(5, 5);

        HashMap<Integer, Integer> pool = createObjectPoolForMap(map);

        for (int i = 0; i < pool.size(); i++) {
            int amountOfEntity = pool.get(i);

            for (int j = 0; j < amountOfEntity; j++) {
                if (i == 0) {
                    Grass grass = new Grass(new Coordinates(1,1));
                    map.setEntity(getRandomEmptyCell(map),grass);
                }
                if (i == 1) {
                    Tree tree = new Tree(new Coordinates(1, 1));
                    map.setEntity(getRandomEmptyCell(map), tree);
                }
                if (i == 2) {
                    Rock rock = new Rock(new Coordinates(1, 1));
                    map.setEntity(getRandomEmptyCell(map), rock);
                }
                if (i == 3) {
                    Herbivore herbivore = new Herbivore(new Coordinates(1,1),1,10);
                    map.setEntity(getRandomEmptyCell(map),herbivore);
                }
                if (i == 4) {
                    Predator predator = new Predator(new Coordinates(1,1),2,10,5);
                    map.setEntity(getRandomEmptyCell(map),predator);
                }
            }
        }
        return map;
    }

    private HashMap<Integer, Integer> createObjectPoolForMap(Map map) {
        HashMap<Integer, Integer> pool = new HashMap<>();

        int amountOfGrass =  map.getHeight() * map.getWidth() / 7;
        pool.put(0, amountOfGrass);

        int amountOfRocks = map.getHeight() * map.getWidth() / 20;
        pool.put(1, amountOfRocks);

        int amountOfTress = map.getHeight() * map.getWidth() / 20 ;
        pool.put(2, amountOfTress);

        int amountOfHerbivores = map.getHeight() * map.getWidth() / 10;
        pool.put(3, amountOfHerbivores);

        int amountOfPredators = map.getHeight() * map.getWidth() / 10;
        pool.put(4, amountOfPredators);

        return pool;
    }

    private Coordinates getRandomEmptyCell(Map map) {
        List<Coordinates> coordinates = new ArrayList<>();
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (map.isSquareEmpty(new Coordinates(i, j))) {
                    coordinates.add(new Coordinates(i, j));
                }
            }
        }
        return coordinates.get(new Random().nextInt(coordinates.size()));
    }
}