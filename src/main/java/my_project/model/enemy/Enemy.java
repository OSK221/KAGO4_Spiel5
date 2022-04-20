package my_project.model.enemy;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Player;
import my_project.model.maze.Tilemap;

import java.awt.*;

public abstract class Enemy extends GraphicalObject {

    private String name;
    private double x, y;
    private int lives, strength, speed;
    protected Player player;
    private Color color;

    protected boolean freeze;
    protected double freezeTimer;

    private Tilemap tilemap;

    public Enemy(String name, double x, double y, int lives, int strength, int speed, Player player, Tilemap tilemap, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.lives = lives;
        this.strength = strength;
        this.speed = speed;
        this.player = player;
        this.tilemap = tilemap;
        this.color = color;
    }

    @Override
    public void update(double dt){
        double dx = player.getX() - x;
        double dy = player.getY() - y;

        double dist = Math.hypot(dx, dy);

        if(!freeze && dist < 55) {
            //Hit
            freezeTimer = 0;
            freeze = true;
        }else if(freeze){
            freezeTimer += dt;
            if(freezeTimer > 1) freeze = false;
        }else {
            dx = dx / dist;
            dy = dy / dist;

            if(tilemap != null) {
                if (tilemap.isAbleToMoveHorizontal(x, y, dx * dt * speed)) x += dx * dt * speed;
                if (tilemap.isAbleToMoveVertical(x, y, dy * dt * speed)) y += dy * dt * speed;
            }else{ //Ein Vogel kennt keine Grenzen :)
                x += dx * dt * speed;
                y += dy * dt * speed;
            }

        }
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(color);
        drawTool.drawFilledCircle(x, y, 30);
        drawTool.drawText(x-30,y-30,"" + lives);
    }

    public void hitEnemy(int damage){
        lives -= damage;
    }

}