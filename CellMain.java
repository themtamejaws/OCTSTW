import java.util.*;

class CellMain {
    public static void main(String[] args) {
        Cell cell_1 = new Cell();
        
        cell_1.position = cell_1.changePosition( cell_1.position, 2);

        System.out.println( "The cell's new position is: " + cell_1.position[0]
            + "," + cell_1.position[1] + "," + cell_1.position[2] + "...");

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            cell_1.time_count++; 
            cell_1.blue_abs = cell_1.updateAbsorbtion( cell_1.blue_abs, 1 );
            cell_1.energy = cell_1.updateEnergy( cell_1.energy, cell_1.blue_abs, cell_1.green_abs, cell_1.red_abs );
            System.out.println("Do you want to buy a gene?");
            String response = sc.nextLine();
            if (response.equals("yes")){ 
                for (int j = 0; j < cell_1.possible_genes.size(); j++){
                    System.out.println(cell_1.possible_genes.get(j));
                }
                String gene = sc.nextLine();
                List<ArrayList<String>> unpack = cell_1.buy_gene( gene, cell_1.possible_genes, cell_1.current_genes);
                cell_1.possible_genes = unpack.get(0);
                cell_1.current_genes = unpack.get(1);
                System.out.println(cell_1.current_genes);
            }
            System.out.println("What direction do you want to move? [0-5]");
            int movement = sc.nextInt();
            cell_1.position = cell_1.changePosition( cell_1.position, movement );
            System.out.println("Your new position is: " + cell_1.position);

	        if (cell_1.energy > 6) {
                int[] temp = cell_1.buyCarbon( cell_1.energy, cell_1.carbon, 1, cell_1.carbon_price);
                System.out.println( "Bought 1 carbon for a total of:" + cell_1.carbon );
                cell_1.energy = temp[0];
                cell_1.carbon = temp[1];
            }
            cell_1.energy = cell_1.endofTurn( cell_1.energy, cell_1.time_count );
            System.out.println( "The cell's turn is " + cell_1.time_count );
            System.out.println( "The cell's energy is " + cell_1.energy );
        }
    }
}
