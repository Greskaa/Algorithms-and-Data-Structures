import java.util.Locale;
import java.util.Scanner;
import java.lang.String;

public class Initials {
    static void printInitials(String name)
    {
        System.out.print(Character.toUpperCase(name.charAt(0)));
        for (int i=1; i<name.length(); i++)
        {
            if (name.charAt(i) == ' ')
                System.out.print(Character.toUpperCase(name.charAt(i+1)));
        }
    }

    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //get total names
        String name;
        input.nextLine(); //new line

        for(int i=0; i<n; i++){
            name = input.nextLine(); //takes the whole line as input until pressed enter
            printInitials(name); //pas each name of the array to the method
            System.out.println();
        }
    }
}
