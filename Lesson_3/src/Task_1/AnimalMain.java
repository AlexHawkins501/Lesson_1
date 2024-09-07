package Task_1;

public class AnimalMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик", 5,false);
        Dog dog1 = new Dog("Бим");
        Cat cat2 = new Cat("Тео",9,false);
        Miska miska = new Miska(81);

        Cat[] cats = new Cat[4];
        cats[0]  = new Cat("Нолик",3,false);
        cats[1] = new Cat("Толик",8,false);
        cats[2]= new Cat("Лелик",7,false);
        cats[3]= new Cat("Болик", 5,false);



        cat1.swim(150);
        dog1.run(460);
        System.out.println("Создано котов: "+ Cat.getCount());
        System.out.println("Создано собак: "+ Dog.getCount());
        System.out.println("Создано животных: " + Animal.getCount()+"\n");


        miska.miskaNapolnit();
        cat1.getFood(miska);
        cat2.getFood(miska);

        for(Cat cat: cats){
            System.out.println();
            cat.getFood(miska);
            cat.info();
        }
    }
}
