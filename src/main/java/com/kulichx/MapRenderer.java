package com.kulichx;

import com.kulichx.Entitys.Entity;

public class MapRenderer {
    public void render(Map map){
        System.out.print("   ");
        for(int width = 0; width < map.getWidth(); width++){
            System.out.print(" Y" + width + " ");
        }
        System.out.println();
        for (int x = 0; x < map.getHeight(); x++){
            System.out.print("X" + x);
            for (int y = 0; y <= map.getWidth(); y++){
                Coordinates coordinates = new Coordinates(y, x);
                if (map.isSquareEmpty(coordinates)){
                    System.out.print("|   ");
                } else {
                    System.out.print("|" + getEntitySprite(map.getEntity(coordinates)));
                }
            }
            System.out.println();
        }
    }
    private String selectUnicodeSpriteForEntity(Entity entity){
        switch (entity.getClass().getSimpleName()){
            case "Grass":
                return "Grs";
            case "Rock":
                return "Rok";
            case "Tree":
                return "Tre";
            case "Herbivore":
                return "Her";
            case "Predator":
                return "Pre";
        }
        return "";
    }
    public String getEntitySprite(Entity entity){
        return "" + selectUnicodeSpriteForEntity(entity) + "";
    }
}
