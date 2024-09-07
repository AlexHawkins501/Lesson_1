package Task_1;

public class Cat extends Animal {
    static int count;
    int appetit;
    boolean sitost;


    public Cat(String name, int appetit, boolean sitost) {
        super(name);
        count++;
        this.appetit = appetit;
        this.sitost = sitost;
    }


    public static int getCount() {
        return count;
    }

    @Override
    public int getRunLimit() {
        return 200;
    }

    @Override
    public int getSwimLimit() {
        return 0;
    }


    public void info() {
        String Hungry = sitost ? "Сытый" : "Голоден";
        System.out.println(name + ":" + Hungry + "." + "\n");
    }

    public void getFood(Miska kolvo) {
        if (appetit < 10)/* если значение меньше 10, кот голоден*/ {
            if (kolvo.kolvo < kolvo.getEda()) /* если в миске меньше еды чем кот хочет поесть */ {
                System.out.println("В миске мало еды, добавьте еды, чтобы " + name + " мог поесть");
                System.out.println("Сытость:" + sitost);
            } else {
                kolvo.kolvo -= kolvo.getEda();
                appetit += kolvo.getEda();
                sitost = appetit >= kolvo.getEda();
                System.out.println(name + " поел." + " Cытость: " + sitost + ". " + "Остаток еды в миске: " + kolvo.kolvo);
            }
        }
    }
}


