class Worker {

    private String name;
    private String post;
    private String email;
    private String number;
    private int salary;
    private int age;

    public Worker(String name, String post, String email,
                  String number, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Имя: " + name + "\nДолжность: " + post +
                "\nПочта: " + email + "\nНомер: " + number + "\nЗарплата: " + salary +
                "\nВозраст: " + age + "\n");

    }
}

