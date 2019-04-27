package main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;


/*
 * Description: 
 * <p> This class creates a hash map of the prescriptions and the details you enter.<p>
 * 
 * @author: Joseph Curto
 * @version: 04/07/2019
 */

public class PrescriptionMap {
	
	HashMap<Integer,Prescription> hmap = new HashMap<Integer, Prescription>();
	private static Scanner scan = new Scanner(System.in);
	
	/*
	 * <p>The medDocumentation method acts as the UI, beginning with the questions, "Do you wish to enter any prescriptions?"
	 * If you do, then you type yes, otherwise any other word typed in will give the exiting program prompt and terminate the program.
	 * As the user types in the prescription name, dosage, daily amount, and how many hours apart the medication should be taken, they 
	 * will then be added to the hash map with the keys corresponding to the order in which you entered your prescription.<p>
	 * <p> After the questions have been asked, then the initial question of, "Do you wish to enter any prescriptions?" will be asked
	 * until the user types in "no".<p>
	 */
	public void medDocumentation() {
		
		Scanner scan = new Scanner(System.in);
		int key = 0;
		boolean prescript_Decision = true;
		
		do {
		System.out.print("Do you wish to enter any prescriptions?");
		String perscriptCount = scan.next();
		System.out.println();
		
		if(perscriptCount.equalsIgnoreCase("y")) {
			
			System.out.print("Prescription Name: ");
			String prescriptionName = scan.next();
			
			System.out.print("Enter the dosage in milligrams: ");
			float dosage = scan.nextFloat();
			
			System.out.print("Enter the daily amount: ");
			int dailyIntake = scan.nextInt();
			
			System.out.print("Enter how many hours apart between dosages: ");
			int hoursApart = scan.nextInt();
		
			System.out.println();
			
			Prescription perscript = new Prescription(prescriptionName, dosage, dailyIntake, hoursApart);
			hmap.put(key,perscript);
			key++;
			
		}//end if
		else {
			prescript_Decision = false;
			
			printData();
			printMap();
			
			System.out.println();
		}//end else
		
	}//end do
		
		while(prescript_Decision == true); 
		
	}//end medAddition
	
	 /*
	  * The deletePrescription method will delete the specified prescription.
	  */
	private void deletePrescription(int num) {
		hmap.remove(num);
	}//end deletePrescription
	
	/*
	 * The deletionPrompt provides a UI for the user to interact with which allows them to 
	 * specify what prescription they wish to remove.
	 */
	public void deletionPrompt(){
		System.out.print("Do you need to delete a prescription? Y/N: ");
		String choice = scan.next();
		
		while(choice.equalsIgnoreCase("y")){
			System.out.println("Which prescription would you like to delete?");
		
			numericalPrint();
		
			System.out.println();
			System.out.print("Please enter the number corresponding with the prescription: ");
			int num = scan.nextInt();
			deletePrescription(num);
			
			System.out.println("This is what remains after the deletion.");
		
			printData();
			printMap();
			System.exit(0);
			
		}//end while
		scan.close();
		
		if(choice.equalsIgnoreCase("n")){
			System.out.println("You have chosen not to delete a prescription.");
			System.exit(0);
		}//end if
	}//end deletePrompt method
	
	/*
	 * The printData method simply formats the header of the table that will be printed out when the program terminates
	 */
	public void printData() {
		System.out.printf("%-24s %-14s %-13s %-15s", "Prescription Name", "Dosage", "Daily Intake", "Hours Apart");
		System.out.println();
		System.out.println("-----------------------------------------------------------------");
	}//end printData method

	/*
	 * The printMap method prints the elements of the hash map to the table.
	 */
	public void printMap() {
		for(Entry<Integer, Prescription> entry: hmap.entrySet()) {
			System.out.println(entry.getValue());
		}//end for
	}//end printMap
	
	/*
	 * This method prints the table with the key values and the prescription names.
	 */
	public void numericalPrint(){
		int i = 0;
		for(Entry<Integer, Prescription> entry: hmap.entrySet()) {
			System.out.println(i + ". " + entry.getValue().getName());
			i++;
		}//end for
	}//end numbericalPrint
}//end class
