class Cell {
        int blue_abs = 0;
        int green_abs = 1;
        int red_abs = 0;

        int carbon = 0;
        int nitrogen = 0;
        int sulphur = 0;
        int phosphorous = 0;

        int carbon_price = 3;
        int nitrogen_price = 10;
        int sulphur_price = 15;
        int phosphorous_price = 20;

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

        int[] buyCarbon( int energy, int carbon_current, int carbon_desired, int carbon_price ) {
            energy = energy - ( carbon_desired * carbon_price );
            carbon_current = carbon_current + carbon_desired;
            return new int[] { energy, carbon_current };
        }
}
