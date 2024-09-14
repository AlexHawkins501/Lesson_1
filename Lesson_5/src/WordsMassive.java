import java.util.*;

import static com.sun.tools.javac.util.ArrayUtils.ensureCapacity;
import static java.lang.reflect.Array.get;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class WordsMassive {
    public static void main(String[] args) {

        ArrayList<String> words = getStringArrayList();


        HashMap<String, Integer> counterWord = new HashMap<>();
        for (String list : words) {
            if (counterWord.containsKey(list)) {
                counterWord.put(list, counterWord.get(list) + 1);
            } else {
                counterWord.put(list, 1);
            }
        }
        for (Map.Entry<String, Integer> counter : counterWord.entrySet()) {
            System.out.println("Слово: " + "'" + counter.getKey() + "'" + " Встречается " + counter.getValue() + " раз");
        }

        Set<String> uniqueWords = new LinkedHashSet<>(words);
        System.out.println("Выводим уникальные слова: " + uniqueWords);


    }

    private static ArrayList<String> getStringArrayList() {
        ArrayList<String> words = new ArrayList<>();
        words.add("Апельсин");
        words.add("Яблоко");
        words.add("Мандарин");
        words.add("Орехи");
        words.add("Банан");
        words.add("Апельсин");
        words.add("Тыква");
        words.add("Апельсин");
        words.add("Груша");
        words.add("Буквоед");
        words.add("Молния");
        words.add("Апельсин");
        words.add("Олени");
        words.add("Мандарин");
        words.add("Соль");
        words.add("Апельсин");
        words.add("Мандарин");
        words.add("Ананас");
        words.add("Буквоед");
        words.add("Книга");
        words.add("Охотник");
        words.add("Кухня");
        words.add("Дискотека");
        words.add("Апельсин");
        return words;
    }
}