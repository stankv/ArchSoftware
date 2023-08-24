package Lesson3_1.LSP;

public class Main {

    public static void main(String[] args) {

        Square square = new Square(10);
        Rectangle rectangle = new Rectangle(7, 8);
        System.out.println(square.area());
        System.out.println(rectangle.area());

    }
    
}
