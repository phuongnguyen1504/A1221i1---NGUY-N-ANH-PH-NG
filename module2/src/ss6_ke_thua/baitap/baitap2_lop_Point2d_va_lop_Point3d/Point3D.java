package ss6_ke_thua.baitap.baitap2_lop_Point2d_va_lop_Point3d;

public class Point3D extends Point2D{
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x,float y,float z){
        setXY(x,y);
        setZ(z);
    }
    public float[] getXYZ(){
        return new float[]{getX(), getY(), z};
    }
    @Override
    public String toString(){
        return "Tọa độ (x,y,z)=("+getXYZ()[0]+","+getXYZ()[1]+","+getXYZ()[2]+")";
    }
}
