package Queue_Examples;

import java.util.Scanner;

public class Circular_Queue { //bounded buffer uses this
    private int front;
    private int rear;      // points to next insertion index
    private int count;     // number of elements currently in queue
    private int maxSize;
    private int[] queue;

    public void createQueue(int size) {
        this.maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = 0;   // next insert pos
        count = 0;
    }

    public boolean isFull() {
        return count == maxSize;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Full - cannot enqueue " + data);
            return;
        }
        queue[rear] = data;
        rear = (rear + 1) % maxSize;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty - cannot dequeue");
            return Integer.MIN_VALUE; // sentinel; you can throw exception instead
        }
        int value = queue[front];
        front = (front + 1) % maxSize;
        count--;
        return value;
    }

    /*
     * Print using variables i and c like your diagram:
     * i = front, c = 0; while (c < count) { print queue[i]; i=(i+1)%maxSize; c++; }
     * Also print indices so you can see f and r on the ring.
     */
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
            return;
        }

        System.out.print("Queue contents: ");
        int i = front;
        int c = 0;
        while (c < count) {
            System.out.print(queue[i]);
            if (c < count - 1) System.out.print(" , ");
            i = (i + 1) % maxSize;
            c++;
        }
        System.out.println();

        // show front index (f), last element index (r_last) and count (c)
        int r_last = (rear - 1 + maxSize) % maxSize; // index of last element
        System.out.println("front index (f): " + front + "   last-element index (r): " + r_last + "   count (c): " + count);
    }

    public static void main(String[] args) {
        Circular_Queue obj = new Circular_Queue();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter size of queue: ");
        int size = in.nextInt();
        while (size <= 0) {
            System.out.print("Size must be > 0. Enter size of queue: ");
            size = in.nextInt();
        }
        obj.createQueue(size);

        int choice;
        do {
            System.out.println("\nQueue Menu");
            System.out.println("----------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Print (visual)");
            System.out.println("0. Exit");
            System.out.print(": ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    if (!obj.isFull()) {
                        System.out.print("Enter Data: ");
                        int data = in.nextInt();
                        obj.enqueue(data);
                        System.out.println(data + " enqueued");
                    } else {
                        System.out.println("Queue Full");
                    }
                    break;

                case 2:
                    if (!obj.isEmpty()) {
                        int v = obj.dequeue();
                        if (v != Integer.MIN_VALUE) System.out.println(v + " dequeued");
                    } else {
                        System.out.println("Queue Empty");
                    }
                    break;

                case 3:
                    obj.printQueue();
                    break;

                case 0:
                    System.out.println("Thanks for using the code.");
                    break;

                default:
                    System.out.println("Wrong Choice given.");
            }
        } while (choice != 0);

        in.close();
    }
}
