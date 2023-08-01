package com.kulichx.Entitys.dynamics;

import com.kulichx.Entitys.statics.Coordinates;

public class Predator extends Creature {

    private final int attackPower;

    public Predator(Coordinates coordinates, int speed, int hp, int attackPower) {
        super(coordinates, speed, hp);
        this.attackPower = attackPower;
    }
    public int getAttackPower() {
        return attackPower;
    }
}
