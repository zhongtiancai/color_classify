package com.zhongtiancai.classify;

import java.util.Arrays;
import java.util.List;

public class Color {
	// 需要就自己加上吧
	//品红
	public static final Color MAGENTA = new Color(255, 0, 255);
	//蓝色
	public static final Color BLUE = new Color(0, 0, 250);
	
	//青色
	public static final Color CHING = new Color(0, 255, 255);

    //绿色
	public static final Color GREEN = new Color(0, 250, 0);
	//黄色
	public static final Color YELLOW = new Color(255, 255, 0);
	
	//红色
	public static final Color RED = new Color(255, 0, 0);
	
	//紫色
	public static final Color PURPLE = new Color(128, 0, 128);

  
    //深蓝
	public static final Color DARKBLUE = new Color(0, 0, 128);
    //鸭绿
	public static final Color DUCKGREEN = new Color(0, 128, 128);
    
    //深绿
	public static final Color DARKGREEN = new Color(0, 128, 0);
	
	public static final Color BLACK = new Color(0, 0, 0);

	public static final Color GRAY = new Color(128, 128, 128);

	public static final Color WHITE = new Color(255, 255, 255);

	public static final Color SILVERY = new Color(192, 192, 192);
	
	
	
	
	
	

	
	public static final Color OLIVE = new Color(128, 128, 0);
	
	public static final Color CHESTNUT = new Color(128, 0, 0);
	
	public static List<Color> defaultColors = Arrays.asList(new Color[] {
			MAGENTA,BLUE,CHING,GREEN,YELLOW,RED,PURPLE,DARKBLUE,DUCKGREEN,DARKGREEN,BLACK,GRAY,WHITE,SILVERY
	});
	
	
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
