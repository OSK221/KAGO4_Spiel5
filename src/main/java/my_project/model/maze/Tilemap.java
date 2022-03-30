package my_project.model.maze;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.ArrayList;

public class Tilemap extends GraphicalObject {

    private ArrayList<TileBase> allTiles;

    public Tilemap(){
        allTiles = new ArrayList<>();
        Maze.area(this,1);
        Maze.area(this,2);
        Maze.area(this,3);
        Maze.area(this,4);
        Maze.area(this,5);
        Maze.area(this,6);
        load();
    }

    @Override
    public void draw(DrawTool drawTool){
        for (int i = 0; i < allTiles.size(); i++) {
            allTiles.get(i).draw(drawTool);
        }
    }

    @Override
    public void update(double dt){
        for (int i = 0; i < allTiles.size(); i++) {
            allTiles.get(i).update(dt);
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
                                allTiles.remove(j);
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
                                allTiles.remove(j);
                            }
                        }
                    }
                }
            }
        }while (reload);
    }

    public void add(TileBase tileBase){
        allTiles.add(tileBase);
    }

    public void remove(int index){
        allTiles.remove(index);
    }
}