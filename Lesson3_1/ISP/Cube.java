package Lesson3_1.ISP;

public class Cube implements Shape, ThreeDShape {

    private int length;

    public Cube(int length) {
        this.length = length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }



    @Override
    public double area() {
        return length * length * 6;
    }

    @Override
    public double value() {
        return length * length * length;
    }
    
}
