class CellMain {
    public static void main(String[] args) {
        Cell cell_1 = new Cell();
        
        cell_1.position = cell_1.changePosition( cell_1.position, 2);

        System.out.println( "The cell's new position is: " + cell_1.position[0] + "," + cell_1.position[1] + "," + cell_1.position[2] + "...");

        for (int i = 0; i < 9; i++) {
            cell_1.time_count++; 
            cell_1.blue_abs = cell_1.updateAbsorbtion( cell_1.blue_abs, 1 );
            cell_1.energy = cell_1.updateEnergy( cell_1.energy, cell_1.blue_abs, cell_1.green_abs, cell_1.red_abs );
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
