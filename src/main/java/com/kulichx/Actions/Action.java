package com.kulichx.Actions;

import com.kulichx.Coordinates;
import com.kulichx.Entitys.*;
import com.kulichx.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Action<T extends Entity> {
    /*
    double spawnRate;
    public void perform(Map map) throws IllegalArgumentException {
        int rate = 0;
        while (rate < spawnRate) {
            Coordinates coordinates;
            try {
                coordinates = getRandomEmptyCell(map);
                map.setEntity(coordinates, createEntity());
                rate++;
            } catch (IllegalArgumentException e) {
                System.out.println("На карте не хватает места : " + e.getMessage());
                break;
            }
        }
    }

*/
}
