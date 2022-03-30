package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.*;

/*public class EnemyBase extends GraphicalObject {
    private int lives;
    private
}*/
public class EnemyBase extends InteractiveGraphicalObject{
    private int lives, strength, speed;
    private String name;
    private double x,y;
    private Player player;

    private DrawTool drawTool;

    public EnemyBase(int lives, String name, double x, double y, int strength, int speed, Player player){
        this.lives = lives;
        this.name = name;
        this.x = x;
        this.y = y;
        this.strength = strength;
        this.speed = speed;
        this.player=player;
    }

    @Override
    public void update(double dt){
        follow(dt);
    }

    public void follow(double dt) {
        double distance = Math.hypot(x - player.getX(), y - player.getY());
        double angle_radians = Math.atan2(y - player.getY(), x - player.getX());

        x -= Math.cos(angle_radians) * dt * 100;
        y -= Math.cos(angle_radians) * dt * 100;

        if(distance < 1) System.out.println("HIHIHTIHTITHITHIT");
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.BLUE);
        drawTool.drawFilledRectangle(x - 30, y - 30, 60, 60);
    }

}
