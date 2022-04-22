package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class DeathScreen extends GraphicalObject {

    private boolean load;
    private DrawTool drawTool;

    public DeathScreen() {
        load = false;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.RED);
        drawTool.drawFilledRectangle(0,0,2000,2000);
        drawTool.setCurrentColor(Color.BLUE);
        drawTool.drawText(600,600,"YOU LOST!");
        if (!load) {
            this.drawTool = drawTool;
        }
    }

    public DrawTool getDrawTool() {
        if (!(drawTool == null)) load = true;
        return drawTool;
    }
}
