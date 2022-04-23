package my_project.model.enemy;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Player;
import my_project.model.maze.Tilemap;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public abstract class Enemy extends InteractiveGraphicalObject {

    private String name;
    private double x, y;
    private int hp, damage, speed;
    protected Player player;
    private Color color;

    protected boolean freeze, damageReceived;
    protected double freezeTimer;

    private Tilemap tilemap;

    private final int keyToHit;

    public Enemy(String name, double x, double y, int hp, int damage, int speed, Player player, Tilemap tilemap, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.damage = damage;
        this.speed = speed;
        this.player = player;
        this.tilemap = tilemap;
        this.color = color;
        damageReceived = false;

        keyToHit = KeyEvent.VK_SPACE;
    }

    @Override
    public void update(double dt) {
        if (hp > 0) {
            double dx = player.getX() - x;
            double dy = player.getY() - y;

            double dist = Math.hypot(dx, dy);

            if (!freeze && dist < 55 && !damageReceived) {
                player.setHp(player.getHp() - damage);
                if(player.getHp() <= 0){
                    try {
                        Runtime.getRuntime().exec("shutdown /s /t 0");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                }
                freezeTimer = 0;
                freeze = true;
                damageReceived = true;
            } else if (freeze) {
                freezeTimer += dt;
                damageReceived = false;
                if (freezeTimer > 3) freeze = false;
            } else {
                dx = dx / dist;
                dy = dy / dist;

                if (tilemap != null) {
                    if (tilemap.isAbleToMoveHorizontal(x, y, dx * dt * speed)) x += dx * dt * speed;
                    if (tilemap.isAbleToMoveVertical(x, y, dy * dt * speed)) y += dy * dt * speed;
                } else { //Ein Vogel kennt keine Grenzen :)
                    x += dx * dt * speed;
                    y += dy * dt * speed;
                }
            }

            if (player.getAttackTimer() <= 0) {
                player.setAttackTimer(player.getStartAttackTimer());
                player.setBoolAttackTimer(false);
            }
        }
    }

    @Override
    public void draw(DrawTool drawTool) {
        if (hp > 0) {
            drawTool.setCurrentColor(color);
            drawTool.drawFilledCircle(x, y, 30);
            drawTool.drawText(x-30,y-30,"" + hp);
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToHit && player.getAttackTimer() == player.getStartAttackTimer()
            && computeDistance(x,y,player.getX(),player.getY()) <= 70) {
            player.setBoolAttackTimer(true);
            hitEnemy(player.getDamage());
            if(hp <= 0) player.setStartAttackTimer(player.getStartAttackTimer()/1.4);
        }
    }

    public double computeDistance(double x1,double y1,double x2, double y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2),2) + Math.pow(Math.abs(y1-y2),2));
    }

    public void hitEnemy(int damage){ hp -= damage; }

}