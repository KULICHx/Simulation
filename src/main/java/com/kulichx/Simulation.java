package com.kulichx;

import com.kulichx.Actions.Action;
import com.kulichx.Actions.InitAction;
import com.kulichx.Entitys.Entity;
import com.kulichx.Entitys.Grass;
import com.kulichx.Entitys.Herbivore;
import com.kulichx.Entitys.Predator;

public class Simulation {
    public static void main(String[] args) {

        InitAction action = new InitAction();
        MapRenderer renderer= new MapRenderer();
        renderer.render(action.initMap());
    }
}
