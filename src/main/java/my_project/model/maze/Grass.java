package my_project.model.maze;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Grass extends GraphicalObject {

    public Grass (double x, double y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(10,205,35,255);
        for (int i = 0; i < 7; i++) {
            drawTool.drawLine(x+i*3,y,x+i*3,y+15);
        }
    }
}