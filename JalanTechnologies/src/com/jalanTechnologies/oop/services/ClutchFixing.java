package com.jalanTechnologies.oop.services;

public class ClutchFixing implements Service {
	private static final String serviceCode = "CF01";
	private static final int chargeForHatchback = 2000;
	private static final int chargeForSedan = 4000;
	private static final int chargeForSUV = 6000;
	
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
