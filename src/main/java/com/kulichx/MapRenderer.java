package com.kulichx;

import com.kulichx.Entitys.statics.Coordinates;
import com.kulichx.Entitys.statics.Entity;

public class MapRenderer {
    public void render(MapEntity mapEntity){
        System.out.print("   ");
        for(int width = 0; width < Simulation.width; width++){
            System.out.print(" Y" + width + " ");
        }
        System.out.println();
        for (int x = 0; x < Simulation.height; x++){
            System.out.print("X" + x);
            for (int y = 0; y <= Simulation.width; y++){
                Coordinates coordinates = new Coordinates(x, y);
                if (mapEntity.isSquareEmpty(coordinates)){
                    System.out.print("|   ");
                } else {
                    System.out.print("|" + getEntitySprite(mapEntity.getEntity(coordinates)));
                }
            }
            System.out.println();
        }
    }
    private String selectUnicodeSpriteForEntity(Entity entity){
        return switch (entity.getClass().getSimpleName()) {
            case "Grass" -> "Grs";
            case "Rock" -> "Rok";
            case "Tree" -> "Tre";
            case "Herbivore" -> "Her";
            case "Predator" -> "Pre";
            default -> "";
        };
    }
    public String getEntitySprite(Entity entity){
        return "" + selectUnicodeSpriteForEntity(entity) + "";
    }
}
