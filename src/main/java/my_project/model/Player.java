package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.maze.Tilemap;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private double dtf;

    private boolean load;
    private DrawTool drawTool;

    private final Tilemap tilemap;

    private double speed;
    private char direction;
    private int damage, hp;
    private double attackTimer, startAttackTimer;
    private boolean boolAttackTimer;

    private final int keyToGoLeft, keyToGoRight, keyToGoUp, keyToGoDown;

    public Player(double x, double y, Tilemap tilemap,double startAttackTimer) {
        this.x = x;
        this.y = y;
        load = false;
        speed = 200;
        hp = 12;
        damage = 1;
        this.startAttackTimer = startAttackTimer;
        attackTimer = startAttackTimer;
        width = 60;
        height = 60;
        boolAttackTimer = false;

        this.tilemap = tilemap;

        this.keyToGoLeft = KeyEvent.VK_A;
        this.keyToGoRight = KeyEvent.VK_D;
        this.keyToGoUp = KeyEvent.VK_W;
        this.keyToGoDown = KeyEvent.VK_S;
        this.direction = 'n';
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.RED);
        drawTool.drawFilledCircle(x, y, 30);
        drawTool.drawText(x - 30, y - 30, "" + hp);
        drawTool.setCurrentColor(Color.GRAY);
        drawTool.drawCircle(x, y, 70);
        if (!load) {
            this.drawTool = drawTool;
        }
    }

    @Override
    public void update(double dt) {
        dtf = dt;

        if (direction == 'd') {
            if (tilemap.isAbleToMoveHorizontal(x, y, 1)) x = x + speed * dt;
            if (x >= 2400 - width) x = 2400 - width;
        } else if (direction == 'a') {
            if (tilemap.isAbleToMoveHorizontal(x, y, -1)) x = x - speed * dt;
            if (x <= -1200) x = -1200;
        } else if (direction == 's') {
            if (tilemap.isAbleToMoveVertical(x, y, 1)) y = y + speed * dt;
            if (y >= 900) y = 900;
        } else if (direction == 'w') {
            if (tilemap.isAbleToMoveVertical(x, y, -1)) y = y - speed * dt;
            if (y <= -900) y = -900;
        }

        if (boolAttackTimer) attackTimer -= dt;
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){ direction = 'a'; }
        if(key == keyToGoRight){ direction = 'd'; }
        if(key == keyToGoDown) { direction = 's'; }
        if(key == keyToGoUp) { direction ='w'; }
        if(key == KeyEvent.VK_P) { System.out.println("x: " + x + ", y: " + y); }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft || key == keyToGoRight || key == keyToGoDown || key == keyToGoUp){
            direction = 'n';
        }
    }

    public DrawTool getDrawTool() {
        if (!(drawTool == null)) load = true;
        return drawTool;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public int getDamage() { return damage; }
    public double getAttackTimer() { return attackTimer; }
    public double getStartAttackTimer() { return startAttackTimer; }
    public int getHp() { return hp; }

    public void setStartAttackTimer(double st) {startAttackTimer = st;}
    public void setX(double newX){ x = newX; }
    public void setY(double newY) { y = newY; }
    public void setBoolAttackTimer(boolean nBoolAttackTimer) { boolAttackTimer = nBoolAttackTimer; }
    public void setHp(int newHP) { hp = newHP; }
    public void setAttackTimer(double newAttackTimer) { attackTimer = newAttackTimer; }
}