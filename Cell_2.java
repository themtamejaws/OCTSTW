class Cell {

        public static void main(String[] args ) {

            int blue_abs = 0;
            int green_abs = 1;
            int red_abs = 0;

            int energy = 0;
            int new_energy;

        calculateEnergy();

        }

        public static void calculateEnergy() { 
            new_energy = harvestLight( blue_abs, green_abs, red_abs );
            energy = energy + new_energy;
            System.out.println( "The cell's energy is " + energy );
        }

        public static int harvestLight( int blue, int green, int red) {
            int new_energy = 0;
            new_energy = blue + green + red;
            return new_energy;
        }
}
