import java.util.Scanner;

class Input{
    //takes input from the commandline and returns it

    public static String readline(){
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        sc.close();
        return value;
    }
}
