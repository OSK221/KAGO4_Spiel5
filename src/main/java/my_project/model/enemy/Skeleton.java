package my_project.model.enemy;

import my_project.model.Player;
import my_project.model.maze.Tilemap;

import java.awt.*;

public class Skeleton extends Enemy{

    public Skeleton(String name, double x, double y, int lives, int strength, int speed, Player player, Tilemap tilemap) {
        super(name, x, y, lives, strength, speed, player, tilemap, Color.WHITE);
    }
}