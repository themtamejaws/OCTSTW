import java.util.Random;

class Hex {
    int nitrogen = randInt(0, 3);
    int sulphur = randInt(0, 2);
    int phosphorous = randInt(0, 1);
    int[] position;

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static int[] hexNumber( int hex_number) {
        int[] position = HexCoordGen.coords( 9, hex_number );
        return position;
    }

    void printValues() {
        System.out.println( " nitrogen: " + nitrogen );
        System.out.println( " sulphur: " + sulphur );
        System.out.println( " phosphorous: " + phosphorous );
        System.out.println( " position in x: " + position[0] );
        System.out.println( " position in y: " + position[1] );
        System.out.println( " position in z: " + position[2] );
        System.out.println( " ring number (from loop): " + position[3] );
    }
}
