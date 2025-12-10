package Stack_Example;

import java.util.Scanner;

public class Stack_Class
{
    int tos,MaxSize,stack[];
    public void create_stack(int size)
    {
        MaxSize=size;
        tos=-1;//init as stack starts from 0th index(Array)
        stack=new int[MaxSize];
    }
    //push:Inserts one element on top of the stack.
    //tos+1 and then accept the element
    public void push(int data)
    {
        tos++;
        stack[tos]=data;
        //stack[++tos]=data;
    }
    //is_full:
    // if tos is at last location return true(full)e else false
    public boolean is_full()
    {
        if(tos==MaxSize-1)
            return true;
        else
            return false;
        //return(tos==MaxSize-1);
    }
    //pop:
    // Remove and returns the topmost element from the stack by reducing tos-1.
    public int pop()
    {
       int temp=stack[tos];
       tos--;//reduced
        return(temp);
        //return(stack[tos--]);
    }

    //is_empty
    //Sources at -1, that means stack is empty, so returns true.
    public boolean is_empty()
    {
        if(tos==-1)
            return true;
        else
            return false;
        //return(tos==-1);
    }
    //peek
    // only returns the topmost element from the stack.
    public int peek()
    {
        return(stack[tos]);
    }
    public void print_stack()//print stack in LIFO manner means from top to bottom
    {
        for(int i=tos;i>=0;i--)
            System.out.println(stack[i]);
    }

    public static void main(String[] args)
    {
        Stack_Class obj=new Stack_Class();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter size of stack:");
        int size=in.nextInt();
        int choice=0;
        obj.create_stack(size);
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
                    if (!obj.is_full())//not full
                    {
                        System.out.print("\nEnter Data:");
                        int data=in.nextInt();
                        obj.push(data);
                        System.out.print("\n"+data+" pushed");
                    }
                    else
                        System.out.print("\nStack Full");
                    break;
                case 2:
                    if (!obj.is_empty())//not empty
                    {
                        System.out.print("\n"+obj.pop()+" is poped..");
                    }
                    else
                        System.out.print("\nStack Empty");
                    break;
                case 3:
                    if (!obj.is_empty())//not empty
                    {
                        System.out.print("\n"+obj.peek()+" is at peek");
                    }
                    else
                        System.out.print("\nStack Empty");
                    break;
                case 4:
                    if (!obj.is_empty())//not empty
                    {
                        System.out.print("\nStack has:\n");
                        obj.print_stack();
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
//---------------------------------------------------------------------------



//package Stack_Example;
//
//import java.util.Scanner;
//
//public class Stack_Class {
//
//    int tos, MaxSize, stack[];
//
//    // Create stack of given size
//    void create_stack(int size) {
//        MaxSize = size;
//        tos = -1; // stack starts empty
//        stack = new int[MaxSize];
//    }
//
//    // Push element
//    void push(int data) {
//        stack[++tos] = data;
//    }
//
//    // Check if stack is full
//    boolean is_full() {
//        return (tos == MaxSize - 1);
//    }
//
//    // Pop element
//    int pop() {
//        return stack[tos--];
//    }
//
//    // Check if stack is empty
//    boolean is_empty() {
//        return (tos == -1);
//    }
//
//    // Peek top element
//    int peek() {
//        return stack[tos];
//    }
//
//    // Display entire stack (LIFO / top → bottom)
//    void print_stack() {
//        System.out.println("\nStack elements (Top to Bottom):");
//        for (int i = tos; i >= 0; i--) {
//            System.out.println(stack[i]);
//        }
//    }
//
//    // Main – Menu Driven Program
//    public static void main(String[] args) {
//
//        Stack_Class obj = new Stack_Class();
//        Scanner in = new Scanner(System.in);
//
//        System.out.print("Enter size of stack: ");
//        int size = in.nextInt();
//        obj.create_stack(size);
//
//        int choice;
//
//        do {
//            System.out.println("\n========== STACK MENU ==========");
//            System.out.println("1. Push");
//            System.out.println("2. Pop");
//            System.out.println("3. Peek");
//            System.out.println("4. Print");
//            System.out.println("0. Exit");
//            System.out.print("Enter your choice: ");
//            choice = in.nextInt();
//
//            switch (choice) {
//
//                case 1:
//                    if (!obj.is_full()) {
//                        System.out.print("Enter element to push: ");
//                        int data = in.nextInt();
//                        obj.push(data);
//                        System.out.println(data + " pushed successfully.");
//                    } else {
//                        System.out.println("Error: Stack is FULL!");
//                    }
//                    break;
//
//                case 2:
//                    if (!obj.is_empty()) {
//                        System.out.println(obj.pop() + " popped successfully.");
//                    } else {
//                        System.out.println("Error: Stack is EMPTY!");
//                    }
//                    break;
//
//                case 3:
//                    if (!obj.is_empty()) {
//                        System.out.println("Top element is: " + obj.peek());
//                    } else {
//                        System.out.println("Error: Stack is EMPTY!");
//                    }
//                    break;
//
//                case 4:
//                    if (!obj.is_empty()) {
//                        obj.print_stack();
//                    } else {
//                        System.out.println("Stack is EMPTY!");
//                    }
//                    break;
//
//                case 0:
//                    System.out.println("Thank you for using Stack Program.");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//                    break;
//            }
//
//        } while (choice != 0);
//
//        in.close();
//    }
//}

//-------------------------------------------------------------------------------
//Stack class:

//package Stack_Example;
//
//import java.util.Stack;
//import java.util.Scanner;
//import java.util.EmptyStackException;
//
//public class Stack_Class {
//
//    public static void main(String[] args) {
//        Stack<String> stack = new Stack<>();
//        Scanner scanner = new Scanner(System.in);
//        int choice = -1;
//
//        System.out.println("=== Menu-driven Stack (Strings) ===");
//
//        do {
//            System.out.println("\nSelect an operation:");
//            System.out.println("1. Push (Add Element)");
//            System.out.println("2. Pop (Remove Top Element)");
//            System.out.println("3. Peek (View Top Element)");
//            System.out.println("4. Check if Empty");
//            System.out.println("5. Print Stack");
//            System.out.println("0. Exit");
//            System.out.print("Enter choice: ");
//
//            if (scanner.hasNextInt()) {
//                choice = scanner.nextInt();
//                scanner.nextLine(); // consume newline
//            } else {
//                System.out.println("Invalid input. Please enter a number between 0 and 5.");
//                scanner.nextLine(); // clear bad input
//                continue;
//            }
//
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter string to push: ");
//                    String data = scanner.nextLine();
//                    stack.push(data);
//                    System.out.println("'" + data + "' pushed to stack.");
//                    break;
//
//                case 2:
//                    try {
//                        String poppedItem = stack.pop();
//                        System.out.println("Popped element: " + poppedItem);
//                    } catch (EmptyStackException e) {
//                        System.out.println("Error: Stack is empty. Cannot pop.");
//                    }
//                    break;
//
//                case 3:
//                    try {
//                        String topItem = stack.peek();
//                        System.out.println("Top element (peek): " + topItem);
//                    } catch (EmptyStackException e) {
//                        System.out.println("Error: Stack is empty. Nothing to peek.");
//                    }
//                    break;
//
//                case 4:
//                    if (stack.empty()) {
//                        System.out.println("The stack is currently empty.");
//                    } else {
//                        System.out.println("The stack is NOT empty. Size: " + stack.size());
//                    }
//                    break;
//
//                case 5:
//                    if (stack.empty()) {
//                        System.out.println("The stack is empty.");
//                    } else {
//                        System.out.println("Stack Contents (Top to Bottom):");
//                        for (int i = stack.size() - 1; i >= 0; i--) {
//                            System.out.println(stack.get(i));
//                        }
//                    }
//                    break;
//
//                case 0:
//                    System.out.println("Exiting program. Goodbye!");
//                    break;
//
//                default:
//                    System.out.println("Invalid choice. Please enter a number between 0 and 5.");
//            }
//        } while (choice != 0);
//
//        scanner.close();
//    }
//}
//
