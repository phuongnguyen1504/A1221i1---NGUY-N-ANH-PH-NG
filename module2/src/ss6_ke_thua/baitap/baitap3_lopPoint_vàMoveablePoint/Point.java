package ss6_ke_thua.baitap.baitap3_lopPoint_vàMoveablePoint;

public class Point {
    private float x;
    private float y;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        return new float[]{x, y};
    }

    public String toString() {
        return "Tọa độ (x,y) là (" + getXY()[0] + "," + getXY()[1] + ")";
    }
}