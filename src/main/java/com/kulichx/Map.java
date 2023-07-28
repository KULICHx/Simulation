package com.kulichx;

import com.kulichx.Entitys.Entity;

import java.util.HashMap;

public class Map {
    final int width;
    final int height;
    HashMap<Coordinates, Entity> entity = new HashMap<>();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        this.entity.put(coordinates,entity);
    }

    public boolean isSquareEmpty(Coordinates coordinates){
        return !entity.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates){
        return entity.get(coordinates);
    }
}
