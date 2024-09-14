import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    public HashMap<String, ArrayList<String>> phoneBook;


    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String name, String phones) {
        /* phones - номер телефона, name - Фамилия */
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phones);
        } else {
            ArrayList<String> number = new ArrayList<>();
            number.add(phones);
            phoneBook.put(name, number);
        }
    }

    public ArrayList<String> get(String name) {
        return phoneBook.get(name);
    }
}
