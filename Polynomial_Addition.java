package Linked_List_Examples;

import java.util.LinkedList;
import java.util.Scanner;

class Pnode
{
	int power;
	float co;
//	Pnode next;
	Pnode(float co, int power)
	{
		this.co =co;
		this.power =power;
	}
}

public class Polynomial_Addition 
{
	public static void main(String[] args) {
		LinkedList<Pnode> list1 = new LinkedList<>();
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter highest power");
		int hp = in.nextInt();
		for(int i =hp; i>=0;i--)
		{
			System.out.print("\nEnter coefficient for power:" + i + ", ");
			float co = in.nextFloat();
			if(co!=0)
			{
				list1.add(new Pnode(co,i));
			}
		}
		for(Pnode item:list1)
		{
			System.out.print(item.co+"X ^" +item.power+" + ");
		}
	}
}
