package Task_2;

import java.io.FileReader;

public class SquareMain {

    public static void main(String[] args) {
        Figure square = new Square(10,"Квадрат","Зеленый","Оранжевый");
        square.print();
        Figure triangle = new Triangle(3,5,6,"Треугольник", "Синий"," Красный");
        triangle.print();
        Figure circle = new Circle(12.2,"Круг","Фиолетовый","Голубой");
        circle.print();

        /*Реализация подсчета периметра в интерфейсе, простенькая */
        System.out.println(triangle.Peri());
        System.out.println(String.format("%.2f",circle.Peri()));
        System.out.println(square.Peri());

    }
}
