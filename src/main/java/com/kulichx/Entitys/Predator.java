package com.kulichx.Entitys;

import com.kulichx.Coordinates;

public class Predator extends Creature{


    public Predator(Coordinates coordinates, int speed, int hp, int attack) {
        super(coordinates, speed, hp);
        this.attack = attack;
    }

    final int attack;

    @Override
    void makeMove() {

    }
}
