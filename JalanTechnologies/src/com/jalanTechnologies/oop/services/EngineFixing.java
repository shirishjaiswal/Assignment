package com.jalanTechnologies.oop.services;

public class EngineFixing implements Service{
	private static final String serviceCode = "EF01";
	private static final int chargeForHatchback = 5000;
	private static final int chargeForSedan = 8000;
	private static final int chargeForSUV = 10000;
	
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
