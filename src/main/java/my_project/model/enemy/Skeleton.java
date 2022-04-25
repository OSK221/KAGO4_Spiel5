package my_project.model.enemy;

import KAGO_framework.view.DrawTool;
import my_project.model.Player;
import my_project.model.maze.Tilemap;

import java.awt.*;

public class Skeleton extends Enemy{

    public Skeleton(String name, double x, double y, Player player, Tilemap tilemap) {
        super(name, x, y, 5, 2, 20, player, tilemap, Color.WHITE);
    }

    @Override
    public void update(double dt) {
        if(checkRange(0)) super.update(dt);
    }

    @Override
    public void draw(DrawTool drawTool) {
        if(checkRange(770)) super.draw(drawTool);
    }

    private boolean checkRange(int addR){
        return (super.player.getX() > -1115 - addR && super.player.getX() < -75 + addR)
                && (super.player.getY() > 75 - addR && super.player.getY() < 825 + addR);
    }
}