package ss4_class_va_object_trong_java.baitap.baitap3_xaydunglop_fan;

public class Fan {
    private final int SLOW=1;
    private final int MEDIUM=2;
    private final int FAST=3;
    private int speed=1;
    private boolean on=false;
    private double radius=5;
    private String color="blue";
    public Fan(){
    }
    public Fan(int speed,double radius,String color, boolean on){
        this.speed=speed;
        this.radius=radius;
        this.color=color;
        this.on=on;
    }
    public int getSLOW(){
        return SLOW;
    }
    public int getMEDIUM(){
        return MEDIUM;
    }
    public int getFAST(){
        return FAST;
    }
    public int getSpeed(){
        return speed;
    }
    public boolean isOn(){
        return on;
    }
    public String getColor(){
        return color;
    }
    public double getRadius(){
        return radius;
    }
    public void setSpeed(int speed){
        this.speed=speed;
    }
    public void setOn(boolean on){
        this.on=on;
    }
    public void setColor(String color){
        this.color=color;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }

    public String toString(){
        String state="";
        if (this.isOn()){
            state+="Fan is on \n";
            state+="Speed: "+this.getSpeed()+"\n";
        }
        else {
            state+="Fan is off\n";
        }
        state+="Color: "+this.color+"\n";
        state+="Radius: "+this.radius+"\n";
        return state;
    }


}
