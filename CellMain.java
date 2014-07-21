class CellMain {
    public static void main(String[] args) {
        Cell cell_1 = new Cell();
        
        for (int i = 0; i < 9; i++) {
            cell_1.time_count++; 
            cell_1.blue_abs = cell_1.updateAbsorbtion( cell_1.blue_abs, 1 );
            cell_1.energy = cell_1.updateEnergy( cell_1.energy, cell_1.blue_abs, cell_1.green_abs, cell_1.red_abs );
            cell_1.energy = cell_1.endofTurn( cell_1.energy, cell_1.time_count );
            if cell_1.
            System.out.println( "The cell's turn is " + cell_1.time_count );
            System.out.println( "The cell's energy is " + cell_1.energy );
        }
    }
}
