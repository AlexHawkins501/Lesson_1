package Task_2;

import java.util.Objects;

public class Circle implements Figure {

    double r;
    String figure;
    String colorGran;
    String colorFon;
    double S;
    double P;

    public Circle(double r, String figure, String colorFon, String colorGran) {
        this.r = r;
        this.figure = figure;
        this.colorFon = colorFon;
        this.colorGran = colorGran;
    }

    public void SCircle() {
        if (Objects.equals(figure, "Круг")) {
            S = SquareCircle();
            System.out.println("Площадь круга: " + String.format("%.2f", S));
        } else {
            System.out.println("Ошбика введите другое название фигуры: 'Круг'");
        }
    }

    public void PCircle() {
        if (Objects.equals(figure, "Круг")) {
            P = PerimeterCircle();
            System.out.println("Периметр круга: " + String.format("%.2f", P));
        } else {
            System.out.println("Ошбика введите другое название фигуры: 'Круг'");
        }
    }

    public void colors() {
        System.out.println("Цвет границы: " + figure + " " + colorGran);
        System.out.println("Цвет заливки " + figure + " " + colorFon + "\n");
    }


    public double SquareCircle() {
        if (Objects.equals(figure, "Круг")) {
            return Math.PI * (r * r);

        }
        return 0;
    }

    public double PerimeterCircle() {
        if (Objects.equals(figure, "Круг")) {
            return Math.PI * 2 * r;
        }
        return 0;
    }

    public double Peri(){
        return Math.PI * 2 * r;
    }

    public void print() {
        PCircle();
        SCircle();
        colors();
    }
}
