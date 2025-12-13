package Linked_List_Examples;

import java.util.LinkedList;
import java.util.Stack;

public class Reverse_Linked_List {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(30);
        list.add(20);
        list.add(50);
        list.add(5);

        System.out.println("Original list: " + list);

        // Use a stack to reverse the linked list
        Stack<Integer> stack = new Stack<>();

        // remove first from linked list and push on stack
        while (!list.isEmpty()) {
            stack.push(list.removeFirst());
        }

        // from stack copy back to linked list (now reversed)
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        System.out.println("Reversed list: " + list);

        // Optional: print elements line by line
        System.out.println("\nList elements (one per line):");
        for (Integer v : list) {
            System.out.println(v);
        }
    }
}
