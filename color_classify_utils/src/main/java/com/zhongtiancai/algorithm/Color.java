package com.zhongtiancai.algorithm;

import org.apache.commons.math3.ml.clustering.Clusterable;

public class Color implements Clusterable{
    private double[] point;
	
	public Color(double r,double g,double b){
		point = new double[]{
				r,g,b
		};
    }
	
	public Color(double [] point){
		this.point = point;
    }
	
	public double[] getPoint() {
		return point;
	}
	
	
	public String getColor() {
		return Integer.toHexString((int) this.point[0]) + Integer.toHexString((int) this.point[1])
				+ Integer.toHexString((int) this.point[2]);
	}

}
