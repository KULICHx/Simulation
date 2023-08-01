package com.kulichx.Entitys.dynamics;


import com.kulichx.Entitys.statics.Coordinates;
import com.kulichx.Entitys.statics.Entity;
import com.kulichx.MapEntity;
import com.kulichx.Node;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public abstract class Creature extends Entity {

    private int hp;

    final int speed;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }

    public void makeMove(MapEntity map, Class<?> obstacle){
        this.setHp(this.hp-1);
        List<Coordinates> path = findPath(map, obstacle);
        if (path == null || path.isEmpty()) {
            if (this.hp == 0){
                map.removeEntity(this.getCoordinates());
            }
            return;
        }
        for (int i = 0; i < this.speed; i++) {
            if (path.size() - 1 == i) {
                if (this instanceof Predator predator){
                    Creature entityHerbivore = (Creature) map.getEntity(path.get(0));
                    entityHerbivore.setHp(entityHerbivore.getHp() - predator.getAttackPower());
                    if (entityHerbivore.hp <= 0){
                        map.makeMove(this.getCoordinates(), path.get(i));
                        this.setHp(this.hp + 1);
                    }
                } else {
                    map.makeMove(this.getCoordinates(), path.get(i));
                    this.setHp(this.hp + 1);
                }
            } else {
                if (this.hp == 0){
                    map.removeEntity(this.getCoordinates());
                } else {
                    map.makeMove(this.getCoordinates(), path.get(path.size() - 1));
                }
            }
        }
    }


    //находим самый короткий путь до поедания (если это травоядный, то это самый короткий путь до травы,
    //  если это хищник, то это самый короткий путь до травоядного)
    private List<Coordinates> findPath(MapEntity map, Class<?> obstacle){
        List<Coordinates> path = null;
        List<Coordinates> tmp;
        for (var entity : map.getEntityMap().entrySet()){
            if (!obstacle.isInstance(entity.getValue())) continue;
            if (path == null) {
                path = Node.aStar(this.getCoordinates(), entity.getKey(), map, obstacle);
                continue;
            }
            tmp = Node.aStar(this.getCoordinates(), entity.getKey(), map, obstacle);
            if (tmp != null && tmp.size() < path.size()) path = tmp;
        }
        return path;
    }
}
