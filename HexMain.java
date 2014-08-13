import java.util.*;

class HexMain {
    public static void main(String[] args) {
        
	//Calls the various classes to generate the board
	
	List<Hex> boardHexList;

        boardHexList = new ArrayList<Hex>();

        for (int i = 0; i < 100; ++i) {
            Hex freshHex = new Hex();
            freshHex.position = freshHex.hexNumber(i);
            boardHexList.add(freshHex);
        }

        int[][] hello = boardHexList.get(0).neighbourCount( boardHexList.get(0).position);

        boardHexList.get(0).printValues();
        boardHexList.get(1).printValues();
        boardHexList.get(2).printValues();
        boardHexList.get(3).printValues();
        boardHexList.get(4).printValues();
        boardHexList.get(5).printValues();
        boardHexList.get(6).printValues();
        boardHexList.get(7).printValues();
        boardHexList.get(8).printValues();
        boardHexList.get(9).printValues();
        boardHexList.get(10).printValues();
    }
}
