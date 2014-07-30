import java.util.Random;

class Hex {
    int nitrogen = randInt(0, 3);
    int sulphur = randInt(0, 2);
    int phosphorous = randInt(0, 1);

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    void printValues() {
        System.out.println( " nitrogen: " + nitrogen );
        System.out.println( " sulphur: " + sulphur );
        System.out.println( " phosphorous: " + phosphorous );
    }
}
