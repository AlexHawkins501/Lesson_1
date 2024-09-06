import java.util.Arrays;

public class WorkersMassive {
    public static void main(String[] args) {
        Worker[] workersArray = new Worker[5];
        workersArray[0] = new Worker("Зубенко Михаил Петрович",
                "Мафиозник", "zzmafi@mail.ru",
                "87776665534", 192000, 45);
        workersArray[1] = new Worker("Mask Bess Onov", "Director",
                "bess@rambler.ru", "3756434427", 87574, 23);
        workersArray[2] = new Worker("Dima Lis", "Coach",
                "didmdim@gg.ru", "98777326536", 45451, 33);
        workersArray[3] = new Worker("Ahri Stepanovna", "Prodaction",
                "ahri2321@ggmail.com", "----", 3333333, 400);
        workersArray[4] = new Worker("Teo Mits", "Manager",
                "neo224@yandex.com", "22154535343", 56222, 44);
        for (Worker worker : workersArray) {
            worker.info();
        }
    }
}
