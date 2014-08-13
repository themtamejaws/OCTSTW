import java.util.Random;

class Hex {
    int nitrogen = randInt(0, 3);
    int sulphur = randInt(0, 2); 
    int phosphorous = randInt(0, 1);
    boolean access = isAccessable( 1 );
    int[] position;

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum; //generates the random numbers for the resources
    }

    public static int[] hexNumber( int hex_number) {
        int[] position = HexCoordGen.coords( 9, hex_number );
        return position; //generates the coordinates for each hex
    }

    public static boolean isAccessable( int neighbour_access) {
        int access_check = randInt(0,9) - neighbour_access;
        if (access_check <= 0) {
            return false;
        }
        return true;
    }

    public static int[][] neighbourCount( int[] position ) {

        int[][] translations = {{1,0,-1},{1,-1,0},{0,-1,1},{-1,0,1},{-1,1,0},{0,1,-1}};
        int[][] neighbour_positions = new int[6][3];
        
        for (int i=0; i<6; ++i) {
            for (int j = 0; j < 3; ++j) {
                neighbour_positions[i][j] = position[j] + translations[i][j];
            }
        }
        return neighbour_positions;
    }

    void printValues() {
        System.out.println( " nitrogen: " + nitrogen );
        System.out.println( " sulphur: " + sulphur );
        System.out.println( " phosphorous: " + phosphorous );
        System.out.println( " position in x: " + position[0] );
        System.out.println( " position in y: " + position[1] );
        System.out.println( " position in z: " + position[2] );
        System.out.println( " ring number (from loop): " + position[3] );
        System.out.println( " is the hex accessable: " + access );
    }
}
