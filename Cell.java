class Cell {
        int blue_abs = 0;
        int green_abs = 1;
        int red_abs = 0;

        int energy = 0;
        int time_count = 0; 

        int updateEnergy( int energy, int blue, int green, int red) {
            energy = energy + blue + green + red;
            return energy;
        }

        int updateAbsorbtion( int colour, int increment ) {
            colour = colour + increment;
            return colour;
        }

        int endofTurn ( int energy, int time_count ) {
            if (time_count % 5 == 4 ) {
                energy = energy/2 ;
            }
            return energy;
        }
}
