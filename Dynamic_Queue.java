package Linked_List_Examples;

import Queue_Examples.Queue_Class;

import java.util.Scanner;

public class Dynamic_Queue
{
    Node front,rear;
    void dequeue()
    {
        if(front==null)//not assigned till now
            System.out.print("\nQueue Empty");
        else
        {
            Node t=front;
            if(front==rear)//single node
                front=rear=null;//manual deletion
            else
                front=front.next;//move ahead
            System.out.println(t.data+" Deleted");
        }
    }
    void enqueue(int data)
    {
        Node n=new Node(data);//created node
        if(rear==null)//not assigned till now
            front=rear=n;
        else
        {
           rear.next=n;
           rear=n;
        }
    }
    void print_queue()
    {
        if(front==null)//not assigned till now
            System.out.print("\nQueue Empty");
        else
        {
            Node t;
            t = front;//1
            while (t != null)//2
            {
                System.out.print("|" + t.data + "|-");
                t = t.next;
            }
        }

    }
    public static void main(String[] args)
    {
        Dynamic_Queue obj=new Dynamic_Queue();
        Scanner in=new Scanner(System.in);
        int choice=0;

        do
        {
            System.out.print("\nQueue Menu");
            System.out.print("\n----------");
            System.out.print("\n1.Enqueue");
            System.out.print("\n2.Dequeue");
            System.out.print("\n3.Print");
            System.out.print("\n0.Exit");
            System.out.print("\n:");
            choice=in.nextInt();
            switch (choice) {
                case 1:
                        System.out.print("\nEnter Data:");
                        int data=in.nextInt();
                        obj.enqueue(data);
                        System.out.print("\n"+data+" enqueued");
                    break;
                case 2:
                   obj.dequeue();
                    break;
                case 3:
                  obj.print_queue();
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
