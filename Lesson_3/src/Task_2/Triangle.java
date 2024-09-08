package Task_2;

import java.util.Objects;

import static java.lang.Math.sqrt;

public class Triangle implements Figure {

    double a;
    double b;
    double c;
    double S;
    double P;
    double p; //полупериметр
    String figure;
    String colorFon;
    String colorGran;

    public Triangle(double a, double b, double c, String figure, String colorGran, String colorFon) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.colorFon = colorFon;
        this.colorGran = colorGran;
        this.figure = figure;
    }

    public void SquareTr() {
        if (Objects.equals(figure, "Треугольник")) {
            p = (a + b + c) / 2;
            S = sqrt(p * ((p - a) * (p - b) * (p - c)));
            System.out.println("Площадь треугольника: " + String.format("%.2f", S));
        } else {
            System.out.println("Ошбика введите другое название фигуры: 'Треугольник'");
        }
    }



    public void colors() {
        System.out.println("Цвет границы: " + figure + " " + colorGran);
        System.out.println("Цвет заливки " + figure + " " + colorFon + "\n");
    }

    public void PerimeterTr() {
        if (a + b > c && a + c > b && c + b > a) /* Проверка правила неравенства треугольника */ {
            if (Objects.equals(figure, "Треугольник")) {
                P = a + b + c;
                System.out.println("Периметр треугольника: " + String.format("%.2f", P));
                SquareTr();
                colors();
            }
        }
        else{
            System.out.println("Введенные стороны, не удовлетворяют правилу 'Неравенство треугольника'.\n"
                    +"Пожалуйста введите другие стороны треугольника, так чтобы сумма двух сторон превышала третью.\n");
        }

    }

    public double Peri(){
        return a+b+c;
    }

    public void print() {
        PerimeterTr();
    }
}
