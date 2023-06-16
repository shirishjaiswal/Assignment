package com.jalanTechnologies.oop.services;

public class BrakeFixing implements Service {
	private static final String serviceCode = "BF01";
	private static final int chargeForHatchback = 1000;
	private static final int chargeForSedan = 1500;
	private static final int chargeForSUV = 2500;
	
	@Override
	public int getChargeForHatchback() {
		return this.chargeForHatchback;
	}
	@Override
	public int getChargeForSedan() {
		return this.chargeForSedan;
	}
	@Override
	public int getChargeForSUV() {
		return this.chargeForSUV;
	}
	@Override
	public String getServiceCode() {
		return this.serviceCode;
	}
	
}
