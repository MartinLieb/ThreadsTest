import java.util.Random;

public class Main {

    private static final int GENTAGELSER = 10;
    private static final int LINELENGHT = 40;
    
    

    public static void main(String[] args) {

        Random r = new Random();

        String abc = "qwertyuiopåasdfghjklæøzxcvbnm";

        for (int i = 0; i < 100; i++) {
            int random = getRandomNumberInRange(0,abc.length()-1);
            Opgave opgave = new Opgave(abc.charAt(random));
            Thread thread = new Thread(opgave);
            thread.setPriority(getRandomNumberInRange(1,10));

            thread.start();

        }


    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static class Opgave implements Runnable {

        char bogstav;

        public Opgave(char bogstav) {
            this.bogstav = bogstav;
        }


        @Override
        public void run() {
            for (int i = 0; i < GENTAGELSER; i++) {
                if (i % LINELENGHT == 0) {
                }
                System.out.print((Thread.currentThread().getId()) + "" + bogstav + "\n");
            }
        }
    }
}
