package Task_1;

public class Miska{
    int kolvo;

    public Miska(int kolvo){
        this.kolvo=kolvo;
    }

    public int getEda() {

        return 20;/* Количество еды необходимое котам */
    }

    public void miskaNapolnit() {
        if (kolvo < 20) {
            kolvo += 20;
        }
    }

}