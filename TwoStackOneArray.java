package Linked_List_Examples;

import java.util.InputMismatchException;
import java.util.Scanner;

class TwoStacks {
    private final int[] arr;
    private final int size;
    private int top1, top2;

    // Constructor
    TwoStacks(int n) {
        this.size = n;
        this.arr = new int[n];
        this.top1 = -1;   // stack1 grows right from index 0
        this.top2 = n;    // stack2 grows left from index n-1
    }

    /** Push into Stack 1.
     *  Returns true if pushed, false if overflow (no space). */
    boolean push1(int x) {
        if (top1 + 1 < top2) { // space available
            top1++;
            arr[top1] = x;
            return true;
        }
        return false; // overflow
    }

    /** Push into Stack 2.
     *  Returns true if pushed, false if overflow (no space). */
    boolean push2(int x) {
        if (top2 - 1 > top1) { // space available
            top2--;
            arr[top2] = x;
            return true;
        }
        return false; // overflow
    }

    /** Pop from Stack 1. Returns value or -1 if empty. */
    int pop1() {
        if (top1 == -1) return -1; // empty
        return arr[top1--];
    }

    /** Pop from Stack 2. Returns value or -1 if empty. */
    int pop2() {
        if (top2 == size) return -1; // empty
        return arr[top2++];
    }

    /** Display contents of both stacks (top to bottom). */
    void display() {
        System.out.println("---- Stacks Status ----");
        // Stack 1
        if (top1 == -1) {
            System.out.println("Stack1: [empty]");
        } else {
            System.out.print("Stack1 (top -> bottom): ");
            for (int i = top1; i >= 0; i--) {
                System.out.print(arr[i]);
                if (i > 0) System.out.print(" <- ");
            }
            System.out.println();
        }

        // Stack 2
        if (top2 == size) {
            System.out.println("Stack2: [empty]");
        } else {
            System.out.print("Stack2 (top -> bottom): ");
            for (int i = top2; i < size; i++) {
                System.out.print(arr[i]);
                if (i < size - 1) System.out.print(" <- ");
            }
            System.out.println();
        }
        System.out.println("------------------------");
    }
}

public class TwoStackOneArray {
	
    private static void printMenu() {
        System.out.println("\n---- Menu ----");
        System.out.println("1. push1 (push into Stack1)");
        System.out.println("2. push2 (push into Stack2)");
        System.out.println("3. pop1  (pop from Stack1)");
        System.out.println("4. pop2  (pop from Stack2)");
        System.out.println("5. display (show both stacks)");
        System.out.println("6. exit");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array capacity for two stacks (e.g. 100): ");
        int capacity = 100;
        try {
            capacity = sc.nextInt();
            if (capacity <= 0) {
                System.out.println("Invalid capacity. Using default 100.");
                capacity = 100;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Using default capacity 100.");
            sc.nextLine(); // clear bad input
        }

        TwoStacks ts = new TwoStacks(capacity);

        while (true) {
            printMenu();
            System.out.print("Choose option: ");
            int choice;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                sc.nextLine(); // clear bad input
                continue;
            }

            switch (choice) {
                case 1: // push1
                    System.out.print("Enter value to push into Stack1: ");
                    try {
                        int v1 = sc.nextInt();
                        boolean ok1 = ts.push1(v1);
                        if (ok1) System.out.println("Pushed " + v1 + " into Stack1.");
                        else System.out.println("Stack Overflow: cannot push into Stack1.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid number.");
                        sc.nextLine();
                    }
                    break;

                case 2: // push2
                    System.out.print("Enter value to push into Stack2: ");
                    try {
                        int v2 = sc.nextInt();
                        boolean ok2 = ts.push2(v2);
                        if (ok2) System.out.println("Pushed " + v2 + " into Stack2.");
                        else System.out.println("Stack Overflow: cannot push into Stack2.");
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid number.");
                        sc.nextLine();
                    }
                    break;

                case 3: // pop1
                    int p1 = ts.pop1();
                    if (p1 == -1) System.out.println("Stack1 Underflow: Stack1 is empty.");
                    else System.out.println("Popped from Stack1: " + p1);
                    break;

                case 4: // pop2
                    int p2 = ts.pop2();
                    if (p2 == -1) System.out.println("Stack2 Underflow: Stack2 is empty.");
                    else System.out.println("Popped from Stack2: " + p2);
                    break;

                case 5: // display
                    ts.display();
                    break;

                case 6: // exit
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Please choose a valid option (1-6).");
                    break;
            }
        }
    }
}
