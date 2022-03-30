package my_project.control;

import KAGO_framework.model.GraphicalObject;

public class RotationPoint {

    private double xR, yR;
    private double hypotenuse;
    private double standardRotation;
    private double rotation;

    public RotationPoint(double xR,double yR, double xP, double yP){
        setRotationCenter(xR,yR);
        if (xP >= 0) {
            standardRotation = Math.atan((yP / xP)) * 180 / Math.PI;
        }else{
            standardRotation = Math.atan((yP / xP)) * 180 / Math.PI+180;
        }
        hypotenuse = Math.sqrt(Math.pow(xP,2)+Math.pow(yP,2));
    }

    public RotationPoint(GraphicalObject graphicalObject, double xP, double yP){
        setRotationCenter(graphicalObject);
        if (xP >= 0) {
            standardRotation = Math.atan((yP / xP)) * 180 / Math.PI;
        }else{
            standardRotation = Math.atan((yP / xP)) * 180 / Math.PI+180;
        }
        hypotenuse = Math.sqrt(Math.pow(xP,2)+Math.pow(yP,2));
    }

    public void setRotationCenter(double xR,double yR){
        this.xR = xR;
        this.yR = yR;
    }

    public void setRotationCenter(GraphicalObject graphicalObject){
        xR = graphicalObject.getX();
        yR = graphicalObject.getY();
    }

    public void rotate(double rotation){
        this.rotation = rotation;
    }

    public void rotate(double x, double y){
        if (x - xR >= 0) {
            rotation = Math.atan(((y-yR) / (x-xR))) * 180 / Math.PI;
        }else{
            rotation = Math.atan(((y-yR) / (x-xR))) * 180 / Math.PI+180;
        }
    }

    public void rotate(GraphicalObject graphicalObject){
        rotate(graphicalObject.getX(), graphicalObject.getY());
    }

    public double getX(){
        return xR + Math.cos((rotation + standardRotation) / 180 * Math.PI) * hypotenuse;
    }

    public double getY(){
        return yR + Math.sin((rotation + standardRotation) / 180 * Math.PI) * hypotenuse;
    }
}