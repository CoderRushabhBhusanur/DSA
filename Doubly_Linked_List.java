package Linked_List_Examples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Doubly_Linked_List {
    // Node class with left and right pointers
    static class Dnode {
        int data;
        Dnode left, right;

        Dnode(int d) {
            data = d;
            left = right = null;
        }
    }

    Dnode root;   // head pointer

    // Insert at left (new node becomes root)
    void insert_left(int data) {
        Dnode n = new Dnode(data);
        if (root == null)
            root = n;
        else {
            n.right = root;
            root.left = n;
            root = n;
        }
        System.out.println(data + " inserted at left.");
    }

    // Delete from left (remove root)
    void delete_left() {
        if (root == null) {
            System.out.println("\nList empty");
            return;
        }

        Dnode t = root;

        // If only one node
        if (root.right == null) {
            System.out.println(t.data + " Deleted ");
            root = null;
            return;
        }

        // More than one node
        root = root.right;
        root.left = null;
        System.out.println(t.data + " Deleted ");
    }

    // Insert at right (end)
    void insert_right(int data) {
        Dnode n = new Dnode(data);
        if (root == null)
            root = n;
        else {
            Dnode t = root; //1
            while (t.right != null) //2
                t = t.right;
            t.right = n; //3
            n.left = t;  //4
        }
        System.out.println(data + " inserted at right.");
    }

    // Delete from right (remove last)
    void delete_right() {
        if (root == null) {
            System.out.println("\nList empty");
            return;
        }

        Dnode t = root;
        while (t.right != null) {
            t = t.right;
        }

        // t is last node
        if (t == root) {
            // only one node
            System.out.println(t.data + " deleted from right.");
            root = null;
        } else {
            Dnode t2 = t.left; // second last
            t2.right = null;   // detach last
            System.out.println(t.data + " deleted from right.");
        }
    }

    // Print list left -> right
    void print_list() {
        if (root == null) {
            System.out.println("\nList empty");
            return;
        }
        Dnode t = root; //1
        System.out.print("\nList: ");
        while (t != null) { //2
            System.out.print("<-|" + t.data + "|->");
            t = t.right;
        }
        System.out.println();
    }

    // Print list right -> left (reverse)
    void print_list_reverse() {
        if (root == null) {
            System.out.println("\nList empty");
            return;
        }

        // first move t to the last node
        Dnode t = root;
        while (t.right != null) {
            t = t.right;
        }

        // Now t is at the rightmost end.
        System.out.print("\nReverse List: ");
        // travel backwards to the first node
        while (t != null) {
            System.out.print("<-|" + t.data + "|->");
            t = t.left;   // move backward
        }
        System.out.println();
    }

    // ------------------ Menu-driven main ------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Doubly_Linked_List dll = new Doubly_Linked_List();

        System.out.println("Doubly Linked List (left/right pointers)");
        while (true) {
            printMenu();
            System.out.print("Choose option: ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number between 0 and 7.");
                sc.nextLine(); // clear bad input
                continue;
            }

            switch (choice) {
                case 1: // insert_left
                    System.out.print("Enter integer to insert at left: ");
                    try {
                        int v = sc.nextInt();
                        dll.insert_left(v);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid number.");
                        sc.nextLine();
                    }
                    break;

                case 2: // insert_right
                    System.out.print("Enter integer to insert at right: ");
                    try {
                        int v2 = sc.nextInt();
                        dll.insert_right(v2);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid number.");
                        sc.nextLine();
                    }
                    break;

                case 3: // delete_left
                    dll.delete_left();
                    break;

                case 4: // delete_right
                    dll.delete_right();
                    break;

                case 5: // print forward
                    dll.print_list();
                    break;

                case 6: // print reverse
                    dll.print_list_reverse();
                    break;

                case 7: // isEmpty / peek
                    if (dll.root == null)
                        System.out.println("List is empty.");
                    else
                        System.out.println("First element (root): " + dll.root.data);
                    break;

                case 0: // exit
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Please choose a valid option (0-7).");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n---- Doubly Linked List Menu ----");
        System.out.println("1. Insert Left");
        System.out.println("2. Insert Right");
        System.out.println("3. Delete Left");
        System.out.println("4. Delete Right");
        System.out.println("5. Print List (left -> right)");
        System.out.println("6. Print Reverse (right -> left)");
        System.out.println("7. isEmpty / Show root");
        System.out.println("0. Exit");
    }
}
