package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private boolean load;
    private DrawTool drawTool;

    private double speed;
    private int keyToGoLeft;
    private int keyToGoRight;
    private int direction;
    private double damage;
    private int level;
    private int enemyTillNextLevel;
    private double hp;
    private double attackTimer;
    private int money;
    private double animationTimer;

    public Player(double x, double y) {
        this.x = x;
        this.y = y;
        load = false;
        speed = 450;
        width = 60;
        height = 60;

        this.keyToGoLeft = KeyEvent.VK_A;
        this.keyToGoRight = KeyEvent.VK_D;
        this.direction = -1;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.RED);
        drawTool.drawFilledRectangle(x - 30, y - 30, 60, 60);
        if (!load) {
            this.drawTool = drawTool;
        }
    }

    @Override
    public void update(double dt) {
        if (direction==0) {
            x = x + speed*dt;
            if (x >= 1000 - width) {
                x = 1000-width;
            }
        } else if (direction == 2) {
            x = x-speed*dt;
            if (x<=0) {
                x = 0;
            }
        }
    }

    public DrawTool getDrawTool() {
        if (!(drawTool == null)) load = true;
        return drawTool;
    }

    public void hit() {

    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){
            direction = 2;
        }
        if(key == keyToGoRight){
            direction = 0;
        }
    }

    @Override
    public void keyReleased(int key) {
        if(key == keyToGoLeft){
            direction = -1;
        }
        if(key == keyToGoRight){
            direction = -1;
        }
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getSpeed() { return speed; }

    public void setX(double newX){ x = newX; }
    public void setY(double newY) { y = newY; }
    public void setSpeed(double newSpeed) { speed = newSpeed; }
}
