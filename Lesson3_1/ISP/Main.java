package Lesson3_1.ISP;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        Cube cube = new Cube(5);
        System.out.println("Circle area: %.2f".formatted(circle.area()));
        System.out.println("Cube area: %.2f   Cube value: %.2f".formatted(cube.area(), cube.value()));
    }
    
}
