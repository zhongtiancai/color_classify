package com.zhongtiancai.classify;

public class Distance {
	private Color one;
	private Color two;

	public double getDistance() {
		double distanceSum = Math.pow((one.getR() - two.getR()), 2) + Math.pow((one.getG() - two.getG()), 2)
				+ Math.pow((one.getB() - two.getB()), 2);
		return Math.sqrt(distanceSum);
	}

	public Distance(Color one, Color two) {
		super();
		this.one = one;
		this.two = two;
	}
  
  
}
