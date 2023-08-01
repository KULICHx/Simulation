package com.kulichx.Entitys.statics;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Entity {
    public Coordinates coordinates;

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}
