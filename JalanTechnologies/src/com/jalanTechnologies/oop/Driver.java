package com.jalanTechnologies.oop;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import com.jalanTechnologies.oop.vehicals.HatchBack;
import com.jalanTechnologies.oop.vehicals.SUV;
import com.jalanTechnologies.oop.vehicals.Sedan;
import com.jalanTechnologies.oop.vehicals.Vehical;

public class Driver {
	public static void main (String [] args) {
		Scanner sc = new Scanner(System.in);
		Vehical vehicle = null;
		System.out.println("Select Your Car Type : "
				+ "\n1 - Hatchback"
				+ "\n2 - Sedan"
				+ "\n3 - SUV");
		boolean isValid = false;
		int option = 0;
		while (!isValid) {
			try {
				if(option >= 1 && option <= 3) {
					if(option == 1) {
						vehicle = new HatchBack();
					}
					else if(option == 2) {
						vehicle = new Sedan();
					}
					else if(option == 3) {
						vehicle = new SUV();
					}
					isValid = true;
				}
				else {
					option = sc.nextInt();
				}
			}
			catch (InputMismatchException e) {
				System.out.print("Please Enter Proper Input : ");
				sc.next();
			}
			catch (Exception e) {
				System.out.print("Error occured!"
						+ "\nPlease Re-Select the Choice : ");
				sc.next();
			}
		}
		
		Set<Integer> services = new TreeSet<>(); 
		
		System.out.println("ENTER '0' TO PROCEED"
				+ "\nSelect Your Services : "
				+ "\n1 - Basic Service"
				+ "\n2 - Berak Fixing"
				+ "\n3 - Clutch Fixing"
				+ "\n4 - Gear Fixing"
				+ "\n5 - Engine Fixing");
		
		int serviceNo = -1;
		isValid = false;

		while (serviceNo != 0) {
		    try {

		        serviceNo = sc.nextInt();

		        if (serviceNo == 0) {
		            if (services.isEmpty()) {
		                System.out.println("Thanks For Visiting");
		            } else {
		                System.out.println("Generating Bill");
		                getBill(vehicle, services);
		            }
		        } else if (serviceNo >= 1 && serviceNo <= 5) {
		            services.add(serviceNo);
		            isValid = true;
		        } else {
		            System.out.print("Please Enter a Valid Service Number: ");
		        }
		    } catch (InputMismatchException e) {
		        System.out.print("Please Enter Proper Input : ");
		        sc.next();
		    } catch (Exception e) {
		        e.printStackTrace();
		        System.out.print("Error occurred!"
		                + "\nPlease Re-Select the Choice : ");
		        sc.next();
		    }
		}
		
		System.out.println("Thanks For viting");
	}
	public static void getBill(Vehical vehical, Set<Integer> services) {
		Bill bill = new Bill(vehical, services);
		bill.generateBill();
	}
}
