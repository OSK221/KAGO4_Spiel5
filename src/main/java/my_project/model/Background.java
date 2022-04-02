package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Background extends GraphicalObject {

    private final int widthF = Toolkit.getDefaultToolkit().getScreenSize().width;
    private final int heightF = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final int desktop = (widthF-((heightF/900)*1200))/2/(heightF/900);

    @Override
    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(Color.BLACK);
        drawTool.drawFilledRectangle(-desktop-drawTool.getTransformX(), - drawTool.getTransformY(), desktop, heightF);
        drawTool.drawFilledRectangle(1199 +desktop/2 - drawTool.getTransformX(), - drawTool.getTransformY(), desktop, heightF);
        for (int i = 0; i < desktop/2; i++) {
                drawTool.setCurrentColor((int)((double)i/(double)desktop*150),(int)((double)i/(double)desktop*150),(int)((double)i/(double)desktop*150),255);
            drawTool.drawFilledRectangle(i-desktop/2-drawTool.getTransformX(), - drawTool.getTransformY(), 1, heightF);
            drawTool.drawFilledRectangle(1199 -i +desktop/2 - drawTool.getTransformX(), - drawTool.getTransformY(), 1, heightF);
        }
    }
}