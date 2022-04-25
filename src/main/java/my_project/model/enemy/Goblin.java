package my_project.model.enemy;

import my_project.model.Player;
import my_project.model.maze.Tilemap;

import java.awt.*;

public class Goblin extends Enemy{

    public Goblin(String name, double x, double y, Player player, Tilemap tilemap) {
        super(name, x, y, 2, 1, 100, player, tilemap, Color.BLUE);
    }

    @Override
    public void update(double dt) {
        if(checkRange()) super.update(dt);
    }

    private boolean checkRange(){
        return (super.player.getX() < 1125)
                && (super.player.getY() > 75-900 && super.player.getY() < 825-900);
    }
}