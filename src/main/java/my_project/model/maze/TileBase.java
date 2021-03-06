package my_project.model.maze;

import KAGO_framework.Config;
import KAGO_framework.view.DrawTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TileBase {

    protected double x, y;
    protected double width = 1, height = 1;

    private final boolean collider;
    private final String typ;

    private int r, g, b;
    private BufferedImage myImage;

    public TileBase(double x, double y, String typ, String pathToImage, boolean collider){
        this.x = x;
        this.y = y;
        this.typ = typ;
        this.collider = collider;

        pathToImage = "src/main/resources/graphic/" + pathToImage;
        try {
            myImage = ImageIO.read(new File(pathToImage));
        } catch (IOException e01) {
            if (Config.INFO_MESSAGES) System.out.println("Error while loading: src/main/resources/graphic/" + pathToImage);
            System.out.println(e01.getMessage());
            try {
                myImage = ImageIO.read(new File("src/main/resources/graphic/Error.png"));
            } catch (IOException e02) {
                if (Config.INFO_MESSAGES) System.out.println("Error while loading other important files -> Now ending process (No Textures found)");
                System.exit(1);
            }
        }
    }

    public TileBase(double x, double y, String typ, int r, int g, int b, boolean collider){
        this.x = x;
        this.y = y;
        this.typ = typ;
        this.collider = collider;

        this.r = r;
        this.g = g;
        this.b = b;
    }

    public void draw(DrawTool drawTool){
        if (myImage==null) {
            drawTool.setCurrentColor(r, g, b, 255);
            drawTool.drawFilledRectangle(x*60,y*60,width*60,height*60);
        }else{
            drawTool.setCurrentColor(0, 0, 0, 255);
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    drawTool.drawTransformedImage(myImage, (x+i)*60, (y+j)*60, 0, 1);
                }
            }
        }
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String getTyp() {
        return typ;
    }

    public boolean isCollider() {
        return collider;
    }
}