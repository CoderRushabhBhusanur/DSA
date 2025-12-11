//package Linked_List_Examples;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class StackLinkedLIst {
//
//    // Node class for linked list
//    static class Node {
//        int data;
//        Node next;
//
//        Node(int d) {
//            this.data = d;
//            this.next = null;
//        }
//    }
//
//    // top of stack (leftmost node)
//    private Node root;
//
//    // constructor
//    public StackLinkedLIst() {
//        root = null;
//    }
//
//    /** push - insert_left: push value onto stack (O(1)) */
//    public void push(int data) {
//        Node n = new Node(data);
//        if (root == null) {
//            root = n;
//        } else {
//            n.next = root; // link new node to old top
//            root = n;      // make new node the top
//        }
//    }
//
//    /** pop - delete_left: remove and return top value. Return -1 if empty. */
//    public int pop() {
//        if (root == null) return -1; // stack empty
//        int val = root.data;
//        root = root.next; // unlink old top
//        return val;
//    }
//
//    /** peek: return top value without removing. Return -1 if empty. */
//    public int peek() {
//        if (root == null) return -1;
//        return root.data;
//    }
//
//    /** isEmpty helper */
//    public boolean isEmpty() {
//        return root == null;
//    }
//
//    /** printStack: prints stack from top to bottom (LIFO order) */
//    public void printStack() {
//        if (root == null) {
//            System.out.println("[empty]");
//            return;
//        }
//        System.out.print("Top -> ");
//        Node cur = root;
//        while (cur != null) {
//            System.out.print(cur.data);
//            if (cur.next != null) System.out.print(" -> ");
//            cur = cur.next;
//        }
//        System.out.println(" -> null");
//    }
//
//    // --- Interactive menu-driven main ---
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        StackLinkedLIst stack = new StackLinkedLIst();
//
//        System.out.println("Stack using Linked List (insert_left = push, delete_left = pop)");
//        while (true) {
//            printMenu();
//            System.out.print("Choose option: ");
//            int choice;
//            try {
//                choice = sc.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a number (1-6).");
//                sc.nextLine(); // clear bad input
//                continue;
//            }
//
//            switch (choice) {
//                case 1: // push
//                    System.out.print("Enter integer to push: ");
//                    try {
//                        int v = sc.nextInt();
//                        stack.push(v);
//                        System.out.println(v + " pushed onto stack.");
//                    } catch (InputMismatchException e) {
//                        System.out.println("Invalid number. Please enter an integer.");
//                        sc.nextLine();
//                    }
//                    break;
//
//                case 2: // pop
//                    int popped = stack.pop();
//                    if (popped == -1) {
//                        System.out.println("Stack Empty. Underflow.");
//                    } else {
//                        System.out.println(popped + " popped from stack.");
//                    }
//                    break;
//
//                case 3: // peek
//                    int top = stack.peek();
//                    if (top == -1) {
//                        System.out.println("Stack Empty.");
//                    } else {
//                        System.out.println("Top element: " + top);
//                    }
//                    break;
//
//                case 4: // isEmpty
//                    System.out.println("Stack is " + (stack.isEmpty() ? "empty." : "not empty."));
//                    break;
//
//                case 5: // print
//                    System.out.println("Stack contents (top -> bottom):");
//                    stack.printStack();
//                    break;
//
//                case 6: // exit
//                    System.out.println("Exiting. Goodbye!");
//                    sc.close();
//                    return;
//
//                default:
//                    System.out.println("Please choose a valid option (1-6).");
//                    break;
//            }
//        }
//    }
//
//    private static void printMenu() {
//        System.out.println("\n---- Menu ----");
//        System.out.println("1. Push (insert_left)");
//        System.out.println("2. Pop  (delete_left)");
//        System.out.println("3. Peek (tos.data)");
//        System.out.println("4. isEmpty");
//        System.out.println("5. Print stack");
//        System.out.println("6. Exit");
//    }
//}


//-----------------------------------------------

package Linked_List_Examples;

import java.util.Scanner;

public class Dynamic_Stack
{
    Node tos;//single data member
    //insert_left:push
    void push(int data)
    {
        Node n=new Node(data);//created node
        if(tos==null)//not assigned till now
            tos=n;
        else
        {
            n.next=tos;//1:   2100
            tos=n;//2 root=3400
        }
    }
    void pop()
    {
        if(tos==null)//not assigned till now
            System.out.print("\nStack Empty");
        else
        {
            Node t=tos;//1
            tos=tos.next;//2
            System.out.println(t.data+" Poped");
        }
    }
    void peek()
    {
        if(tos==null)//not assigned till now
            System.out.print("\nStack Empty");
        else
        {
            System.out.println(tos.data+" @ Peek");
        }
    }
    boolean is_empty()
    {
        return(tos==null);
    }
    void print_stack()
    {
        if(tos==null)//not assigned till now
            System.out.print("\nStack Empty");
        else {
            Node t;
            t = tos;//1
            while (t != null)//2
            {
                System.out.print("\n|" + t.data + "|");
                System.out.print("\n____");
                t = t.next;
            }
        }

    }
    public static void main(String[] args)
    {
        Dynamic_Stack obj=new Dynamic_Stack();
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
                        obj.pop();
                        break;
                case 3:
                       obj.peek();
                        break;
                case 4:
                    obj.print_stack();
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
