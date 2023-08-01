package com.kulichx;

import com.kulichx.Entitys.statics.Grass;
import com.kulichx.actions.Action;
import com.kulichx.actions.InitAction;
import com.kulichx.actions.TurnAction;

public class Simulation {
    public static int width;
    public static int height;

    private final MapRenderer render = new MapRenderer();
    private final InitAction initActions = new InitAction();
    private final Action moveActions = new TurnAction();
    private final MapEntity map = new MapEntity();

    public Simulation(int width, int height){
        Simulation.width = width;
        Simulation.height = height;
        initActions.perfActions(map);
    }

    //кол-во выполненных шагов симуляции
    private int countMove;

    //просимулировать и отрендерить один ход
    private void nextTurn(){
        try {
            countMove++;
            moveActions.perfActions(map);
            render.render(map);
            Thread.sleep(2000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    //запустить бесконечный цикл симуляции и рендеринга
    public void startSimulation(){
        render.render(map);
        System.out.println();
        while (map.isExistingOfHerbivores() && map.isExistingOfPredators()){
            this.nextTurn();
            System.out.println(countMove);
            if (!map.isExistingOfGrass()){
                map.addObject(initActions.createOneEntity(Grass.class, initActions.freeCoordinatesMap(map)));
                map.addObject(initActions.createOneEntity(Grass.class, initActions.freeCoordinatesMap(map)));
                map.addObject(initActions.createOneEntity(Grass.class, initActions.freeCoordinatesMap(map)));
            }
        }
        if (map.isExistingOfHerbivores()) {
            System.out.println("Победа травоядных");
        } else {
            System.out.println("Победа хищников");
        }
    }

    //приостановить бесконечный цикл симуляции и рендеринга
    public void pauseSimulation(){

    }
}