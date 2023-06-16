package com.jalanTechnologies.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jalanTechnologies.oop.services.BasicService;
import com.jalanTechnologies.oop.services.BrakeFixing;
import com.jalanTechnologies.oop.services.ClutchFixing;
import com.jalanTechnologies.oop.services.EngineFixing;
import com.jalanTechnologies.oop.services.GearFixing;
import com.jalanTechnologies.oop.services.Service;
import com.jalanTechnologies.oop.vehicals.Vehical;

public class Bill {
	Vehical vehical;
	List<Service> services = new ArrayList<>();
	
	Bill (Vehical vehical, Set<Integer> services) {
		this.vehical = vehical;
		for (int serviceNo : services) {
			if (serviceNo == 1) {
				Service service = new BasicService();
                this.services.add(service);
            } else if (serviceNo == 2) {
            	Service service = new BrakeFixing();
            	this.services.add(service);
            } else if (serviceNo == 3) {
            	Service service = new ClutchFixing();
            	this.services.add(service);
            } else if (serviceNo == 4) {
            	Service service = new GearFixing();
            	this.services.add(service);
            } else if (serviceNo == 5) {
            	Service service = new EngineFixing();
            	this.services.add(service);
            }
		}
	}
	
	public void generateBill () {
		String name = vehical.getName();
		int totalBill = 0;
		if(name.equals("HatchBack")) {
			totalBill = generateBillForHatchBack();
		}
		else if (name.equals("Sedan")) {
			totalBill = generateBillForSedan();
		}
		else if (name.equals("SUV")) {
			totalBill = generateBillForSUV();
		}
		if(totalBill > 10000) {
			System.out.println("== complimentary cleaning ==");
		}
		System.out.println("Total Bill - " + totalBill);
	}
	
	public int generateBillForHatchBack () {
		int totalBill = 0;
		getVehicalNameAndServiceCode();
		for (Service service : services) {
			int amount = service.getChargeForHatchback();
			preDisplay(service);
			System.out.println(amount + " ");
			totalBill += amount;
		}
		return totalBill;
	}
	
	public int generateBillForSedan () {
		int totalBill = 0;
		getVehicalNameAndServiceCode();
		for (Service service : services) {
			int amount = service.getChargeForSedan();
			preDisplay(service);
			System.out.println(amount + " ");
			totalBill += amount;
		}
		return totalBill;
	}
	
	public int generateBillForSUV () {
		int totalBill = 0;
		getVehicalNameAndServiceCode();
		for (Service service : services) {
			int amount = service.getChargeForSUV();
			preDisplay(service);
			System.out.println(amount + " ");
			totalBill += amount;
		}
		return totalBill;
	}
	
	public void getVehicalNameAndServiceCode() {
		System.out.println("Type of car - " + this.vehical.getName());
		System.out.print("Service Code - ");
		for (int i = 0; i < services.size(); i++) {
			System.out.print(services.get(i).getServiceCode());
			if(i < services.size()-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	public void preDisplay (Service service) {
		if(service.getServiceCode().equals("BS01")) {
			System.out.print("Charges for Basic Servicing - ");
		}
		else if(service.getServiceCode().equals("BF01")) {
			System.out.print("Charges for Brake Fixing - ");
		}
		else if(service.getServiceCode().equals("CF01")) {
			System.out.print("Charges for Clutch Fixing - ");
		}
		else if(service.getServiceCode().equals("EF01")) {
			System.out.print("Charges for Engine Fixing - ");
		}
		else if(service.getServiceCode().equals("GF01")) {
			System.out.print("Charges for Gear Fixing - ");
		}
	}
}
