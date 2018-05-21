package com.zhongtiancai.classify;

public class Color {
	private double r;
	private double g;
	private double b;
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public Color(double r, double g, double b) {
		super();
		this.r = r;
		this.g = g;
		this.b = b;
	}
	@Override
	public String toString() {
		return "Color [r=" + r + ", g=" + g + ", b=" + b + "]";
	}

	
	

}
