package com.jalanTechnologies.oop.services;

public class BasicService implements Service {
	private static final String serviceCode = "BS01";
	private static final int chargeForHatchback = 2000;
	private static final int chargeForSedan = 4000;
	private static final int chargeForSUV = 5000;
	
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
