package my_project.model.maze;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.util.ArrayList;

public class Tilemap extends GraphicalObject {

    private final ArrayList<TileBase> allTiles;

    public Tilemap(){
        allTiles = new ArrayList<>();
        Maze.area(this);
        load();
    }

    @Override
    public void draw(DrawTool drawTool){
        for (TileBase tile : allTiles) {
            tile.draw(drawTool);
        }
    }

    private void load(){
        boolean reload;
        do{
            reload = false;
            for (int i = 0; i < allTiles.size(); i++) {
                for (int j = 0; j < allTiles.size(); j++) {
                    if (!reload) {
                        if (allTiles.get(i).getTyp().equals(allTiles.get(j).getTyp()) & allTiles.get(i).getHeight() == allTiles.get(j).getHeight()) {
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
                        if (allTiles.get(i).getTyp().equals(allTiles.get(j).getTyp()) & allTiles.get(i).getWidth() == allTiles.get(j).getWidth()) {
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
        for (TileBase tile : allTiles) {
            if (tile.getTyp().equals("ground")) {
                for (int i = 0; i < tile.getWidth(); i++) {
                    for (int j = 0; j < tile.getHeight(); j++) {
                        viewController.draw(new Grass((tile.getX() + i) * 60 + Math.random() * 38 + 1, (tile.getY() + j) * 60 + Math.random() * 43 + 1));
                    }
                }
            }
        }
    }

    public boolean isAbleToMoveHorizontal(double x, double y, double speed){
        for (TileBase tile : allTiles) {
            if (tile.isCollider()) {
                if (speed > 0) {
                    if (tile.getX() * 60 - 30 < x && x < tile.getX() * 60 && tile.getY() * 60 - 15 < y && y < (tile.getY() + tile.getHeight()) * 60 + 15) {
                        return false;
                    }
                } else {
                    if ((tile.getX() + tile.getWidth()) * 60 < x && x < (tile.getX() + tile.getWidth()) * 60 + 30 && tile.getY() * 60 - 15 < y && y < (tile.getY() + tile.getHeight()) * 60 + 15) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isAbleToMoveVertical(double x, double y, double speed){
        for (TileBase tile : allTiles) {
            if (tile.isCollider()) {
                if (speed > 0) {
                    if (tile.getX() * 60 - 15 < x && x < (tile.getX() + tile.getWidth()) * 60 + 15 && tile.getY() * 60 - 30 < y && y < tile.getY() * 60) {
                        return false;
                    }
                } else {
                    if (tile.getX() * 60 - 15 < x && x < (tile.getX() + tile.getWidth()) * 60 + 15 && (tile.getY() + tile.getHeight()) * 60 < y && y < (tile.getY() + tile.getHeight()) * 60 + 30) {
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