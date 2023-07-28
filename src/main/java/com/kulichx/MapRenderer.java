package com.kulichx;

import com.kulichx.Entitys.Entity;

public class MapRenderer {
    public void render(Map map){
        System.out.print("   ");
        for(int width = 0; width < map.width; width++){
            System.out.print(" Y" + width + " ");
        }
        System.out.println();
        for (int x = 0; x < map.height; x++){
            System.out.print("X" + x);
            for (int y = 0; y <= map.width; y++){
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
                return "\uD83C\uDF3F";
            case "Rock":
                return "\uD83E\uDEA8";
            case "Tree":
                return "\uD83C\uDF33";
            case "Herbivore":
                return "\uD83D\uDC30";
            case "Predator":
                return "\uD83E\uDD8A";
        }
        return "";
    }
    public String getEntitySprite(Entity entity){
        return " " + selectUnicodeSpriteForEntity(entity) + " ";
    }
}
