package Queue_Examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BinaryToDecimal
{
    public static void main(String[] args)
    {
        Queue<Integer> obj = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        int choice = 0;
        do
        {
            System.out.print("\nQueue Menu");
            System.out.print("\n----------");
            System.out.print("\n1.Enqueue Binary Number");
            System.out.print("\n2.Convert to Decimal");
            System.out.print("\n3.Print Queue");
            System.out.print("\n0.Exit");
            System.out.print("\n:");
            choice = in.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("\nEnter Binary Number:");
                    String bin = in.next();      // read whole binary number

                    obj.clear();                 // empty queue before adding new number

                    for (char ch : bin.toCharArray())
                    {
                        obj.add(ch - '0');       // convert char → int (0 or 1)
                    }

                    System.out.print("\nBinary digits enqueued.");
                    break;

                case 2:
                    if (!obj.isEmpty())
                    {
                        int decimal = 0;
                        for (int bit : obj)
                        {
                            decimal = decimal * 2 + bit; // binary to decimal logic
                        }
                        System.out.print("\nDecimal Value = " + decimal);
                    }
                    else
                    {
                        System.out.print("\nQueue Empty");
                    }
                    break;

                case 3:
                    if (!obj.isEmpty())
                    {
                        System.out.print("\nQueue has:\n");
                        for (int e : obj)
                        {
                            System.out.print(e + ",");
                        }
                    }
                    else
                        System.out.print("\nQueue Empty");
                    break;

                case 0:
                    System.out.print("\nThanks for using the code..amar.career");
                    break;

                default:
                    System.out.print("\nWrong Choice given.");
                    break;
            }

        } while (choice != 0);
    }
}
