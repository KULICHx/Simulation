package com.kulichx.Entitys;

import com.kulichx.Coordinates;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Creature extends Entity{
    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }
    public int hp;
    final int speed;
    abstract void makeMove();
}
