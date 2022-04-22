package my_project.control;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Player;

import java.awt.event.KeyEvent;

public class Camera extends InteractiveGraphicalObject {

    private final Player player;

    public Camera(Player player) {
        this.player = player;
    }

    @Override
    public void draw(DrawTool drawTool) {

        if(player.getX() < 0){
            drawTool.translate(1200, drawTool.getTransformY());
        }else if(player.getX() > 1200){
            drawTool.translate(-1200, drawTool.getTransformY());
        }else{
            drawTool.translate(0, drawTool.getTransformY());
        }

        if (player.getY() > 0){
            drawTool.translate(drawTool.getTransformX(), 0);
        }else{
            drawTool.translate(drawTool.getTransformX(), 900);
        }
    }

    @Override
    public void keyPressed(int key) {
        if(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_Q || key == KeyEvent.VK_TAB) System.exit(0);
    }
}
