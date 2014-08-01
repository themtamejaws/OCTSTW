import java.io.*;
import java.lang.*;
import java.util.*;


public class test{
	
	private Formatter x;

	int[][] testArray = {{0,0},{1,1}};
	
	public void openFile(){

		try {
			x = new Formatter("test.txt");

		}
		catch(Exception ex){
			System.out.println("exception!");
		}
	}

	public void addRecords(){
		x.format("%s", "hello");
	}

	public void closeFile(){
		x.close();
	}
}

