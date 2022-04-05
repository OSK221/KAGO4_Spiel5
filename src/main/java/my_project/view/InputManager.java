package my_project.view;

import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.model.Player;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class InputManager extends InteractiveGraphicalObject {

    private boolean up, down, left, right;

    private ProgramController programController;
    private DrawTool drawTool;
    private Player player;

    public InputManager(ProgramController programController,Player player){
        this.programController = programController;
        this.player = player;
    }

    @Override
    public void keyPressed(int key) {
        if(key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_Q || key == KeyEvent.VK_TAB) System.exit(0);
        if (!(drawTool==null)) {
            switch (key) {
                case KeyEvent.VK_UP:
                    drawTool.translate(drawTool.getTransformX(), drawTool.getTransformY() + 60);
                    break;
                case KeyEvent.VK_DOWN:
                    drawTool.translate(drawTool.getTransformX(), drawTool.getTransformY() - 60);
                    break;
                case KeyEvent.VK_LEFT:
                    drawTool.translate(drawTool.getTransformX() + 60, drawTool.getTransformY());
                    break;
                case KeyEvent.VK_RIGHT:
                    drawTool.translate(drawTool.getTransformX() - 60, drawTool.getTransformY());
                    break;
            }
        }else{
            drawTool = player.getDrawTool();
        }

    }
}
