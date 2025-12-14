//package Queue_Examples;
//
//public class Priority_Queue {
//	//this queue is very commonly used in RTOS for Preemptive Based Interrupt Handling
//	//RTOS best example is Android and IOS.
//	//RTOS is like it do highest priority work first even if other work is going on
//	//Reactive: search on environment
//	//Active: do nothing till we do
//	public class queueexample {
//		int tos,maxSize,stack[];
//	    void create_stack(int size){
//	        maxSize=size;
//	        tos=-1;
//	        stack=new int[maxSize];
//	    }
//	    void push(int data){
//	        tos++;
//	        stack[tos]=data;
//	        //stack[++tos]=data;
//	    }
//	    boolean is_full(){
//	        if(tos==maxSize-1){
//	            return true;
//	        }
//	        else{
//	            return false;
//	        }
//	       // return (tos==maxSize -1);
//	    }
//	    int pop(){
//	        //int temp=stack[tos];
//	        //tos--; //reducexs
//	        //return(temp);
//	        return stack[tos--];
//	    }
//	    boolean is_empty(){
//	        if(tos==-1){
//	            return true;
//	        }
//	        else{
//	            return false;
//	        }
//	       // return (tos==-1);
//	    }
//	    
//	    int peek(){
//	        return stack[tos];
//	    }
//
//	    void print_stack(){
//	        //print stack in lifo manner from top to bottum;
//	        for(int i=tos;i>=0;i--){
//	            System.out.println(stack[i]);
//	        }
//	    }
//
//	}
//}

//---------------------------------------------------------------------------
package Queue_Examples;

import java.util.Scanner;

public class Priority_Queue
    //used in RTOS for preemptive based interrupt handling
{
    int front,rear,MaxSize,queue[];
    void create_queue(int size)
    {
        MaxSize=size;
        rear=-1;//init as stack starts from 0th index(Array)
        front=0;
        queue=new int[MaxSize];
    }
    //Enqueue:Entry on queue
    //in this rear+1 and then new entry taken
    void enqueue(int data)
    {
        queue[++rear]=data;
        for(int i=front;i<rear;i++)
        {
            for(int j=front;j<rear;j++)
            {
                if(queue[j]<queue[j+1])//ASC    < //DEC
                {
                    int temp=queue[j];queue[j]=queue[j+1];queue[j+1]=temp;
                }
            }
        }
    }
    //is_full:
    // if rear==MaxSize-1 then full
    boolean is_full()
    {
        return(rear==MaxSize-1);
    }
    //dequeue:
    // Remove and returns element from front
    // in this front+1 on every dequeue
    int dequeue()
    {
        return(queue[front++]);
    }

    //is_empty
    //front>rear then empty
    boolean is_empty()
    {
        return(front>rear);
    }

    void print_queue()
    //print queue in FIFO manner means from front to rear
    {
        for(int i=front;i<=rear;i++)
            System.out.print(queue[i]+" ,");
    }

    public static void main(String[] args)
    {
        Priority_Queue obj=new Priority_Queue();
        Scanner in=new Scanner(System.in);
        System.out.println("Enter size of queue:");
        int size=in.nextInt();
        int choice=0;
        obj.create_queue(size);
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
                    if (!obj.is_full())//not full
                    {
                        System.out.print("\nEnter Data:");
                        int data=in.nextInt();
                        obj.enqueue(data);
                        System.out.print("\n"+data+" enqueued");
                    }
                    else
                        System.out.print("\nQueue Full");
                    break;
                case 2:
                    if (!obj.is_empty())//not empty
                    {
                        System.out.print("\n"+obj.dequeue()+" is dequeued");
                    }
                    else
                        System.out.print("\nQueue Empty");
                    break;
                case 3:
                    if (!obj.is_empty())//not empty
                    {
                        System.out.print("\nQueue has:\n");
                        obj.print_queue();
                    }
                    else
                        System.out.print("\nQueue Empty");
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