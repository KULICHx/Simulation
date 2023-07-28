package com.kulichx;

import com.kulichx.Entitys.Grass;
import com.kulichx.Entitys.Herbivore;
import com.kulichx.Entitys.Predator;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map(5,5);
        MapRenderer renderer= new MapRenderer();
        map.setEntity(new Coordinates(0,0),new Herbivore(new Coordinates(0,0)));
        renderer.render(map);
    }
}
