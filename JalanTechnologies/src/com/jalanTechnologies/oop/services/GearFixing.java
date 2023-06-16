package com.jalanTechnologies.oop.services;

public class GearFixing implements Service {
	private static final String serviceCode = "GF01";
	private static final int chargeForHatchback = 3000;
	private static final int chargeForSedan = 6000;
	private static final int chargeForSUV = 8000;
	
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
