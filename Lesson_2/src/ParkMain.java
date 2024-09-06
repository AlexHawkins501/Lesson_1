public class ParkMain {
    public static void main(String[] args) {

        Park park = new Park();
        Park.Attraction carusel = park.new Attraction("карусель","12-18",1200);
        Park.Attraction bochka = park.new Attraction("Бочка","9-16",3000);
        Park.Attraction safari = park.new Attraction("Сафари","12-16",500);

        park.getAttraction().add(bochka);
        park.getAttraction().add(safari);
        park.getAttraction().add(carusel);
        park.printGetInfo();

    }
}
