package com.kulichx.actions;

import com.kulichx.Entitys.dynamics.Creature;
import com.kulichx.Entitys.statics.Grass;
import com.kulichx.Entitys.dynamics.Herbivore;
import com.kulichx.MapEntity;


public class TurnAction extends Action{

    public void perfActions(MapEntity map) {
        for (var entity : map.getEntityOfType(Creature.class).entrySet()){
            entity.getValue().makeMove(map, (entity.getValue() instanceof Herbivore) ? Grass.class : Herbivore.class);
            System.out.println("Health " + entity.getValue().getClass().getSimpleName() + ": " +entity.getValue().getHp());
        }
    }
}
