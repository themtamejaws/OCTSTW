import java.util.*;

class HexMain {
    public static void main(String[] args) {
        List<Hex> boardHexList;

        boardHexList = new ArrayList<Hex>();

        for (int i = 0; i < 99; ++i) {
            Hex freshHex = new Hex();
            boardHexList.add(freshHex);
        }

        boardHexList.get(1).printValues();
        boardHexList.get(2).printValues();
    }
}
