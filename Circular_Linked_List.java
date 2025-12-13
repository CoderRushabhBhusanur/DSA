//package Linked_List_Examples;
//
//public class Circular_Linked_List {
//	
//	 Node root,last;   // 2 references : root :leftmost/first,   last:rightmost
//
//	    void insert_left(int data) {
//	        Node n = new Node(data);
//	        if (root == null)
//	        {
//	            root =last =  n;
//	            last.next = root;
//
//	        }
//	        else {
//	        	 n.next = root;     // new node points to old first
//	             root = n;          // update root
//	             last.next = root;  // maintain circular link
//	        }
//	        System.out.println(data + " inserted at left.");
//	    }
//
//	    void delete_left() {
//	        if (root == null)
//	            System.out.println("\nList empty");
//	        else {
//	            Node t = root;
//	            if(root==last) //single node
//	            	root = last = null;
//	            else
//	            {
//	            	root = root.next; //2 
//	            	last.next = root; //3
//	            }
//	            
//	            System.out.println(t.data + " deleted from left.");
//	        }
//	    }
//
//	    void insert_right(int data) {
//	        Node n = new Node(data);
//	        if (root == null)
//	        {
//	        	root = last = n;
//	        	last.next = root;
//	        }
//	        else {
//	            Node t = root;
//	            while (t.next != null)
//	                t = t.next;
//	            t.next = n;
//	        }
//	        System.out.println(data + " inserted at right.");
//	    }
//
//	    void delete_right() {
//	        if (root == null)
//	            System.out.println("\nList empty");
//	        else {
//	            Node t = root, t2 = root;
//	            while (t.next != root) {
//	                t2 = t;
//	                t = t.next;
//	            }
//	            if (root == last)
//	            {root=last=null;}
//	            else
//	            {
//	            	last =t2; //3
//	            	last.next = root; //4
//	            }
//
//	            System.out.println(t.data + " deleted from right.");
//	        }
//	    }
//	    
//	    void print_list() {
//	        if (root == null)
//	            System.out.println("\nList empty");
//	        else {
//	            Node t = root;
//	            System.out.print("\nList: ");
//	            while (t != null) {
//	                System.out.print("|" + t.data + "|->");
//	                t = t.next;
//	            }
//	            System.out.println("null");
//	        }
//	    }
//
//}

//-------------------------------------------------------------------------------------

package Linked_List_Examples;

import java.util.Scanner;

public class Circular_Linked_List {
    Node root, last;//2 references root:leftmost/first   last:rightmost

    //insert_left
    void insert_left(int data) {
        Node n = new Node(data);//created node
        if (root == null)//not assigned till now
        {
            root = last = n;
            last.next = root;
        } else {
            n.next = root;//1:   2100
            root = n;//2 root=3400
            last.next = root;//3
        }
    }

    void delete_left() {
        if (root == null)//not assigned till now
            System.out.print("\nList empty");
        else {
            Node t = root;//1
            if (root == last)//single node
                root = last = null;//manual deletion
            else {
                root = root.next;//2
                last.next = root;//3
            }
            System.out.println(t.data + " Deleted");
        }
    }

    void insert_right(int data) {
        Node n = new Node(data);//created node
        if (root == null)//not assigned till now
        {
            root = last = n;
            last.next = root;
        } else {
            last.next = n;//1
            last = n;//2
            last.next = root;//3
        }
    }

    void delete_right() {
        if (root == null)//not assigned till now
            System.out.print("\nList empty");
        else {
            Node t, t2;
            t = t2 = root;//1
            while (t.next != root)//2
            {
                t2 = t;
                t = t.next;
            }
            if (root == last) {
                root = last = null;
            }//manual deletion}
            else {
                last = t2;//3
                last.next = root;//4
            }
            System.out.println(t.data + " Deleted");
        }
    }

    void print_list() {
        if (root == null)//not assigned till now
            System.out.print("\nList empty");
        else {
            Node t;
            t = root;//1
            do {
                System.out.print("|" + t.data + "|->");
                t = t.next;
            } while (t != root);//2;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Circular_Linked_List list = new Circular_Linked_List();
        int ch;
        do {
            System.out.println("\n\n===== LINKED LIST OPS =====");
            System.out.println("1. Insert Left");
            System.out.println("2. Delete Left");
            System.out.println("3. Insert Right");
            System.out.println("4. Delete Right");
            System.out.println("5. Print List");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter element: ");
                    list.insert_left(sc.nextInt());
                    break;

                case 2:
                    list.delete_left();
                    break;

                case 3:
                    System.out.print("Enter element: ");
                    list.insert_right(sc.nextInt());
                    break;

                case 4:
                    list.delete_right();
                    break;

                case 5:
                    list.print_list();
                    break;
                case 0:
                    System.out.println("Mission terminated. Exiting… ✨");
                    break;

                default:
                    System.out.println("Invalid choice, boss.");
            }
        } while (ch != 0);
    }
}

