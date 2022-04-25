package my_project.model.enemy;

import my_project.model.Player;
import my_project.model.maze.Tilemap;

import java.awt.*;

public class Knight extends Enemy{

    public Knight(String name, double x, double y, Player player, Tilemap tilemap) {
        super(name, x, y, 3, 2, 80, player, tilemap, Color.GRAY);
    }

    @Override
    public void update(double dt) {
        if(checkRange()) super.update(dt);
    }

    private boolean checkRange(){
        return (super.player.getX() > 1275);
    }
}