package Task_2;

import java.util.Objects;

public class Square implements Figure {

    double a;
    String figure;
    double S;
    double P;
    String colorGran;
    String colorFon;

    public Square(double a, String figure, String colorFon, String colorGran) {
        this.a = a;
        this.figure = figure;
        this.colorFon = colorFon;
        this.colorGran = colorGran;
    }

    public void SquareS() {
        if (Objects.equals(figure, "Квадрат")) {
            S = a * a;
            System.out.println("Площадь квадрата: " + String.format("%.2f", S));
        } else {
            System.out.println("Ошбика введите другое название фигуры: 'Квадрат'");
        }
    }


    public void colors() {
        System.out.println("Цвет границы: " + figure + " " + colorGran);
        System.out.println("Цвет заливки: " + figure + " " + colorFon + "\n");
    }

    public void PerimetrS() {
        if (Objects.equals(figure, "Квадрат")) {
            P = a * 4;
            System.out.println("Периметр квадрата: " + String.format("%.2f", P));
        } else {
            System.out.println("Ошбика введите другое название фигуры: 'Квадрат'");
        }
    }

    @Override
    public void print() {
        PerimetrS();
        SquareS();
        colors();
    }
}
