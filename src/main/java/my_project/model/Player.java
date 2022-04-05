package my_project.model;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends InteractiveGraphicalObject {

    private double dtf;

    private boolean load;
    private DrawTool drawTool;

    private double speed;
    private int keyToGoLeft;
    private int keyToGoRight;
    private int keyToGoUp;
    private int keyToGoDown;
    private char direction;
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
        this.keyToGoUp = KeyEvent.VK_W;
        this.keyToGoDown = KeyEvent.VK_S;
        this.direction = 'n';
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.RED);
        drawTool.drawFilledCircle(x, y, 30);
        drawTool.drawText(x-30,y-30,"" + dtf);
        if (!load) {
            this.drawTool = drawTool;
        }
    }

    @Override
    public void update(double dt) {
        dtf = dt;
        if (direction == 'd') {
            x = x + speed*dt;
            if (x >= 1200 - width) { x = 1200-width; }
        } else if (direction == 'a') {
            x = x - speed*dt;
            if (x <= -1200) { x = -1200; }
        } else if (direction == 's') {
            y = y + speed*dt;
            if (y <= -900) { y = -900; }
        } else if (direction == 'w') {
            y = y - speed*dt;
            if (y >= 900) { y = 900; }
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == keyToGoLeft){ direction = 'a'; }
        if(key == keyToGoRight){ direction = 'd'; }
        if(key == keyToGoDown) { direction = 's'; }
        if(key == keyToGoUp) { direction ='w'; }
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
    public double getSpeed() { return speed; }

    public void setX(double newX){ x = newX; }
    public void setY(double newY) { y = newY; }
    public void setSpeed(double newSpeed) { speed = newSpeed; }
}

//die boarders, damit der spieler nicht über jeden scheiss laufen kann
//alle Methoden die mit Kampf zu tun haben: Geld, Damage, Hp, etc.