package Task_1;

public abstract class Animal {
    String name;
    static int count;

    public abstract int getRunLimit();

    public abstract int getSwimLimit();


    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount(){
        return count;
    }


    public void run(int distance) {
        if (getRunLimit() >= distance) {
            System.out.println(name + " пробежал " + distance+ " метров");
        } else {
            System.out.println(name + " не может проплыть " + distance+ " метров"+" его максимум: "+ getRunLimit());
        }
    }

    public void swim(int distance) {
        if (getSwimLimit() >= distance) {
            System.out.println((name + " проплыл " + distance + " метров"));
        } else {
            System.out.println(name + " не может проплыть " + distance + " метров" +" его максимум: "+ getSwimLimit());
        }

    }

}