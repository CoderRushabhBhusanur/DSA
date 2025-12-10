
package Stack_Example;

import java.util.Scanner;
import java.util.Stack;

public class stack_built_in
{
    public static void main(String[] args)
    {
        Stack<Integer> obj=new Stack<>();
        Scanner in=new Scanner(System.in);
        int choice=0;
        do
        {
            System.out.print("\nStack Menu");
            System.out.print("\n----------");
            System.out.print("\n1.Push");
            System.out.print("\n2.Pop");
            System.out.print("\n3.Peek");
            System.out.print("\n4.Print");
            System.out.print("\n0.Exit");
            System.out.print("\n:");
            choice=in.nextInt();
            switch (choice) {
                case 1:
                        System.out.print("\nEnter Data:");
                        int data=in.nextInt();
                        obj.push(data);
                        System.out.print("\n"+data+" pushed");
                        break;
                case 2:
                    if (!obj.empty())//not empty
                       System.out.print("\n"+obj.pop()+" is poped..");
                    else
                        System.out.print("\nStack Empty");
                    break;
                case 3:
                    if (!obj.empty())//not empty
                        System.out.print("\n"+obj.peek()+" is at peek");
                    else
                        System.out.print("\nStack Empty");
                    break;
                case 4:
                    if (!obj.empty())//not empty
                    {
                        System.out.print("\nStack has:\n");

                        for(int i=obj.size()-1;i>=0;i--)
                            System.out.print("\n"+obj.elementAt(i));
                    }
                    else
                        System.out.print("\nStack Empty");
                    break;
                case 0:
                    System.out.print("\n Thanks for using the code..amar.career");
                    break;
                default:
                    System.out.print("\nWrong Choice given.");
                    break;

            }
        }while(choice!=0);
    }
}
