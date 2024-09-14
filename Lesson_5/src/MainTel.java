public class MainTel {

    public static void main(String[] args) {

        PhoneBook telephoneBook = new PhoneBook();

        telephoneBook.add("Hawk", "89132747274242");
        telephoneBook.add("Hawk", "87356346334");
        telephoneBook.add("Hawk", "87356346334");
        telephoneBook.add("Hawk", "87356346334");
        telephoneBook.add("Hawk", "87356346334");
        telephoneBook.add("Hawk", "87356346334");
        telephoneBook.add("Sidor", "56856757896");
        telephoneBook.add("Gil", "478546548");

        System.out.println("Номера телефонов с фамилей: Hawk " + telephoneBook.get("Hawk"));

    }
}
