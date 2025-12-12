package Linked_List_Examples;

import java.util.InputMismatchException;
import java.util.Scanner;

class Enode
{
	int id;
	String name;
	double salary;
	Enode next;
	
	Enode (int id, String name, double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.next = next;
	}
	
	void printNode()
	{
        System.out.printf("ID: %d\tName: %s\tSalary: %.2f\n", id, name, salary);
	}
}

public class EmployeManagement {
	
	private Enode head;
	
	public EmployeManagement()
	{
		head =null;
	}
	
	public void addEmployee(int id, String name, double salary)
	{
		if(findById(id) != null)
		{
			System.out.println("Error: Employee ID already exists. Choose a unique ID");
			return;
		}
		
		Enode node = new Enode(id, name, salary);
		if(head == null)
		{
			head = node;
		}
		else
		{
			Enode t = head;
			while(t.next != null) t = t.next;
			t.next = node;
		}
		System.out.println("Employee added successfully.");
	}
	
	public void displayEmployee()
	{
		if(head == null)
		{
			System.out.println("No EMployees to display");
			return;
		}
		System.out.println("\n----- Employee List -----");
		Enode t = head;
		while(t!= null)
		{
			t.printNode();
			t=t.next;
		}
		System.out.println("---------------------------------");
	}
	
	public void searchEmployee(int id)
	{
		Enode found = findById(id);
		if (found == null)
			System.out.println("Employee with ID " + id + " not found.");
		else {
			System.out.println("Employee found.");
			found.printNode();
		}
	} 

	private Enode findById(int id) {
		Enode t = head;
		while(t!= null) {
			if(t.id == id) return t;
			t= t.next;
		}
		return null;
	}
	
	
	public void updateEmploye(int id, String newName, double newSalary)
	{
		Enode found = findById(id);
		if( found == null)
		{
			System.out.println("Employee with ID " + id + "not found. Update Failed");
		}
		else
		{
			found.name = newName;
			found.salary = newSalary;
			System.out.println("Employee updated successfully.");
		}
	}
	
	 public void deleteEmployee(int id) {
	        if (head == null) {
	            System.out.println("No employees to delete.");
	            return;
	        }

	        // If head is to be deleted
	        if (head.id == id) {
	            System.out.println("Deleted Employee: ");
	            head.printNode();
	            head = head.next;
	            return;
	        }

	        Enode t = head;
	        Enode prev = null;
	        while (t != null && t.id != id) {
	            prev = t;
	            t = t.next;
	        }

	        if (t == null) {
	            System.out.println("Employee with ID " + id + " not found. Delete failed.");
	        } else {
	            prev.next = t.next; // unlink
	            System.out.println("Deleted Employee: ");
	            t.printNode();
	        }
	    }

	    // F. Menu Driven main()
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        EmployeManagement em = new EmployeManagement();

	        while (true) {
	            printMenu();
	            System.out.print("Enter choice: ");
	            int choice;
	            try {
	                choice = sc.nextInt();
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Enter a number from menu.");
	                sc.nextLine();
	                continue;
	            }

	            switch (choice) {
	                case 1: // Add Employee
	                    try {
	                        System.out.print("Enter Employee ID (int): ");
	                        int id = sc.nextInt();
	                        sc.nextLine(); // consume newline
	                        System.out.print("Enter Name: ");
	                        String name = sc.nextLine();
	                        System.out.print("Enter Salary (double): ");
	                        double salary = sc.nextDouble();
	                        em.addEmployee(id, name, salary);
	                    } catch (InputMismatchException e) {
	                        System.out.println("Invalid data. Try again.");
	                        sc.nextLine();
	                    }
	                    break;

	                case 2: // Display All
	                    em.displayEmployee();
	                    break;

	                case 3: // Search
	                    System.out.print("Enter Employee ID to search: ");
	                    int sid = sc.nextInt();
	                    em.searchEmployee(sid);
	                    break;

	                case 4: // Update
	                    try {
	                        System.out.print("Enter Employee ID to update: ");
	                        int uid = sc.nextInt();
	                        sc.nextLine();
	                        System.out.print("Enter new Name: ");
	                        String newName = sc.nextLine();
	                        System.out.print("Enter new Salary: ");
	                        double newSalary = sc.nextDouble();
	                        em.updateEmploye(uid, newName, newSalary);
	                    } catch (InputMismatchException e) {
	                        System.out.println("Invalid input. Update aborted.");
	                        sc.nextLine();
	                    }
	                    break;

	                case 5: // Delete
	                    System.out.print("Enter Employee ID to delete: ");
	                    int did = sc.nextInt();
	                    em.deleteEmployee(did);
	                    break;

	                case 0:
	                    System.out.println("Exiting. Goodbye!");
	                    sc.close();
	                    return;

	                default:
	                    System.out.println("Invalid choice. Try again.");
	            }
	        }
	    }

	    private static void printMenu() {
	        System.out.println("\n====== Employee Management ======");
	        System.out.println("1. Add Employee");
	        System.out.println("2. Display All Employees");
	        System.out.println("3. Search Employee by ID");
	        System.out.println("4. Update Employee by ID");
	        System.out.println("5. Delete Employee by ID");
	        System.out.println("0. Exit");
	        System.out.println("=================================");
	    }
	}

