package my_project.model.enemy;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Player;
import my_project.model.maze.Tilemap;

import java.awt.*;

public class Enemy extends GraphicalObject {

    private String name;
    private double x, y;
    private int lives, strength, speed;
    private Player player;

    private Tilemap tilemap;

    public Enemy(String name, double x, double y, int lives, int strength, int speed, Player player, Tilemap tilemap) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.lives = lives;
        this.strength = strength;
        this.speed = speed;
        this.player = player;
        this.tilemap = tilemap;
    }

    @Override
    public void update(double dt){
        double dx = player.getX() - x;
        double dy = player.getY() - y;

        double dist = Math.hypot(dx, dy);

        if(dist < 55){
            //Hit
        }else {
            if (dist < 600) {
                dx = dx / dist;
                dy = dy / dist;

                if (tilemap.isAbleToMoveHorizontal(x, y, dx * dt * speed)) x += dx * dt * speed;
                if (tilemap.isAbleToMoveVertical(x, y, dy * dt * speed)) y += dy * dt * speed;
            }
        }
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.BLUE);
        drawTool.drawFilledCircle(x, y, 30);
    }

}