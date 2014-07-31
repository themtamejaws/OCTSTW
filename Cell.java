class Cell {
	//instantiates an Cell object
        int blue_abs = 0;
        int green_abs = 1;
        int red_abs = 0;

        int carbon = 0;
        int nitrogen = 0;
        int sulphur = 0;
        int phosphorous = 0;

        int carbon_price = 3;
        int nitrogen_price = 10;
        int sulphur_price = 10;
        int phosphorous_price = 10;

        int energy = 0;
        int time_count = 0; 

        int updateEnergy( int energy, int blue, int green, int red) {
            energy = energy + blue + green + red;
            return energy;//tracks a cells energy
        }

        int updateAbsorbtion( int colour, int increment ) {
            colour = colour + increment;
            return colour; //tracks the amount a cell can absorb
        }

        int endofTurn ( int energy, int time_count ) {
            if (time_count % 5 == 4 ) {
                energy = energy/2 ;
            }
            return energy; //tracks the end of turn for the game,
        }

        int[] buyCarbon( int energy, int carbon_current, int carbon_desired, int carbon_price ) {
            energy = energy - ( carbon_desired * carbon_price );
            carbon_current = carbon_current + carbon_desired;
            return new int[] { energy, carbon_current }; //buy carbon, lower energy
        }

        int[] buyResource( int energy, int resource_current, int resource_desired, int resource_price ) {
            energy = energy - ( resource_desired * resource_price );
            resource_current = resource_current + resource_desired; //buy resource
        }
}
