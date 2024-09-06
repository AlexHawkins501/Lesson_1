import java.util.ArrayList;
import java.util.List;

public class Park {

    ArrayList<Park.Attraction> attractions = new ArrayList<>();

    public List<Attraction> getAttraction(){
        return attractions;
    }

    public void printGetInfo(){
        attractions.forEach(attraction -> attraction.getInfo());
    }

    public class Attraction {
        String attraction;
        String time;
        int price;

        public Attraction(String attraction, String time, int price) {
            this.attraction = attraction;
            this.price = price;
            this.time = time;
        }

        public void getInfo() {
            System.out.println("Аттракцион: " + attraction + "\n" + "Часы работы: "
                    + time + "\n" + "Стоимость: " + price+ "\n");
        }
    }
}

