package com.kulichx;

import com.kulichx.Entitys.dynamics.Herbivore;
import com.kulichx.Entitys.dynamics.Predator;
import com.kulichx.Entitys.statics.Coordinates;
import com.kulichx.Entitys.statics.Entity;
import com.kulichx.Entitys.statics.Grass;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;

@Getter
public class MapEntity {
    HashMap<Coordinates, Entity> entity = new HashMap<>();

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
    public void removeEntity(Coordinates coordinates) {
        entity.remove(coordinates);
    }
    public Collection<Entity> getValues(){
        return  entity.values();
    }
    public HashMap<Coordinates, Entity> getEntityMap() {
        return entity;
    }
    public boolean containsKey(Coordinates coordinates){
        return this.entity.containsKey(coordinates);
    }
    public <T> HashMap<Coordinates, T> getEntityOfType(Class<T> typeEntity){
        HashMap<Coordinates, T> res = new HashMap<>();
        for (var entry : getEntityMap().entrySet()){
            if (typeEntity.isInstance(entry.getValue())){
                res.put(entry.getKey(), (T) entry.getValue());
            }
        }
        return res;
    }
    public void makeMove(Coordinates start, Coordinates end){
        Entity entity = this.entity.remove(start);
        setEntity(end, entity);
    }
    public boolean isExistingOfHerbivores(){
        return entity.values().stream().anyMatch(Herbivore.class::isInstance);
    }

    public boolean isExistingOfPredators(){
        return entity.values().stream().anyMatch(Predator.class::isInstance);
    }

    public boolean isExistingOfGrass(){
        return entity.values().stream().anyMatch(Grass.class::isInstance);
    }

    public void addObject(Entity entity){
        this.entity.put(entity.getCoordinates(), entity);
    }
}
