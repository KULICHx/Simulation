package com.kulichx.actions;

import com.kulichx.Entitys.statics.Coordinates;
import com.kulichx.Entitys.dynamics.Herbivore;
import com.kulichx.Entitys.dynamics.Predator;
import com.kulichx.Entitys.statics.Entity;
import com.kulichx.Entitys.statics.Grass;
import com.kulichx.Entitys.statics.Rock;
import com.kulichx.Entitys.statics.Tree;
import com.kulichx.MapEntity;
import com.kulichx.Simulation;

import java.util.Random;

public class InitAction extends Action {


    private final Random random = new Random();

    @Override
    public void perfActions(MapEntity map) {
        Coordinates coordinates;
        for (int i = 0; i < 5; i++) {
            coordinates = freeCoordinatesMap(map);
            map.getEntityMap().put(coordinates, createOneEntity(Grass.class, coordinates));
        }
        for (int i = 0; i < 5; i++) {
            coordinates = freeCoordinatesMap(map);
            map.getEntityMap().put(coordinates, createOneEntity(Tree.class, coordinates));
        }
        for (int i = 0; i < 5; i++) {
            coordinates = freeCoordinatesMap(map);
            map.getEntityMap().put(coordinates, createOneEntity(Rock.class, coordinates));
        }
        for (int i = 0; i < 5; i++) {
            coordinates = freeCoordinatesMap(map);
            map.getEntityMap().put(coordinates, createOneEntity(Herbivore.class, coordinates));
        }
        for (int i = 0; i < 3; i++) {
            coordinates = freeCoordinatesMap(map);
            map.getEntityMap().put(coordinates, createOneEntity(Predator.class, coordinates));
        }
    }

    public Entity createOneEntity(Class<?> clazz, Coordinates coordinates){
        switch (clazz.getSimpleName()) {
            case "Grass" -> {
                return new Grass(coordinates);
            }
            case "Tree" -> {
                return new Tree(coordinates);
            }
            case "Rock" -> {
                return new Rock(coordinates);
            }
            case "Herbivore" -> {
                return new Herbivore(coordinates, 1, 7);
            }
            case "Predator" -> {
                return new Predator(coordinates, 1, 5, 1);
            }
            default -> {
                return null;
            }
        }
    }

    public Coordinates freeCoordinatesMap(MapEntity map){
        Coordinates coordinates;
        while (true) {
            int height = random.nextInt(Simulation.height);
            int width = random.nextInt(Simulation.width);
            coordinates = new Coordinates(width, height);
            if (!map.getEntityMap().containsKey(coordinates)) return coordinates;
        }
    }
}