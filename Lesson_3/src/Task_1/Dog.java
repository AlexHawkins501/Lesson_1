package Task_1;

public class Dog extends Animal {

    static int count;

    public Dog(String name) {
        super(name);
        count++;
    }

    public static int getCount(){
        return count;
    }

    @Override
    public int getRunLimit(){
        return 500;
    }
    @Override
    public int getSwimLimit(){
        return 10;
    }
}