import java.util.Scanner;

public class pushZerosToEnd
{
    static void pushZerosToEnd(int arr[], int n)
    {
        int counter = 0;
        for (int i=0; i<n; i++)
        {
            if (arr[i] != 0)
            {
                arr[counter++] = arr[i];
                System.out.print(arr[i] + " ");
            }
        }
        for (int j=counter; j<n; j++)
        {
            System.out.print("0 ");
        }
    }

    public static void main (String[] args)
    {
        int arr[] = new int[100];
        int n;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        System.out.println("Transformiranata niza e:");
        for (int i=0; i<n; i++)
        {
            arr[i] = in.nextInt();
        }
        pushZerosToEnd(arr, n);
    }
}
