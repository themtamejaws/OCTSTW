class HexCoordGen {
    public static int[] coords( int rings, int hex_number ) {
	
	//Generates Hex coordinates inputs; number of rings and maybe hex_number

        int hex_count = 0;

        int[][] record = new int [10000][4]; //record of the values of the hex coords

        for (int ring = 0; ring <= rings; ring++) {
            
            int max_num = ring;
            int abs_tot = ring*2;

            for ( int x = -max_num; x <= max_num; x++ ) {
                for ( int y = -max_num; y <= max_num; y++ ) {
                    int z = 0-(x+y);
                    if ( (Math.abs(z) <= max_num) && (Math.abs(x)+Math.abs(y)+Math.abs(z)==abs_tot) ) {
                            record[hex_count][0]=x;
                            record[hex_count][1]=y;
                            record[hex_count][2]=z;
                            record[hex_count][3]=hex_count;
                            hex_count=hex_count+1;
                    }
                }
            }
        }
        int[] position = record[hex_number];
        return position; //returns the position of a hex in HexMain
    }
}
