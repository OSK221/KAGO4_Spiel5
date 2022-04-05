package my_project.model.maze;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.ArrayList;

public class Tilemap extends GraphicalObject {

    private ArrayList<TileBase> allTiles;

    public Tilemap(){
        allTiles = new ArrayList<>();
        Maze.area(this);
    }

    @Override
    public void draw(DrawTool drawTool){
        for (int i = 0; i < allTiles.size(); i++) {
            allTiles.get(i).draw(drawTool);
        }
    }

    public void load(){
        boolean reload;
        do{
            reload = false;
            for (int i = 0; i < allTiles.size(); i++) {
                for (int j = 0; j < allTiles.size(); j++) {
                    if (!reload) {
                        if (allTiles.get(i).getTyp() == allTiles.get(j).getTyp() & allTiles.get(i).getHeight() == allTiles.get(j).getHeight()) {
                            if (allTiles.get(i).getX() + allTiles.get(i).getWidth() == allTiles.get(j).getX() && allTiles.get(i).getY() == allTiles.get(j).getY()) {
                                allTiles.get(i).setWidth(allTiles.get(i).getWidth()+allTiles.get(j).getWidth());
                                reload = true;
                                remove(j);
                            }
                        }
                    }
                }
            }
        }while (reload);
        do{
            reload = false;
            for (int i = 0; i < allTiles.size(); i++) {
                for (int j = 0; j < allTiles.size(); j++) {
                    if (!reload) {
                        if (allTiles.get(i).getTyp() == allTiles.get(j).getTyp() & allTiles.get(i).getWidth() == allTiles.get(j).getWidth()) {
                            if (allTiles.get(i).getY() + allTiles.get(i).getHeight() == allTiles.get(j).getY() && allTiles.get(i).getX() == allTiles.get(j).getX()) {
                                allTiles.get(i).setHeight(allTiles.get(i).getHeight()+allTiles.get(j).getHeight());
                                reload = true;
                                remove(j);
                            }
                        }
                    }
                }
            }
        }while (reload);
    }

    public void generateGrass(ViewController viewController){
        for (int i = 0; i < allTiles.size(); i++) {
            if (allTiles.get(i).getTyp() == "ground"){
                for (int j = 0; j < allTiles.get(i).getWidth(); j++) {
                    for (int k = 0; k < allTiles.get(i).getHeight(); k++) {
                        viewController.draw(new Grass((allTiles.get(i).getX()+j)*60+Math.random()*40,(allTiles.get(i).getY()+k)*60+Math.random()*40));
                    }
                }
            }
        }
    }

    public boolean isAbleToMoveHorizontal(double x, double y, double speed){
        for (int i = 0; i < allTiles.size(); i++) {
            if (allTiles.get(i).isCollider()){
                if (speed > 0){
                    if (allTiles.get(i).getX()*60-30 < x && x < allTiles.get(i).getX()*60 && allTiles.get(i).getY()*60-15 < y && y < (allTiles.get(i).getY() + allTiles.get(i).getHeight())*60+15){
                        return false;
                    }
                }else{
                    if ((allTiles.get(i).getX() + allTiles.get(i).getWidth())*60 < x && x < (allTiles.get(i).getX() + allTiles.get(i).getWidth())*60+30 && allTiles.get(i).getY()*60-15 < y && y < (allTiles.get(i).getY() + allTiles.get(i).getHeight())*60+15){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isAbleToMoveVertical(double x, double y, double speed){
        for (int i = 0; i < allTiles.size(); i++) {
            if (allTiles.get(i).isCollider()){
                if (speed > 0){
                    if (allTiles.get(i).getX()*60-15 < x && x < (allTiles.get(i).getX() + allTiles.get(i).getWidth())*60+15 && allTiles.get(i).getY()*60-30 < y && y < allTiles.get(i).getY()*60){
                        return false;
                    }
                }else{
                    if (allTiles.get(i).getX()*60-15 < x && x < (allTiles.get(i).getX() + allTiles.get(i).getWidth())*60+15 && (allTiles.get(i).getY() + allTiles.get(i).getHeight())*60 < y && y < (allTiles.get(i).getY() + allTiles.get(i).getHeight())*60+30){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void add(TileBase tileBase){
        allTiles.add(tileBase);
    }

    public void remove(int index){
        allTiles.remove(index);
    }
}